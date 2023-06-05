package com.toyrobot.blueprints;

import com.toyrobot.Coordinate;
import com.toyrobot.Movement;

public interface Robot {

	String getName();

	void move();

	Movement getNextMove();

	void setNextMove(Movement nextMove);

	boolean isValidRobot(Coordinate location, Movement nextMove, Table table, String robotName);

	void turnLeft();

	void turnRight();

	String report();

	Table getTable();

	Coordinate getCurrentLocation();

}
