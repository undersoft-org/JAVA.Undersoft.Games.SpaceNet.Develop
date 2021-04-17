package com.example.spacenetdemo.misionsscreen;

//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.BitmapFactory.Options;

import com.example.spacenetdemo.Constants;
//import com.example.spacenetdemo.R;
import com.example.spacenetdemo.abstractclass.Screen;

public class MissionsScreen extends Screen {
	//private Bitmap img_Background = null;
	//private Bitmap img_Start = null;
	
	@Override
	public void prepare() {
    	Options bitmapOptions = new Options();
    	bitmapOptions.inScaled = false;

		Constants.buttons.clear();
		BackButtonBounds b = new BackButtonBounds(android.view.MotionEvent.ACTION_DOWN, 0f, 0f, Constants.S_W, Constants.S_H);
		Constants.buttons.add(b);
	}

	@Override
	public void update() {
	}

	@Override
	public void draw(Canvas g) {
		g.drawColor(Color.BLACK);
	}
	
}
