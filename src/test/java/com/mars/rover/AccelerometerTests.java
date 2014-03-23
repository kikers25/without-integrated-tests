package com.mars.rover;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Test;
import org.junit.runner.RunWith;

@SuppressWarnings("deprecation")
@RunWith(JMock.class)
public class AccelerometerTests {
	
	private Mockery context = new JUnit4Mockery() {{
        setImposteriser(ClassImposteriser.INSTANCE);
    }};
    
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
