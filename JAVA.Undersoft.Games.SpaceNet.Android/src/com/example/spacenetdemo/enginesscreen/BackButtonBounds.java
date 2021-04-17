package com.example.spacenetdemo.enginesscreen;

import com.example.spacenetdemo.Constants;
import com.example.spacenetdemo.abstractclass.ButtonBounds;
import com.example.spacenetdemo.onplanetscreen.OnPlanetScreen;

public class BackButtonBounds extends ButtonBounds{

	public BackButtonBounds(int lAction, float left, float top, float right, float bottom) {
		super(lAction, left, top, right, bottom);
	}
	
	@Override
	public void doAction() {
		Constants.screen = new OnPlanetScreen();
		Constants.screen.prepare();
	}

}
