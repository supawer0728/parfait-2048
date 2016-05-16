package com.parfait.tzfe.model;

import com.parfait.tzfe.utils.BlockRandomValueGenerator;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.awt.*;

@Data
@EqualsAndHashCode
public class Block {
	private Integer value;
	private Point point;
	private Block() {}

	public static Block getInstanceWithValue(Integer value) {
		Block block = new Block();
		block.value = value;

		return block;
	}

	public static Block getInstanceWithPointAndValue(Point point, Integer value) {
		Block block = new Block();
		block.value = value;
		block.point = point;

		return block;
	}

	public static Block getNewBlock() {

		int value = BlockRandomValueGenerator.generateBlockRandomValue();

		Block block = getInstanceWithValue(value);
		return block;
	}
}
