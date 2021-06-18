package com.khanna.grpc.client;

import com.bank.models.Money;

import io.grpc.stub.StreamObserver;

public class MoneyStreamingResponse implements StreamObserver<Money>{

	@Override
	public void onNext(Money money) {
		System.out.println("Received async : " + money.getValue());
	}

	@Override
	public void onError(Throwable t) {
		System.out.println("Received error : " + t.getMessage());
		
	}

	@Override
	public void onCompleted() {
		System.out.println("Server done " );
	}

}
