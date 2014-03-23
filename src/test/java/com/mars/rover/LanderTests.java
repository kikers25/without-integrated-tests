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
public class LanderTests {
	
	private Mockery context = new JUnit4Mockery() {{
        setImposteriser(ClassImposteriser.INSTANCE);
    }};
    
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
