package com.example.spacenetdemo.rocketsscreen;

import com.example.spacenetdemo.Constants;
import com.example.spacenetdemo.abstractclass.ButtonBounds;
import com.example.spacenetdemo.enginesscreen.EnginesScreen;

public class EnginesButtonBounds extends ButtonBounds{

	public EnginesButtonBounds(int lAction, float left, float top, float right, float bottom) {
		super(lAction, left, top, right, bottom);
    	//System.out.println("LBBc=" + left + " " + top + " " + right + " " + bottom);
	}
	
	@Override
	public void doAction() {
		Constants.screen = new EnginesScreen();
		Constants.screen.prepare();
	}

}
