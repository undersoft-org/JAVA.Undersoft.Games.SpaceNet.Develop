package com.example.spacenetdemo.common;

import com.example.spacenetdemo.R;
import com.example.spacenetdemo.Constants;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;

public class User {
	public float positionJetInSpaceX = 0;
	public float positionJetInSpaceY = 0;
	public int money = 100;
	//green, brown, blue
    public int gatheredCrystals[] = {2,13,15};
    public int jet = 0;
    public Bitmap jetBitmap = getJetBitmap(0);
    public Bitmap jetBigBitmap = getJetBigBitmap(0);
    public static final int MAX_NUMBER_OF_SHIPS = 2;
    
	public User() {
			
	}
	
	public User(float posX, float posY, int lMoney,
			int crystalsGreen, int crystalsBrown, int crystalsBlue, int lJet) {
		positionJetInSpaceX = posX;
		positionJetInSpaceY = posY;
		money = lMoney;
		gatheredCrystals[0] = crystalsGreen;
		gatheredCrystals[1] = crystalsBrown;
		gatheredCrystals[2] = crystalsBlue;
		jet = lJet;
	}
	
//	public void changeJet(int newJet) {
//		if(newJet > 2) {
//			jet = 2;
//		} else if(jet < 0) {
//			jet = 0;
//		} else {
//			jet = newJet;
//		}
//    	Options bitmapOptions = new Options();
//    	bitmapOptions.inScaled = false;
//    	
//		switch(jet) {
//			case 0:
//				jetBitmap = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.spaceship5a35, bitmapOptions);
//				jetBitmap = Bitmap.createScaledBitmap(jetBitmap, (int)(jetBitmap.getWidth()*Constants.SZ), (int)(jetBitmap.getHeight()*Constants.WY), false);
//				jetBigBitmap = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.spaceship5a64x100, bitmapOptions);
//				jetBigBitmap = Bitmap.createScaledBitmap(jetBigBitmap, (int)(jetBigBitmap.getWidth()*Constants.SZ), (int)(jetBigBitmap.getHeight()*Constants.WY), false);
//				break;
//			case 1:
//				jetBitmap = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.spaceship1b, bitmapOptions);
//				jetBitmap = Bitmap.createScaledBitmap(jetBitmap, (int)(jetBitmap.getWidth()*Constants.SZ), (int)(jetBitmap.getHeight()*Constants.WY), false);
//				jetBigBitmap = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.spaceship1a100, bitmapOptions);
//				jetBigBitmap = Bitmap.createScaledBitmap(jetBigBitmap, (int)(jetBigBitmap.getWidth()*Constants.SZ), (int)(jetBigBitmap.getHeight()*Constants.WY), false);
//				break;
//			case 2:
//				jetBitmap = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.spaceship2a32, bitmapOptions);
//				jetBitmap = Bitmap.createScaledBitmap(jetBitmap, (int)(jetBitmap.getWidth()*Constants.SZ), (int)(jetBitmap.getHeight()*Constants.WY), false);
//				jetBigBitmap = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.spaceship2a100, bitmapOptions);
//				jetBigBitmap = Bitmap.createScaledBitmap(jetBigBitmap, (int)(jetBigBitmap.getWidth()*Constants.SZ), (int)(jetBigBitmap.getHeight()*Constants.WY), false);
//				break;
//		}
//	}
	
	public Bitmap getJetBitmap(int newJet) {
		int jetNumber = newJet;
		Bitmap newJetBitmap = null;
		
		if(jetNumber > MAX_NUMBER_OF_SHIPS) {
			jetNumber = MAX_NUMBER_OF_SHIPS;
		} else if(jetNumber < 0) {
			jetNumber = 0;
		}
    	Options bitmapOptions = new Options();
    	bitmapOptions.inScaled = false;
    	
		switch(jetNumber) {
			case 0:
				newJetBitmap = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.spaceship5a35, bitmapOptions);
				newJetBitmap = Bitmap.createScaledBitmap(newJetBitmap, (int)(newJetBitmap.getWidth()*Constants.SZ), (int)(newJetBitmap.getHeight()*Constants.WY), false);
				break;
			case 1:
				newJetBitmap = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.spaceship1b, bitmapOptions);
				newJetBitmap = Bitmap.createScaledBitmap(newJetBitmap, (int)(newJetBitmap.getWidth()*Constants.SZ), (int)(newJetBitmap.getHeight()*Constants.WY), false);
				break;
			case 2:
				newJetBitmap = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.spaceship2a32, bitmapOptions);
				newJetBitmap = Bitmap.createScaledBitmap(newJetBitmap, (int)(newJetBitmap.getWidth()*Constants.SZ), (int)(newJetBitmap.getHeight()*Constants.WY), false);
				break;
		}
		return newJetBitmap;
	}
	
	public Bitmap getJetBigBitmap(int newJet) {
		int jetNumber = newJet;
		Bitmap newJetBigBitmap = null;
		
		if(jetNumber > MAX_NUMBER_OF_SHIPS) {
			jetNumber = MAX_NUMBER_OF_SHIPS;
		} else if(jetNumber < 0) {
			jetNumber = 0;
		}
    	Options bitmapOptions = new Options();
    	bitmapOptions.inScaled = false;
    	
		switch(jetNumber) {
			case 0:
				newJetBigBitmap = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.spaceship5a64x100, bitmapOptions);
				newJetBigBitmap = Bitmap.createScaledBitmap(newJetBigBitmap, (int)(newJetBigBitmap.getWidth()*Constants.SZ), (int)(newJetBigBitmap.getHeight()*Constants.WY), false);
				break;
			case 1:
				newJetBigBitmap = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.spaceship1a100, bitmapOptions);
				newJetBigBitmap = Bitmap.createScaledBitmap(newJetBigBitmap, (int)(newJetBigBitmap.getWidth()*Constants.SZ), (int)(newJetBigBitmap.getHeight()*Constants.WY), false);
				break;
			case 2:
				newJetBigBitmap = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.spaceship2a100, bitmapOptions);
				newJetBigBitmap = Bitmap.createScaledBitmap(newJetBigBitmap, (int)(newJetBigBitmap.getWidth()*Constants.SZ), (int)(newJetBigBitmap.getHeight()*Constants.WY), false);
				break;
		}
		return newJetBigBitmap;
	}

}

