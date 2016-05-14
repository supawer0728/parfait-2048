package com.parfait.tzfe.utils;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class BlockRandomValueGeneratorTest {

	@Test
	public void testGenerateBlockRandomValue() throws Exception {

		for (int i = 0; i < 10000; i++) {
			int random = BlockRandomValueGenerator.generateBlockRandomValue();
			if (random != 2 && random != 4) {
				fail(String.format("random : %d\n", random));
			}
		}
	}
}
