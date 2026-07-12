package com.rf.rt.mcnp.api.sender;

import com.rf.rt.mcnp.api.model.Notification;

public interface NotificationSender {

	public void sendNotification(Notification notification);
}
