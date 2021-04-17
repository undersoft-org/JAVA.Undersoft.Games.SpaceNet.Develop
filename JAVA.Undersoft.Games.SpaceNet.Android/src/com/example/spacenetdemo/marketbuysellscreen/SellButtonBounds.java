package com.example.spacenetdemo.marketbuysellscreen;

import com.example.spacenetdemo.Constants;
import com.example.spacenetdemo.abstractclass.ButtonBounds;

public class SellButtonBounds extends ButtonBounds{
	MarketBuySellScreen marketScreen;
	int count = 0;
	
	public SellButtonBounds(MarketBuySellScreen lMarketScreen, int lCount, int lAction, float left, float top, float right, float bottom) {
		super(lAction, left, top, right, bottom);
		marketScreen = lMarketScreen;
		count = lCount;
	}
	
	@Override
	public void doAction() {
		int crystalCount = Constants.user.gatheredCrystals[marketScreen.activeSellBuyCrystalButton];
		if( crystalCount >= count) {
			Constants.user.gatheredCrystals[marketScreen.activeSellBuyCrystalButton] -= count;
			Constants.user.money += marketScreen.pricesOfCrystals[marketScreen.activeSellBuyCrystalButton]*count;
		}
	}

}
