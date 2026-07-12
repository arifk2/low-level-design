package com.rf.rt.mcnp.api.decorator;

import com.rf.rt.mcnp.api.model.Notification;
import com.rf.rt.mcnp.api.sender.NotificationSender;

public class LoggingDecorator extends NotificationDecorator {

	public LoggingDecorator(NotificationSender notificationSender) {
		super(notificationSender);
	}

	@Override
	public void sendNotification(Notification notification) {
		System.out.println("<<<<< LOGGING ADDED >>>>>");
		notificationSender.sendNotification(notification);
	}
}
