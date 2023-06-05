package com.toyrobot.blueprints.implementations;

import com.toyrobot.Coordinate;
import com.toyrobot.Movement;
import com.toyrobot.blueprints.Robot;
import com.toyrobot.blueprints.Table;

public class RobotImpl implements Robot {

	private String robotName;
	private Coordinate currentLocation;
	private Movement nextMove;
	private Table table;

	public RobotImpl(Coordinate currentLocation, Movement nextMove, Table table, String robotName) {
		if (isValidRobot(currentLocation, nextMove, table, robotName)) {
			this.robotName = robotName;
			this.currentLocation = currentLocation;
			this.nextMove = nextMove;
			this.table = table;
		} else {
			throw new IllegalArgumentException("Something is wrong with this robot");
		}
	}

	@Override
	public void move() {
		Integer xTmp = currentLocation.getX() + nextMove.getxAdjustment();
		Integer yTmp = currentLocation.getY() + nextMove.getyAdjustment();
		if (table.isValidLocation(xTmp, yTmp)) {
			boolean setOccupantSuccess = table.setOccupant(new Coordinate(xTmp, yTmp), this);
			if (setOccupantSuccess) {
				table.removeOccupant(currentLocation.getX(), currentLocation.getY());
				currentLocation.setX(xTmp);
				currentLocation.setY(yTmp);
				System.out.println("Robot Moved");
			} else {
				System.out.println("Location on table is not Empty!");
			}
		} else {
			System.out.println("Robot Cannot Move");
		}
	}

	@Override
	public void turnLeft() {
		setNextMove(getNextMove().getLeft());
	}

	@Override
	public void turnRight() {
		setNextMove(getNextMove().getRight());
	}

	@Override
	public boolean isValidRobot(Coordinate location, Movement nextMove, Table table, String robotName) {
		boolean validLocation = table.isValidLocation(location.getX(), location.getY());
		return validLocation && nextMove != null && table != null && robotName != null;
	}

	@Override
	public String getName() {
		return robotName;
	}

	@Override
	public Movement getNextMove() {
		return nextMove;
	}

	@Override
	public void setNextMove(Movement nextMove) {
		this.nextMove = nextMove;
	}

	@Override
	public Table getTable() {
		return table;
	}
	
	@Override
	public Coordinate getCurrentLocation() {
		return currentLocation;
	}

	@Override
	public String report() {
		StringBuilder sb = new StringBuilder();
		sb.append(robotName);
		sb.append(": ");
		sb.append(currentLocation.toString());
		sb.append(",");
		sb.append(nextMove.toString());
		System.out.println(sb.toString());
		return sb.toString();
	}

}
