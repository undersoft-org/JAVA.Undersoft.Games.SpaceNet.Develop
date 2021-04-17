package com.example.spacenetdemo.hangarscreen;

import com.example.spacenetdemo.Constants;
import com.example.spacenetdemo.abstractclass.ButtonBounds;
import com.example.spacenetdemo.shipsscreen.ShipsScreen;

public class ShipsButtonBounds extends ButtonBounds{

	public ShipsButtonBounds(int lAction, float left, float top, float right, float bottom) {
		super(lAction, left, top, right, bottom);
    	//System.out.println("LBBc=" + left + " " + top + " " + right + " " + bottom);
	}
	
	@Override
	public void doAction() {
		Constants.screen = new ShipsScreen();
		Constants.screen.prepare();
	}

}
