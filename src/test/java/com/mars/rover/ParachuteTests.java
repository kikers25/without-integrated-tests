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
public class ParachuteTests {
	
	private Mockery context = new JUnit4Mockery() {{
        setImposteriser(ClassImposteriser.INSTANCE);
    }};
    
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
