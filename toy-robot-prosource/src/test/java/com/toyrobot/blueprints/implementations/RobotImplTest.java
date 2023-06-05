package com.toyrobot.blueprints.implementations;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.toyrobot.Coordinate;
import com.toyrobot.Movement;
import com.toyrobot.blueprints.Robot;
import com.toyrobot.blueprints.Table;

class RobotImplTest {
	
	private Table table;
	private Robot robot;

	@BeforeEach
	void setUp() {
		table = new TableImpl(10, 9);
		robot = new RobotImpl(new Coordinate(0, 0), Movement.NORTH, table, "1");
	}

	@Test
	void testGetSetNextMove() {
		assertEquals(Movement.NORTH, robot.getNextMove());
		robot.setNextMove(Movement.EAST);
		assertEquals(Movement.EAST, robot.getNextMove());
		robot.move();
		assertEquals(Movement.EAST, robot.getNextMove());
		
		robot.setNextMove(Movement.WEST);
		assertEquals(Movement.WEST, robot.getNextMove());
		robot.setNextMove(Movement.SOUTH);
		assertEquals(Movement.SOUTH, robot.getNextMove());
	}

	@Test
	void testMove() {
		robot.setNextMove(Movement.WEST);
		robot.move();
		assertEquals(new Coordinate(0, 0), robot.getCurrentLocation());
		robot.setNextMove(Movement.SOUTH);
		robot.move();
		assertEquals(new Coordinate(0, 0), robot.getCurrentLocation());
		robot.setNextMove(Movement.NORTH);
		robot.move();
		assertEquals(new Coordinate(0, 1), robot.getCurrentLocation());
		robot.setNextMove(Movement.EAST);
		robot.move();
		assertEquals(new Coordinate(1, 1), robot.getCurrentLocation());
		robot.setNextMove(Movement.WEST);
		robot.move();
		assertEquals(new Coordinate(0, 1), robot.getCurrentLocation());
		robot.setNextMove(Movement.SOUTH);
		robot.move();
		assertEquals(new Coordinate(0, 0), robot.getCurrentLocation());
	}


	@Test
	void testIsValidRobot() {
		assertThrows(IllegalArgumentException.class, ()-> new RobotImpl(null, null, null, null));
		assertThrows(IllegalArgumentException.class, ()-> new RobotImpl(new Coordinate(0, 0), null, table, null));
		assertThrows(IllegalArgumentException.class, ()-> new RobotImpl(new Coordinate(0, 0), Movement.NORTH, table, null));
		assertDoesNotThrow(() -> new RobotImpl(new Coordinate(0, 0), Movement.NORTH, new TableImpl(5, 5), "R1"));
	}

	@Test
	void testReport() {
		Robot robot1 = new RobotImpl(new Coordinate(1, 0), Movement.NORTH, table, "1");
		Robot robot2 = new RobotImpl(new Coordinate(0, 1), Movement.SOUTH, table, "B222");
		Robot robot3 = new RobotImpl(new Coordinate(0, 2), Movement.WEST, table, "ROBOCOP");
		Robot robot4 = new RobotImpl(new Coordinate(5, 5), Movement.EAST, table, "EASTROBO");

		assertEquals("1: 1,0,NORTH", robot1.report());
		assertEquals("B222: 0,1,SOUTH", robot2.report());
		assertEquals("ROBOCOP: 0,2,WEST", robot3.report());
		assertEquals("EASTROBO: 5,5,EAST", robot4.report());

	}
	
	@Test
	void testGetLocation() {
		assertEquals(new Coordinate(0, 0), robot.getCurrentLocation());
		robot.move();
		robot.setNextMove(Movement.EAST);
		robot.move();
		assertEquals(new Coordinate(1, 1), robot.getCurrentLocation());
		robot.setNextMove(Movement.SOUTH);
		robot.move();
		assertEquals(new Coordinate(1, 0), robot.getCurrentLocation());
		robot.setNextMove(Movement.WEST);
		robot.move();
		assertEquals(new Coordinate(0, 0), robot.getCurrentLocation());
	}

}

