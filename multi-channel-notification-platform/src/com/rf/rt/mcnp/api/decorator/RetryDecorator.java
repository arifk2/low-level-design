package com.rf.rt.mcnp.api.decorator;

import com.rf.rt.mcnp.api.model.Notification;
import com.rf.rt.mcnp.api.sender.NotificationSender;

public class RetryDecorator extends NotificationDecorator {

	public RetryDecorator(NotificationSender notificationSender) {
		super(notificationSender);
	}

	@Override
	public void sendNotification(Notification notification) {
		System.out.println("<<<<< RETRY ADDED >>>>>");
		notificationSender.sendNotification(notification);

	}

}
