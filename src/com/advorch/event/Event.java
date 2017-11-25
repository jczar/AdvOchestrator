package com.advorch.event;

public class Event {

	private String nodeId; 
	private String action;
	private int actionHashCode = 0;
	
	private EventType eventType;
    private int seq = 0;
	
	public Event(String nodeId, String action, int actionHashCode, EventType eventType) {
		this.nodeId = nodeId;
		this.action = action;
		actionHashCode = action.hashCode();
		
		this.eventType = eventType;
	}
	
	public String getNodeId() {
		return nodeId;
	}
	
	public String getAction() {
		return action;
	}
	
	public int getActionHashCode() {
		return actionHashCode;
	}
	
	public EventType getEventType() {
		return eventType;
	}
	
	@Override
	public int hashCode() {
		
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null || !(o instanceof Event))
			return false;
		
		Event e = (Event) o;
		if (e.nodeId == null & this.nodeId == null) 
	}
}
