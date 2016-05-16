package com.parfait.tzfe.model;

import org.apache.commons.lang3.StringUtils;

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

		for (int i = 0; i < rowSize; i++) {

			for (int j = 0; j < colSize; j++) {

				System.out.print(blocks[i][j].getValue() + " ");
			}

			System.out.println("\n");
		}
	}
}
