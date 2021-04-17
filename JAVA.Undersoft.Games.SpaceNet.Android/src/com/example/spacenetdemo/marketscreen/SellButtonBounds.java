package com.example.spacenetdemo.marketscreen;

import com.example.spacenetdemo.Constants;
import com.example.spacenetdemo.abstractclass.ButtonBounds;
import com.example.spacenetdemo.marketsellscreen.MarketSellScreen;
import com.example.spacenetdemo.shipsscreen.ShipsScreen;

public class SellButtonBounds extends ButtonBounds{

	public SellButtonBounds(int lAction, float left, float top, float right, float bottom) {
		super(lAction, left, top, right, bottom);
    	//System.out.println("LBBc=" + left + " " + top + " " + right + " " + bottom);
	}
	
	@Override
	public void doAction() {
		Constants.screen = new MarketSellScreen();
		Constants.screen.prepare();
	}

}
