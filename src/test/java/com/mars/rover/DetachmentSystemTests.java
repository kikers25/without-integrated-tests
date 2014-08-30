package com.mars.rover;

import org.jmock.Expectations;
import org.jmock.auto.Mock;

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

}
