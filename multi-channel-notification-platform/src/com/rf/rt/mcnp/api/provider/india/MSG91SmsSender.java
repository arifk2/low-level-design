package com.rf.rt.mcnp.api.provider.india;

import com.rf.rt.mcnp.api.model.Notification;
import com.rf.rt.mcnp.api.sender.SmsSender;

public class MSG91SmsSender implements SmsSender {

	@Override
	public void sendNotification(Notification notification) {

		System.out.println("====== MSG91 SMS ======");
		System.out.println(notification.getMessage());
	}
}
