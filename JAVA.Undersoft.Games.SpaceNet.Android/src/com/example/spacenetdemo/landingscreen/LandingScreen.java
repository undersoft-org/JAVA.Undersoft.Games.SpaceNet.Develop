package com.example.spacenetdemo.landingscreen;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.BitmapFactory.Options;

import com.example.spacenetdemo.Constants;
import com.example.spacenetdemo.R;
import com.example.spacenetdemo.abstractclass.Screen;
import com.example.spacenetdemo.onplanetscreen.OnPlanetScreen;

public class LandingScreen extends Screen {
	
	float scale = 3.0f;
	
    float oldPositionBitmapX = 0;
    float oldPositionBitmapY = 0;
    float newPositionBitmapX = 0;
    float newPositionBitmapY = 0;
    
    int npbX1 = 0;
    int npbX2 = 0;
    int npbX3 = 0;
    int npbY1 = 0;
    int npbY2 = 0;
    int npbY3 = 0;
    
	private Bitmap img_jet = null;
    private Bitmap img_bkg[] = new Bitmap[9];

    float deltaScaleLanding = 1.0f;
    
	@Override
	public void prepare() {
    	Options bitmapOptions = new Options();
    	bitmapOptions.inScaled = false;

    	img_jet = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.spaceship5a35);

		img_bkg[0] = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.a11, bitmapOptions);
		img_bkg[1] = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.a12, bitmapOptions);
		img_bkg[2] = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.a13, bitmapOptions);
		img_bkg[3] = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.a21, bitmapOptions);
		img_bkg[4] = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.a22, bitmapOptions);
		img_bkg[5] = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.a23, bitmapOptions);
		img_bkg[6] = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.a31, bitmapOptions);
		img_bkg[7] = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.a32, bitmapOptions);
		img_bkg[8] = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.a33, bitmapOptions);
		
    	newPositionBitmapX = Constants.user.positionJetInSpaceX;
    	newPositionBitmapY = Constants.user.positionJetInSpaceY;
    	        
        Constants.buttons.clear();
        
        deltaScaleLanding = 1.0f;
    }
	
	@Override
	public void update() {
		if(deltaScaleLanding < 4) {
			deltaScaleLanding += 0.05f;
		} else {
			Constants.screen = new OnPlanetScreen();
			Constants.screen.prepare();
		}
	}
	
	@Override
	public void draw(Canvas g) {
		drawSpace(g);
	}
    
    public void drawSpace(Canvas g) {
    	float angleLocal = Constants.angle;
    	
    	if(newPositionBitmapX > 768) {
    		newPositionBitmapX -= 768*3;
        } else if(newPositionBitmapX < -768*2) {
    		newPositionBitmapX += 768*3;
        }

    	if(newPositionBitmapY > 768) {
    		newPositionBitmapY -= 768*3;
        } else if(newPositionBitmapY < -768*2) {
    		newPositionBitmapY += 768*3;
        }
    	
        //System.out.println("oPBX=" + oldPositionBitmapX);
        g.drawColor(Color.BLACK);
        
        g.setMatrix(null);
        g.scale(scale, scale);
        g.rotate(angleLocal,Constants.positionJetOnTheScreenX/scale,Constants.positionJetOnTheScreenY/scale);
        g.translate(newPositionBitmapX, newPositionBitmapY);
        
        //tlo gwiazdowe
        //System.out.println("nPBX=" + (int)newPositionBitmapX + " " + (int)newPositionBitmapY);

        npbX1 = -768*((int)newPositionBitmapX/768) + 256;
        npbX2 = -768*(((int)newPositionBitmapX - 256)/768) +  0;
        npbX3 = -768*(((int)newPositionBitmapX - 512)/768) - 256;
        npbY1 = -768*((int)newPositionBitmapY/768) + 256;
        npbY2 = -768*(((int)newPositionBitmapY - 256)/768) +  0;
        npbY3 = -768*(((int)newPositionBitmapY - 512)/768) - 256;
        
        if(newPositionBitmapX > 0) {
        	npbX1-=768;
        }
        if(newPositionBitmapX > 256) {
        	npbX2-=768;
        }
        if(newPositionBitmapX > 512) {
        	npbX3-=768;
        }
        
        if(newPositionBitmapY > 0) {
        	npbY1-=768;
        }
        if(newPositionBitmapY > 256) {
        	npbY2-=768;
        }
        if(newPositionBitmapY > 512) {
        	npbY3-=768;
        }
        
        g.drawBitmap(img_bkg[0], npbX1 + Constants.positionJetOnTheScreenX/scale, npbY1 + Constants.positionJetOnTheScreenY/scale, null);
        g.drawBitmap(img_bkg[1], npbX2 + Constants.positionJetOnTheScreenX/scale, npbY1 + Constants.positionJetOnTheScreenY/scale, null);
        g.drawBitmap(img_bkg[2], npbX3 + Constants.positionJetOnTheScreenX/scale, npbY1 + Constants.positionJetOnTheScreenY/scale, null);
        g.drawBitmap(img_bkg[3], npbX1 + Constants.positionJetOnTheScreenX/scale, npbY2 + Constants.positionJetOnTheScreenY/scale, null);
        g.drawBitmap(img_bkg[4], npbX2 + Constants.positionJetOnTheScreenX/scale, npbY2 + Constants.positionJetOnTheScreenY/scale, null);
        g.drawBitmap(img_bkg[5], npbX3 + Constants.positionJetOnTheScreenX/scale, npbY2 + Constants.positionJetOnTheScreenY/scale, null);
        g.drawBitmap(img_bkg[6], npbX1 + Constants.positionJetOnTheScreenX/scale, npbY3 + Constants.positionJetOnTheScreenY/scale, null);
        g.drawBitmap(img_bkg[7], npbX2 + Constants.positionJetOnTheScreenX/scale, npbY3 + Constants.positionJetOnTheScreenY/scale, null);
        g.drawBitmap(img_bkg[8], npbX3 + Constants.positionJetOnTheScreenX/scale, npbY3 + Constants.positionJetOnTheScreenY/scale, null);

        //kwadraty(g);
        g.setMatrix(null);
        g.translate(Constants.positionJetOnTheScreenX, Constants.positionJetOnTheScreenY);
        g.scale(deltaScaleLanding, deltaScaleLanding);
        Constants.planets.listOfPlanets.get(Constants.planets.checkStayInCenterOfPlanet).drawLanding(g);
    	
        g.setMatrix(null);
        g.drawBitmap(img_jet, (Constants.positionJetOnTheScreenX * 2 - img_jet.getWidth())/2, Constants.positionJetOnTheScreenY, null);
//    	brightness.setARGB((int)(255*deltaScale/5f), 255, 255, 255);
//   	g.drawRect(0,0, szerokosc_ekranu, wysokosc_ekranu, brightness);
    }
}

