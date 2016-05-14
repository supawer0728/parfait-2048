package com.parfait.tzfe.model;

import com.parfait.tzfe.utils.BlockRandomValueGenerator;
import lombok.Data;

import java.awt.*;

@Data
public class Block {
	private int value;
	private Block() {}

	public static Block getInstanceWithValue(int value) {
		Block block = new Block();
		block.value = value;

		return block;
	}

	public static Block getNewBlock() {

		int value = BlockRandomValueGenerator.generateBlockRandomValue();

		Block block = getInstanceWithValue(value);
		return block;
	}
}
