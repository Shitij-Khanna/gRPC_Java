package com.khanna.grpc.client;

import java.util.concurrent.CountDownLatch;

import com.bank.models.Balance;

import io.grpc.stub.StreamObserver;

public class BalanceStreamObserver implements StreamObserver<Balance> {

	private CountDownLatch latch;
	
	public BalanceStreamObserver(CountDownLatch latch) {
		super();
		this.latch = latch;
	}

	@Override
	public void onNext(Balance balance) {
		System.out.println("Final balance "+balance.getAmount());
	}

	@Override
	public void onError(Throwable t) {
		this.latch.countDown();
	}

	@Override
	public void onCompleted() {
		System.out.println("Server is done : ");
		this.latch.countDown();
	}

}
