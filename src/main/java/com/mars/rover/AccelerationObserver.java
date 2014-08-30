package com.mars.rover;

public interface AccelerationObserver {

	public void handle_acceleration_report(int acceleration) throws Exception;

}
