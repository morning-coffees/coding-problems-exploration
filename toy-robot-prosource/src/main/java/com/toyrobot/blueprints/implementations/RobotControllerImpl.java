package com.toyrobot.blueprints.implementations;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.toyrobot.CommandsList;
import com.toyrobot.blueprints.Command;
import com.toyrobot.blueprints.Robot;
import com.toyrobot.blueprints.RobotController;
import com.toyrobot.blueprints.Table;
import com.toyrobot.commands.LeftCommandImpl;
import com.toyrobot.commands.MoveCommandImpl;
import com.toyrobot.commands.PlaceCommandImpl;
import com.toyrobot.commands.ReportCommandImpl;
import com.toyrobot.commands.RightCommandImpl;

public class RobotControllerImpl implements RobotController {

	Scanner input = new Scanner(System.in);
	Table table = new TableImpl(5, 5);
	Map<Integer, Robot> robotList = new HashMap<>();

	@Override
	public void start() {
		setTableDetails();
		setRobotDetails();
		table.printTable();
		if (robotList.size() > 0) {
			receiveCommands();
		} else {
			System.out.println("There are no robots. Ending");
		}
	}

	@Override
	public void setTableDetails() {
		try {
			System.out.print("Table # columns: ");
			int x = input.nextInt();
			System.out.print("Table # rows: ");
			int y = input.nextInt();
			table = new TableImpl(x, y);
		} catch (Exception e) {
			throw new IllegalArgumentException("Provided invalid agument, ending the program now.");
		}
	}

	@Override
	public void setRobotDetails() {
		System.out.print("How many robots? ");
		int numberOfRobots = input.nextInt();

		for (Integer robotNumber = 1; robotNumber <= numberOfRobots; robotNumber++) {
			System.out.print("Robot " + robotNumber.toString() + " Details (PLACE x,y,DIRECTION): ");
			String command = input.next();
			try {
				if (CommandsList.PLACE.getStringValue().equals(command.toUpperCase())) {
					String parameter = input.next();
					Robot robot = PlaceCommandImpl.getRobotPlacementInstance(parameter, table, robotNumber);
					Command placeCommand = new PlaceCommandImpl();
					placeCommand.execute(robot);
					robotList.put(robotNumber, robot);
				} else {
					System.out.println("Incorrect Command, destroyed robot #" + robotNumber.toString());
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(
						"Something is wrong with this robot, self destructing robot #" + robotNumber.toString());
			}
		}
	}

	@Override
	public void receiveCommands() {
		System.out.println("Available Commands: MOVE,LEFT,RIGHT,REPORT,END");
		while (true) {
			try {
				System.out.println("Enter Command (COMMAND ROBOTNUMBER):");
				String command = input.next();

				if (CommandsList.END.getStringValue().equals(command)) {
					System.out.println("Exiting..");
					break;
				}
				
				Integer parameter = input.nextInt();

				if (robotList.containsKey(parameter) && CommandsList.getEquivalent(command) != null) {
					parseCommand(command, robotList.get(parameter));
					table.printTable();
				} else {
					System.out.println("Invalid Command or parameter");
				}
			} catch (Exception e) {
				System.out.println("Invalid Command or parameter");
			}
			
		}
	}

	@Override
	public void parseCommand(String stringCommand, Robot robot) {
		Command command = switch (CommandsList.getEquivalent(stringCommand)) {
		case LEFT -> new LeftCommandImpl();
		case RIGHT -> new RightCommandImpl();
		case MOVE -> new MoveCommandImpl();
		case REPORT -> new ReportCommandImpl();
		default -> throw new IllegalArgumentException("Unexpected value for equivalent command of " + stringCommand);
		};
		command.execute(robot);
	}

}
