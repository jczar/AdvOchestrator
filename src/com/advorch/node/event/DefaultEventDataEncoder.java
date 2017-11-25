package com.advorch.node.event;

import com.advorch.message.EventMessage;

public class DefaultEventDataEncoder implements EventDataEncoder {

	public String encodeEvent(EventMessage msg) {
		return msg.toString();
	}
}
