package com.rf.rt.mcnp.api.decorator;

import com.rf.rt.mcnp.api.model.Notification;
import com.rf.rt.mcnp.api.sender.NotificationSender;

public class EncryptionDecorator extends NotificationDecorator {

	public EncryptionDecorator(NotificationSender notificationSender) {
		super(notificationSender);
	}

	@Override
	public void sendNotification(Notification notification) {
		System.out.println("<<<<< ENCRYPTIION ADDED >>>>>");
		notificationSender.sendNotification(notification);
	}
}
