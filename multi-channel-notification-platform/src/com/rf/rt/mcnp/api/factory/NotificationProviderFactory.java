package com.rf.rt.mcnp.api.factory;

import com.rf.rt.mcnp.api.sender.EmailSender;
import com.rf.rt.mcnp.api.sender.PushSender;
import com.rf.rt.mcnp.api.sender.SmsSender;

public interface NotificationProviderFactory {
	
	EmailSender createEmailSender();

	SmsSender createSMSSender();

	PushSender createPushSender();
}
