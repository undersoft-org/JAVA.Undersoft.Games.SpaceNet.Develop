package com.example.spacenetdemo.startscreen;

import com.example.spacenetdemo.Constants;
import com.example.spacenetdemo.abstractclass.ButtonBounds;
import com.example.spacenetdemo.antaresinspace.InSpaceAntaresScreen;

public class StartButtonBounds extends ButtonBounds{

	public StartButtonBounds(int lAction, float left, float top, float right, float bottom) {
		super(lAction, left, top, right, bottom);
	}
	
	@Override
	public void doAction() {
		Constants.screen = new InSpaceAntaresScreen();
		Constants.screen.prepare();
	}

}
