package com.parfait.tzfe.service;

import com.parfait.tzfe.model.Block;
import com.parfait.tzfe.model.Direction;
import com.parfait.tzfe.model.Point;
import com.parfait.tzfe.model.Table;

public class TableMoveImpl implements TableMoveService {

	@Override
	public void move(Table table, Direction direction) {

		switch (direction) {
			case RIGHT:
			case LEFT:
				moveAllBlocksHorizontally(table.getBlocks(), direction);
				break;
			case UP:
			case DOWN:
				moveAllBlocksVertically(table.getBlocks(), direction);
				break;
		}
	}

	private void moveAllBlocksHorizontally(Block[][] blocks, Direction direction) {
		int repeat = blocks.length;
		for (int i = 0; i < repeat; i++) {
			moveBlocksWithinRow(blocks, i, direction);
		}
	}

	private void moveBlocksWithinRow(Block[][] blocks, int rowIndex, Direction direction) {

		int colSize = blocks.length;

		int from = (direction == Direction.LEFT) ? 0 : colSize - 1;
		int to = (direction == Direction.LEFT) ? colSize : -1;
		int interval = (direction == Direction.LEFT) ? 1 : -1;

		for (int colIndex = from; colIndex != to; colIndex += interval) {

			if (blocks[rowIndex][colIndex] == null) {

				Integer notNullBlockIndex = findNotNullBlockIndexInRow(blocks, rowIndex, colIndex + interval, to, interval);
				if (notNullBlockIndex == null) {
					break;
				}

				copyBlock(blocks, rowIndex, notNullBlockIndex, rowIndex, colIndex);
				clear(blocks, rowIndex, notNullBlockIndex);
			}
		}
	}

	private Integer findNotNullBlockIndexInRow(Block[][] blocks, int rowIndex, int from, int to, int interval) {
		for (int i = from; i != to; i += interval) {
			if (blocks[rowIndex][i] != null) {
				return i;
			}
		}

		return null;
	}

	private void copyBlock(Block[][] blocks, int fromRow, int fromCol, int toRow, int toCol) {

		blocks[toRow][toCol] = blocks[fromRow][fromCol];
		blocks[toRow][toCol].setPoint(new Point(toCol, toRow));
	}

	private void clear(Block[][] blocks, int row, int col) {

		blocks[row][col] = null;
	}

	private void moveAllBlocksVertically(Block[][] blocks, Direction direction) {

	}
}
