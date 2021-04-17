package com.example.spacenetdemo.marketbuyscreen;

import com.example.spacenetdemo.abstractclass.ButtonBounds;

public class AcceptButtonBounds extends ButtonBounds{
	MarketBuyScreen marketBuyScreen;
	boolean active = true;
	
	public AcceptButtonBounds(MarketBuyScreen lMarketBuyScreen, int lAction, float left, float top, float right, float bottom) {
		super(lAction, left, top, right, bottom);
		marketBuyScreen = lMarketBuyScreen;
	}
	
	@Override
	public void doAction() {
		if(active) {
			marketBuyScreen.enableConfirmWindow();
		}
	}

	public void setActive(boolean lActive) {
		active = lActive;
	}
}
