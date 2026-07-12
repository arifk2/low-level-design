package com.rf.rt.mcnp.api.factory;

import com.rf.rt.mcnp.api.enums.Region;

public class ProviderFactoryProducer {

	private ProviderFactoryProducer() {
	}

	public static NotificationProviderFactory getFactory(Region region) {
		switch (region) {
		case INDIA:
			return new IndiaNotificationFactory();
		case US:
			return new USNotificationFactory();
		default:
			throw new IllegalArgumentException("Unexpected value: " + region);
		}
	}
}
