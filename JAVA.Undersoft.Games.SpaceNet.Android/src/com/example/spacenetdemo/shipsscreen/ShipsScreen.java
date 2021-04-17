package com.example.spacenetdemo.shipsscreen;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import com.example.spacenetdemo.Constants;
import com.example.spacenetdemo.enginesscreen.EnginesScreen;
import com.example.spacenetdemo.enginesscreen.RocketsButtonBounds;

public class ShipsScreen extends EnginesScreen {
	
	int displayedJet = 0; 
	Bitmap displayedJetBigBitmap = Constants.user.getJetBigBitmap(displayedJet);
	
	@Override
	public void prepare() {
		prepareCommon();
		EnginesButtonBounds ben = new EnginesButtonBounds(android.view.MotionEvent.ACTION_DOWN, 180*Constants.SZ, 90*Constants.WY, (180 + 130)*Constants.SZ, (90*Constants.WY + img_menuTextBackgroundSmallLeft.getHeight()));
		RocketsButtonBounds bro = new RocketsButtonBounds(android.view.MotionEvent.ACTION_DOWN, 340*Constants.SZ, 90*Constants.WY, (340 + 130)*Constants.SZ, (90*Constants.WY + img_menuTextBackgroundSmallLeft.getHeight()));
		Constants.buttons.add(ben);
		Constants.buttons.add(bro);

		PrevButtonBounds bpr = new PrevButtonBounds(this, android.view.MotionEvent.ACTION_DOWN,  10*Constants.SZ, Constants.S_H - 10*Constants.WY - img_menuBackSmall.getHeight(),  10*Constants.SZ + img_menuBackSmall.getWidth(), Constants.S_H - 10*Constants.WY);
		NextButtonBounds bne = new NextButtonBounds(this, android.view.MotionEvent.ACTION_DOWN, 120*Constants.SZ, Constants.S_H - 10*Constants.WY - img_menuBackSmall.getHeight(), 120*Constants.SZ + img_menuBackSmall.getWidth(), Constants.S_H - 10*Constants.WY);
		Constants.buttons.add(bpr);
		Constants.buttons.add(bne);
	}
	
	@Override
	public void draw(Canvas g) {
		drawCommon(g);
        drawTextSmallMenu(g, "Ships",    15*Constants.SZ, 90*Constants.WY, 5*(int)(26*Constants.SZ), paintWhiteTextInHangar, true, false);
        drawTextSmallMenu(g, "Engines", 180*Constants.SZ, 90*Constants.WY, 5*(int)(26*Constants.SZ), paintWhiteTextInHangar, true, true);
        drawTextSmallMenu(g, "Rockets", 340*Constants.SZ, 90*Constants.WY, 5*(int)(26*Constants.SZ), paintWhiteTextInHangar, true, true);
        
        g.drawBitmap(displayedJetBigBitmap, 98*Constants.SZ - displayedJetBigBitmap.getWidth()/2, 150*Constants.WY, null);
        
        g.drawText("Max Speed:",    200*Constants.SZ, 150*Constants.WY + img_menuBackSmall.getHeight()*16/24f, paintWhiteTextInHangarPrevNext);
        g.drawText("Capacity:", 200*Constants.SZ, 170*Constants.WY + img_menuBackSmall.getHeight()*16/24f, paintWhiteTextInHangarPrevNext);
        
        g.drawText("Cost:",     200*Constants.SZ, 210*Constants.WY + img_menuBackSmall.getHeight()*16/24f, paintWhiteTextInHangarPrevNext);
	}
}
