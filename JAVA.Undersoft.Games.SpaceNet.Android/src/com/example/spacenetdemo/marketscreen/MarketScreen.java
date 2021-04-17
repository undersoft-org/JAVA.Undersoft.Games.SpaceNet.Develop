package com.example.spacenetdemo.marketscreen;

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

public class MarketScreen extends Screen {
	private Bitmap img_Background = null;
	private Bitmap img_menuLineBlueGradientRight;
	private Bitmap img_menuBack = null;

	private Bitmap img_menuTextBackgroundLeft;
	private Bitmap img_menuTextBackgroundCenter;
	private Bitmap img_menuTextBackgroundRight;

	Paint paintWhiteText = null;
	Paint paintWhiteTextOnPlanet = null;
	Typeface font;
	
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
    	
    	img_menuTextBackgroundLeft = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.menu1_tlo_lewy, bitmapOptions);
    	img_menuTextBackgroundLeft = Bitmap.createScaledBitmap(img_menuTextBackgroundLeft, img_menuTextBackgroundLeft.getWidth(), (int)(img_menuTextBackgroundLeft.getHeight()*Constants.WY), false);
    	img_menuTextBackgroundCenter = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.menu1_tlo_srodek, bitmapOptions);
    	img_menuTextBackgroundCenter = Bitmap.createScaledBitmap(img_menuTextBackgroundCenter, img_menuTextBackgroundCenter.getWidth(), (int)(img_menuTextBackgroundCenter.getHeight()*Constants.WY), false);
    	img_menuTextBackgroundRight = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.menu1_tlo_prawy, bitmapOptions);
    	img_menuTextBackgroundRight = Bitmap.createScaledBitmap(img_menuTextBackgroundRight, img_menuTextBackgroundRight.getWidth(), (int)(img_menuTextBackgroundRight.getHeight()*Constants.WY), false);

    	font = Typeface.create(Typeface.MONOSPACE, Typeface.NORMAL); 
        paintWhiteText = new Paint();
        paintWhiteText.setColor(Color.WHITE);
	    paintWhiteText.setTypeface(font);
	    //paintWhiteText.setFakeBoldText(true);
	    paintWhiteText.setTextSize(23);
	    paintWhiteText.setTextSkewX(-0.2f);
	    paintWhiteText.setAntiAlias(true);
	    
	    paintWhiteTextOnPlanet = new Paint(paintWhiteText); 
	    paintWhiteTextOnPlanet.setTextSize(40*Constants.WY);
	    
		Constants.buttons.clear();
		BackButtonBounds b = new BackButtonBounds(android.view.MotionEvent.ACTION_DOWN, 10*Constants.SZ, 10*Constants.WY, 10*Constants.SZ + img_menuBack.getWidth(), 10*Constants.WY + img_menuBack.getHeight());
		Constants.buttons.add(b);

		SellButtonBounds bsh = new SellButtonBounds(android.view.MotionEvent.ACTION_DOWN,  15*Constants.SZ, 120*Constants.WY,  (15 + 220)*Constants.SZ, (120*Constants.WY + img_menuTextBackgroundLeft.getHeight()));
		BuyButtonBounds   ben = new BuyButtonBounds(android.view.MotionEvent.ACTION_DOWN, 240*Constants.SZ, 120*Constants.WY, (240 + 220)*Constants.SZ, (120*Constants.WY + img_menuTextBackgroundLeft.getHeight()));
		BuySellBounds       bro = new BuySellBounds(android.view.MotionEvent.ACTION_DOWN, 120*Constants.SZ, 210*Constants.WY, (120 + 220)*Constants.SZ, (210*Constants.WY + img_menuTextBackgroundLeft.getHeight()));
		Constants.buttons.add(bsh);
		Constants.buttons.add(ben);
		Constants.buttons.add(bro);
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
        
        drawTextMenu(g, "SELL",      15*Constants.SZ, 120*Constants.WY, 10*(int)(22*Constants.SZ), paintWhiteTextOnPlanet, true);
        drawTextMenu(g, "BUY",      240*Constants.SZ, 120*Constants.WY, 10*(int)(22*Constants.SZ), paintWhiteTextOnPlanet, true);
        drawTextMenu(g, "BUY/SELL", 120*Constants.SZ, 210*Constants.WY, 10*(int)(22*Constants.SZ), paintWhiteTextOnPlanet, true);
	}
	
    public void drawTextMenu(Canvas g, String text, float x, float y, int width, Paint paint, boolean center) {
	    g.drawBitmap(img_menuTextBackgroundLeft, x, y, null);
	    for(int i = 0; i < (width - 20)/10; i++) {
	    	g.drawBitmap(img_menuTextBackgroundCenter, x + 10 + 10*i, y, null);
	    }
	    g.drawBitmap(img_menuTextBackgroundRight, x + 10 + (width - 20), y, null);
	    if(center) {
	    	g.drawText(text, x + 10 + ((width - 20) - paint.measureText(text))/2f, y + img_menuTextBackgroundCenter.getHeight()*16/24f , paint);
	    } else {
	    	g.drawText(text, x + 10, y + img_menuTextBackgroundCenter.getHeight()*16/24f , paint);
	    }
	}
}
