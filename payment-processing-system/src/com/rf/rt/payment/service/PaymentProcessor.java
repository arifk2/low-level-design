package com.rf.rt.payment.service;

import com.rf.rt.model.PaymentResult;
import com.rf.rt.payment.PaymentMethod;
import com.rf.rt.payment.enums.PaymentStatus;

public class PaymentProcessor {

	public PaymentResult process(PaymentMethod paymentMethod, double amount) {

		if (!paymentMethod.validate())
			return new PaymentResult(false, PaymentStatus.FAILED.name());

		return paymentMethod.pay(amount);
	}
}

// Payment Processor is depends on PaymentMethod: Dependency Inversion Principle
