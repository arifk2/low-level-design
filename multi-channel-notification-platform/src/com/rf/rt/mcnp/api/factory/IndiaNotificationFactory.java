package com.rf.rt.mcnp.api.factory;

import com.rf.rt.mcnp.api.provider.india.AmazonSESEmailSender;
import com.rf.rt.mcnp.api.provider.india.MSG91SmsSender;
import com.rf.rt.mcnp.api.provider.india.OneSignalPushSender;
import com.rf.rt.mcnp.api.sender.EmailSender;
import com.rf.rt.mcnp.api.sender.PushSender;
import com.rf.rt.mcnp.api.sender.SmsSender;

public class IndiaNotificationFactory implements NotificationProviderFactory {

	@Override
	public EmailSender createEmailSender() {
		return new AmazonSESEmailSender();
	}

	@Override
	public SmsSender createSMSSender() {
		return new MSG91SmsSender();
	}

	@Override
	public PushSender createPushSender() {
		return new OneSignalPushSender();
	}

}
