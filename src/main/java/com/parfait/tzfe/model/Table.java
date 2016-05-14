package com.parfait.tzfe.model;

import com.parfait.tzfe.exception.InvokeNewBlockException;
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

		return null;
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
}
