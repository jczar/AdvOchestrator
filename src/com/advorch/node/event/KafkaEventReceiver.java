package com.advorch.node.event;

import com.advorch.message.EventMessage;

public class KafkaEventReceiver implements EventReceiver {

	private int blockTimeout = 0;
	private int NUMBER_OF_QUEUE_CHECKS = 3; 
	
	public KafkaEventReceiver(int blockTimeout) {
		this.blockTimeout = blockTimeout;		
	}
	
	/*
	 * This method blocks for the defined time until an eventmessage of type RESPONSE
	 * is received from the Kafka Server 
	 * 
	 * (non-Javadoc)
	 * @see com.advorch.node.event.EventReceiver#receiveEvent()
	 */
	public EventMessage receiveEvent() {
	
		boolean received = false;
		int checks = 0;
		while (!received && checks <= NUMBER_OF_QUEUE_CHECKS) {
			
			// Should make sure to use a sleep time
			// that's less than the blockTimeout
			Thread.sleep((int) (blockTimeout / NUMBER_OF_QUEUE_CHECKS));
			
			// if (Kafka has response messsage) then received = true;
			
			checks++;
		}
		
		return new EventMessage();
	}
	
	
	static class EllapsedTimeChecker {
		
		private Date startedTime
		
		public void 
		
	}
}
