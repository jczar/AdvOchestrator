package com.advorch.exception;

public class AdvOrchException extends RuntimeException {

    public AdvOrchException(String message) {
        super(message);
    }
    
    public AdvOrchException(Throwable t) {
    	super(t);
    }
    
    public AdvOrchException(String message, Throwable t) {
    	super(message, t);
    }
}
