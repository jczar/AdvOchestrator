package com.advorch.node.event;

import com.advorch.message.EventMessage;
import com.advorch.node.service.BlockeableContainer;

public interface NodeEventAware {

	/*
	 * These methods are used for asynchronous communication
	 */
	public boolean onOutgoingEvent(EventMessage eventMessage);
	public void onIncomingEvent(EventMessage eventMessage);

	/*
	 * This method is expected to implement some handling of an 
	 * expected response/confirmation for the outgoing event 
	 */
	public boolean onOutgoingBlockingEvent(EventMessage eventMessage, BlockeableContainer container);
}