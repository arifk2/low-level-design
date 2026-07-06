package com.rf.rt.cashback;

public class NoCashbackImpl implements CashbackStrategy {

	@Override
	public double calculate(double amount) {
		return 0;
	}

}
