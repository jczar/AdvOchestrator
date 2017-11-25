package com.advorch.event;

public enum EventType {

	START("ST"),
	END("E");
	
	private String eventType;
	
	private EventType(String eventType) {
		this.eventType = eventType;
	}
	public String getType() {
		return eventType;
	}
}
