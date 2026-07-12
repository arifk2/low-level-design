package com.rf.rt.mcnp.api.provider.india;

import com.rf.rt.mcnp.api.model.Notification;
import com.rf.rt.mcnp.api.sender.EmailSender;

public class AmazonSESEmailSender implements EmailSender {

	 @Override
	    public void sendNotification(Notification notification) {

	        System.out.println("====== Amazon SES ======");
	        System.out.println("To      : " + notification.getRecipient());
	        System.out.println("Title   : " + notification.getTitle());
	        System.out.println("Message : " + notification.getMessage());
	    }
}
