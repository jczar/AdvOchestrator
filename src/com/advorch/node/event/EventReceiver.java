package com.advorch.node.event;

import com.advorch.message.EventMessage;

public interface EventReceiver {

	public EventMessage receiveEvent();
}
