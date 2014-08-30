package com.mars.rover;

public class Accelerometer {

	private AccelerationObserver observer;

	public void add_observer(AccelerationObserver observer) {
		// just one observer
		this.observer = observer;
	}

	public void report_acceleration(int acceleration) throws Exception {
		observer.handle_acceleration_report(-50);
	}

}
