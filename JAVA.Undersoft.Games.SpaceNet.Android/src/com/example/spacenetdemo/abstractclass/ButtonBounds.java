package com.example.spacenetdemo.abstractclass;

import com.example.spacenetdemo.common.TouchEvent;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public abstract class ButtonBounds {
	float area[] = new float[4];

	Paint paintRed = new Paint();
	int action = android.view.MotionEvent.ACTION_DOWN;
	protected TouchEvent touchEvent;
	
	public ButtonBounds() {
		area[0] = 0;
		area[1] = 0;
		area[2] = 0;
		area[3] = 0;
		paintRed.setColor(Color.RED);
	}
	
	public ButtonBounds(int lAction, float left, float top, float right, float bottom) {
		action = lAction;
		area[0] = left;
		area[1] = top;
		area[2] = right;
		area[3] = bottom;
		paintRed.setColor(Color.RED);
	}

	public void draw(Canvas g) {
		g.drawLine(area[0], area[1], area[2], area[1], paintRed);
		g.drawLine(area[2], area[1], area[2], area[3], paintRed);
		g.drawLine(area[0], area[1], area[0], area[3], paintRed);
		g.drawLine(area[0], area[3], area[2], area[3], paintRed);
	}
	
	public boolean inBounds(float x,  float y) {
		if(x >= area[0] && x <= area[2] && y >= area[1] && y <= area[3]) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean actionInBounds(TouchEvent tE) {
		//System.out.println("aIB a x y = " + tE.action + " " + tE.x + " " + tE.y);
		if(action == tE.action && tE.x >= area[0] && tE.x <= area[2] && tE.y >= area[1] && tE.y <= area[3]) {
			touchEvent = new TouchEvent(tE.action, tE.x, tE.y);
			return true;
		} else {
			return false;
		}
	}
	
	public abstract void doAction();
	
}
