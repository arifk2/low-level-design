package com.rf.rt.payment.impl;

import com.rf.rt.model.PaymentResult;
import com.rf.rt.payment.PaymentMethod;
import com.rf.rt.payment.ReceiptGenerator;
import com.rf.rt.payment.Refundable;
import com.rf.rt.payment.Schedulable;
import com.rf.rt.payment.enums.PaymentStatus;

public class WalletPayment implements PaymentMethod, ReceiptGenerator, Refundable, Schedulable {

	@Override
	public void schedule(double amount) {
		System.out.println("Scheduled : " + amount);
	}

	@Override
	public void cancelSchedule() {
		System.out.println("Cancelled scheduled");
	}

	@Override
	public void refund(double amount) {
		System.out.println("Wallet Refund");
	}

	@Override
	public String generateReceipt() {
		return "Wallent Payment Receipt";
	}

	@Override
	public boolean validate() {
		// validate the wallet
		return true;
	}

	@Override
	public PaymentResult pay(double amount) {
		System.out.println("Wallet Payment");
		return new PaymentResult(true, PaymentStatus.SUCCESS.name());
	}

}
