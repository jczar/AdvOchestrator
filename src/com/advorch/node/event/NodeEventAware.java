package com.advorch.node.event;

import com.advorch.message.EventMessage;

public interface NodeEventAware {

	public void onOutgoingEvent(EventMessage eventMessage);
	public void onIncomingEvent(EventMessage eventMessage);
	
}
