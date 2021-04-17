package com.example.spacenetdemo.marketbuyscreen;

import com.example.spacenetdemo.abstractclass.ButtonBounds;

public class MinusPlusButtonBounds extends ButtonBounds{
	MarketBuyScreen marketBuyScreen;
	int crystalNumber = 0;
	boolean plus = true;
	boolean active = true;
	
	public MinusPlusButtonBounds(MarketBuyScreen lMarketBuyScreen, boolean lPlus, int lCrystalNumber, int lAction, float left, float top, float right, float bottom) {
		super(lAction, left, top, right, bottom);
		marketBuyScreen = lMarketBuyScreen;
		crystalNumber = lCrystalNumber;
		plus = lPlus;
	}
	
	@Override
	public void doAction() {
		if(active) {
			if(plus) {
				if(marketBuyScreen.formCountOfCrystals[crystalNumber] < 99)
					marketBuyScreen.formCountOfCrystals[crystalNumber]++;
			} else {
				if(marketBuyScreen.formCountOfCrystals[crystalNumber] > 0)
					marketBuyScreen.formCountOfCrystals[crystalNumber]--;
			}
			marketBuyScreen.countCrystalsForm();
		}
	}
	
	public void setActive(boolean lActive) {
		active = lActive;
	}
	
}
