package com.rf.rt.mcnp.api.sender;

import com.rf.rt.mcnp.api.model.Notification;

public class EmailNotificationImpl implements NotificationSender {

	@Override
	public void sendNotification(Notification notification) {
		System.out.println("Pushing Notification from Email Notification: " + notification);
	}
}
