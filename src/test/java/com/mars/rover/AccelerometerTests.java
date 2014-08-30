package com.mars.rover;

import static org.junit.Assert.fail;

import org.jmock.Expectations;
import org.jmock.auto.Mock;
import org.junit.Test;

public class AccelerometerTests extends TestsWithMokingClasses {

	@Mock
	private AccelerationObserver observer;

	@Test
	public void testAccelerometerCanReportRapidAcceleration() throws Exception {
		Accelerometer accelerometer = new Accelerometer();
		accelerometer.add_observer(observer);
		context.checking(new Expectations() {
			{
				oneOf(observer).handle_acceleration_report(-50);
			}
		});

		accelerometer.report_acceleration(-50);
	}

	@Test
	public void //
	testAccelerometerCanRespondToFailureWhenReportingAcceleration() throws Exception {
		Accelerometer accelerometer = new Accelerometer();
		accelerometer.add_observer(observer);
		context.checking(new Expectations() {
			{
				allowing(observer).handle_acceleration_report(-50);
				will(throwException(new Exception()));
			}
		});

		try {
			accelerometer.report_acceleration(-50);
			fail("No threw exception");
		} catch (Exception e) {
		}
	}
}
