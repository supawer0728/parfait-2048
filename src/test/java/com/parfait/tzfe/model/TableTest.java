package com.parfait.tzfe.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

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

		Table table = Table.getInstance();
		Block[][] blocks = table.getBlocks();

		Block[] expected = new Block[table.getRowSize()];

		for (int i = 0; i < table.getRowSize(); i++) {
			blocks[i][0] = Block.getInstanceWithPointAndValue(
					new Point(0, i), BlockRandomValueGenerator.generateBlockRandomValue());
			expected[i] = blocks[i][0];
		}

		table.printToConsole();

		table.moveBlocksTo(Direction.RIGHT);

		table.printToConsole();

		for (int i = 0; i < table.getRowSize(); i++) {
			assertEquals(expected[i].getValue(), blocks[i][table.getColSize() - 1].getValue());
			assertEquals(blocks[i][table.getColSize() - 1].getPoint().getX(), table.getColSize() - 1);
			assertEquals(blocks[i][table.getColSize() - 1].getPoint().getY(), i);
		}

		blocks[0][0] = Block.getInstanceWithPointAndValue(
				new Point(0, 0), BlockRandomValueGenerator.generateBlockRandomValue());

		table.printToConsole();
		table.moveBlocksTo(Direction.RIGHT);
		table.printToConsole();
	}
}
