package com.example.spacenetdemo.startscreen;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.BitmapFactory.Options;

import com.example.spacenetdemo.Constants;
import com.example.spacenetdemo.R;
import com.example.spacenetdemo.abstractclass.Screen;
import com.example.spacenetdemo.common.User;

public class StartScreen extends Screen {
	private Bitmap img_Background = null;
	private Bitmap img_Start = null;
	
	@Override
	public void prepare() {
    	Options bitmapOptions = new Options();
    	bitmapOptions.inScaled = false;

		img_Background = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.start1c, bitmapOptions);
		img_Background = Bitmap.createScaledBitmap(img_Background,  Constants.S_W, Constants.S_H, false);

		img_Start = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.start1d, bitmapOptions);
		img_Start = Bitmap.createScaledBitmap(img_Start,  Constants.S_W, Constants.S_H, false);
		
		Constants.user = new User();
		Constants.user.positionJetInSpaceX = Constants.positionJetOnTheScreenX/3 - 50;
		Constants.user.positionJetInSpaceY = Constants.positionJetOnTheScreenY/3 - 50;
		
        //on blackhole                              
        //oldPositionBitmapX = Constants.positionJetOnTheScreenX/3 - 15;
        //oldPositionBitmapY = Constants.positionJetOnTheScreenY/3 - 250;
        //on antares
        //oldPositionBitmapX = Constants.positionJetOnTheScreenX/3 - 50;
        //oldPositionBitmapY = Constants.positionJetOnTheScreenY/3 - 50;

		Constants.buttons.clear();
		StartButtonBounds b = new StartButtonBounds(android.view.MotionEvent.ACTION_DOWN, 0f, 0f, 300f*Constants.SZ, 130f*Constants.WY);
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
        g.drawBitmap(img_Start, 0, 0, null);
        //g.drawBitmap(img_Background, 0, -Constants.S_W, null);
        //g.drawBitmap(img_Start, 0, -Constants.S_W, null);
	}
	
}
