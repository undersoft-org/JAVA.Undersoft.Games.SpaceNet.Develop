package com.example.spacenetdemo.marketsellscreen;

import java.util.ArrayList;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.BitmapFactory.Options;

import com.example.spacenetdemo.Constants;
import com.example.spacenetdemo.R;
import com.example.spacenetdemo.abstractclass.ButtonBounds;
import com.example.spacenetdemo.abstractclass.Screen;

public class MarketSellScreen extends Screen {
	private Bitmap img_Background = null;
	private Bitmap img_menuLineBlueGradientRight;
	private Bitmap img_menuBack = null;
	private Bitmap img_menuBackSmall = null;
	private Bitmap img_menuBackSmallRight = null;
	
	private Bitmap img_crystal0 = null;
	private Bitmap img_crystal1 = null;
	private Bitmap img_crystal2 = null;
	
	private Bitmap img_menuTextBackgroundLeft = null;
	private Bitmap img_menuTextBackgroundCenter = null;
	private Bitmap img_menuTextBackgroundRight = null;
	
	Paint paintWhiteText = null;
	Paint paintWhiteTextOnPlanet = null;
	Paint paintMinusPlus = null;
	Paint paintWhiteTextCount = null;
	
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
	Paint paintDarkness = null;
	
	public int activeSellBuyCrystalButton = 0;
	public int pricesOfCrystals[] = {2,4,5,3,5,7};
	
	public int formCountOfCrystals[] = {0,0,0};
	public int formCostOfCrystals[] = {0,0,0};
	
	public boolean drawConfirmWindow = false; 
	
	public MinusPlusButtonBounds bm0 = null; 
	public MinusPlusButtonBounds bm1 = null; 
	public MinusPlusButtonBounds bm2 = null; 
	public MinusPlusButtonBounds bp0 = null; 
	public MinusPlusButtonBounds bp1 = null; 
	public MinusPlusButtonBounds bp2 = null;
	public AcceptButtonBounds bab = null;
	
	public ArrayList<ButtonBounds> buttons = new ArrayList<ButtonBounds>();
	 
	@Override
	public void prepare() {
    	Options bitmapOptions = new Options();
    	bitmapOptions.inScaled = false;

		img_Background = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.menu65, bitmapOptions);
		img_Background = Bitmap.createScaledBitmap(img_Background,  Constants.S_W, Constants.S_H, false);

		img_menuLineBlueGradientRight = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.linia_blue_gradient_prawo150x1, bitmapOptions);
    	img_menuLineBlueGradientRight = Bitmap.createScaledBitmap(img_menuLineBlueGradientRight, (int)(img_menuLineBlueGradientRight.getWidth()*Constants.SZ*2), (int)(75*320f/320f), false);

    	img_menuBack = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.menu9back65, bitmapOptions);
    	img_menuBack = Bitmap.createScaledBitmap(img_menuBack, (int)(img_menuBack.getWidth()*Constants.SZ*3/4), (int)(img_menuBack.getHeight()*Constants.WY*2/3), false);
 
    	img_menuBackSmall = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.menu9back35, bitmapOptions);
    	img_menuBackSmall = Bitmap.createScaledBitmap(img_menuBackSmall, (int)(img_menuBackSmall.getWidth()*Constants.SZ/2), (int)(img_menuBackSmall.getHeight()*Constants.WY), false);
    	img_menuBackSmallRight = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.menu9back35prawo, bitmapOptions);
    	img_menuBackSmallRight = Bitmap.createScaledBitmap(img_menuBackSmallRight, (int)(img_menuBackSmallRight.getWidth()*Constants.SZ/2), (int)(img_menuBackSmallRight.getHeight()*Constants.WY), false);

    	img_crystal0 = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.krysztal10a35, bitmapOptions);
    	img_crystal0 = Bitmap.createScaledBitmap(img_crystal0, (int)(img_crystal0.getWidth()*Constants.SZ), (int)(img_crystal0.getHeight()*Constants.WY), false);
    	img_crystal1 = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.krysztal11a35, bitmapOptions);
    	img_crystal1 = Bitmap.createScaledBitmap(img_crystal1, (int)(img_crystal1.getWidth()*Constants.SZ), (int)(img_crystal1.getHeight()*Constants.WY), false);
    	img_crystal2 = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.krysztal12a35, bitmapOptions);
    	img_crystal2 = Bitmap.createScaledBitmap(img_crystal2, (int)(img_crystal2.getWidth()*Constants.SZ), (int)(img_crystal2.getHeight()*Constants.WY), false);

    	img_menuTextBackgroundLeft = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.menu1_tlo_lewy, bitmapOptions);
    	img_menuTextBackgroundLeft = Bitmap.createScaledBitmap(img_menuTextBackgroundLeft, img_menuTextBackgroundLeft.getWidth(), (int)(img_menuTextBackgroundLeft.getHeight()*3*Constants.WY), false);
    	img_menuTextBackgroundCenter = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.menu1_tlo_srodek, bitmapOptions);
    	img_menuTextBackgroundCenter = Bitmap.createScaledBitmap(img_menuTextBackgroundCenter, img_menuTextBackgroundCenter.getWidth(), (int)(img_menuTextBackgroundCenter.getHeight()*3*Constants.WY), false);
    	img_menuTextBackgroundRight = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.menu1_tlo_prawy, bitmapOptions);
    	img_menuTextBackgroundRight = Bitmap.createScaledBitmap(img_menuTextBackgroundRight, img_menuTextBackgroundRight.getWidth(), (int)(img_menuTextBackgroundRight.getHeight()*3*Constants.WY), false);

	    font = Typeface.create(Typeface.MONOSPACE, Typeface.NORMAL);
        paintWhiteText = new Paint();
        paintWhiteText.setColor(Color.WHITE);
	    paintWhiteText.setTypeface(font);
	    //paintWhiteText.setFakeBoldText(true);
	    paintWhiteText.setTextSize(25*Constants.WY);
	    paintWhiteText.setTextSkewX(-0.2f);
	    paintWhiteText.setAntiAlias(true);
	    
	    paintWhiteTextOnPlanet = new Paint(paintWhiteText); 
	    paintWhiteTextOnPlanet.setTextSize(40*Constants.WY);
	    
	    paintMinusPlus = new Paint(paintWhiteText);
	    paintMinusPlus.setTextSize(44*Constants.WY);
	    paintMinusPlus.setTextSkewX(0);
	    
	    paintWhiteTextCount = new Paint(paintMinusPlus);
	    paintWhiteTextCount.setTextSize(35*Constants.WY);
	    
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
		
        paintDarkness = new Paint();
        paintDarkness.setAntiAlias(true);
        paintDarkness.setARGB(150,0,0,0);
        
		Constants.buttons.clear();
		BackButtonBounds bba = new BackButtonBounds(android.view.MotionEvent.ACTION_DOWN, 10*Constants.SZ, 10*Constants.WY, 10*Constants.SZ + img_menuBack.getWidth(), 10*Constants.WY + img_menuBack.getHeight());
		Constants.buttons.add(bba);
		
		buttons.clear();
		bm0 = new MinusPlusButtonBounds(this, false, 0, android.view.MotionEvent.ACTION_DOWN, 130*Constants.SZ, 85*Constants.WY, 130*Constants.SZ + img_menuBackSmall.getWidth()*2, 85*Constants.WY + img_menuBackSmall.getHeight()); 
		buttons.add(bm0);
		bm1 = new MinusPlusButtonBounds(this, false, 1, android.view.MotionEvent.ACTION_DOWN, 130*Constants.SZ, 135*Constants.WY, 130*Constants.SZ + img_menuBackSmall.getWidth()*2, 135*Constants.WY + img_menuBackSmall.getHeight()); 
		buttons.add(bm1);
		bm2 = new MinusPlusButtonBounds(this, false, 2, android.view.MotionEvent.ACTION_DOWN, 130*Constants.SZ, 190*Constants.WY, 130*Constants.SZ + img_menuBackSmall.getWidth()*2, 190*Constants.WY + img_menuBackSmall.getHeight()); 
		buttons.add(bm2);
		bp0 = new MinusPlusButtonBounds(this, true, 0, android.view.MotionEvent.ACTION_DOWN, 280*Constants.SZ, 85*Constants.WY, 280*Constants.SZ + img_menuBackSmallRight.getWidth()*2, 85*Constants.WY + img_menuBackSmallRight.getHeight()); 
		buttons.add(bp0);
		bp1 = new MinusPlusButtonBounds(this, true, 1, android.view.MotionEvent.ACTION_DOWN, 280*Constants.SZ, 135*Constants.WY, 280*Constants.SZ + img_menuBackSmallRight.getWidth()*2, 135*Constants.WY + img_menuBackSmallRight.getHeight()); 
		buttons.add(bp1);
		bp2 = new MinusPlusButtonBounds(this, true, 2, android.view.MotionEvent.ACTION_DOWN, 280*Constants.SZ, 190*Constants.WY, 280*Constants.SZ + img_menuBackSmallRight.getWidth()*2, 190*Constants.WY + img_menuBackSmallRight.getHeight()); 
		buttons.add(bp2);
		bab = new AcceptButtonBounds(this, android.view.MotionEvent.ACTION_DOWN, 360*Constants.SZ,  230*Constants.WY, 475*Constants.SZ, 320*Constants.WY);
		buttons.add(bab);
	}

	@Override
	public void update() {
		if(drawConfirmWindow) {
			int len = Constants.touchEvents.size();
			for(int j = 0; j < len; j++) {
				if(Constants.touchEvents.get(j).action == android.view.MotionEvent.ACTION_DOWN) {
					if(Constants.touchEvents.get(j).x > Constants.S_W/2	) {
						//System.out.println("YES");
						Constants.user.gatheredCrystals[0] -= formCountOfCrystals[0]; 
						Constants.user.gatheredCrystals[1] -= formCountOfCrystals[1];
						Constants.user.gatheredCrystals[2] -= formCountOfCrystals[2];
						Constants.user.money += formCostOfCrystals[0];
						Constants.user.money += formCostOfCrystals[1];
						Constants.user.money += formCostOfCrystals[2];
						formCountOfCrystals[0] = 0;
						formCountOfCrystals[1] = 0;
						formCountOfCrystals[2] = 0;
						countCrystalsForm();
					} else {
						//System.out.println("NO");
					}
					disableConfirmWindow();
				}
			}
		} else {
	    	int len = Constants.touchEvents.size();
	    	ButtonBounds buttonBounds;
			for(int i = 0; i < buttons.size(); i++) {
				for(int j = 0; j < len; j++) {
					buttonBounds = buttons.get(i);
					if(buttonBounds.actionInBounds(Constants.touchEvents.get(j))) {
						buttonBounds.doAction();
						//System.out.println("+++++++++++");
						j = 1000;
						i = 1000;
						break;
					}
				}
			}
		}
	}

	public void countCrystalsForm() {
        for(int i = 0; i < 3; i++) {
        	formCostOfCrystals[i] = pricesOfCrystals[i]*formCountOfCrystals[i];
        }
	}
	
	@Override
	public void draw(Canvas g) {
        g.drawBitmap(img_Background, 0, 0, null);

        g.drawBitmap(img_menuLineBlueGradientRight, g.getWidth() - img_menuLineBlueGradientRight.getWidth(), 0, null);
//        Constants.planets.listOfPlanets.get(Constants.planets.checkStayInCenterOfPlanet).drawNameOnPosition(g, g.getWidth() - (int)paintWhiteTextOnPlanet.measureText(Constants.planets.listOfPlanets.get(Constants.planets.checkStayInCenterOfPlanet).name) - 85, (int)(img_menuLineBlueGradientRight.getHeight()*16/24f), paintWhiteTextOnPlanet);
        g.drawText("$"+ Constants.user.money, g.getWidth() - (int)paintWhiteTextOnPlanet.measureText("$"+ Constants.user.money) - 10, (int)(img_menuLineBlueGradientRight.getHeight()*16/24f), paintWhiteTextOnPlanet);
        g.drawText("SELL",(Constants.S_W - paintWhiteTextOnPlanet.measureText("SELL"))/2, 50*Constants.WY, paintWhiteTextOnPlanet); 
        g.scale(0.5f, 0.5f);
//        Constants.planets.listOfPlanets.get(Constants.planets.checkStayInCenterOfPlanet).drawOnPosition(g, (g.getWidth() - 75)*2, 0);
        g.scale(2, 2);

        g.drawRect(5*Constants.SZ,  80*Constants.WY, 120*Constants.SZ, 230*Constants.WY, paintYellowAlpha);
        g.drawRect(120*Constants.SZ,  80*Constants.WY, 360*Constants.SZ, 230*Constants.WY, paintCenter);
        g.drawRect(360*Constants.SZ,  80*Constants.WY, 475*Constants.SZ, 230*Constants.WY, paintBlueAlpha);
        g.drawRect(360*Constants.SZ,  230*Constants.WY, 475*Constants.SZ, 320*Constants.WY, paintBlue);
        //--------left side
        g.drawBitmap(img_crystal0, 20*Constants.SZ, 100*Constants.WY - img_crystal0.getHeight()/2, null);
        g.drawBitmap(img_crystal1, 20*Constants.SZ, 155*Constants.WY - img_crystal0.getHeight()/2, null);
        g.drawBitmap(img_crystal2, 20*Constants.SZ, 205*Constants.WY - img_crystal0.getHeight()/2, null);
        
        String price0 = new String("$" + pricesOfCrystals[0]);
        drawPriceOnPosition(g, price0, 45*Constants.SZ + 50*Constants.SZ - paintWhiteText.measureText(price0)/2f, 87*Constants.WY + paintWhiteText.getTextSize()*21/24f, paintWhiteText);        
        String price1 = new String("$" + pricesOfCrystals[1]);
        drawPriceOnPosition(g, price1, 45*Constants.SZ + 50*Constants.SZ - paintWhiteText.measureText(price1)/2f, 135*Constants.WY + paintWhiteText.getTextSize()*21/24f, paintWhiteText);        
        String price2 = new String("$" + pricesOfCrystals[2]);
        drawPriceOnPosition(g, price2, 45*Constants.SZ + 50*Constants.SZ - paintWhiteText.measureText(price2)/2f, 190*Constants.WY + paintWhiteText.getTextSize()*21/24f, paintWhiteText);        
        //center
        g.drawBitmap(img_menuBackSmall, 130*Constants.SZ, 85*Constants.WY, null);
        g.drawBitmap(img_menuBackSmall, 130*Constants.SZ, 135*Constants.WY, null);
        g.drawBitmap(img_menuBackSmall, 130*Constants.SZ, 190*Constants.WY, null);
        
        g.drawBitmap(img_menuBackSmallRight, 317*Constants.SZ, 85*Constants.WY, null);
        g.drawBitmap(img_menuBackSmallRight, 317*Constants.SZ, 135*Constants.WY, null);
        g.drawBitmap(img_menuBackSmallRight, 317*Constants.SZ, 190*Constants.WY, null);
        
        g.drawText("-", 136*Constants.SZ, 115*Constants.WY, paintMinusPlus);
        g.drawText("-", 136*Constants.SZ, 165*Constants.WY, paintMinusPlus);
        g.drawText("-", 136*Constants.SZ, 220*Constants.WY, paintMinusPlus);
        
        g.drawText("+", 318*Constants.SZ, 118*Constants.WY, paintMinusPlus);
        g.drawText("+", 318*Constants.SZ, 168*Constants.WY, paintMinusPlus);
        g.drawText("+", 318*Constants.SZ, 223*Constants.WY, paintMinusPlus);
        
        g.drawText("" + formCountOfCrystals[0] + " (" + Constants.user.gatheredCrystals[0] + ")", 240*Constants.SZ - paintWhiteTextCount.measureText("" + formCountOfCrystals[0] + " (" + Constants.user.gatheredCrystals[2] + ")")/2, 114*Constants.WY, paintWhiteTextCount);
        g.drawText("" + formCountOfCrystals[1] + " (" + Constants.user.gatheredCrystals[1] + ")", 240*Constants.SZ - paintWhiteTextCount.measureText("" + formCountOfCrystals[1] + " (" + Constants.user.gatheredCrystals[2] + ")")/2, 164*Constants.WY, paintWhiteTextCount);
        g.drawText("" + formCountOfCrystals[2] + " (" + Constants.user.gatheredCrystals[2] + ")", 240*Constants.SZ - paintWhiteTextCount.measureText("" + formCountOfCrystals[2] + " (" + Constants.user.gatheredCrystals[2] + ")")/2, 219*Constants.WY, paintWhiteTextCount);
        
        g.drawText("$" + formCostOfCrystals[0], 465*Constants.SZ - paintWhiteTextCount.measureText("$" + formCostOfCrystals[0]), 114*Constants.WY, paintWhiteTextCount);
        g.drawText("$" + formCostOfCrystals[1], 465*Constants.SZ - paintWhiteTextCount.measureText("$" + formCostOfCrystals[1]), 164*Constants.WY, paintWhiteTextCount);
        g.drawText("$" + formCostOfCrystals[2], 465*Constants.SZ - paintWhiteTextCount.measureText("$" + formCostOfCrystals[2]), 219*Constants.WY, paintWhiteTextCount);

        int temporarySum = 0;
        for(int i = 0; i < 3; i++) {
        	temporarySum += formCostOfCrystals[i];
        }
        g.drawText("$" + temporarySum, 465*Constants.SZ - paintWhiteTextCount.measureText("$" + temporarySum), 267*Constants.WY, paintWhiteTextCount);
        g.drawText("ACCEPT", 417*Constants.SZ - paintWhiteText.measureText("ACCEPT")/2, 300*Constants.WY, paintWhiteText);
        
        if(temporarySum == 0) {
        	g.drawRect(360*Constants.SZ,  230*Constants.WY, 475*Constants.SZ, 320*Constants.WY, paintDarkness);
        	bab.setActive(false);
        } else if(!drawConfirmWindow) {
        	bab.setActive(true);
        }
        
        if(drawConfirmWindow) {
        	g.drawRect(0, 0, Constants.S_W, Constants.S_H, paintDarkness);
        	drawTextMenu(g, 110*Constants.SZ, 70*Constants.WY, 10*(int)(26*Constants.SZ) );
        }
        
        g.drawBitmap(img_menuBack, 10*Constants.SZ, 10*Constants.WY, null);
        g.drawText("Back", 32*Constants.SZ, 10*Constants.WY + img_menuBack.getHeight()*16/24f, paintWhiteText);
        
    	for(int i = 0; i < buttons.size(); i++) {
    		//buttons.get(i).draw(g);
    	}        
	}
	
	public void drawPriceOnPosition(Canvas g, String text, float x, float y, Paint paint) {
		g.drawText(text, x, y, paint);
	}
	
    public void drawTextMenu(Canvas g, float x, float y, int width) {
	    g.drawBitmap(img_menuTextBackgroundLeft, x, y, null);
	    for(int i = 0; i < (width - 20)/10; i++) {
	    	g.drawBitmap(img_menuTextBackgroundCenter, x + 10 + 10*i, y, null);
	    }
	    g.drawBitmap(img_menuTextBackgroundRight, x + 10 + (width - 20), y, null);
	    
    	g.drawText("Do you want", x + 10 + ((width - 20) - paintWhiteTextCount.measureText("Do you want"))/2f, y + 60*Constants.WY, paintWhiteTextCount);
    	g.drawText("to sell ?", x + 10 + ((width - 20) - paintWhiteTextCount.measureText("to buy ?"))/2f, y + 100*Constants.WY , paintWhiteTextCount);
    	
    	g.drawText("NO   YES", x + 10 + ((width - 20) - paintMinusPlus.measureText("NO   YES"))/2f, y + 160*Constants.WY , paintMinusPlus);
	}

    public void enableConfirmWindow() {
    	drawConfirmWindow = true;
    	bm0.setActive(false);
    	bm1.setActive(false);
    	bm2.setActive(false);
    	bp0.setActive(false);
    	bp1.setActive(false);
    	bp2.setActive(false);
    	bab.setActive(false);
    }

    public void disableConfirmWindow() {
    	drawConfirmWindow = false;
    	bm0.setActive(true);
    	bm1.setActive(true);
    	bm2.setActive(true);
    	bp0.setActive(true);
    	bp1.setActive(true);
    	bp2.setActive(true);
    	bab.setActive(true);
    }
}
