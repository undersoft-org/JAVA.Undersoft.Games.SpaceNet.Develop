package com.example.spacenetdemo.marketsellscreen;

import com.example.spacenetdemo.abstractclass.ButtonBounds;

public class AcceptButtonBounds extends ButtonBounds{
	MarketSellScreen marketBuyScreen;
	boolean active = true;
	
	public AcceptButtonBounds(MarketSellScreen lMarketSellScreen, int lAction, float left, float top, float right, float bottom) {
		super(lAction, left, top, right, bottom);
		marketBuyScreen = lMarketSellScreen;
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
