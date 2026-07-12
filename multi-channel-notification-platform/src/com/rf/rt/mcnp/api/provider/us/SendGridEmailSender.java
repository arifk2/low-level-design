package com.rf.rt.mcnp.api.provider.us;

import com.rf.rt.mcnp.api.model.Notification;
import com.rf.rt.mcnp.api.sender.EmailSender;

public class SendGridEmailSender implements EmailSender {

	@Override
	public void sendNotification(Notification notification) {
		System.out.println("====== SendGrid Email ======");
		System.out.println(notification.getMessage());
	}
}
