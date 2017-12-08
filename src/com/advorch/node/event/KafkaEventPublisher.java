package com.advorch.node.event;

import com.advorch.message.EventMessage;

public class KafkaEventPublisher implements EventPublisher {

	@Override
	public boolean publishEvent(EventMessage eventMessage) {
		// TODO Auto-generated method stub
		String encodedEventMsg = new DefaultEventDataEncoder().encodeEvent(eventMessage);
		// Publish to Kafka topic
		
	}
	
}
