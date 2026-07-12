package com.rf.rt.mcnp.api.provider.india;

import com.rf.rt.mcnp.api.model.Notification;
import com.rf.rt.mcnp.api.sender.PushSender;

public class OneSignalPushSender implements PushSender {

	@Override
	public void sendNotification(Notification notification) {

		System.out.println("====== OneSignal Push ======");
		System.out.println(notification.getMessage());
	}

}
