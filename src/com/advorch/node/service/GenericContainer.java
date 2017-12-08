package com.advorch.node.service;

import com.advorch.exception.AdvOrchException;

public abstract class GenericContainer {

	public abstract void execute() throws AdvOrchException;
	
	public abstract void onNodeStart();
	
	public abstract void onNodeEnd();
	
	public abstract void onNodeFailed(Throwable t);
	
	public abstract void onNodeSuspended();
	
	public void runIt() throws AdvOrchException {
		onNodeStart();
		
		try {
		    execute();
		    
		} catch (AdvOrchException oe) {
			onNodeFailed(oe);
			throw oe;
			
		} catch (Exception e) {
			onNodeFailed(e);
			throw new AdvOrchException("", e);
		}
		
		onNodeEnd();
	}

}
