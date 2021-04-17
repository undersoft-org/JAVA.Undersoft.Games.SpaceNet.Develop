package com.example.spacenetdemo.common;

import java.util.ArrayList;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Planets {

    public ArrayList<Planet> listOfPlanets = null;
    String name = "";
    Paint paintName = null;
    public int checkStayInCenterOfPlanet = -1;
    
    public Planets() {
    	listOfPlanets = new ArrayList<Planet>();
    	paintName = new Paint();
    	paintName.setColor(Color.YELLOW);
    	paintName.setTextSize(250);
    	checkStayInCenterOfPlanet = -1;
    }


    public boolean checkIfContains(float x, float y) {
    	boolean contains = false;
    	for(int i = 0; i < listOfPlanets.size(); i++) {
    		if(listOfPlanets.get(i).contains(x, y)) {
   				contains = true;
    			break;
    		}
    	}
    	return contains;
    }
    
    public void checkIfContainsInCenter(float x, float y, float radius) {
    	checkStayInCenterOfPlanet = -1;
    	for(int i = 0; i < listOfPlanets.size(); i++) {
    		if(listOfPlanets.get(i).containsInCenter(x, y, radius)) {
    			checkStayInCenterOfPlanet = i;
    			break;
    		}
    	}
    }
    
    public void update() {
    	for(int i = 0; i < listOfPlanets.size(); i++) {
    		listOfPlanets.get(i).update();
    	}
    }

    public void draw(Canvas g) {
     	for(int i = 0; i < listOfPlanets.size(); i++) {
     		listOfPlanets.get(i).draw(g);
     	}
    }

    public void drawOnMap(Canvas g, int left, int top, int przesMapy, boolean drawTitle) {
     	for(int i = 0; i < listOfPlanets.size(); i++) {
     		listOfPlanets.get(i).drawOnMap(g, left, top, przesMapy, drawTitle);
     	}
        if(drawTitle) {
        	g.drawText(name, g.getWidth()/4, 300, paintName);
        }
    }

    public void setName(String lName) {
    	name = lName;
    }

    public void addPanet(float left, float top, Bitmap lBitmap, Bitmap lBitmapSymbol, float scale, int lType, String name) {
    	Planet planet = new Planet(left, top, lBitmap, lBitmapSymbol, scale, lType, name);
    	listOfPlanets.add(planet);
    }

    
}
