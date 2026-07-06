package com.rf.rt.cashback;

public class CardCashbackImpl implements CashbackStrategy {

	@Override
	public double calculate(double amount) {
		return amount * 0.05;
	}

}
