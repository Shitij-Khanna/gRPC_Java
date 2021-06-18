package com.khanna.grpc.server;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Shitij Khanna
 * 
 *         This is a DB account no 1 -> balance 10 2 ==> 20 3 ==> 30 Also
 *         contains methods to add and deduct balance from the account
 */
public class AccountDatabase {

	private static final Map<Integer, Integer> MAP = IntStream.rangeClosed(1, 10).boxed()
			.collect(Collectors.toMap(Function.identity(), v -> v * 10));

	public static Integer getBalance(int accountID) {
		return MAP.get(accountID);
	}

	public static Integer addBalance(int accountID, int amount) {
		return MAP.computeIfPresent(accountID, (k, v) -> v + amount);
	}

	public static Integer deductBalance(int accountID, int amount) {
		return MAP.computeIfPresent(accountID, (k, v) -> v - amount);
	}
}
