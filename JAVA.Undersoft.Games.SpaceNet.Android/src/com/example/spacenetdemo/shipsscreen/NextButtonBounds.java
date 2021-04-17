package com.example.spacenetdemo.shipsscreen;

import com.example.spacenetdemo.Constants;
import com.example.spacenetdemo.abstractclass.ButtonBounds;

public class NextButtonBounds extends ButtonBounds{
	ShipsScreen shipsScreen;
	
	public NextButtonBounds(ShipsScreen lShipsScreen, int lAction, float left, float top, float right, float bottom) {
		super(lAction, left, top, right, bottom);
		shipsScreen = lShipsScreen;
	}
	
	@Override
	public void doAction() {
		if(shipsScreen.displayedJet < Constants.user.MAX_NUMBER_OF_SHIPS) {
			shipsScreen.displayedJet++;
			shipsScreen.displayedJetBigBitmap = Constants.user.getJetBigBitmap(shipsScreen.displayedJet);
		}
	}

}
