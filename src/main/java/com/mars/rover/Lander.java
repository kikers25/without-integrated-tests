package com.mars.rover;

public class Lander {

	private Accelerometer accelerometer;

	public Lander(Accelerometer accelerometer, Altimeter altimeter) {
		this.accelerometer = accelerometer;
	}

	public void decelerate() {
		accelerometer.report_acceleration(-50);
	}

	public void has_landed() {

	}

}
