package com.toyrobot;

import com.toyrobot.blueprints.RobotController;
import com.toyrobot.blueprints.implementations.RobotControllerImpl;

public class Main {

	public static void main(String[] args) {
		RobotController robotController = new RobotControllerImpl();
		robotController.start();
	}

}
