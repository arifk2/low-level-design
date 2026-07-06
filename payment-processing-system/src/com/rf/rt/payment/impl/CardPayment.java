package com.rf.rt.payment.impl;

import com.rf.rt.cashback.CardCashbackImpl;
import com.rf.rt.cashback.CashbackStrategy;
import com.rf.rt.model.PaymentResult;
import com.rf.rt.payment.CashbackProvider;
import com.rf.rt.payment.PaymentMethod;
import com.rf.rt.payment.ReceiptGenerator;
import com.rf.rt.payment.Refundable;
import com.rf.rt.payment.enums.PaymentStatus;

public class CardPayment implements PaymentMethod, Refundable, ReceiptGenerator, CashbackProvider {

	private CashbackStrategy cashbackStrategy;

	public CardPayment() {
		cashbackStrategy = new CardCashbackImpl();
	}

	@Override
	public double cashback(double amount) {
		return cashbackStrategy.calculate(amount);
	}

	@Override
	public String generateReceipt() {
		return "Card Payment Receipt";
	}

	@Override
	public void refund(double amount) {
		// if payment failed, then we need to refund
		System.out.println("Refunded amount: " + amount);

	}

	@Override
	public boolean validate() {
		// check whether card is valid
		return true;
	}

	@Override
	public PaymentResult pay(double amount) {
		// logic if the card is not having sufficient balance then payment failed with
		// failed response
		System.out.println("Card Payment: " + amount);
		return new PaymentResult(true, PaymentStatus.SUCCESS.name());
	}

}
