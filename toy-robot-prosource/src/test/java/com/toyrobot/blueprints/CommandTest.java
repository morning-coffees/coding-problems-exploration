package com.toyrobot.blueprints;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.toyrobot.Coordinate;
import com.toyrobot.Movement;
import com.toyrobot.blueprints.implementations.RobotImpl;
import com.toyrobot.blueprints.implementations.TableImpl;
import com.toyrobot.commands.LeftCommandImpl;
import com.toyrobot.commands.MoveCommandImpl;
import com.toyrobot.commands.PlaceCommandImpl;
import com.toyrobot.commands.RightCommandImpl;

class CommandTest {
	private Table table;
	private Robot robot;

	@BeforeEach
	void setUpBeforeEach() {
		table = new TableImpl(10, 9);
		robot = new RobotImpl(new Coordinate(0, 0), Movement.NORTH, table, "1");
		Command command = new PlaceCommandImpl();
		command.execute(robot);
	}

	@Test
	void leftCommandTest() {
		Command command = new LeftCommandImpl();
		command.execute(robot);
		assertEquals(robot.getCurrentLocation(), new Coordinate(0,0));
		robot.move();
		assertEquals(robot.getCurrentLocation(), new Coordinate(0,0));
		command.execute(robot);
		assertEquals(robot.getCurrentLocation(), new Coordinate(0,0));
		robot.move();
		assertEquals(robot.getCurrentLocation(), new Coordinate(0,0));
		command.execute(robot);
		assertEquals(robot.getCurrentLocation(), new Coordinate(0,0));
		robot.move();
		assertEquals(robot.getCurrentLocation(), new Coordinate(1,0));
	}
	
	@Test
	void rightCommandTest() {
		Command command = new RightCommandImpl();
		command.execute(robot);
		assertEquals(robot.getCurrentLocation(), new Coordinate(0,0));
		robot.move();
		assertEquals(robot.getCurrentLocation(), new Coordinate(1,0));
		command.execute(robot);
		assertEquals(robot.getCurrentLocation(), new Coordinate(1,0));
		robot.move();
		assertEquals(robot.getCurrentLocation(), new Coordinate(1,0));
	}
	
	@Test
	void moveCommandTest() {
		Command command = new MoveCommandImpl();
		command.execute(robot);
		assertEquals(robot.getCurrentLocation(), new Coordinate(0,1));
		command.execute(robot);
		assertEquals(robot.getCurrentLocation(), new Coordinate(0,2));
	}
	

	@Test
	void placeCommandTest() {
		Command command = new PlaceCommandImpl();
		Robot robot2 = new RobotImpl(new Coordinate(0, 1), Movement.NORTH, table, "2");
		assertTrue(table.isValidLocation(0, 1));
		command.execute(robot2);
		assertFalse(table.isValidLocation(0, 1));
	}

}
