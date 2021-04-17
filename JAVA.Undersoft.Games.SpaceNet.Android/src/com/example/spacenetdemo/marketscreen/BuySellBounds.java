package com.example.spacenetdemo.marketscreen;

import com.example.spacenetdemo.Constants;
import com.example.spacenetdemo.abstractclass.ButtonBounds;
import com.example.spacenetdemo.marketbuysellscreen.MarketBuySellScreen;

public class BuySellBounds extends ButtonBounds{

	public BuySellBounds(int lAction, float left, float top, float right, float bottom) {
		super(lAction, left, top, right, bottom);
    	//System.out.println("LBBc=" + left + " " + top + " " + right + " " + bottom);
	}
	
	@Override
	public void doAction() {
		Constants.screen = new MarketBuySellScreen();
		Constants.screen.prepare();
	}

}
