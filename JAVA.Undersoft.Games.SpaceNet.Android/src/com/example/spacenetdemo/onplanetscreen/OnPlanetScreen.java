package com.example.spacenetdemo.onplanetscreen;

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

public class OnPlanetScreen extends Screen {
	private Bitmap img_Background = null;
	private Bitmap img_Launch = null;
	private Bitmap img_menuLineBlueGradient;
	
	private Bitmap img_menuTextBackgroundLeft;
	private Bitmap img_menuTextBackgroundCenter;
	private Bitmap img_menuTextBackgroundRight;

	Paint paintWhiteText = null;
	Paint paintWhiteTextOnPlanet = null;
	Typeface font;
	Paint paintBlueTextOnPlanet = null;

	@Override
	public void prepare() {
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

        paintBlueTextOnPlanet = new Paint(paintWhiteText);
        paintBlueTextOnPlanet.setColor(Color.BLUE);
        paintBlueTextOnPlanet.setTextSize(40*Constants.WY);

	    Options bitmapOptions = new Options();
    	bitmapOptions.inScaled = false;

		img_Background = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.space_city1, bitmapOptions);
		img_Background = Bitmap.createScaledBitmap(img_Background,  Constants.S_W, Constants.S_H, false);

		img_Launch = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.launch4, bitmapOptions);
		img_Launch = Bitmap.createScaledBitmap(img_Launch, (int)(img_Launch.getWidth()*Constants.SZ), (int)(img_Launch.getHeight()*Constants.WY), false);

    	img_menuLineBlueGradient = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.linia_blue_gradient150x1, bitmapOptions);
    	img_menuLineBlueGradient = Bitmap.createScaledBitmap(img_menuLineBlueGradient, (int)(img_menuLineBlueGradient.getWidth()*Constants.SZ*2), (int)(75*320f/320f), false);

    	img_menuTextBackgroundLeft = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.menu1_tlo_lewy, bitmapOptions);
    	img_menuTextBackgroundLeft = Bitmap.createScaledBitmap(img_menuTextBackgroundLeft, img_menuTextBackgroundLeft.getWidth(), (int)(img_menuTextBackgroundLeft.getHeight()*Constants.WY), false);
    	img_menuTextBackgroundCenter = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.menu1_tlo_srodek, bitmapOptions);
    	img_menuTextBackgroundCenter = Bitmap.createScaledBitmap(img_menuTextBackgroundCenter, img_menuTextBackgroundCenter.getWidth(), (int)(img_menuTextBackgroundCenter.getHeight()*Constants.WY), false);
    	img_menuTextBackgroundRight = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.menu1_tlo_prawy, bitmapOptions);
    	img_menuTextBackgroundRight = Bitmap.createScaledBitmap(img_menuTextBackgroundRight, img_menuTextBackgroundRight.getWidth(), (int)(img_menuTextBackgroundRight.getHeight()*Constants.WY), false);

    	Constants.buttons.clear();
    	//System.out.println("LBB=" + 280*Constants.SZ + " " + 80*Constants.WY + " " + (280*Constants.SZ + img_Launch.getWidth()) + " " + (80*Constants.WY + img_Launch.getHeight()));
		LaunchButtonBounds bla = new LaunchButtonBounds(android.view.MotionEvent.ACTION_DOWN, 280*Constants.SZ, 80*Constants.WY, (280*Constants.SZ + img_Launch.getWidth()), (80*Constants.WY + img_Launch.getHeight()));
		Constants.buttons.add(bla);
		
		MissionsButtonBounds bmi = new MissionsButtonBounds(android.view.MotionEvent.ACTION_DOWN, 30*Constants.SZ, 90*Constants.WY, (30 + 220)*Constants.SZ,  (90*Constants.WY + img_menuTextBackgroundLeft.getHeight()));
		MarketButtonBounds    bma = new MarketButtonBounds(android.view.MotionEvent.ACTION_DOWN, 30*Constants.SZ, 160*Constants.WY, (30 + 220)*Constants.SZ, (160*Constants.WY + img_menuTextBackgroundLeft.getHeight()));
		HangarButtonBounds    bha = new HangarButtonBounds(android.view.MotionEvent.ACTION_DOWN, 30*Constants.SZ, 230*Constants.WY, (30 + 220)*Constants.SZ, (230*Constants.WY + img_menuTextBackgroundLeft.getHeight()));
		Constants.buttons.add(bmi);
		Constants.buttons.add(bma);
		Constants.buttons.add(bha);
	}

	@Override
	public void update() {
	}

	@Override
	public void draw(Canvas g) {
        g.drawBitmap(img_Background, 0, 0, null);
        g.drawBitmap(img_Launch, 280*Constants.SZ, 80*Constants.WY, null);
        
        drawTextMenu(g, "Missions", 30*Constants.SZ, 90*Constants.WY, 10*(int)(22*Constants.SZ), paintWhiteTextOnPlanet, false);
        drawTextMenu(g, "Market", 30*Constants.SZ, 160*Constants.WY, 10*(int)(22*Constants.SZ), paintWhiteTextOnPlanet, false);
        drawTextMenu(g, "Hangar", 30*Constants.SZ, 230*Constants.WY, 10*(int)(22*Constants.SZ), paintWhiteTextOnPlanet, false);
        g.drawText("Launch", 280*Constants.SZ, 210*Constants.WY + img_menuTextBackgroundCenter.getHeight()*16/24f , paintBlueTextOnPlanet);
        
        g.drawBitmap(img_menuLineBlueGradient, 0, 0, null);
        Constants.planets.listOfPlanets.get(Constants.planets.checkStayInCenterOfPlanet).drawNameOnPosition(g, 75, (int)(img_menuLineBlueGradient.getHeight()*16/24f), paintWhiteTextOnPlanet);
        g.scale(0.5f, 0.5f);
        Constants.planets.listOfPlanets.get(Constants.planets.checkStayInCenterOfPlanet).drawOnPosition(g, 0, 0);
        g.scale(2f, 2f);
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
