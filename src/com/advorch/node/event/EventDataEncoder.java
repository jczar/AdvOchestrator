package com.advorch.node.event;

import com.advorch.message.EventMessage;

public interface EventDataEncoder {
	
	public String encodeEvent(EventMessage eventMsg);
	
}
