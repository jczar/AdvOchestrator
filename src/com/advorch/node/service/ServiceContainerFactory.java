package com.advorch.node.service;

import com.advorch.node.event.NodeEventAware;

public class ServiceContainerFactory {

	private ServiceContainerFactory() {
	}
	
	public static ServiceContainer createServiceContainer(SERVICE_TYPE serviceType, String serviceId, String payload, NodeEventAware eventHandler) {
		switch (serviceType) {
		    case QUADRO: return new ServiceContainer(new QuadroService(serviceId, payload), eventHandler);	
		}
		
		return null;
	}
	
	public enum SERVICE_TYPE {
		QUADRO
	}
}
