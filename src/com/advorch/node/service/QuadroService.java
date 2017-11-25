package com.advorch.node.service;

import com.advorch.exception.AdvOrchException;

public class QuadroService extends Service {

	public QuadroService(String serviceId, String payload) {
		super(serviceId, payload);
	}
	
	public void execute() throws AdvOrchException {		
		print("Executing Quadro operation");
	}
	
	public void loadInputs(String... inputs) {
		print("Loading inputs");
	}
	
	public void returnOutput() {
		print("Returning output");
	}
	
	private void print(String msg) {
		System.out.println("[" + this.getClass().getName() + " - " + serviceId + "]: " + msg);
	}
}
