package com.example.spacenetdemo.antaresinspace;

import com.example.spacenetdemo.Constants;
import com.example.spacenetdemo.abstractclass.ButtonBounds;
import com.example.spacenetdemo.common.Bullet;

public class SwitchWeaponButtonBounds extends ButtonBounds {

	InSpaceAntaresScreen inSpaceAntaresScreen = null;
	
	public SwitchWeaponButtonBounds(InSpaceAntaresScreen screen, int lAction, float left, float top, float right, float bottom) {
		super(lAction, left, top, right, bottom);
		inSpaceAntaresScreen = screen;
	}

	@Override
	public void doAction() {
//		if(Constants.touchEvents.get(j).x > Constants.S_W/2 && Constants.touchEvents.get(j).action == android.view.MotionEvent.ACTION_DOWN) {
		switch(inSpaceAntaresScreen.weapon_phase) {
			case InSpaceAntaresScreen.PHASE_HIDDEN_WEAPON:
				if(touchEvent.x > (Constants.S_W - 50) && touchEvent.y > (Constants.S_H - 50)) {
					inSpaceAntaresScreen.weapon_phase = InSpaceAntaresScreen.PHASE_SELECT_WEAPON; 
				} else {
					inSpaceAntaresScreen.shotTheBullet();
				}
				break;
			case InSpaceAntaresScreen.PHASE_SELECT_WEAPON:
				if((touchEvent.x > Constants.S_W - 50) && (touchEvent.y > Constants.S_H - 50)) {
					inSpaceAntaresScreen.weapon_phase = InSpaceAntaresScreen.PHASE_HIDDEN_WEAPON;
				} else if((touchEvent.x > Constants.S_W*3/5) && (touchEvent.y > Constants.S_H - Constants.S_W*2/5)){
					int angleWeapon = (int)(Math.atan((Constants.S_H - touchEvent.y)/(Constants.S_W - touchEvent.x))*180/Math.PI);
					if(angleWeapon < 23) {
						Bullet.setNewWeapon(Bullet.TYPE_WEAPON_CRYSTAL_BLUE);
					} else if(angleWeapon < 45) {
						Bullet.setNewWeapon(Bullet.TYPE_WEAPON_CRYSTAL_BROWN);
					} else if(angleWeapon < 67) {
						Bullet.setNewWeapon(Bullet.TYPE_WEAPON_CRYSTAL_GREEN);
					} else if(angleWeapon < 90) {
						Bullet.setNewWeapon(Bullet.TYPE_WEAPON_CRYSTAL_CYAN);
					}
					inSpaceAntaresScreen.weapon_phase = InSpaceAntaresScreen.PHASE_HIDDEN_WEAPON;
				}				
				break;
		}
//		}
//		if(inSpaceAntaresScreen.weapon_phase == inSpaceAntaresScreen.PHASE_HIDDEN_WEAPON) {
//			inSpaceAntaresScreen.weapon_phase = inSpaceAntaresScreen.PHASE_SELECT_WEAPON;
//		} else {
//			inSpaceAntaresScreen.weapon_phase = inSpaceAntaresScreen.PHASE_HIDDEN_WEAPON;
//		}
	}
}
