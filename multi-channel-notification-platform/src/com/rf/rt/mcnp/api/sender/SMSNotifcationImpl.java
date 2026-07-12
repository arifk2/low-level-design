package com.rf.rt.mcnp.api.sender;

import com.rf.rt.mcnp.api.model.Notification;

public class SMSNotifcationImpl implements NotificationSender {

	@Override
	public void sendNotification(Notification notification) {
		System.out.println("Pushing Notification from SMS Notification: " + notification);
	}
}
