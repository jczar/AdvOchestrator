package com.advorch.node.service;

public abstract class BlockeableContainer extends GenericContainer implements Runnable {
	
	private Object lock = new Object();
	
	private final static int BLOCK_TIMEOUT = 5000;
	private boolean isWaitingForResponse = false; 
	
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
		
		synchronized (lock) {
			isWaitingForResponse = true;
			try {
				lock.wait(BLOCK_TIMEOUT);
				
				isWaiting
			} catch (InterruptedException ie) {
				
			}
		}
		// this.getLock().wait();
	}
}
