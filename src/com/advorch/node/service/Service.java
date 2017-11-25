package com.advorch.node.service;

import com.advorch.exception.AdvOrchException;

/*
 * 
 */
public abstract class Service {
	
	protected String serviceId;
	protected String payload;
	
	public Service(String serviceId, String payload) {
		this.serviceId = serviceId;
		this.payload = payload;
	}
	
	public void runIt() throws AdvOrchException {
		loadInputs();
		
		execute();
		
		returnOutput();
	}
	
	public abstract void execute() throws AdvOrchException;
	
	public abstract void loadInputs(String... inputs);
	
	public abstract void returnOutput();
	
	public String getId() {
		return this.serviceId;
	}
}
