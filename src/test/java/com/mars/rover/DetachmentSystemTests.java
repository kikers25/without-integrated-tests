package com.mars.rover;

import static org.junit.Assert.fail;

import org.jmock.Expectations;
import org.jmock.auto.Mock;
import org.junit.Test;

public class DetachmentSystemTests extends AccelerationObserverTests {

	@Mock
	private Parachute parachute;

	@Override
	protected AccelerationObserver create_acceleration_observer() throws Exception {
		DetachmentSystem detachmentSystem = new DetachmentSystem(parachute);
		context.checking(new Expectations() {
			{
				oneOf(parachute).detach();
			}
		});
		return detachmentSystem;
	}

	@Test
	public void testRespondsToDetachFailing() throws Exception {
		DetachmentSystem detachmentSystem = new DetachmentSystem(parachute);
		context.checking(new Expectations() {
			{
				allowing(parachute).detach();
				will(throwException(new Exception()));
			}
		});

		try {
			detachmentSystem.handle_acceleration_report(-50);
			fail("No threw exception");
		} catch (Exception e) {
		}
	}

}
