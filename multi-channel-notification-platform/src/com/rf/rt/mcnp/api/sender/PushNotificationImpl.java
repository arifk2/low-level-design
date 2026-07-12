package com.rf.rt.mcnp.api.sender;

import com.rf.rt.mcnp.api.model.Notification;

public class PushNotificationImpl implements NotificationSender {

	@Override
	public void sendNotification(Notification notification) {
		System.out.println("Pushing Notification from Push Notifcation: " + notification);
	}
}
