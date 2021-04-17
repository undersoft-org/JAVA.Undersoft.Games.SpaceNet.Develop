package com.example.spacenetdemo.shipsscreen;

import com.example.spacenetdemo.Constants;
import com.example.spacenetdemo.abstractclass.ButtonBounds;

public class PrevButtonBounds extends ButtonBounds{
	ShipsScreen shipsScreen;
	
	public PrevButtonBounds(ShipsScreen lShipsScreen, int lAction, float left, float top, float right, float bottom) {
		super(lAction, left, top, right, bottom);
		shipsScreen = lShipsScreen;
	}
	
	@Override
	public void doAction() {
		if(shipsScreen.displayedJet > 0) {
			shipsScreen.displayedJet--;
			shipsScreen.displayedJetBigBitmap = Constants.user.getJetBigBitmap(shipsScreen.displayedJet);
		}
	}

}
