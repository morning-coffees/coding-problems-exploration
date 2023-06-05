package com.toyrobot.blueprints;

import java.util.Map;

import com.toyrobot.Coordinate;

public interface Table {

	boolean setOccupant(Coordinate coordinate, Robot occupant);

	boolean isValidLocation(Integer x, Integer y);

	void setEmptyTable();

	void removeOccupant(Integer x, Integer y);

	void printTable();

	int getyLength();

	int getxLength();

	int getRobotCountInTable();

	Map<String, Robot> getTableSlots();

}