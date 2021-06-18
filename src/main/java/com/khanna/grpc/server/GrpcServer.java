package com.khanna.grpc.server;

import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class GrpcServer {

	public static void main(String[] args) {
		Server server = ServerBuilder.forPort(6565).addService(new BankService()).build();
		try {
			server.start();
			
			server.awaitTermination();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
