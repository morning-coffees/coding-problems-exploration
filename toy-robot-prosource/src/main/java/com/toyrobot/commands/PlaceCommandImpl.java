package com.toyrobot.commands;

import com.toyrobot.Coordinate;
import com.toyrobot.Movement;
import com.toyrobot.blueprints.Command;
import com.toyrobot.blueprints.Robot;
import com.toyrobot.blueprints.Table;
import com.toyrobot.blueprints.implementations.RobotImpl;

public class PlaceCommandImpl implements Command{
	
	public static Robot getRobotPlacementInstance(String parameter, Table table, Integer robotNumber) {
		Robot robot = null;
		try {
			String[] parameters = parameter.split(",");
			if (parameters.length == 3) {
				Integer x = Integer.parseInt(parameters[0]);
				Integer y = Integer.parseInt(parameters[1]);
				Movement movement = Movement.getEquivalent(parameters[2]);

				Coordinate coordinate = new Coordinate(x, y);
				robot = new RobotImpl(coordinate, movement, table, robotNumber.toString());
			}
		} catch (Exception e) {
			System.out.println("PLACE given incorrect parameters!");
		}
		return robot;
	}

	@Override
	public void execute(Robot robot) {
		if(robot != null) {
			robot.getTable().setOccupant(robot.getCurrentLocation(), robot);
		}
	}

}
