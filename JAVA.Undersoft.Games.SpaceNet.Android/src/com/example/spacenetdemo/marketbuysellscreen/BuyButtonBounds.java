package com.example.spacenetdemo.marketbuysellscreen;

import com.example.spacenetdemo.Constants;
import com.example.spacenetdemo.abstractclass.ButtonBounds;

public class BuyButtonBounds extends ButtonBounds{
	MarketBuySellScreen marketScreen;
	int count = 0;
	
	public BuyButtonBounds(MarketBuySellScreen lMarketScreen, int lCount, int lAction, float left, float top, float right, float bottom) {
		super(lAction, left, top, right, bottom);
		marketScreen = lMarketScreen;
		count = lCount;
	}
	
	@Override
	public void doAction() {
		int buyPrice = marketScreen.pricesOfCrystals[marketScreen.activeSellBuyCrystalButton + 3];
		if( Constants.user.money >= buyPrice * count) {
			Constants.user.gatheredCrystals[marketScreen.activeSellBuyCrystalButton] += count;
			Constants.user.money -= buyPrice * count;
		}
	}

}
