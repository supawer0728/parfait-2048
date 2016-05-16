package com.parfait.tzfe.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode()
public class Point {

	private int x;
	private int y;

	public Point() {}
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
