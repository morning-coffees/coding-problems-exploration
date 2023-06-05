package main;

import java.util.LinkedList;
import java.util.Queue;

import main.commands.RobotCommand;

public class Invoker {
	
	private Queue<RobotCommand> listCommand = new LinkedList<>();
	
	public void addCommand(RobotCommand command) {
		listCommand.add(command);
	}
	
	public void invoke(RobotCommand command) {
		command.execute();
	}
	
	public void invokeAll() {
		System.out.println(String.format("Running %d commands", listCommand.size()));
		while (!listCommand.isEmpty()) {
			listCommand.remove().execute();			
		}
	}
}
