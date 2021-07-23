package com.khanna.grpc.server;

import com.bank.models.Balance;
import com.bank.models.DepositRequest;

import io.grpc.stub.StreamObserver;

public class CashStreamingRequest implements StreamObserver<DepositRequest> {
	
	private StreamObserver<Balance> balanceStreamObserver;
	private int balance;


	public CashStreamingRequest(StreamObserver<Balance> balanceStreamObserver) {
		super();
		this.balanceStreamObserver = balanceStreamObserver;
	}
	
	@Override
	public void onNext(DepositRequest request) {
		int accountNo = request.getAccountNumber();
		int amount = request.getAmount();
		this.balance = AccountDatabase.addBalance(accountNo, amount);
	}

	@Override
	public void onError(Throwable t) {
		
	}

	@Override
	public void onCompleted() {
		Balance balance = Balance.newBuilder().setAmount(this.balance).build();
		this.balanceStreamObserver.onNext(balance);
		this.balanceStreamObserver.onCompleted();
	}

}
