package com.mars.rover;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
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

		parachute.detach();
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
			fail("No threw exception");
		} catch (Exception e) {
			assertThat(e.getMessage(), is("You broke the lander, idiot."));
		}
	}

}
