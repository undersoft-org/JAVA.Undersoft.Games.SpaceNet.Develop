package com.example.spacenetdemo.common;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Bullet {
	
	float angleBullet = 0;
	float startPositionBulletX = 0;
	float startPositionBulletY = 0;
	public float positionBulletX = 0;
	public float positionBulletY = 0;
	public float speed = 0;
	
	Paint paintBullet = new Paint();
	public static Paint paintCyanWeapon = new Paint();
	public static Paint paintGreenWeapon = new Paint();
	public static Paint paintBrownWeapon = new Paint();
	public static Paint paintBlueWeapon = new Paint();
    
	public boolean outOfScene = false;
	float rangeBullet = 150;
	
	public static final int TYPE_WEAPON_CRYSTAL_CYAN = -1;
	public static final int TYPE_WEAPON_CRYSTAL_GREEN = 0;
	public static final int TYPE_WEAPON_CRYSTAL_BROWN = 1;
	public static final int TYPE_WEAPON_CRYSTAL_BLUE = 2;
	
	static int typeOfNewWeapon = TYPE_WEAPON_CRYSTAL_CYAN;
	public int typeActualWeapon = TYPE_WEAPON_CRYSTAL_CYAN;
	
	public Bullet() {
		paintCyanWeapon.setColor(Color.CYAN);
		paintCyanWeapon.setAntiAlias(true);
		paintGreenWeapon.setColor(Color.GREEN);
		paintGreenWeapon.setAntiAlias(true);
		paintGreenWeapon.setTextSize(35);
        paintBrownWeapon.setARGB(255, 213, 88, 5);
        paintBrownWeapon.setAntiAlias(true);
        paintBrownWeapon.setTextSize(35);
        paintBlueWeapon.setColor(Color.BLUE);
        paintBlueWeapon.setAntiAlias(true);
        paintBlueWeapon.setTextSize(35);
        paintBullet = paintCyanWeapon;		
	}

	public Bullet(float angle, float positionX, float positionY) {
		angleBullet = angle;
		startPositionBulletX = positionX;
		startPositionBulletY = positionY;
		positionBulletX = positionX;
		positionBulletY = positionY;
		speed = 6;
		typeActualWeapon = typeOfNewWeapon;
		switch(typeActualWeapon) {
			case TYPE_WEAPON_CRYSTAL_CYAN:
				paintBullet = paintCyanWeapon;
				break;
			case TYPE_WEAPON_CRYSTAL_GREEN:
				paintBullet = paintGreenWeapon;
				break;
			case TYPE_WEAPON_CRYSTAL_BROWN:
				paintBullet = paintBrownWeapon;
				break;
			case TYPE_WEAPON_CRYSTAL_BLUE:
				paintBullet = paintBlueWeapon;
				break;
			default :
				typeOfNewWeapon = TYPE_WEAPON_CRYSTAL_CYAN;
				paintBullet = paintCyanWeapon;
				break;
		}
//		System.out.println("bulletXY= " + positionX + " " + positionY);
	}
	
	public void update() {
		if(!outOfScene && speed > 0) {
			positionBulletX = positionBulletX - (float)(speed*Math.sin(angleBullet*Math.PI/180.0));
			positionBulletY = positionBulletY - (float)(speed*Math.cos(angleBullet*Math.PI/180.0));
			
			if((Math.abs(positionBulletX - startPositionBulletX) > rangeBullet) ||
			   (Math.abs(positionBulletY - startPositionBulletY) > rangeBullet))
					outOfScene = true;
		}
	}
	
	public void draw(Canvas g) {
		if(!outOfScene && speed > 0) {
			g.drawCircle(positionBulletX, positionBulletY, 1, paintBullet);
		}
	}
	
	public static void setNewWeapon(int weapon) {
		switch(weapon) {
			case -1:
				typeOfNewWeapon = TYPE_WEAPON_CRYSTAL_CYAN;
				break;
			case 0:
				typeOfNewWeapon = TYPE_WEAPON_CRYSTAL_GREEN;
				break;
			case 1:
				typeOfNewWeapon = TYPE_WEAPON_CRYSTAL_BROWN;
				break;
			case 2:
				typeOfNewWeapon = TYPE_WEAPON_CRYSTAL_BLUE;
				break;
			default :
				typeOfNewWeapon = TYPE_WEAPON_CRYSTAL_CYAN;
				break;
		}
	}
	
	public static Paint getPaintNewWeapon() {
		switch(typeOfNewWeapon) {
			case TYPE_WEAPON_CRYSTAL_CYAN:
				return paintCyanWeapon;
			case TYPE_WEAPON_CRYSTAL_GREEN:
				return paintGreenWeapon;
			case TYPE_WEAPON_CRYSTAL_BROWN:
				return paintBrownWeapon;
			case TYPE_WEAPON_CRYSTAL_BLUE:
				return paintBlueWeapon;
			default :
				return paintCyanWeapon;
		}		
	}
}
