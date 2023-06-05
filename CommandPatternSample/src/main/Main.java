package main;

import main.commands.DanceCommand;
import main.commands.RobotCommand;
import main.commands.RunCommand;

public class Main {

	public static void main(String[] args) {
		Robot humanRobot = new HumanRobot();
		RobotCommand danceCommand = new DanceCommand(humanRobot);
		RunCommand runCommand = new RunCommand(humanRobot);
//		danceCommand.execute();
//		runCommand.execute();
		
		Robot carpenterRobot = new CarpenterRobot();
		RobotCommand carpenterDance = new DanceCommand(carpenterRobot);
		RunCommand carpenterRun = new RunCommand(carpenterRobot);
//		carpenterDance.execute();
//		carpenterRun.execute();
//		carpenterRun.execute();
		
		Invoker invoker = new Invoker();
		invoker.addCommand(danceCommand);
		invoker.addCommand(carpenterDance);
		invoker.addCommand(runCommand);
		invoker.addCommand(carpenterRun);
		invoker.invokeAll();
		System.out.println("+=======================");
		invoker.invokeAll();
		invoker.invoke(danceCommand);
				
	}

}
