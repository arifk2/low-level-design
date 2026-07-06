package com.rf.rt.payment;

public interface Schedulable {

	void schedule(double amount);

	void cancelSchedule();
}
