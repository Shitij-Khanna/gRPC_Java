package com.khanna.grpc.client;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;

import com.bank.models.Balance;
import com.bank.models.BalanceCheckRequest;
import com.bank.models.BankServiceGrpc;
import com.bank.models.WithdrawRequest;
import com.google.common.util.concurrent.Uninterruptibles;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BankClientTest {

	private BankServiceGrpc.BankServiceBlockingStub blockingStub;
	
	private BankServiceGrpc.BankServiceStub bankServiceStub;

	@Test
	public void balanceTest() {
		ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 6565).usePlaintext().build();

		this.blockingStub = BankServiceGrpc.newBlockingStub(managedChannel);

		BalanceCheckRequest request = BalanceCheckRequest.newBuilder().setAccountNumber(2).build();
		Balance balance = this.blockingStub.getBalance(request);
		System.out.println("Received : " + balance.getAmount());
	}
	
	@Test
	public void withdrawTest() {
		ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 6565).usePlaintext().build();

		this.blockingStub = BankServiceGrpc.newBlockingStub(managedChannel);
		
		WithdrawRequest request = WithdrawRequest.newBuilder().setAccountNumber(7).setAmount(20).build();
		this.blockingStub.withdraw(request).forEachRemaining(money-> {
			System.out.println("Received : "+money.getValue());
		});;
	}
	
	@Test
	public void withdrawTestAsync() {
		ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 6565).usePlaintext().build();

		WithdrawRequest request = WithdrawRequest.newBuilder().setAccountNumber(10).setAmount(50).build();
		this.bankServiceStub = BankServiceGrpc.newStub(managedChannel);
		
		this.bankServiceStub.withdraw(request, new MoneyStreamingResponse());
		
		Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
	}

}
