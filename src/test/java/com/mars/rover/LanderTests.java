package com.mars.rover;

import org.jmock.Expectations;
import org.jmock.auto.Mock;
import org.junit.Test;

public class LanderTests extends TestsWithMokingClasses {
	
	@Mock
	private Accelerometer accelerometer;
	@Mock
	private Altimeter altimeter;

	@Test
    public void testLanderDecelerates() throws Exception {
		Lander lander = new Lander(accelerometer, altimeter);
		
		context.checking(new Expectations(){{
			oneOf(accelerometer).report_acceleration(-50);
		}});

		lander.decelerate();
    }
}
