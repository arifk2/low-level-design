package com.rf.rt.main;

import com.rf.rt.payment.impl.CardPayment;
import com.rf.rt.payment.impl.CashPayment;
import com.rf.rt.payment.impl.CryptoPayment;
import com.rf.rt.payment.impl.UpiPayment;
import com.rf.rt.payment.impl.WalletPayment;
import com.rf.rt.payment.service.PaymentProcessor;

public class PaymentProcessingDriver {
	public static void main(String[] args) {
		PaymentProcessor processor = new PaymentProcessor();

		/********************* CARD PAYMENT *****************************/
		CardPayment cardPayment = new CardPayment();
		double payByCard = 500;

		processor.process(cardPayment, payByCard);
		System.out.println(cardPayment.generateReceipt());
		System.out.println(cardPayment.cashback(payByCard));
		cardPayment.refund(200);

		/********************* UPI PAYMENT *****************************/
		UpiPayment upiPayment = new UpiPayment();
		double payByUPI = 1000;
		processor.process(upiPayment, payByUPI);
		System.out.println(upiPayment.generateReceipt());

		/********************* WALLET PAYMENT *****************************/
		WalletPayment walletPayment = new WalletPayment();
		double payByWallet = 2000;
		walletPayment.schedule(payByWallet);
		walletPayment.cancelSchedule();

		/********************* CASH PAYMENT *****************************/
		CashPayment cashPayment = new CashPayment();
		processor.process(cashPayment, 399);

		/********************* CRYPTO PAYMENT *****************************/
		CryptoPayment cryptoPayment = new CryptoPayment();
		processor.process(cryptoPayment, 8999);
		System.out.println(cryptoPayment.generateReceipt());

	}
}
