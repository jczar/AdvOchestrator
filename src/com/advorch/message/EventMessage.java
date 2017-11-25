package com.advorch.message;

import com.advorch.event.EventType;

public class EventMessage {
    
	private EventType eventType;
	private String nodeId;
	private String serviceId;
	private String payload;
	
	public EventMessage(EventType eventType, String nodeId) {
		this(eventType, nodeId, null);
	}

	public EventMessage(EventType eventType, String nodeId, String serviceId) {
		this(eventType, nodeId, serviceId, null);
	}

	public EventMessage(EventType eventType, String nodeId, String serviceId, String payload) {
		this.eventType = eventType;
		this.nodeId = nodeId;
		this.payload = payload;
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
}
