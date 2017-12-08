package com.advorch.node.event;

import com.advorch.message.EventMessage;

public interface EventPublisher {

	public boolean publishEvent(EventMessage eventMessage);
	
}
