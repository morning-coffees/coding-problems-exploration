package com.toyrobot.commands;

import com.toyrobot.blueprints.Command;
import com.toyrobot.blueprints.Robot;

public class LeftCommandImpl implements Command {

	@Override
	public void execute(Robot robot) {
		if(robot != null) {
			robot.turnLeft();			
		}
	}
}
