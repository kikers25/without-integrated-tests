package com.mars.rover;


public class Parachute {

    private Lander lander;

	public Parachute(Lander lander) {
    	this.lander = lander;
    }

    public void open() {
    	lander.decelerate();
    }

    public void detach() {
	    
    }
	
}
