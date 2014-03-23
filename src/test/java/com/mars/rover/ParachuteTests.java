package com.mars.rover;

import org.jmock.Expectations;
import org.jmock.auto.Mock;
import org.junit.Test;

public class ParachuteTests extends TestsWithMokingClasses {
	
	@Mock
	private Lander lander;

	@Test
	public void testOpenParachute() {
		Parachute parachute = new Parachute(lander);
		context.checking(new Expectations(){{
			oneOf(lander).decelerate();
		}});
		
		parachute.open();
	}
}
