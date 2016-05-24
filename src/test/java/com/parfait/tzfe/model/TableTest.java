package com.parfait.tzfe.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.parfait.tzfe.service.TableMoveImpl;
import com.parfait.tzfe.service.TableMoveService;
import com.parfait.tzfe.utils.BlockRandomValueGenerator;

import static org.junit.Assert.assertEquals;
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

	@Test
	public void testMoveRight() throws Exception {

		TableMoveService moveService = new TableMoveImpl();

		for (int i = 0; i < 10; i++) {
			Table table = Table.getInstance();
			Block[][] blocks = table.getBlocks();

			Block[] expected = new Block[table.getRowSize()];

			for (int j = 0; j < table.getRowSize(); j++) {
				table.fillWithNewBlock();
			}

			System.out.println("===== before =====");
			table.printToConsole();

			moveService.move(table, Direction.RIGHT);

			System.out.println("===== after =====");
			table.printToConsole();
		}
	}
}
