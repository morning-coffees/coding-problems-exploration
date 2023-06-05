package main;

public class CarpenterRobot implements Robot{

	@Override
	public void dance() {
		System.out.println("Carpenter Robot is dancing!");
	}

	@Override
	public void run() {
		System.out.println("Carpenter Robot is running!");
	}
}
