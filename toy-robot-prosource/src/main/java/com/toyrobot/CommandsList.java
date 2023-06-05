package com.toyrobot;


public enum CommandsList {

	LEFT("LEFT"),
	RIGHT("RIGHT"),
	MOVE("MOVE"),
	REPORT("REPORT"),
	END("END"),
	PLACE("PLACE");
	
	private String stringValue;
	
	CommandsList(String stringValue) {
		this.stringValue = stringValue;
	}
	
	public String getStringValue() {
		return stringValue;
	}
	
	public static CommandsList getEquivalent(String command) { 
		return switch (command.toUpperCase()) {
		case "LEFT" -> LEFT;
		case "RIGHT" -> RIGHT;
		case "MOVE" -> MOVE;
		case "REPORT" -> REPORT;
		default -> null;
		};
	}
}
