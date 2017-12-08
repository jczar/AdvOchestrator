package com.advorch.node.service;

public abstract class BlockeableContainer extends GenericContainer implements Runnable {
	
	private Object lock = new Object();
	
	@Override
	public void run() {
		runIt();
	}
	
	protected Object getLock() {
		return lock;
	}

	// Quits the execution of the current container thread
	public void halt() {
	    // Some way to end container thread	
		synchronized (getLock()) {
			
		}
	}
	
	public void block() {
		//
		// this.getLock().wait();
	}
}
