package com.rf.rt.mcnp.api.provider.us;

import com.rf.rt.mcnp.api.model.Notification;
import com.rf.rt.mcnp.api.sender.SmsSender;

public class TwilioSmsSender implements SmsSender {

	@Override
	public void sendNotification(Notification notification) {
		System.out.println("====== Twilio SMS ======");
		System.out.println(notification);
	}
}
