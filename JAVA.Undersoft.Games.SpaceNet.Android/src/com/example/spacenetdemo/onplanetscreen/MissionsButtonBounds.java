package com.example.spacenetdemo.onplanetscreen;

import com.example.spacenetdemo.Constants;
import com.example.spacenetdemo.abstractclass.ButtonBounds;
import com.example.spacenetdemo.misionsscreen.MissionsScreen;

public class MissionsButtonBounds extends ButtonBounds{

	public MissionsButtonBounds(int lAction, float left, float top, float right, float bottom) {
		super(lAction, left, top, right, bottom);
    	//System.out.println("LBBc=" + left + " " + top + " " + right + " " + bottom);
	}
	
	@Override
	public void doAction() {
		Constants.screen = new MissionsScreen();
		Constants.screen.prepare();
	}

}
