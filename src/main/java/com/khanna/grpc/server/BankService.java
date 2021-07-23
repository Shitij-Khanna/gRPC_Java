package com.khanna.grpc.server;

import com.bank.models.Balance;
import com.bank.models.BalanceCheckRequest;
import com.bank.models.BankServiceGrpc.BankServiceImplBase;
import com.bank.models.DepositRequest;
import com.bank.models.Money;
import com.bank.models.WithdrawRequest;

import io.grpc.Status;
import io.grpc.stub.StreamObserver;

//public class BankService{
public class BankService extends BankServiceImplBase {

	@Override
	public void getBalance(BalanceCheckRequest request, StreamObserver<Balance> responseObserver) {
//		super.getBalance(request, responseObserver);
		int accountNumber = request.getAccountNumber();

		Balance balance = Balance.newBuilder().setAmount(AccountDatabase.getBalance(accountNumber)).build();
		responseObserver.onNext(balance);
		responseObserver.onCompleted();
	}

	@Override
	public void withdraw(WithdrawRequest request, StreamObserver<Money> responseObserver) {
//		super.withdraw(request, responseObserver);
		int accountNumber = request.getAccountNumber();
		int amount = request.getAmount(); // 10,20,30 bcoz amount can be deducted in sets of 10 by the accountAA
		int balance = AccountDatabase.getBalance(accountNumber);

		if (balance < amount) {
			Status status = Status.FAILED_PRECONDITION
					.withDescription("Not enough money in account. You have only : " + balance);
			responseObserver.onError(status.asRuntimeException());
			return;
		}

		// validations are passed
		for (int i = 0; i < amount / 10; i++) {
			Money money = Money.newBuilder().setValue(10).build();
			responseObserver.onNext(money);
			AccountDatabase.deductBalance(accountNumber, 10);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		responseObserver.onCompleted();
	}

	@Override
	public StreamObserver<DepositRequest> deposit(StreamObserver<Balance> responseObserver) {
		return new CashStreamingRequest(responseObserver);
	}

}
