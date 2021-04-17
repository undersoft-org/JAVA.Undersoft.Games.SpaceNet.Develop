package com.example.spacenetdemo.marketscreen;

import com.example.spacenetdemo.Constants;
import com.example.spacenetdemo.abstractclass.ButtonBounds;
import com.example.spacenetdemo.marketbuyscreen.MarketBuyScreen;

public class BuyButtonBounds extends ButtonBounds{

	public BuyButtonBounds(int lAction, float left, float top, float right, float bottom) {
		super(lAction, left, top, right, bottom);
    	//System.out.println("LBBc=" + left + " " + top + " " + right + " " + bottom);
	}
	
	@Override
	public void doAction() {
		Constants.screen = new MarketBuyScreen();
		Constants.screen.prepare();
	}

}
