package com.toyrobot;

public class Coordinate {
	private Integer x;
	private Integer y;

	public Coordinate(Integer x, Integer y) {
		this.x = x;
		this.y = y;
	}

	public Integer getX() {
		return x;
	}

	public void setX(Integer x) {
		this.x = x;
	}

	public Integer getY() {
		return y;
	}

	public void setY(Integer y) {
		this.y = y;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(x);
		sb.append(",");
		sb.append(y.toString());
		return sb.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof Coordinate)) {
			return false;
		}

		Coordinate coordinate = (Coordinate) obj;

		return coordinate.getX() == this.getX() && coordinate.getY() == this.getY();
	}
}
