package com.example.spacenetdemo.antaresinspace;

import com.example.spacenetdemo.abstractclass.ButtonBounds;
import com.example.spacenetdemo.antaresinspace.InSpaceAntaresScreen;

public class MapButtonBounds extends ButtonBounds {

	InSpaceAntaresScreen inSpaceAntaresScreen = null;
	
	public MapButtonBounds(InSpaceAntaresScreen screen, int lAction, float left, float top, float right, float bottom) {
		super(lAction, left, top, right, bottom);
		inSpaceAntaresScreen = screen;
	}
	
	@Override
	public void doAction() {
		//System.out.println("MBB");
//		if(inSpaceAntaresScreen.mapPhase == InSpaceAntaresScreen.PHASE_BIG_MAP) {
//			inSpaceAntaresScreen.mapPhase = InSpaceAntaresScreen.PHASE_SMALL_MAP; 
//		} else {
			inSpaceAntaresScreen.mapPhase = InSpaceAntaresScreen.PHASE_BIG_MAP;
//		}
	}

}
