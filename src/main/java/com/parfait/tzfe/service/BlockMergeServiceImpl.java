package com.parfait.tzfe.service;

import com.parfait.tzfe.model.Block;

public class BlockMergeServiceImpl implements BlockMergeService {
	@Override
	public Block merge(Block from, Block into) {

		Block merged = Block.getInstanceWithPointAndValue(into.getPoint(), from.getValue() + into.getValue());

		return merged;
	}

	@Override
	public boolean isAbleToMerge(Block from, Block into) {

		if (from == null || into == null) {
			return false;
		}

		return from.getValue().intValue() == into.getValue().intValue();
	}
}
