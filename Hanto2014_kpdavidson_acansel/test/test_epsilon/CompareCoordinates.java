package test_epsilon;

import static org.junit.Assert.*;
import hanto.student_kpdavidson_acansel_.common.BasicCoordinate;

import org.junit.Test;

public class CompareCoordinates {

	@Test
	public void test() {
		// EQUALS IS OVERRIDEN FOR USE IN COMPARRISON AND MUST BE TESTED

		BasicCoordinate one = new BasicCoordinate(0, 0);
		BasicCoordinate two = new BasicCoordinate(1, 1);
		BasicCoordinate three = new BasicCoordinate(0, 0);
		
		assertFalse(one.equals(two));
		assertTrue(one.equals(three));
	}

}
