package com.example.spacenetdemo.common;

import java.util.ArrayList;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class ObjectsToShoot {

    public ArrayList<ObjectToShoot> listObjectsToShoot = null;
    
    public ObjectsToShoot() {
    	listObjectsToShoot = new ArrayList<ObjectToShoot>();
    }

    public boolean checkIfContainsBullet(float x, float y, int type) {
    	boolean contains = false;
    	for(int i = 0; i < listObjectsToShoot.size(); i++) {
    		if(listObjectsToShoot.get(i).contains(x, y, type)) {
    			if(listObjectsToShoot.get(i).secondPhaseEnabled) {
    				listObjectsToShoot.get(i).changePhaseTo2();
    			} else {
    				listObjectsToShoot.remove(i);
    			}
   				contains = true;
    			break;
    		}
    	}
    	return contains;
    }
    
    public int checkIfContainsJetPositionAndPhase2(float x, float y) {
    	int type = -1;
    	for(int i = 0; i < listObjectsToShoot.size(); i++) {
    		if(listObjectsToShoot.get(i).contains(x, y) && listObjectsToShoot.get(i).phase == 2) {
    			listObjectsToShoot.get(i).deleteMe = true;
    			type = listObjectsToShoot.get(i).type;
    			break;
    		}
    	}
    	return type;
    }
    
    public void update() {
    	for(int i = 0; i < listObjectsToShoot.size(); i++) {
    		listObjectsToShoot.get(i).update();
    	}
    	for(int i = 0; i < listObjectsToShoot.size(); i++) {
    		if(listObjectsToShoot.get(i).deleteMe) {
    			listObjectsToShoot.remove(i);
    		}
    	}
    }

    public void draw(Canvas g) {
     	for(int i = 0; i < listObjectsToShoot.size(); i++) {
      		listObjectsToShoot.get(i).draw(g);
     	}
    }

    public void addObject() {
    	ObjectToShoot objectToShoot = new ObjectToShoot();
    	listObjectsToShoot.add(objectToShoot);
    }

    public void addObject(float left, float top, float right, float bottom, int lType) {
    	ObjectToShoot objectToShoot = new ObjectToShoot(left, top, right, bottom, lType);
    	listObjectsToShoot.add(objectToShoot);
    }
    
    public void addObject(float left, float top, Bitmap lBitmap, int lType) {
    	ObjectToShoot objectToShoot = new ObjectToShoot(left, top, lBitmap, lType);
    	listObjectsToShoot.add(objectToShoot);
    }
    
    public void addObject(float left, float top, Bitmap lBitmap, Bitmap lBitmapSecondPhase, int lType) {
    	ObjectToShoot objectToShoot = new ObjectToShoot(left, top, lBitmap, lBitmapSecondPhase, lType);
    	listObjectsToShoot.add(objectToShoot);
    }

    
}
