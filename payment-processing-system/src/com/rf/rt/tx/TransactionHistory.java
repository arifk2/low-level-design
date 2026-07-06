package com.rf.rt.tx;

import java.util.ArrayList;
import java.util.List;

import com.rf.rt.model.Transaction;

public class TransactionHistory {
	private List<Transaction> history;

	public TransactionHistory() {
		history = new ArrayList<>();
	}

	public void add(Transaction tx) {
		history.add(tx);
	}

	public void printTx() {
		history.stream().forEach(System.out::println);
	}

}
