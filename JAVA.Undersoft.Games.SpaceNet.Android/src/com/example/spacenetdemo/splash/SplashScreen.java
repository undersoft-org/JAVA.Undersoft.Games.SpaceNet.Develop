package com.example.spacenetdemo.splash;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.BitmapFactory.Options;

import com.example.spacenetdemo.Constants;
import com.example.spacenetdemo.R;
import com.example.spacenetdemo.abstractclass.Screen;

public class SplashScreen extends Screen {
	private Bitmap img_Background = null;
	
	@Override
	public void prepare() {
    	Options bitmapOptions = new Options();
    	bitmapOptions.inScaled = false;
		img_Background = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.start2b, bitmapOptions);
		img_Background = Bitmap.createScaledBitmap(img_Background,  Constants.S_W, Constants.S_H, false);
		
		Constants.buttons.clear();
		SplashButtonBounds b = new SplashButtonBounds(android.view.MotionEvent.ACTION_DOWN, 0f, 0f, Constants.S_W, Constants.S_H);
		Constants.buttons.add(b);
	}

	@Override
	public void update() {
	}

	@Override
	public void draw(Canvas g) {
        //g.setMatrix(null);
        //g.rotate(90);
        g.drawBitmap(img_Background, 0, 0, null);
        //g.drawBitmap(img_Background, 0, -Constants.S_W, null);
	}
	
}
