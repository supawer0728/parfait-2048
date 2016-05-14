package com.parfait.tzfe.utils;

import java.util.Random;

public class BlockRandomValueGenerator {

	private static final int RAND_BOUND = 2;
	private static final int RAND_ADD = 1;
	private static final double BASE_VALUE = 2.0;

	public static int generateBlockRandomValue() {
		int power = new Random(System.currentTimeMillis()).nextInt(RAND_BOUND) + RAND_ADD;
		return (int) Math.pow(BASE_VALUE, power);
	}
}
