package com.example.spacenetdemo.antaresinspace;

import com.example.spacenetdemo.Constants;
import com.example.spacenetdemo.abstractclass.ButtonBounds;
import com.example.spacenetdemo.antaresinspace.InSpaceAntaresScreen;
import com.example.spacenetdemo.landingscreen.LandingScreen;

public class SpeedButtonBounds extends ButtonBounds {

	InSpaceAntaresScreen inSpaceAntaresScreen = null;
	float speed = 0;
	
	public SpeedButtonBounds(InSpaceAntaresScreen screen, float lSpeed, int lAction, float left, float top, float right, float bottom) {
		super(lAction, left, top, right, bottom);
		inSpaceAntaresScreen = screen;
		speed = lSpeed;
	}
	
	@Override
	public void doAction() {
		//inSpaceAntaresScreen.speed = speed;
		if(speed == 0 && Constants.planets.checkStayInCenterOfPlanet >= 0) {
			Constants.screen = new LandingScreen();
			Constants.screen.prepare();
		}
	}

}
