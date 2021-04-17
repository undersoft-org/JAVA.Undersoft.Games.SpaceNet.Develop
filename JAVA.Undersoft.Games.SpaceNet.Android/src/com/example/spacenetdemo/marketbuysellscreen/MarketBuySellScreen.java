package com.example.spacenetdemo.marketbuysellscreen;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.BitmapFactory.Options;

import com.example.spacenetdemo.Constants;
import com.example.spacenetdemo.R;
import com.example.spacenetdemo.abstractclass.Screen;

public class MarketBuySellScreen extends Screen {
	private Bitmap img_Background = null;
	private Bitmap img_menuLineBlueGradientRight;
	private Bitmap img_menuBack = null;
	
	private Bitmap img_crystal0 = null;
	private Bitmap img_crystal1 = null;
	private Bitmap img_crystal2 = null;
	
	Paint paintWhiteText = null;
	Paint paintWhiteTextOnPlanet = null;
	
	Paint paintYellow = null;
	Paint paintYellowAlpha = null;
	Paint paintYellowAlpha34 = null;
	Paint paintBlue = null;
	Paint paintBlueAlpha = null;
	Paint paintBlueAlpha34 = null;
	Paint paintBrownSell = null;
	Paint paintRedSell = null;
	Typeface font;
	Paint paintCenter = null;
	Paint paintCenter2 = null;
	
	public int activeSellBuyCrystalButton = 0;
	public int pricesOfCrystals[] = {2,4,5,3,5,7};
	
	@Override
	public void prepare() {
    	Options bitmapOptions = new Options();
    	bitmapOptions.inScaled = false;

		img_Background = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.menu65, bitmapOptions);
		img_Background = Bitmap.createScaledBitmap(img_Background,  Constants.S_W, Constants.S_H, false);

		img_menuLineBlueGradientRight = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.linia_blue_gradient_prawo150x1, bitmapOptions);
    	img_menuLineBlueGradientRight = Bitmap.createScaledBitmap(img_menuLineBlueGradientRight, (int)(img_menuLineBlueGradientRight.getWidth()*Constants.SZ*2), (int)(75*320f/320f), false);

    	img_menuBack = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.menu9back65, bitmapOptions);
    	img_menuBack = Bitmap.createScaledBitmap(img_menuBack, (int)(img_menuBack.getWidth()*Constants.SZ), (int)(img_menuBack.getHeight()*Constants.WY), false);
    	
    	img_crystal0 = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.krysztal10a35, bitmapOptions);
    	img_crystal0 = Bitmap.createScaledBitmap(img_crystal0, (int)(img_crystal0.getWidth()*Constants.SZ), (int)(img_crystal0.getHeight()*Constants.WY), false);
    	img_crystal1 = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.krysztal11a35, bitmapOptions);
    	img_crystal1 = Bitmap.createScaledBitmap(img_crystal1, (int)(img_crystal1.getWidth()*Constants.SZ), (int)(img_crystal1.getHeight()*Constants.WY), false);
    	img_crystal2 = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.krysztal12a35, bitmapOptions);
    	img_crystal2 = Bitmap.createScaledBitmap(img_crystal2, (int)(img_crystal2.getWidth()*Constants.SZ), (int)(img_crystal2.getHeight()*Constants.WY), false);
    	
	    font = Typeface.create(Typeface.MONOSPACE, Typeface.NORMAL);
        paintWhiteText = new Paint();
        paintWhiteText.setColor(Color.WHITE);
	    paintWhiteText.setTypeface(font);
	    //paintWhiteText.setFakeBoldText(true);
	    paintWhiteText.setTextSize(30*Constants.WY);
	    paintWhiteText.setTextSkewX(-0.2f);
	    paintWhiteText.setAntiAlias(true);
	    
	    paintWhiteTextOnPlanet = new Paint(paintWhiteText); 
	    paintWhiteTextOnPlanet.setTextSize(40*Constants.WY);
	    
		paintYellow = new Paint();
		paintYellow.setColor(Color.YELLOW);
		paintYellowAlpha = new Paint();
		paintYellowAlpha.setColor(Color.YELLOW);
		paintYellowAlpha.setAlpha(128);
		
		paintYellowAlpha34 = new Paint(paintYellowAlpha);
		paintYellowAlpha34.setAlpha(192);
		
		paintBlue = new Paint();
		paintBlue.setColor(Color.GREEN);
		paintBlueAlpha = new Paint();
		paintBlueAlpha.setColor(Color.GREEN);
		paintBlueAlpha.setAlpha(128);
		
		paintBlueAlpha34 = new Paint(paintBlueAlpha);
		paintBlueAlpha34.setAlpha(192);
		
		paintBrownSell = new Paint();
		paintBrownSell.setARGB(255,136,0,21);
		paintBrownSell.setAntiAlias(true);
		paintBrownSell.setTextSize(33*Constants.WY);
		//paintBrownSell.setTypeface(Typeface.create(Typeface.MONOSPACE, Typeface.NORMAL));
		paintBrownSell.setTypeface(Typeface.create(Typeface.DEFAULT_BOLD, Typeface.BOLD));
		
		//paintBrownSell.setFakeBoldText(true);
		paintRedSell = new Paint(paintBrownSell);
		paintRedSell.setColor(Color.RED);
		
		paintCenter = new Paint();
		paintCenter.setARGB(128,135,1,4);
		paintCenter2 = new Paint();
		paintCenter2.setARGB(192,219,2,7);
		
		Constants.buttons.clear();
		BackButtonBounds bba = new BackButtonBounds(android.view.MotionEvent.ACTION_DOWN, 10*Constants.SZ, 10*Constants.WY, 10*Constants.SZ + img_menuBack.getWidth(), 10*Constants.WY + img_menuBack.getHeight());
		Constants.buttons.add(bba);
		ChangeCrystalButtonBounds bc0 = new ChangeCrystalButtonBounds(this, 0, android.view.MotionEvent.ACTION_DOWN, 130*Constants.SZ, 120*Constants.WY, 350*Constants.SZ, 180*Constants.WY);
		ChangeCrystalButtonBounds bc1 = new ChangeCrystalButtonBounds(this, 1, android.view.MotionEvent.ACTION_DOWN, 130*Constants.SZ, 180*Constants.WY, 350*Constants.SZ, 240*Constants.WY);
		ChangeCrystalButtonBounds bc2 = new ChangeCrystalButtonBounds(this, 2, android.view.MotionEvent.ACTION_DOWN, 130*Constants.SZ, 240*Constants.WY, 350*Constants.SZ, 300*Constants.WY);
		Constants.buttons.add(bc0);
		Constants.buttons.add(bc1);
		Constants.buttons.add(bc2);
		SellButtonBounds bs1 = new SellButtonBounds(this, 1, android.view.MotionEvent.ACTION_DOWN, 25*Constants.SZ, 120*Constants.WY, 125*Constants.SZ, 210*Constants.WY);
		Constants.buttons.add(bs1);
		SellButtonBounds bs10 = new SellButtonBounds(this, 10, android.view.MotionEvent.ACTION_DOWN, 25*Constants.SZ, 210*Constants.WY, 125*Constants.SZ, 300*Constants.WY);
		Constants.buttons.add(bs10);
		BuyButtonBounds bb1 = new BuyButtonBounds(this, 1, android.view.MotionEvent.ACTION_DOWN, 355*Constants.SZ, 120*Constants.WY, 455*Constants.SZ, 210*Constants.WY);
		Constants.buttons.add(bb1);
		BuyButtonBounds bb10 = new BuyButtonBounds(this, 10, android.view.MotionEvent.ACTION_DOWN, 355*Constants.SZ, 210*Constants.WY, 455*Constants.SZ, 300*Constants.WY);
		Constants.buttons.add(bb10);
	}

	@Override
	public void update() {
	}

	@Override
	public void draw(Canvas g) {
        g.drawBitmap(img_Background, 0, 0, null);

        g.drawBitmap(img_menuLineBlueGradientRight, g.getWidth() - img_menuLineBlueGradientRight.getWidth(), 0, null);
        Constants.planets.listOfPlanets.get(Constants.planets.checkStayInCenterOfPlanet).drawNameOnPosition(g, g.getWidth() - (int)paintWhiteTextOnPlanet.measureText(Constants.planets.listOfPlanets.get(Constants.planets.checkStayInCenterOfPlanet).name) - 85, (int)(img_menuLineBlueGradientRight.getHeight()*16/24f), paintWhiteTextOnPlanet);
        g.scale(0.5f, 0.5f);
        Constants.planets.listOfPlanets.get(Constants.planets.checkStayInCenterOfPlanet).drawOnPosition(g, (g.getWidth() - 75)*2, 0);
        g.scale(2, 2);

        g.drawBitmap(img_menuBack, 10*Constants.SZ, 10*Constants.WY, null);
        g.drawText("Back", 32*Constants.SZ, 10*Constants.WY + img_menuBack.getHeight()*16/24f, paintWhiteTextOnPlanet);
        
        //--------left side
        g.drawRect(25*Constants.SZ,  85*Constants.WY, (25 + 100)*Constants.SZ, 115*Constants.WY, paintYellowAlpha);
        g.drawRect(25*Constants.SZ, 120*Constants.WY, (25 + 100)*Constants.SZ, 210*Constants.WY, paintYellowAlpha34);
        g.drawRect(25*Constants.SZ, 210*Constants.WY, (25 + 100)*Constants.SZ, 300*Constants.WY, paintYellow);
        String price = new String("$ " + pricesOfCrystals[activeSellBuyCrystalButton]);
        //g.drawText("30", 30*Constants.SZ + 50*Constants.SZ - paintWhiteText.measureText("30")/2f, 115*Constants.WY + paintWhiteText.getTextSize()*16/24f, paintWhiteText);
        drawPriceOnPosition(g, price, 25*Constants.SZ + 50*Constants.SZ - paintWhiteText.measureText(price)/2f, 85*Constants.WY + paintWhiteText.getTextSize()*21/24f, paintWhiteText);
        g.drawText("SELL", 25*Constants.SZ + 50*Constants.SZ - paintRedSell.measureText("SELL")/2f, 155*Constants.WY + paintRedSell.getTextSize()*16/24f, paintRedSell);
        g.drawText("SELL", 25*Constants.SZ + 50*Constants.SZ - paintRedSell.measureText("SELL")/2f, 228*Constants.WY + paintRedSell.getTextSize()*16/24f, paintRedSell);
        g.drawText("10", 25*Constants.SZ + 50*Constants.SZ - paintRedSell.measureText("10")/2f, 260*Constants.WY + paintRedSell.getTextSize()*16/24f, paintRedSell);
        
        //--------right side
        g.drawRect(355*Constants.SZ,  85*Constants.WY, (355 + 100)*Constants.SZ, 115*Constants.WY, paintBlueAlpha);
        g.drawRect(355*Constants.SZ, 120*Constants.WY, (355 + 100)*Constants.SZ, 210*Constants.WY, paintBlueAlpha34);
        g.drawRect(355*Constants.SZ, 210*Constants.WY, (355 + 100)*Constants.SZ, 300*Constants.WY, paintBlue);
        String price2 = new String("$ " + pricesOfCrystals[activeSellBuyCrystalButton + 3]);
        //g.drawText("30", 30*Constants.SZ + 50*Constants.SZ - paintWhiteText.measureText("30")/2f, 115*Constants.WY + paintWhiteText.getTextSize()*16/24f, paintWhiteText);
        drawPriceOnPosition(g, price2, 355*Constants.SZ + 50*Constants.SZ - paintWhiteText.measureText(price2)/2f, 85*Constants.WY + paintWhiteText.getTextSize()*21/24f, paintWhiteText);
        g.drawText("BUY", 355*Constants.SZ + 50*Constants.SZ - paintRedSell.measureText("BUY")/2f, 155*Constants.WY + paintRedSell.getTextSize()*16/24f, paintRedSell);
        g.drawText("BUY", 355*Constants.SZ + 50*Constants.SZ - paintRedSell.measureText("BUY")/2f, 228*Constants.WY + paintRedSell.getTextSize()*16/24f, paintRedSell);
        g.drawText("10", 355*Constants.SZ + 50*Constants.SZ - paintRedSell.measureText("10")/2f, 260*Constants.WY + paintRedSell.getTextSize()*16/24f, paintRedSell);
        
        //---------center
        g.drawRect(130*Constants.SZ, 120*Constants.WY, (200 + 150)*Constants.SZ, (300)*Constants.WY, paintCenter);
        g.drawRect(130*Constants.SZ, (120 + 60*activeSellBuyCrystalButton)*Constants.WY, (200 + 150)*Constants.SZ, (120 + 60*activeSellBuyCrystalButton + 60)*Constants.WY, paintCenter2);
        
        //money
        g.drawRect(130*Constants.SZ, 85*Constants.WY, (200 + 150)*Constants.SZ, 115*Constants.WY, paintCenter);
        g.drawText("$ " + Constants.user.money, 340*Constants.SZ - paintWhiteText.measureText("$ " + Constants.user.money), 85*Constants.WY + paintWhiteText.getTextSize()*21/24f, paintWhiteText);
        
        //crystals
        g.drawBitmap(img_crystal0, 155*Constants.SZ, 150*Constants.WY - img_crystal0.getHeight()/2, null);
        g.drawBitmap(img_crystal1, 155*Constants.SZ, 210*Constants.WY - img_crystal0.getHeight()/2, null);
        g.drawBitmap(img_crystal2, 155*Constants.SZ, 270*Constants.WY - img_crystal0.getHeight()/2, null);

        g.drawText("" + Constants.user.gatheredCrystals[0], 340*Constants.SZ - paintWhiteText.measureText("" + Constants.user.gatheredCrystals[0]), 135*Constants.WY + paintWhiteText.getTextSize()*21/24f, paintWhiteText);
        g.drawText("" + Constants.user.gatheredCrystals[1], 340*Constants.SZ - paintWhiteText.measureText("" + Constants.user.gatheredCrystals[1]), 195*Constants.WY + paintWhiteText.getTextSize()*21/24f, paintWhiteText);
        g.drawText("" + Constants.user.gatheredCrystals[2], 340*Constants.SZ - paintWhiteText.measureText("" + Constants.user.gatheredCrystals[2]), 255*Constants.WY + paintWhiteText.getTextSize()*21/24f, paintWhiteText);
	}
	
	
	public void drawPriceOnPosition(Canvas g, String text, float x, float y, Paint paint) {
		g.drawText(text, x, y, paint);
	}
	
//    //--------left side
//    g.drawRect(25*Constants.SZ, 120*Constants.WY, (25 + 100)*Constants.SZ, 180*Constants.WY, paintYellowAlpha);
//    g.drawRect(25*Constants.SZ, 180*Constants.WY, (25 + 100)*Constants.SZ, 240*Constants.WY, paintYellowAlpha34);
//    g.drawRect(25*Constants.SZ, 240*Constants.WY, (25 + 100)*Constants.SZ, 300*Constants.WY, paintYellow);
//    String price = new String("$ " + 5);
//    //g.drawText("30", 30*Constants.SZ + 50*Constants.SZ - paintWhiteText.measureText("30")/2f, 115*Constants.WY + paintWhiteText.getTextSize()*16/24f, paintWhiteText);
//    drawPriceOnPosition(g, price, 25*Constants.SZ + 50*Constants.SZ - paintWhiteText.measureText(price)/2f, 140*Constants.WY + paintWhiteText.getTextSize()*16/24f, paintWhiteText);
//    g.drawText("SELL", 25*Constants.SZ + 50*Constants.SZ - paintRedSell.measureText("SELL")/2f, 200*Constants.WY + paintRedSell.getTextSize()*16/24f, paintRedSell);
//    g.drawText("SELL", 25*Constants.SZ + 50*Constants.SZ - paintRedSell.measureText("SELL")/2f, 246*Constants.WY + paintRedSell.getTextSize()*16/24f, paintRedSell);
//    g.drawText("10", 25*Constants.SZ + 50*Constants.SZ - paintRedSell.measureText("10")/2f, 273*Constants.WY + paintRedSell.getTextSize()*16/24f, paintRedSell);
//    
//    //--------right side
//    g.drawRect(355*Constants.SZ, 120*Constants.WY, (355 + 100)*Constants.SZ, 180*Constants.WY, paintBlueAlpha);
//    g.drawRect(355*Constants.SZ, 180*Constants.WY, (355 + 100)*Constants.SZ, 240*Constants.WY, paintBlueAlpha34);
//    g.drawRect(355*Constants.SZ, 240*Constants.WY, (355 + 100)*Constants.SZ, 300*Constants.WY, paintBlue);
//    String price2 = new String("$ " + 7);
//    //g.drawText("30", 30*Constants.SZ + 50*Constants.SZ - paintWhiteText.measureText("30")/2f, 115*Constants.WY + paintWhiteText.getTextSize()*16/24f, paintWhiteText);
//    drawPriceOnPosition(g, price2, 355*Constants.SZ + 50*Constants.SZ - paintWhiteText.measureText(price2)/2f, 140*Constants.WY + paintWhiteText.getTextSize()*16/24f, paintWhiteText);
//    g.drawText("BUY", 355*Constants.SZ + 50*Constants.SZ - paintRedSell.measureText("BUY")/2f, 200*Constants.WY + paintRedSell.getTextSize()*16/24f, paintRedSell);
//    g.drawText("BUY", 355*Constants.SZ + 50*Constants.SZ - paintRedSell.measureText("BUY")/2f, 246*Constants.WY + paintRedSell.getTextSize()*16/24f, paintRedSell);
//    g.drawText("10", 355*Constants.SZ + 50*Constants.SZ - paintRedSell.measureText("10")/2f, 273*Constants.WY + paintRedSell.getTextSize()*16/24f, paintRedSell);
//    
//    //---------center
//    g.drawRect(130*Constants.SZ, 120*Constants.WY, (200 + 150)*Constants.SZ, (300)*Constants.WY, paintCenter);
//    g.drawRect(130*Constants.SZ, 120*Constants.WY, (200 + 150)*Constants.SZ, (120 + 60)*Constants.WY, paintCenter2);
//    
//    //money
//    g.drawRect(130*Constants.SZ, 85*Constants.WY, (200 + 150)*Constants.SZ, 115*Constants.WY, paintCenter);
//    g.drawText("$ 0", 340*Constants.SZ - paintWhiteText.measureText("$ 0"), 85*Constants.WY + paintWhiteText.getTextSize()*21/24f, paintWhiteText);
//    
//    //crystals
//    g.drawBitmap(img_crystal0, 155*Constants.SZ, 150*Constants.WY - img_crystal0.getHeight()/2, null);
//    g.drawBitmap(img_crystal1, 155*Constants.SZ, 210*Constants.WY - img_crystal0.getHeight()/2, null);
//    g.drawBitmap(img_crystal2, 155*Constants.SZ, 270*Constants.WY - img_crystal0.getHeight()/2, null);
//
//    g.drawText("5", 340*Constants.SZ - paintWhiteText.measureText("5"), 135*Constants.WY + paintWhiteText.getTextSize()*21/24f, paintWhiteText);
//    g.drawText("31", 340*Constants.SZ - paintWhiteText.measureText("31"), 195*Constants.WY + paintWhiteText.getTextSize()*21/24f, paintWhiteText);
//    g.drawText("425", 340*Constants.SZ - paintWhiteText.measureText("425"), 255*Constants.WY + paintWhiteText.getTextSize()*21/24f, paintWhiteText);

}
