package com.example.spacenetdemo;

import java.util.ArrayList;

import android.content.Context;

import com.example.spacenetdemo.abstractclass.ButtonBounds;
import com.example.spacenetdemo.abstractclass.Screen;
import com.example.spacenetdemo.common.Planets;
import com.example.spacenetdemo.common.TouchEvent;
import com.example.spacenetdemo.common.User;

public class Constants {
    public static int S_W = 1;
    public static int S_H = 1;

	public static float SZ = 1;
	public static float WY = 1;

	public static Context ctx;// = null;

	public static ArrayList<TouchEvent> touchEventBuffer = new ArrayList<TouchEvent>();
	public static ArrayList<TouchEvent> touchEvents = new ArrayList<TouchEvent>();
	
	public static float positionJetOnTheScreenY = 1;
	public static float positionJetOnTheScreenX = 1;

	public static float angle = 0;
	public static float speed = 0;
	public static int animationFrame = 0;
	
	public static Screen screen = null;
	public static ArrayList<ButtonBounds> buttons = new ArrayList<ButtonBounds>();

    public static void copyTouchEvents() {
        synchronized(touchEventBuffer) {    
            touchEvents.clear();
            touchEvents.addAll(touchEventBuffer);
            touchEventBuffer.clear();
        }
    }
    
    public static Planets planets = new Planets();
    public static User user;// = new User();
}
