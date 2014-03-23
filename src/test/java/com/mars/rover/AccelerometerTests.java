package com.mars.rover;

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
		context.checking(new Expectations(){{
			oneOf(observer).handle_acceleration_report(-50);
		}});
	  
		accelerometer.report_acceleration(-50);
    }
}
