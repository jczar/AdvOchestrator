package com.advorch.message;

import com.advorch.event.EventType;

public class EventMessage {
    
	private EventType eventType;
	private MessageType messageType;
	private String nodeId;
	private String serviceId;
	private String payload;
	
	public EventMessage(EventType eventType, String nodeId) {
		this(eventType, nodeId, null);
	}

	public EventMessage(EventType eventType, String nodeId, String serviceId) {
		this(eventType, nodeId, serviceId, null, MessageType.REQUEST);
	}

	public EventMessage(EventType eventType, String nodeId, String serviceId, String payload, MessageType messageType) {
		this.eventType = eventType;
		this.nodeId = nodeId;
		this.payload = payload;
		this.messageType = messageType;
	}

	public EventType getEventType() {
		return this.eventType;
	}
	public String getNodeId() {
		return this.nodeId;
	}
	public String getPayload() {
		return this.payload;
	}
	public String getServiceId() {
		return this.serviceId;
	}
	public MessageType getMessageType() {
		return this.messageType;
	}
}
