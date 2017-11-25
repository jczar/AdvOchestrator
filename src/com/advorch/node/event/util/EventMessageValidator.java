package com.advorch.node.event.util;

import com.advorch.message.EventMessage;

public class EventMessageValidator {

	public boolean isMessageValid(EventMessage eventMessage) {
		return (eventMessage != null && eventMessage.getServiceId() != null && !eventMessage.getServiceId().isEmpty());
	}
	
}
