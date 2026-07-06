package com.rf.rt.model;

public class Transaction {
	private long transactionId;
	private String transactionStatus;
	private double amount;

	public Transaction(long transactionId, String transactionStatus, double amount) {
		this.transactionId = transactionId;
		this.transactionStatus = transactionStatus;
		this.amount = amount;
	}

	public long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", transactionStatus=" + transactionStatus + ", amount="
				+ amount + "]";
	}

	
}
