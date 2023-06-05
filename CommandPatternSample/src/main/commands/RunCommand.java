package main.commands;

import main.Robot;

public class RunCommand implements RobotCommand {

	Robot robot;
	
	public RunCommand(Robot robot) {
		this.robot = robot;
	}
	
	@Override
	public void execute() {
		robot.run();
	}

}
