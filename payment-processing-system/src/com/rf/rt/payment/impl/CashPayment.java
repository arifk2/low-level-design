package com.rf.rt.payment.impl;

import com.rf.rt.model.PaymentResult;
import com.rf.rt.payment.PaymentMethod;
import com.rf.rt.payment.ReceiptGenerator;
import com.rf.rt.payment.enums.PaymentStatus;

public class CashPayment implements PaymentMethod, ReceiptGenerator {

	@Override
	public boolean validate() {
		return true;
	}

	@Override
	public String generateReceipt() {
		return "Cash Payement Receipt";
	}

	@Override
	public PaymentResult pay(double amount) {
		System.out.println("Cash Payment: "+ amount);
		return new PaymentResult(true, PaymentStatus.SUCCESS.name());
	}

}
// no refund, no cashback, no unsupportedOpertaionException
