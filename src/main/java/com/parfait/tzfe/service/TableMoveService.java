package com.parfait.tzfe.service;

import com.parfait.tzfe.model.Direction;
import com.parfait.tzfe.model.Table;

public interface TableMoveService {

	void move(Table table, Direction direction);
}
