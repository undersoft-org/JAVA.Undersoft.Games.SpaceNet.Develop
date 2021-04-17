package com.example.spacenetdemo.rocketsscreen;

import android.graphics.Canvas;

import com.example.spacenetdemo.Constants;
import com.example.spacenetdemo.enginesscreen.EnginesScreen;
import com.example.spacenetdemo.enginesscreen.ShipsButtonBounds;

public class RocketsScreen extends EnginesScreen{
	
	@Override
	public void prepare() {
		prepareCommon();
		ShipsButtonBounds     bsh = new ShipsButtonBounds(android.view.MotionEvent.ACTION_DOWN,  15*Constants.SZ, 90*Constants.WY, ( 15 + 130)*Constants.SZ, (90*Constants.WY + img_menuTextBackgroundSmallLeft.getHeight()));
		EnginesButtonBounds ben = new EnginesButtonBounds(android.view.MotionEvent.ACTION_DOWN, 180*Constants.SZ, 90*Constants.WY, (180 + 130)*Constants.SZ, (90*Constants.WY + img_menuTextBackgroundSmallLeft.getHeight()));
		Constants.buttons.add(bsh);
		Constants.buttons.add(ben);
	}
	
	@Override
	public void draw(Canvas g) {
		drawCommon(g);
        drawTextSmallMenu(g, "Ships",    15*Constants.SZ, 90*Constants.WY, 5*(int)(26*Constants.SZ), paintWhiteTextInHangar, true, true);
        drawTextSmallMenu(g, "Engines", 180*Constants.SZ, 90*Constants.WY, 5*(int)(26*Constants.SZ), paintWhiteTextInHangar, true, true);
        drawTextSmallMenu(g, "Rockets", 340*Constants.SZ, 90*Constants.WY, 5*(int)(26*Constants.SZ), paintWhiteTextInHangar, true, false);
	}
}
