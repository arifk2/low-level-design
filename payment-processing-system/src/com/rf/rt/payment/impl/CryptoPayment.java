package com.rf.rt.payment.impl;

import com.rf.rt.model.PaymentResult;
import com.rf.rt.payment.PaymentMethod;
import com.rf.rt.payment.ReceiptGenerator;
import com.rf.rt.payment.enums.PaymentStatus;

public class CryptoPayment implements PaymentMethod, ReceiptGenerator {

	@Override
	public String generateReceipt() {

		return "Crypto Payment Receipt";
	}

	@Override
	public boolean validate() {
		// validation
		return true;
	}

	@Override
	public PaymentResult pay(double amount) {
		System.out.println("Crypto Payment " + amount);
		return new PaymentResult(true, PaymentStatus.SUCCESS.name());
	}

}

// Added new implement OCP, open for extension, without modifying anything