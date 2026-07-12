package com.rf.rt.mcnp.api.provider.us;

import com.rf.rt.mcnp.api.model.Notification;
import com.rf.rt.mcnp.api.sender.PushSender;

public class FirebasePushSender implements PushSender {

	@Override
	public void sendNotification(Notification notification) {
		System.out.println("====== FIREBASE PUSH SENDER ======");
		System.out.println(notification.getMessage());
	}
}
