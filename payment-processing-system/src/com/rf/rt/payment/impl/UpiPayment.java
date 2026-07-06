package com.rf.rt.payment.impl;

import com.rf.rt.model.PaymentResult;
import com.rf.rt.payment.PaymentMethod;
import com.rf.rt.payment.ReceiptGenerator;
import com.rf.rt.payment.Refundable;
import com.rf.rt.payment.enums.PaymentStatus;

/**
 * No cashback for UPI
 */
public class UpiPayment implements PaymentMethod, Refundable, ReceiptGenerator {

	@Override
	public String generateReceipt() {
		return "UPI Payment Receipt";
	}

	@Override
	public void refund(double amount) {
		System.out.println("UPI Refund");
	}

	@Override
	public boolean validate() {
		// check validation does upi limit crossed or balance not available
		return true;
	}

	@Override
	public PaymentResult pay(double amount) {
		System.out.println("UP Payment: " + amount);
		return new PaymentResult(true, PaymentStatus.SUCCESS.name());
	}

}
