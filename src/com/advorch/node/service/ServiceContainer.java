package com.advorch.node.service;

import com.advorch.event.EventType;
import com.advorch.exception.AdvOrchException;
import com.advorch.message.EventMessage;
import com.advorch.node.event.NodeEventAware;
import com.advorch.node.event.NodeEventNotifier;

public class ServiceContainer extends BlockeableContainer implements NodeEventNotifier {

	private Service service;
	private NodeEventAware eventHandler;
	
	public ServiceContainer(Service service, NodeEventAware eventHandler) {
		this.service = service;
		this.eventHandler = eventHandler;
	}
	
	@Override
	public void execute() throws AdvOrchException {		
		// TODO: Add some sort of validation of the service readiness for being executed
		
		if (null != service) {
			service.runIt();
		}
	}
	
	@Override
	public void onNodeStart() {
		eventHandler.onOutgoingBlockingEvent(new EventMessage(EventType.START, service.getId()), this);
	}
	
	@Override
	public void onNodeEnd() {
		eventHandler.onOutgoingEvent(new EventMessage(EventType.END, service.getId()));
	}	
	
	@Override
	public void onNodeFailed(Throwable t) {		
	}
	
	@Override
	public void onNodeSuspended() {		
	}
	
}
