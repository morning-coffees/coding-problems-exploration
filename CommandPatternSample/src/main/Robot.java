package main;

public interface Robot {
	
	public void dance();
	
	public default void run() {
		System.out.println("Unsupported feature!");
	}
}
