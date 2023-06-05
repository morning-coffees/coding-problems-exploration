package main.commands;

import main.Robot;

public class DanceCommand implements RobotCommand {
	
	Robot robot;
	
	public DanceCommand(Robot robot) {
		this.robot = robot;
	}
	
	@Override
	public void execute() {
		robot.dance();
	}

}
