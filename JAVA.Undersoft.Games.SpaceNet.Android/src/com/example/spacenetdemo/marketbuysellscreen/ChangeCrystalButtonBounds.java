package com.example.spacenetdemo.marketbuysellscreen;

import com.example.spacenetdemo.abstractclass.ButtonBounds;

public class ChangeCrystalButtonBounds extends ButtonBounds{
	MarketBuySellScreen marketScreen;
	int number = 0;
	
	public ChangeCrystalButtonBounds(MarketBuySellScreen lMarketScreen, int lNumber, int lAction, float left, float top, float right, float bottom) {
		super(lAction, left, top, right, bottom);
		marketScreen = lMarketScreen;
		number = lNumber;
	}
	
	@Override
	public void doAction() {
		marketScreen.activeSellBuyCrystalButton = number;
	}

}
