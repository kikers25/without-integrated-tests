package com.mars.rover;

import static org.junit.Assert.fail;

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

		context.checking(new Expectations() {
			{
				oneOf(accelerometer).report_acceleration(-50);
			}
		});

		lander.decelerate();
	}

	@Test
	public void //
	testLanderDeceleratesRespondsToFailure() throws Exception {
		Lander lander = new Lander(accelerometer, altimeter);
		context.checking(new Expectations() {
			{
				allowing(accelerometer).report_acceleration(-50);
				will(throwException(new Exception()));
			}
		});

		try {
			lander.decelerate();
			fail("No threw exception");
		} catch (Exception e) {
		}
	}
}
