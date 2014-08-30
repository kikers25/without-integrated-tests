package com.mars.rover;

public class Lander {

	private Accelerometer accelerometer;

	public Lander(Accelerometer accelerometer, Altimeter altimeter) {
		this.accelerometer = accelerometer;
	}

	public void decelerate() throws Exception {
		accelerometer.report_acceleration(-50);
	}

	public boolean has_landed() {
		return false;
	}

}
