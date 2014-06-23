package com.mars.rover;

import static org.junit.Assert.fail;

import org.jmock.Expectations;
import org.jmock.auto.Mock;
import org.junit.Test;

public class ParachuteTests extends TestsWithMokingClasses {

	@Mock
	private Lander lander;

	@Test
	public void testOpenParachute() {
		Parachute parachute = new Parachute(lander);
		context.checking(new Expectations() {

			{
				oneOf(lander).decelerate();
			}
		});

		parachute.open();
	}

	@Test
	public void testDetachingWhileLanded() {
		Parachute parachute = new Parachute(lander);
		context.checking(new Expectations() {
			{
				oneOf(lander).has_landed();
				will(returnValue(true));
			}
		});

		try {
			parachute.detach();
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testDetachingWhileNotLanded() {
		Parachute parachute = new Parachute(lander);
		context.checking(new Expectations() {
			{
				oneOf(lander).has_landed();
				will(returnValue(false));
			}
		});

		try {
			parachute.detach();
			fail();
		} catch (Exception e) {
		}
	}

}
