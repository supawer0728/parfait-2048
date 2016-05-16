package com.parfait.tzfe.model;

import com.parfait.tzfe.exception.InvokeNewBlockException;
import com.parfait.tzfe.utils.BlockRandomValueGenerator;

import lombok.Data;

@Data
public class Table {

	public static final int ROW_SIZE = 4;
	public static final int COL_SIZE = 4;

	private int rowSize;
	private int colSize;
	private Block[][] blocks;

	private int score;

	private Table() {}

	public static Table getInstaceWithRowAndColSize(int rowSize, int colSize) {

		Table table = new Table();

		table.rowSize = rowSize;
		table.colSize = colSize;
		table.blocks = new Block[rowSize][colSize];

		return table;
	}

	public static Table getInstance() {
		return getInstaceWithRowAndColSize(ROW_SIZE, COL_SIZE);
	}

	public Block fillWithNewBlock() throws InvokeNewBlockException {

		Point newBlockPoint = getNewBlockPoint();
		Integer blockValue = BlockRandomValueGenerator.generateBlockRandomValue();
		Block block = Block.getInstanceWithPointAndValue(newBlockPoint, blockValue);
		blocks[block.getPoint().getY()][block.getPoint().getX()] = block;

		return block;
	}

	public boolean isFull() {

		for (int x = 0; x < colSize; x++) {
			for (int y = 0; y < rowSize; y++) {
				if (blocks[y][x] == null) {
					return false;
				}
			}
		}

		return true;
	}

	private Point getNewBlockPoint() throws InvokeNewBlockException {

		if (this.isFull()) {
			throw new InvokeNewBlockException();
		}

		while(true) {

			int randomX = (int) ((Math.random() * 10) % COL_SIZE);
			int randomY = (int) ((Math.random() * 10) % ROW_SIZE);


			if (blocks[randomY][randomX] == null) {
				return new Point(randomX, randomY);
			}
		}
	}

	public void printToConsole() {

		System.out.println(asString());
	}

	public void moveBlocksTo(Direction direction) {
		switch (direction) {
			case UP:
			case DOWN:
				for (int i = 0; i < rowSize; i++) {
					moveAllBlocksWithinSpecificColumns(i, direction);
				}
				break;
			case RIGHT:
			case LEFT:
				for (int i = 0; i < rowSize; i++) {
					moveAllBlocksWithinSpecificRows(i, direction);
				}
				break;
		}
	}

	private void moveAllBlocksWithinSpecificColumns(int colNum, Direction direction) {

	}

	private void moveAllBlocksWithinSpecificRows(int rowNum, Direction direction) {

		int from = direction == Direction.LEFT ? 0 : colSize - 1;
		int to = direction == Direction.LEFT ? colSize : -1;
		int interval = direction == Direction.LEFT ? 1 : -1;

		for (int i = from; i != to; i += interval) {

			if (blocks[rowNum][i] == null) {
				Integer notNullBlockIndex = findNotNullBlockIndexInRow(blocks[rowNum], i + interval, to, interval);
				if (notNullBlockIndex == null) {
					break;
				}

				moveBlockWithinRow(rowNum, notNullBlockIndex, i);
				clear(rowNum, notNullBlockIndex);
			}
		}
	}

	private void clear(int row, int col) {
		blocks[row][col] = null;
	}

	private void moveBlockWithinRow(int row, int from, int to) {

		blocks[row][to] = blocks[row][from];
		blocks[row][to].setPoint(new Point(to, row));
	}

	private Integer findNotNullBlockIndexInRow(Block[] block, int from, int to, int interval) {

		for (int i = from; i != to; i += interval) {
			if (block[i] != null) {
				return i;
			}
		}

		return null;
	}

	private void mergeBlockWithDirection(Direction direction) {

	}

	private void addScore(int blockValue) {
		score += blockValue;
	}

	private void mergeAndScore(Direction direction) {

	}

	private String asString() {

		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < rowSize; i++) {

			for (int j = 0; j < colSize; j++) {

				String value = blocks[i][j] == null ? "X" : blocks[i][j].getValue().toString();

				sb.append(value + " ");
			}

			sb.append("\n");
		}

		return sb.toString();
	}
}
