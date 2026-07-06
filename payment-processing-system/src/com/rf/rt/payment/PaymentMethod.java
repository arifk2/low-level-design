package com.rf.rt.payment;

import com.rf.rt.model.PaymentResult;

public interface PaymentMethod {

	public boolean validate();

	public PaymentResult pay(double amount);

}
