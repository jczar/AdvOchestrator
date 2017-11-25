package com.advorch.director;

import java.util.Map;

import com.advorch.exception.AdvOrchException;

public class OrchestratorDirector {
	
	private Map eventMap = null;
	private final static OrchestratorDirector instance = new OrchestratorDirector();
	
	private OrchestratorDirector() { 
		runIt();
	}

	public void runIt() {
		// === Stuff for starting up the director
		
		// Loads up NodeRegisterer 
		// NodeRegisterer functions as a daemon thread that listens for new 
		// registering requests from nodes
		
		// Another option is to use RxJava registering Observables for Kafka streams
	}
	
	public OrchestratorDirector getInstance() {
		return instance;
	}
	
	public void processCommand(String commandStr) {
		if ((eventMap = Command.interpret(commandStr)) == null) {
			throw new AdvOrchException("There was a problem parsing user's command string");
		}
	}
	
	
	
	
	enum DirectorState {
		STOPPED,
		LOADING,
		UP,
		RUNNING
	}
}
