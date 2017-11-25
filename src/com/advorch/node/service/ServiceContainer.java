package com.advorch.node.service;

import com.advorch.event.EventType;
import com.advorch.exception.AdvOrchException;
import com.advorch.message.EventMessage;
import com.advorch.node.event.NodeEventAware;
import com.advorch.node.event.NodeEventNotifier;

public class ServiceContainer implements NodeEventNotifier {

	private Service service;
	private NodeEventAware eventHandler;
	
	public ServiceContainer(Service service, NodeEventAware eventHandler) {
		this.service = service;
		this.eventHandler = eventHandler;
	}
	
	public void runIt() throws AdvOrchException {
		onNodeStart();
		
		try {
		    execute();
		    
		} catch (AdvOrchException oe) {
			onNodeFailed(oe);
			throw oe;
			
		} catch (Exception e) {
			onNodeFailed(e);
			throw new AdvOrchException("", e);
		}
		
		onNodeEnd();
	}
	
	public void execute() throws AdvOrchException {		
		// TODO: Add some sort of validation of the service readiness for being executed
		
		if (null != service) {
			service.runIt();
		}
	}
	
	public void onNodeStart() {
		eventHandler.onOutgoingEvent(new EventMessage(EventType.START, service.getId()));
	}
	
	public void onNodeEnd() {
		eventHandler.onOutgoingEvent(new EventMessage(EventType.END, service.getId()));
	}	
	
	public void onNodeFailed(Throwable t) {		
	}
	
	public void onNodeSuspended() {		
	}
}
