package com.rf.rt.payment.service;

import com.rf.rt.model.PaymentResult;
import com.rf.rt.payment.PaymentMethod;
import com.rf.rt.payment.enums.PaymentStatus;

public class RetryPaymentProcessor {

	private PaymentProcessor processor;

	// this can also be taken from properties file
	private static final int RETRY_LIMIT = 3;

	public RetryPaymentProcessor(PaymentProcessor processor) {
		this.processor = processor;
	}

	public PaymentResult process(PaymentMethod paymentMethod, double amount) {
		for (int i = 0; i < RETRY_LIMIT; i++) {
			PaymentResult paymentResult = processor.process(paymentMethod, amount);
			if (paymentResult.isSuccess())
				return paymentResult;
		}
		return new PaymentResult(false, PaymentStatus.FAILED.name());
	}

}
