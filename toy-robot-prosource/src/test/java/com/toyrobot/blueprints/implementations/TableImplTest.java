package com.toyrobot.blueprints.implementations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.toyrobot.Coordinate;
import com.toyrobot.Movement;
import com.toyrobot.blueprints.Robot;
import com.toyrobot.blueprints.Table;

class TableImplTest {
	
	private static Table table;
	private static Robot robot;
	
	@BeforeAll
	static void setUpBeforeClass() {
		table = new TableImpl(10, 9);
		robot = new RobotImpl(new Coordinate(0, 0), Movement.NORTH, table, "1");
	}
	
	@BeforeEach
	void setUpBeforeEach() {
		table.setEmptyTable();
	}
	
	@Test
	void testSetEmptyTable() {
		robot.move();
		assertEquals(1, table.getRobotCountInTable());
		table.setEmptyTable();
		assertEquals(0, table.getRobotCountInTable());
		robot.move();
		assertEquals(1, table.getRobotCountInTable());
	}
	
	@Test
	void testIsValidLocation() {
		table.setOccupant(robot.getCurrentLocation(), robot);
		assertEquals(1, table.getRobotCountInTable());
		table.setOccupant(robot.getCurrentLocation(), robot);
		assertEquals(1, table.getRobotCountInTable());
		assertFalse(table.isValidLocation(robot.getCurrentLocation().getX(), robot.getCurrentLocation().getY()));
		robot.move();
		assertTrue(table.isValidLocation(0, 0));
		table.setEmptyTable();
		assertTrue(table.isValidLocation(robot.getCurrentLocation().getX(), robot.getCurrentLocation().getY()));
		assertTrue(table.isValidLocation(0, 0));		
	}


	@Test
	void testRemoveOccupant() {
		table.setOccupant(robot.getCurrentLocation(), robot);
		assertEquals(1, table.getRobotCountInTable());
		table.removeOccupant(4, 4);
		table.removeOccupant(3, 3);
		table.removeOccupant(10, 10);
		assertEquals(1, table.getRobotCountInTable());
		table.removeOccupant(0, 0);
		assertEquals(0, table.getRobotCountInTable());
	}

	@Test
	void testGetLength() {
		assertEquals(10, table.getxLength());
		assertEquals(9, table.getyLength());
		table.setEmptyTable();
		assertEquals(10, table.getxLength());
		assertEquals(9, table.getyLength());
	}

}

