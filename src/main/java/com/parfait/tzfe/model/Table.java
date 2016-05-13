package com.parfait.tzfe.model;

import lombok.Data;

@Data
public class Table {

	private int rowSize;
	private int colSize;

	private Table() {}

	public static Table getInstaceWithRowAndColSize(int rowSize, int colSize) {

		Table table = new Table();

		rowSize = rowSize;
		colSize = colSize;

		return table;
	}
}
