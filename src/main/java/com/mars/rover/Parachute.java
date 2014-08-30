package com.mars.rover;

public class Parachute {

	private Lander lander;

	public Parachute(Lander lander) {
		this.lander = lander;
	}

	public void open() throws Exception {
		lander.decelerate();
	}

	public void detach() throws Exception {
		if (lander.has_landed() == false) {
			throw new Exception("You broke the lander, idiot.");
		}
	}

}
