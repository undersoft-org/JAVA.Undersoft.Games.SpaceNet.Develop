package com.example.spacenetdemo.common;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

public class Planet {

	float area[] = new float[4];
	int type = 0; 
	float scale = 1;
	Bitmap bitmapBasic = null;
	Bitmap bitmapSymbol = null;
	public String name = "";
	Typeface font;
	Paint paintWhiteText = null;
	
	Planet() {
		area[0] = 0;
		area[1] = 0;
		area[2] = 0;
		area[3] = 0;	
	}
	
	Planet(float left, float top, Bitmap lBitmapBasic, Bitmap lBitmapSymbol, float lScale, int lType, String lName) {
		area[0] = left;
		area[1] = top;
		area[2] = left + lBitmapBasic.getWidth();
		area[3] = top + lBitmapBasic.getHeight();
		bitmapBasic = lBitmapBasic;
		bitmapSymbol = lBitmapSymbol;
		type = lType;
		scale = lScale;
		name = lName;
		
		paintWhiteText = new Paint();
		paintWhiteText.setColor(Color.WHITE);
        font = Typeface.create(Typeface.MONOSPACE, Typeface.NORMAL); 
        paintWhiteText.setTypeface(font);
        paintWhiteText.setTextSize(200);
        paintWhiteText.setTextSkewX(-0.2f);
        paintWhiteText.setAntiAlias(true);

	}
	
	public boolean contains(float x, float y) {
		boolean contains = false;
		if(x > (area[0] - (area[2] - area[0])/2f) && x < (area[0] + (area[2] - area[0])/2f) && y > (area[1] - (area[3] - area[1])/2f) && y < (area[1] + (area[3] - area[1])/2f)) {
			contains = true;
		}
		return contains;
	}

	public boolean containsInCenter(float x, float y, float radius) {
		boolean contains = false;
		if(Math.abs(x - area[0]) < radius && Math.abs(y - area[1]) < radius) {
			contains = true;
		}
		return contains;
	}

	public void update() {
		
	}
	
    public void draw(Canvas g) {
    	//center of bitmpap on (area[0]*scale, area[1]*scale)
		if(bitmapBasic != null) {
	        g.drawBitmap(bitmapBasic,  (area[0]   - bitmapBasic.getWidth()/(2*scale))*scale, (area[1]  - bitmapBasic.getHeight()/(2*scale))*scale, null);
	        g.drawBitmap(bitmapSymbol, (area[0]  - bitmapSymbol.getWidth()/(2*scale))*scale, (area[1] - bitmapSymbol.getHeight()/(2*scale))*scale, null);
		}
    }
    
    public void drawOnMap(Canvas g, int left, int top, int przesMapy, boolean drawTitle) {
		if(bitmapBasic != null) {
	        g.drawBitmap(bitmapBasic, left + przesMapy + area[0] - bitmapBasic.getWidth()/2, top + przesMapy + area[1] - bitmapBasic.getHeight()/2, null);
	        if(drawTitle) {
	        	g.drawText(name, left + przesMapy + area[0] - 2*bitmapBasic.getWidth(), top + przesMapy + area[1] - bitmapBasic.getHeight(), paintWhiteText);
	        }
		}
    }
    
    public void drawLanding(Canvas g) {
    	//center of bitmpap on (area[0]*scale, area[1]*scale)
		if(bitmapBasic != null) {
	        g.drawBitmap(bitmapBasic,  (0   - bitmapBasic.getWidth()/2), (0  - bitmapBasic.getHeight()/2), null);
		}
		if(bitmapSymbol != null) {
	        g.drawBitmap(bitmapSymbol, (0  - bitmapSymbol.getWidth()/2), (0 - bitmapSymbol.getHeight()/2), null);
		}
    }

    public void drawOnPosition(Canvas g, int x, int y) {
		if(bitmapBasic != null) {
	        g.drawBitmap(bitmapBasic, x, y, null);
		}
		if(bitmapSymbol != null) {
	        g.drawBitmap(bitmapSymbol, x + (bitmapBasic.getWidth() - bitmapSymbol.getWidth())/2, y + (bitmapBasic.getHeight() - bitmapSymbol.getHeight())/2, null);
		}
    }

    public void drawNameOnPosition(Canvas g, int x, int y, Paint paint) {
    	g.drawText(name, x, y, paint);
    }
}
