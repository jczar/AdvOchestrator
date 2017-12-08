package com.advorch.node;

import java.util.HashMap;
import java.util.Map;

import com.advorch.event.util.EventMessageValidator;
import com.advorch.exception.AdvOrchException;
import com.advorch.message.EventMessage;
import com.advorch.node.event.EventPublisher;
import com.advorch.node.event.NodeEventAware;
import com.advorch.node.service.BlockeableContainer;
import com.advorch.node.service.ServiceContainer;
import com.advorch.node.service.ServiceContainerFactory;

public class OrchestrationNode implements NodeEventAware {
	
	private String nodeId;
	private Map<String, ServiceContainer> serviceContainers = new HashMap<String, ServiceContainer>();
	private EventPublisher publisher;	
	private EventMessageValidator validator = new EventMessageValidator();
	
	public OrchestrationNode(String nodeId, EventPublisher publisher) {
		this.nodeId = nodeId;
		this.publisher = publisher;
	}
	
	private void dispatchEvent(EventMessage event) throws AdvOrchException {
		String serviceId = event.getServiceId();
		
		if (!serviceContainers.containsKey(serviceId)) {
			throw new AdvOrchException("Service [" + serviceId + "] is not running in this node");
		}
		 
		// Check if a service container has been created for the specific service id 
		ServiceContainer svcContainer = null;
		
		if (!serviceContainers.containsKey(serviceId)) {
			// User container factory for creating a new container
			svcContainer = ServiceContainerFactory.createServiceContainer(
					ServiceContainerFactory.SERVICE_TYPE.QUADRO, 
					serviceId, 
					event.getPayload(),
					this);
			
			serviceContainers.put(serviceId, svcContainer);
		}
		
		svcContainer = serviceContainers.get(serviceId);
		
		if (null == svcContainer) {
			throw new AdvOrchException("Could not create new container for service [" + serviceId + "]");
		}
		
		switch (event.getEventType()) {
		    case START:
		    	svcContainer.runIt();
		    	
		    	break;		

		    default:
		}
	}
	
	public boolean onOutgoingEvent(EventMessage eventMessage) {
		publisher.publishEvent(eventMessage);
		
		return true;
	}

	public void onIncomingEvent(EventMessage eventMessage) {
		if (eventMessage == null) {
			return;
		}
		
		if (validator.isMessageValid(eventMessage)) {
			dispatchEvent(eventMessage);
		}
	}
	
	public boolean onOutgoingBlockingEvent(EventMessage eventMessage, BlockeableContainer container) {
        if (!publisher.publishEvent(eventMessage)) {
        	return false;
        }
        
        container.block();
        
        return true;
	}

	public String getNodeId() {
		return nodeId;
	}
	
}
