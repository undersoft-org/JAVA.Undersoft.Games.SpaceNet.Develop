package com.example.spacenetdemo.common;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class ObjectToShoot {
	
	public static final int TYPE_CRYSTAL_GREEN = 0;
	public static final int TYPE_CRYSTAL_BROWN = 1;
	public static final int TYPE_CRYSTAL_BLUE = 2;
	int type = TYPE_CRYSTAL_GREEN;
	
	//Left Top Right Bottom 
	float area[] = new float[4];
	
	Bitmap bitmapBasic = null;
	
	Bitmap bitmapSecondPhase = null;
	int phase = 1;
	boolean secondPhaseEnabled = false;
	float speedX = (float)(Math.random()*4 - 2);
	float speedY = (float)(Math.random()*4 - 2);
	float maxMove = 200;
	float actualMoveSum = 0;
	boolean deleteMe = false;
	
	ObjectToShoot() {
		area[0] = 0;
		area[1] = 0;
		area[2] = 0;
		area[3] = 0;
	}
	
	ObjectToShoot(float left, float top, float right, float bottom, int lType) {
		area[0] = left;
		area[1] = top;
		area[2] = right;
		area[3] = bottom;
		type = lType;
	}

	ObjectToShoot(float left, float top, Bitmap lBitmap, int lType) {
		area[0] = left;
		area[1] = top;
		area[2] = left + lBitmap.getWidth();
		area[3] = top + lBitmap.getHeight();
		bitmapBasic = lBitmap;
		type = lType;
	}
	
	ObjectToShoot(float left, float top, Bitmap lBitmapBasic, Bitmap lBitmapSecondPhase, int lType) {
		area[0] = left;
		area[1] = top;
		area[2] = left + lBitmapBasic.getWidth();
		area[3] = top + lBitmapBasic.getHeight();
		bitmapBasic = lBitmapBasic;
		bitmapSecondPhase = lBitmapSecondPhase;
		type = lType;
		secondPhaseEnabled = true; 
	}
	
	public boolean contains(float x, float y) {
		boolean contains = false;
		if(x > area[0] && x < area[2] && y > area[1] && y < area[3]) {
			contains = true;
		}
		return contains;
	}

	public boolean contains(float x, float y, int lType) {
		boolean contains = false;
		if(x > area[0] && x < area[2] && y > area[1] && y < area[3] && type == lType) {
			contains = true;
		}
		return contains;
	}

	public void changePhaseTo2() {
		area[2] = area[0] + bitmapSecondPhase.getWidth();
		area[3] = area[1] + bitmapSecondPhase.getHeight();
		phase = 2;
	}
	
	public void update() {
		if(type >= TYPE_CRYSTAL_GREEN && type <= TYPE_CRYSTAL_BLUE && phase == 2) {
			if(actualMoveSum < maxMove) {
				area[0] += speedX;
				area[1] += speedY;
				area[2] += speedX;
				area[3] += speedY;
				actualMoveSum += Math.abs(speedX) + Math.abs(speedY);
			} else {
				deleteMe = true;
			}
		} 
	}
	
	public void draw(Canvas g) {
		switch(phase) {
			case 1:
				if(bitmapBasic != null) {
					g.drawBitmap(bitmapBasic, area[0], area[1], null);
				}
				break;
			case 2:
				if(bitmapSecondPhase != null) {
					g.drawBitmap(bitmapSecondPhase, area[0], area[1], null);
				}
				break;
		}
	}	
}
