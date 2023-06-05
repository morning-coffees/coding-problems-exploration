package com.toyrobot;

public enum Movement {

	NORTH(0, 1), EAST(1, 0), SOUTH(0, -1), WEST(-1, 0);

	private Integer xAdjustment;
	private Integer yAdjustment;

	Movement(int xAdjustment, int yAdjustment) {
		this.xAdjustment = xAdjustment;
		this.yAdjustment = yAdjustment;
	}

	public Integer getxAdjustment() {
		return xAdjustment;
	}

	public Integer getyAdjustment() {
		return yAdjustment;
	}
	
	public static Movement getEquivalent(String movement) {
		return switch (movement.toUpperCase()) {
		case "NORTH" -> NORTH;
		case "EAST" -> EAST;
		case "SOUTH" -> SOUTH;
		case "WEST" -> WEST;
		default -> null;
		};
	}


	public Movement getLeft() {
		return switch (this) {
		case NORTH -> WEST;
		case WEST -> SOUTH;
		case SOUTH -> EAST;
		case EAST -> NORTH;
		default -> null;
		};
	}

	public Movement getRight() {
		return switch (this) {
		case NORTH -> EAST;
		case EAST -> SOUTH;
		case SOUTH -> WEST;
		case WEST -> NORTH;
		default -> null;
		};
	}
}