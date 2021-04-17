package com.example.spacenetdemo.common;

public class TouchEvent {
	public int action = -1;
	public float x = -1;
	public float y = -1;
	public boolean set = false;
	
	public TouchEvent(int lAction, float lX, float lY) {
		
		action = lAction;
		x = lX;
		y = lY;
		set = true;
	}

	public void clearValue() {
		set = false;
//		action = -1;
//		x = -1;
//		y = -1;
	}
}
