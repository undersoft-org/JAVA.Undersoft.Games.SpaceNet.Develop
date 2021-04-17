package com.example.spacenetdemo.abstractclass;

import android.graphics.Canvas;

public abstract interface ScreenInterface {
	
	public void prepare();
	public void update();
	public void draw(Canvas g);
	
}
