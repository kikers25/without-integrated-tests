package com.mars.rover;

public class DetachmentSystem implements AccelerationObserver {

	private Parachute parachute;

	public DetachmentSystem(Parachute parachute) {
		this.parachute = parachute;
	}

	public void handle_acceleration_report(int acceleration) throws Exception {
		parachute.detach();
	}

}
