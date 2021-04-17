package com.example.spacenetdemo.enginesscreen;

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

public class EnginesScreen extends Screen {
	protected Bitmap img_Background = null;
	protected Bitmap img_menuLineBlueGradientRight;
	protected Bitmap img_menuBack = null;
	
	protected Bitmap img_menuTextBackgroundLeft;
	protected Bitmap img_menuTextBackgroundCenter;
	protected Bitmap img_menuTextBackgroundRight;
	
	protected Bitmap img_menuTextBackgroundSmallLeft;
	protected Bitmap img_menuTextBackgroundSmallCenter;
	protected Bitmap img_menuTextBackgroundSmallRight;

	protected Bitmap img_menuTextBackgroundFrameLeft;
	protected Bitmap img_menuTextBackgroundFrameCenter;
	protected Bitmap img_menuTextBackgroundFrameRight;

	protected Bitmap img_menuBackSmall;
	protected Bitmap img_menuBackSmallRight;
	
	protected Paint paintWhiteText = null;
	protected Paint paintWhiteTextOnPlanet = null;
	protected Typeface font;
	protected Paint paintWhiteTextInHangar = null;
	protected Paint paintWhiteTextInHangarPrevNext = null;
	protected Paint paintDarkness = null;
	
	@Override
	public void prepare() {
		prepareCommon();
		ShipsButtonBounds     bsh = new ShipsButtonBounds(android.view.MotionEvent.ACTION_DOWN,  15*Constants.SZ, 90*Constants.WY, ( 15 + 130)*Constants.SZ, (90*Constants.WY + img_menuTextBackgroundSmallLeft.getHeight()));
		RocketsButtonBounds bro = new RocketsButtonBounds(android.view.MotionEvent.ACTION_DOWN, 340*Constants.SZ, 90*Constants.WY, (340 + 130)*Constants.SZ, (90*Constants.WY + img_menuTextBackgroundSmallLeft.getHeight()));
		Constants.buttons.add(bsh);
		Constants.buttons.add(bro);
	}
	
	public void prepareCommon() {
    	Options bitmapOptions = new Options();
    	bitmapOptions.inScaled = false;

		img_Background = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.hangar5, bitmapOptions);
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

    	img_menuTextBackgroundSmallLeft = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.menu1_35_tlo_lewy, bitmapOptions);
    	img_menuTextBackgroundSmallLeft = Bitmap.createScaledBitmap(img_menuTextBackgroundSmallLeft, img_menuTextBackgroundSmallLeft.getWidth(), (int)(img_menuTextBackgroundSmallLeft.getHeight()*Constants.WY), false);
    	img_menuTextBackgroundSmallCenter = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.menu1_35_tlo_srodek, bitmapOptions);
    	img_menuTextBackgroundSmallCenter = Bitmap.createScaledBitmap(img_menuTextBackgroundSmallCenter, img_menuTextBackgroundSmallCenter.getWidth(), (int)(img_menuTextBackgroundSmallCenter.getHeight()*Constants.WY), false);
    	img_menuTextBackgroundSmallRight = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.menu1_35_tlo_prawy, bitmapOptions);
    	img_menuTextBackgroundSmallRight = Bitmap.createScaledBitmap(img_menuTextBackgroundSmallRight, img_menuTextBackgroundSmallRight.getWidth(), (int)(img_menuTextBackgroundSmallRight.getHeight()*Constants.WY), false);

    	img_menuTextBackgroundFrameLeft = Bitmap.createScaledBitmap(img_menuTextBackgroundLeft, img_menuTextBackgroundLeft.getWidth(), (int)(145*Constants.WY), false);
    	img_menuTextBackgroundFrameCenter = Bitmap.createScaledBitmap(img_menuTextBackgroundCenter, img_menuTextBackgroundCenter.getWidth(), (int)(145*Constants.WY), false);
    	img_menuTextBackgroundFrameRight = Bitmap.createScaledBitmap(img_menuTextBackgroundRight, img_menuTextBackgroundRight.getWidth(), (int)(145*Constants.WY), false);

    	img_menuBackSmall = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.menu9back35, bitmapOptions);
    	img_menuBackSmall = Bitmap.createScaledBitmap(img_menuBackSmall, (int)(img_menuBackSmall.getWidth()*Constants.SZ), (int)(img_menuBackSmall.getHeight()*Constants.WY), false);
    	img_menuBackSmallRight = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.menu9back35prawo, bitmapOptions);
    	img_menuBackSmallRight = Bitmap.createScaledBitmap(img_menuBackSmallRight, (int)(img_menuBackSmallRight.getWidth()*Constants.SZ), (int)(img_menuBackSmallRight.getHeight()*Constants.WY), false);

    	
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
	    
        paintWhiteTextInHangar = new Paint(paintWhiteText);
        paintWhiteTextInHangar.setTextSize(24*Constants.WY);
        
        paintWhiteTextInHangarPrevNext = new Paint(paintWhiteText);
        paintWhiteTextInHangarPrevNext.setTextSize(18*Constants.WY);
        
        paintDarkness = new Paint();
        paintDarkness.setAntiAlias(true);
        paintDarkness.setARGB(150,0,0,0);
        
		Constants.buttons.clear();
		BackButtonBounds b = new BackButtonBounds(android.view.MotionEvent.ACTION_DOWN, 10*Constants.SZ, 10*Constants.WY, 10*Constants.SZ + img_menuBack.getWidth(), 10*Constants.WY + img_menuBack.getHeight());
		Constants.buttons.add(b);
	}

	@Override
	public void update() {
	}

	@Override
	public void draw(Canvas g) {
		drawCommon(g);
        drawTextSmallMenu(g, "Ships",    15*Constants.SZ, 90*Constants.WY, 5*(int)(26*Constants.SZ), paintWhiteTextInHangar, true, true);
        drawTextSmallMenu(g, "Engines", 180*Constants.SZ, 90*Constants.WY, 5*(int)(26*Constants.SZ), paintWhiteTextInHangar, true, false);
        drawTextSmallMenu(g, "Rockets", 340*Constants.SZ, 90*Constants.WY, 5*(int)(26*Constants.SZ), paintWhiteTextInHangar, true, true);
	}
	
	public void drawCommon(Canvas g) {	
        g.drawBitmap(img_Background, 0, 0, null);

        g.drawBitmap(img_menuLineBlueGradientRight, g.getWidth() - img_menuLineBlueGradientRight.getWidth(), 0, null);
        Constants.planets.listOfPlanets.get(Constants.planets.checkStayInCenterOfPlanet).drawNameOnPosition(g, g.getWidth() - (int)paintWhiteTextOnPlanet.measureText(Constants.planets.listOfPlanets.get(Constants.planets.checkStayInCenterOfPlanet).name) - 85, (int)(img_menuLineBlueGradientRight.getHeight()*16/24f), paintWhiteTextOnPlanet);
        g.scale(0.5f, 0.5f);
        Constants.planets.listOfPlanets.get(Constants.planets.checkStayInCenterOfPlanet).drawOnPosition(g, (g.getWidth() - 75)*2, 0);
        g.scale(2, 2);

        g.drawBitmap(img_menuBack, 10*Constants.SZ, 10*Constants.WY, null);
        g.drawText("Back", 32*Constants.SZ, 10*Constants.WY + img_menuBack.getHeight()*16/24f, paintWhiteTextOnPlanet);
        
        g.drawBitmap(img_menuBackSmall,       10*Constants.SZ, Constants.S_H - 10*Constants.WY - img_menuBackSmall.getHeight(), null);
        g.drawBitmap(img_menuBackSmallRight, 120*Constants.SZ, Constants.S_H - 10*Constants.WY - img_menuBackSmallRight.getHeight(), null);
        g.drawText("Prev",  28*Constants.SZ, Constants.S_H - 10*Constants.WY - img_menuBackSmall.getHeight() + img_menuBackSmall.getHeight()*16/24f, paintWhiteTextInHangarPrevNext);
        g.drawText("Next", 125*Constants.SZ, Constants.S_H - 10*Constants.WY - img_menuBackSmall.getHeight() + img_menuBackSmall.getHeight()*16/24f, paintWhiteTextInHangarPrevNext);
  
        drawBorderMenu(g, "Description", 190*Constants.SZ, 130*Constants.WY, 10*(int)(28*Constants.SZ), paintWhiteTextInHangarPrevNext, false);
        
        g.drawText("Description",  200*Constants.SZ, (121*Constants.WY) + img_menuBackSmall.getHeight()*16/24f, paintWhiteTextInHangarPrevNext);
        
        drawTextSmallMenu(g,    "", 200*Constants.SZ, 280*Constants.WY, 5*(int)(30*Constants.SZ), paintWhiteTextInHangar, true, false);
        drawTextSmallMenu(g, "Buy", 350*Constants.SZ, 280*Constants.WY, 5*(int)(24*Constants.SZ), paintWhiteTextInHangar, true, false);
	}
	
    public void drawTextSmallMenu(Canvas g, String text, float x, float y, int width, Paint paint, boolean center, boolean darkness) {
	    g.drawBitmap(img_menuTextBackgroundSmallLeft, x, y, null);
	    for(int i = 0; i < (width - 10)/5; i++) {
	    	g.drawBitmap(img_menuTextBackgroundSmallCenter, x + 5 + 5*i, y, null);
	    }
	    g.drawBitmap(img_menuTextBackgroundSmallRight, x + 5 + (width - 10), y, null);
	    if(center) {
	    	g.drawText(text, x + 5 + ((width - 10) - paint.measureText(text))/2f, y + img_menuTextBackgroundSmallCenter.getHeight()*16/24f , paint);
	    } else {
	    	g.drawText(text, x + 5, y + img_menuTextBackgroundSmallCenter.getHeight()*16/24f , paint);
	    }
	    if(darkness) {
	    	g.drawRect(x + 5, y + 4, x + width - 5, y - 5 + img_menuTextBackgroundSmallLeft.getHeight(), paintDarkness);
	    }
	}
	
    public void drawBorderMenu(Canvas g, String text, float x, float y, int width, Paint paint, boolean center) {
	    g.drawBitmap(img_menuTextBackgroundFrameLeft, x, y, null);
	    for(int i = 0; i < (width - 20)/10; i++) {
	    	g.drawBitmap(img_menuTextBackgroundFrameCenter, x + 10 + 10*i, y, null);
	    }
	    g.drawBitmap(img_menuTextBackgroundFrameRight, x + 10 + (width - 20), y, null);
	}

}
