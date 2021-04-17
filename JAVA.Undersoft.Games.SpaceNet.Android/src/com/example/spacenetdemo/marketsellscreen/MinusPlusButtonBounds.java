package com.example.spacenetdemo.marketsellscreen;

import com.example.spacenetdemo.Constants;
import com.example.spacenetdemo.abstractclass.ButtonBounds;

public class MinusPlusButtonBounds extends ButtonBounds{
	MarketSellScreen marketSellScreen;
	int crystalNumber = 0;
	boolean plus = true;
	boolean active = true;
	
	public MinusPlusButtonBounds(MarketSellScreen lMarketSellScreen, boolean lPlus, int lCrystalNumber, int lAction, float left, float top, float right, float bottom) {
		super(lAction, left, top, right, bottom);
		marketSellScreen = lMarketSellScreen;
		crystalNumber = lCrystalNumber;
		plus = lPlus;
	}
	
	@Override
	public void doAction() {
		if(active) {
			if(plus) {
				if(marketSellScreen.formCountOfCrystals[crystalNumber] < Constants.user.gatheredCrystals[crystalNumber])
					marketSellScreen.formCountOfCrystals[crystalNumber]++;
			} else {
				if(marketSellScreen.formCountOfCrystals[crystalNumber] > 0)
					marketSellScreen.formCountOfCrystals[crystalNumber]--;
			}
			marketSellScreen.countCrystalsForm();
		}
	}
	
	public void setActive(boolean lActive) {
		active = lActive;
	}
	
}
