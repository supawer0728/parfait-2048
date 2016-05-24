package com.parfait.tzfe.service;

import com.parfait.tzfe.model.Block;

public interface BlockMergeService {

	Block merge(Block from, Block into);
	boolean isAbleToMerge(Block from, Block into);
}
