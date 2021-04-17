package com.example.spacenetdemo.onplanetscreen;

import com.example.spacenetdemo.Constants;
import com.example.spacenetdemo.abstractclass.ButtonBounds;
import com.example.spacenetdemo.launchingscreen.LaunchingScreen;

public class LaunchButtonBounds extends ButtonBounds{

	public LaunchButtonBounds(int lAction, float left, float top, float right, float bottom) {
		super(lAction, left, top, right, bottom);
    	//System.out.println("LBBc=" + left + " " + top + " " + right + " " + bottom);
	}
	
	@Override
	public void doAction() {
		Constants.screen = new LaunchingScreen();
		Constants.screen.prepare();
	}

}
