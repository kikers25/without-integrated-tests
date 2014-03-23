package com.mars.rover;

import static org.junit.Assert.*;

import org.junit.Test;


public abstract class AccelerationObserverTests {

	@Test
    public void testAccelerationObserverCanHandleRapidAcceleration() throws Exception {
		AccelerationObserver observer = create_acceleration_observer(); // subclass responsibility
	    try {
	      observer.handle_acceleration_report(-50);
	    } catch (Exception e) {
	    	fail("Error to handle acceleration of -50 ms/2: "  + e.getMessage());
	    }
    }

    protected abstract AccelerationObserver create_acceleration_observer();
    
}
