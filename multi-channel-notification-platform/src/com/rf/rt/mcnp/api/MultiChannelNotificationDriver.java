package com.rf.rt.mcnp.api;

import com.rf.rt.mcnp.api.decorator.EncryptionDecorator;
import com.rf.rt.mcnp.api.decorator.LoggingDecorator;
import com.rf.rt.mcnp.api.decorator.RetryDecorator;
import com.rf.rt.mcnp.api.enums.Priority;
import com.rf.rt.mcnp.api.enums.Region;
import com.rf.rt.mcnp.api.factory.NotificationProviderFactory;
import com.rf.rt.mcnp.api.factory.ProviderFactoryProducer;
import com.rf.rt.mcnp.api.model.Notification;
import com.rf.rt.mcnp.api.sender.NotificationSender;

public class MultiChannelNotificationDriver {
	public static void main(String[] args) {
		Notification notification = new Notification.NotificationBuilder().setTitle("Hello Notification")
				.setMessage("Please join us").setRecipient("khanrf19@gmail.com").setPriority(Priority.HIGH).build(); // builder

		NotificationProviderFactory factory = ProviderFactoryProducer.getFactory(Region.INDIA); // factory
		NotificationSender sender = factory.createEmailSender();	//abstract factory
		sender = new EncryptionDecorator(new RetryDecorator(new LoggingDecorator(sender))); // decorator
		sender.sendNotification(notification);
	}
}
