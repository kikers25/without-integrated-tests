package com.mars.rover;

import static org.junit.Assert.fail;

import org.jmock.Expectations;
import org.jmock.auto.Mock;
import org.junit.Test;

public class DetachmentSystemTests extends AccelerationObserverTests {

	@Mock
	private Parachute parachute;
	@Mock
	Altimeter altimeter;

	@Override
	protected AccelerationObserver create_acceleration_observer() throws Exception {
		DetachmentSystem detachmentSystem = new DetachmentSystem(parachute, altimeter);
		context.checking(new Expectations() {
			{
				oneOf(parachute).detach();

				allowing(altimeter).altitude();
				will(returnValue(1));
			}
		});
		return detachmentSystem;
	}

	@Test
	public void testRespondsToDetachFailing() throws Exception {
		DetachmentSystem detachmentSystem = new DetachmentSystem(parachute, altimeter);
		context.checking(new Expectations() {
			{
				allowing(parachute).detach();
				will(throwException(new Exception()));

				allowing(altimeter).altitude();
				will(returnValue(1));
			}
		});

		try {
			detachmentSystem.handle_acceleration_report(-50);
			fail("No threw exception");
		} catch (Exception e) {
		}
	}

	@Test
	public void //
	testDoNotDetachWhenTheLanderIsTooHighUp() throws Exception {
		DetachmentSystem detachmentSystem = new DetachmentSystem(parachute, altimeter);
		context.checking(new Expectations() {
			{
				allowing(altimeter).altitude();
				will(returnValue(5));

				never(parachute).detach();
			}
		});

		detachmentSystem.handle_acceleration_report(-50);

		// ???
	}
}
