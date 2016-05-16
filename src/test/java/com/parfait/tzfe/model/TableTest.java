package com.parfait.tzfe.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TableTest {

	@Test
	public void testFillWithBlock() throws Exception {

		Table table = Table.getInstance();

		int repeat = table.getColSize() * table.getRowSize();

		Set<Point> pointSet = new HashSet<>(repeat);

		for (int i = 0; i < repeat; i++) {

			Block createdBlock = table.fillWithNewBlock();

			assertFalse(pointSet.contains(createdBlock.getPoint()));

			pointSet.add(createdBlock.getPoint());
		}

		assertTrue(table.isFull());

		table.printToConsole();
	}
}
