package com.rf.rt.mcnp.api.factory;

import com.rf.rt.mcnp.api.provider.us.FirebasePushSender;
import com.rf.rt.mcnp.api.provider.us.SendGridEmailSender;
import com.rf.rt.mcnp.api.provider.us.TwilioSmsSender;
import com.rf.rt.mcnp.api.sender.EmailSender;
import com.rf.rt.mcnp.api.sender.PushSender;
import com.rf.rt.mcnp.api.sender.SmsSender;

public class USNotificationFactory implements NotificationProviderFactory {

	@Override
	public EmailSender createEmailSender() {
		return new SendGridEmailSender();
	}

	@Override
	public SmsSender createSMSSender() {
		return new TwilioSmsSender();
	}

	@Override
	public PushSender createPushSender() {
		return new FirebasePushSender();
	}
}
