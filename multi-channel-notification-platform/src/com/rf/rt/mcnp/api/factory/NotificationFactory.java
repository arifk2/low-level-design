package com.rf.rt.mcnp.api.factory;

import com.rf.rt.mcnp.api.enums.NotificationType;
import com.rf.rt.mcnp.api.sender.EmailNotificationImpl;
import com.rf.rt.mcnp.api.sender.NotificationSender;
import com.rf.rt.mcnp.api.sender.PushNotificationImpl;
import com.rf.rt.mcnp.api.sender.SMSNotifcationImpl;

public class NotificationFactory {

	private NotificationFactory() {
	}

	public static NotificationSender create(NotificationType type) {
		switch (type) {
		case EMAIL:
			return new EmailNotificationImpl();
		case SMS:
			return new SMSNotifcationImpl();
		case PUSH:
			return new PushNotificationImpl();
		default:
			throw new IllegalArgumentException("Unexpected value: ");
		}
	}
}
