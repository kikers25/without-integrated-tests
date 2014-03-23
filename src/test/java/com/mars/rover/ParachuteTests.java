package com.mars.rover;

import org.jmock.Expectations;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ParachuteTests {
	
	@Rule
	public JUnitRuleMockery context = new JUnitRuleMockery();
	
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
