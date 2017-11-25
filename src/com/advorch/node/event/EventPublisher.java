package com.advorch.node.event;

import com.advorch.message.EventMessage;

public interface EventPublisher {

	public void publishEvent(EventMessage eventMessage);
	
}
