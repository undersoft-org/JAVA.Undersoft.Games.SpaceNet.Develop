package com.example.spacenetdemo.splash;

import com.example.spacenetdemo.Constants;
import com.example.spacenetdemo.abstractclass.ButtonBounds;
import com.example.spacenetdemo.startscreen.StartScreen;

public class SplashButtonBounds extends ButtonBounds{

	public SplashButtonBounds(int lAction, float left, float top, float right, float bottom) {
		super(lAction, left, top, right, bottom);
	}
	
	@Override
	public void doAction() {
		Constants.screen = new StartScreen();
		Constants.screen.prepare();
	}

}
