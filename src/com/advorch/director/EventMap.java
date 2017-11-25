package com.advorch.director;

import java.util.HashMap;

import com.advorch.event.EventType;

public class EventMap extends HashMap<String, String> {

	private final static String ROOT_ID = "*"; 
	
	private String nodeId; 
	private String action;
	private EventType eventType;
	
	public EventMap() {
		super();
	}
	
	// Event Map should be defined by something simple like the following:
	
	// Key: Structure of <nodeid>-<action>-<source_event> 
	// Value: <nodeid>-<action>-<target-event>
	
	// This event map should be re-thought in the context of a reactive architecture
	// Ideally we'd use a Hash or some encrypted version of the action so we don't have to use it in the actual event key
	
	public String put(String sourceNode, String action, EventType sourceEvent, String targetNode, String action, EventType targetEvent) {
		return super.put(sourceNode + ":" + action + ":" + sourceEvent, targetNode + ":" + action + ":" + targetEvent);
	}
	
    public String get(String sourceNode, String action, EventType sourceEvent) {
    	return super.get(sourceNode + ":" + action + ":" + sourceEvent);
    }
	
    
    private void addToRoot(String sourceNode, String action) {
    	super.put(ROOT_ID, sourceNode + ":" + action + ":" + EventType.START);
    }
}
