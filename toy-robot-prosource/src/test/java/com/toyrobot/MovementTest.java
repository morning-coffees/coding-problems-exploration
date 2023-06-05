package com.toyrobot;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MovementTest {

	@Test
	void getEquivalentTest() {
		assertEquals(Movement.NORTH, Movement.getEquivalent("NORTH"));
		assertEquals(Movement.NORTH, Movement.getEquivalent("north"));
		assertEquals(Movement.EAST, Movement.getEquivalent("EAST"));
		assertEquals(Movement.SOUTH, Movement.getEquivalent("SOUTH"));
		assertEquals(Movement.WEST, Movement.getEquivalent("WEST"));
	}

	@Test
	void getLeftTest() {
		assertEquals(Movement.NORTH.getLeft(), Movement.WEST);
		assertEquals(Movement.WEST.getLeft(), Movement.SOUTH);
		assertEquals(Movement.SOUTH.getLeft(), Movement.EAST);
		assertEquals(Movement.EAST.getLeft(), Movement.NORTH);
	}
	
	@Test
	void getRightTest() {
		assertEquals(Movement.NORTH.getRight(), Movement.EAST);
		assertEquals(Movement.EAST.getRight(), Movement.SOUTH);
		assertEquals(Movement.SOUTH.getRight(), Movement.WEST);
		assertEquals(Movement.WEST.getRight(), Movement.NORTH);
	}

}
