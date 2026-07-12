package com.rf.rt.mcnp.api.decorator;

import com.rf.rt.mcnp.api.sender.NotificationSender;

public abstract class NotificationDecorator implements NotificationSender {
	protected NotificationSender notificationSender;

	protected NotificationDecorator(NotificationSender notificationSender) {
		this.notificationSender = notificationSender;
	}

	
}
