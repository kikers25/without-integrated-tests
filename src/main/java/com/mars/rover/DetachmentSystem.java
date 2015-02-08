package com.mars.rover;

public class DetachmentSystem implements AccelerationObserver {

	private Parachute parachute;
	private Altimeter altimeter;

	public DetachmentSystem(Parachute parachute, Altimeter altimeter) {
		this.parachute = parachute;
		this.altimeter = altimeter;
	}

	public void handle_acceleration_report(int acceleration) throws Exception {
		if (acceleration <= -50 && altimeter.altitude() < 5) {
			parachute.detach();
		}
	}
}
