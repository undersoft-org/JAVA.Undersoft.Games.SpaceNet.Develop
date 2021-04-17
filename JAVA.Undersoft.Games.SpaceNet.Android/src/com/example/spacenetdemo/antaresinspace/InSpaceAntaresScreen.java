package com.example.spacenetdemo.antaresinspace;

import java.util.ArrayList;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PathEffect;
import android.graphics.RectF;
import android.graphics.BitmapFactory.Options;

import com.example.spacenetdemo.Constants;
import com.example.spacenetdemo.R;
import com.example.spacenetdemo.abstractclass.ButtonBounds;
import com.example.spacenetdemo.abstractclass.Screen;
import com.example.spacenetdemo.common.Bullet;
import com.example.spacenetdemo.common.ObjectToShoot;
import com.example.spacenetdemo.common.ObjectsToShoot;

public class InSpaceAntaresScreen extends Screen {
	
	Paint paintCyan = null;
	Paint paintRed = null;
	Paint paintBlue = null;
    Paint paintRedLine = null;
    Paint paintRedLine2 = null;
    Paint paintRedLine3 = null;
    Paint paintRedLineMap = null;
    Paint paintBlueSelectWeapon = null;
    Paint paintOnlyAntiAlias = null;
    Paint paintBlackHoleName = null;
    Paint paintRedAlpha = null;
    Paint paintYellowLandText = null;
    
    Matrix matrixFire = new Matrix();
    
	//float speed = 0;
	float scale = 3.0f;
	
    float oldPositionBitmapX = 0;
    float oldPositionBitmapY = 0;
    float newPositionBitmapX = 0;
    float newPositionBitmapY = 0;
    
    final int mapDistanceX = 2;
    final int mapDistanceY = 2;
    
    int npbX1 = 0;
    int npbX2 = 0;
    int npbX3 = 0;
    int npbY1 = 0;
    int npbY2 = 0;
    int npbY3 = 0;
    
	float scaleM = 1.0f/20.0f;
	
    float crystalsPositionX = 0;
    float crystalsPositionY = 0;
    int crystalsType = 0;

	private Bitmap img_czerwona1;
	private Bitmap img_niebieska1;
	private Bitmap img_skalista1;

	private Bitmap img_krysztal10a35;
	private Bitmap img_krysztal11a35;
	private Bitmap img_krysztal12a35;
	private Bitmap img_krysztal10a35b;
	private Bitmap img_krysztal11a35b;
	private Bitmap img_krysztal12a35b;

	private Bitmap img_symbol1a50;
	private Bitmap img_symbol2a50;
	private Bitmap img_symbol6a50;
	
	private Bitmap img_speed;
	private Bitmap img_weapon;
	private Bitmap img_blackhole;

	private Bitmap img_jet = null;
	private Bitmap img_ast1;
	private Bitmap img_ast4;
    private Bitmap img_bkg[] = new Bitmap[9];

    public ArrayList<ButtonBounds> buttons = new ArrayList<ButtonBounds>();

    public static final int PHASE_SMALL_MAP = 0;
	public static final int PHASE_BIG_MAP = 1;
	int mapPhase = PHASE_SMALL_MAP;
	
    int lastBullet = 0;
    int numberOfBullets = 3;
    Bullet[] bullet = new Bullet[numberOfBullets];

    public static final int PHASE_HIDDEN_WEAPON = 0;
    public static final int PHASE_SELECT_WEAPON = 1;
    int weapon_phase = PHASE_HIDDEN_WEAPON;
    RectF selectWeaponOval;
    
    ObjectsToShoot objectsToShoot = new ObjectsToShoot();
    
    int gatheredCrystalType = -1;
    
	@Override
	public void prepare() {
    	Options bitmapOptions = new Options();
    	bitmapOptions.inScaled = false;

    	img_czerwona1 = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.czerwona1a150, bitmapOptions);
    	img_niebieska1 = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.niebieska1a150, bitmapOptions);
    	img_skalista1 = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.skalista1, bitmapOptions);
    	
    	img_krysztal10a35 = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.krysztal10a35, bitmapOptions);
    	img_krysztal11a35 = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.krysztal11a35, bitmapOptions);
    	img_krysztal12a35 = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.krysztal12a35, bitmapOptions);
    	img_krysztal10a35b = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.krysztal10a35b, bitmapOptions);
    	img_krysztal11a35b = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.krysztal11a35b, bitmapOptions);
    	img_krysztal12a35b = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.krysztal12a35b, bitmapOptions);

    	img_symbol1a50 = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.symb1a50, bitmapOptions);
    	img_symbol2a50 = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.symb2a50, bitmapOptions);
    	img_symbol6a50 = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.symb6a50, bitmapOptions);

    	img_speed = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.menu2);
    	img_weapon = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.cannon1, bitmapOptions);
    	img_blackhole = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.black_hole2, bitmapOptions);

    	img_jet = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.spaceship5a35);
    	img_ast1 = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.asteroid1a, bitmapOptions);
    	img_ast4 = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.asteroid4a, bitmapOptions);

		img_bkg[0] = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.a11, bitmapOptions);
		img_bkg[1] = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.a12, bitmapOptions);
		img_bkg[2] = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.a13, bitmapOptions);
		img_bkg[3] = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.a21, bitmapOptions);
		img_bkg[4] = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.a22, bitmapOptions);
		img_bkg[5] = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.a23, bitmapOptions);
		img_bkg[6] = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.a31, bitmapOptions);
		img_bkg[7] = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.a32, bitmapOptions);
		img_bkg[8] = BitmapFactory.decodeResource(Constants.ctx.getResources(), R.drawable.a33, bitmapOptions);
		
        for(int i = 0; i < numberOfBullets;i++) {
        	bullet[i] = new Bullet();
        }

        paintCyan = new Paint();
        paintCyan.setColor(Color.CYAN);
        paintRed = new Paint();
        paintRed.setColor(Color.RED);
        paintBlue = new Paint();
        paintBlue.setColor(Color.BLUE);
        
        paintRedLine = new Paint();
        float[] f = {10f,8f};
        PathEffect pathEffect = new DashPathEffect( f, 0);
        paintRedLine.setPathEffect(pathEffect);
        paintRedLine.setColor(Color.RED);
        
        paintRedLine.setAntiAlias(true);
        paintRedLine.setDither(true);
        paintRedLine.setColor(0xFFFF0000);
        paintRedLine.setStyle(Paint.Style.STROKE);
        paintRedLine.setStrokeJoin(Paint.Join.ROUND);
       // mPaint.setStrokeCap(Paint.Cap.ROUND);
        paintRedLine.setStrokeWidth(5);
        
        paintRedLine2 = new Paint(paintRedLine);
        PathEffect pathEffect2 = new DashPathEffect( f, 6);
        paintRedLine2.setPathEffect(pathEffect2);
        
        paintRedLine3 = new Paint(paintRedLine);
        PathEffect pathEffect3 = new DashPathEffect( f, 12);
        paintRedLine3.setPathEffect(pathEffect3);
        
        paintRedLineMap = new Paint(paintRedLine);
        paintRedLineMap.setStrokeWidth(30);
 
        paintBlueSelectWeapon = new Paint();
        paintBlueSelectWeapon.setARGB(173,31,82,230);
        paintBlueSelectWeapon.setAntiAlias(true);

        paintOnlyAntiAlias = new Paint();
        paintOnlyAntiAlias.setAntiAlias(true);
        
        paintRedAlpha = new Paint(paintRed);
        paintRedAlpha.setAlpha(128);
        
        paintYellowLandText = new Paint();
        paintYellowLandText.setColor(Color.YELLOW);
        paintYellowLandText.setTextSize(28);
        paintYellowLandText.setAntiAlias(true);

    	paintBlackHoleName = new Paint();
    	paintBlackHoleName.setColor(Color.RED);
    	paintBlackHoleName.setTextSize(200);
    	paintBlackHoleName.setAntiAlias(true);

		selectWeaponOval = new RectF(Constants.S_W - Constants.S_W*2/5, Constants.S_H - Constants.S_W*2/5,
				Constants.S_W + Constants.S_W*2/5, Constants.S_H + Constants.S_W*2/5);

		
		oldPositionBitmapX = Constants.user.positionJetInSpaceX;
		oldPositionBitmapY = Constants.user.positionJetInSpaceY;
        //on blackhole                              
        //oldPositionBitmapX = Constants.positionJetOnTheScreenX/3 - 15;
        //oldPositionBitmapY = Constants.positionJetOnTheScreenY/3 - 250;
        //on antares
        //oldPositionBitmapX = Constants.positionJetOnTheScreenX/3 - 50;
        //oldPositionBitmapY = Constants.positionJetOnTheScreenY/3 - 50;
		//where
		//oldPositionBitmapX = 12;//-150;//-550;//-240;
        //oldPositionBitmapY = 75;//-850;//-550;//-240;
        
        //krysztaly na asteroidzie img_ast1 w kwadracie 640, 90, 740, 190
        //g.drawRect(640, 90, 740, 190, paintRedAlpha);
        for(int i = 0; i < 20; i++) {
        	crystalsPositionX = scale*(float)(640 + Math.random()*95);
        	crystalsPositionY = scale*(float)(90 + Math.random()*95);
        	crystalsType = (int)Math.round((Math.random()*2));
        	switch(crystalsType) {
        		case 0: objectsToShoot.addObject(crystalsPositionX, crystalsPositionY, img_krysztal10a35b, img_krysztal10a35, ObjectToShoot.TYPE_CRYSTAL_GREEN);
        			break;
        		case 1: objectsToShoot.addObject(crystalsPositionX, crystalsPositionY, img_krysztal11a35b, img_krysztal11a35, ObjectToShoot.TYPE_CRYSTAL_BROWN);
        			break;
        		case 2: objectsToShoot.addObject(crystalsPositionX, crystalsPositionY, img_krysztal12a35b, img_krysztal12a35, ObjectToShoot.TYPE_CRYSTAL_BLUE);
        			break;
        	}
        }
        //krysztaly na asteroidzie img_ast4 w kwadracie 185, 720, 260, 850
        //g.drawRect(185, 720, 260, 850, paintRedAlpha);
        for(int i = 0; i < 20; i++) {
        	crystalsPositionX = scale*(float)(185 + Math.random()*70);
        	crystalsPositionY = scale*(float)(720 + Math.random()*125);
        	crystalsType = (int)Math.round((Math.random()*2));
        	switch(crystalsType) {
        		case 0: objectsToShoot.addObject(crystalsPositionX, crystalsPositionY, img_krysztal10a35b, img_krysztal10a35, ObjectToShoot.TYPE_CRYSTAL_GREEN);
        			break;
        		case 1: objectsToShoot.addObject(crystalsPositionX, crystalsPositionY, img_krysztal11a35b, img_krysztal11a35, ObjectToShoot.TYPE_CRYSTAL_BROWN);
        			break;
        		case 2: objectsToShoot.addObject(crystalsPositionX, crystalsPositionY, img_krysztal12a35b, img_krysztal12a35, ObjectToShoot.TYPE_CRYSTAL_BLUE);
        			break;
        	}
        }
        
        Constants.planets.listOfPlanets.clear();
        Constants.planets.setName("Antares System");
        Constants.planets.addPanet(50, 50, img_czerwona1, img_symbol2a50, scale, 0, "Antares");
        Constants.planets.addPanet(500, 350, img_niebieska1, img_symbol1a50, scale, 0, "Substar");
        Constants.planets.addPanet(750, 750, img_skalista1, img_symbol6a50, scale, 0, "Phantos");
        
        Constants.buttons.clear();
        buttons.clear();
        SpeedButtonBounds b2  = new SpeedButtonBounds(this, 2, android.view.MotionEvent.ACTION_MOVE, Constants.S_W/20, Constants.S_H - 4*img_speed.getHeight() - 15, Constants.S_W/20 + img_speed.getWidth(), Constants.S_H - 3*img_speed.getHeight() - 15);
        SpeedButtonBounds b1  = new SpeedButtonBounds(this, 1, android.view.MotionEvent.ACTION_MOVE, Constants.S_W/20, Constants.S_H - 3*img_speed.getHeight() - 10, Constants.S_W/20 + img_speed.getWidth(), Constants.S_H - 2*img_speed.getHeight() - 10);
        SpeedButtonBounds b0  = new SpeedButtonBounds(this, 0, android.view.MotionEvent.ACTION_MOVE, Constants.S_W/20, Constants.S_H - 2*img_speed.getHeight() -  5, Constants.S_W/20 + img_speed.getWidth(), Constants.S_H - 1*img_speed.getHeight() -  5);
        SpeedButtonBounds bm1 = new SpeedButtonBounds(this, -1, android.view.MotionEvent.ACTION_MOVE, Constants.S_W/20, Constants.S_H - 1*img_speed.getHeight() - 0, Constants.S_W/20 + img_speed.getWidth(), Constants.S_H - 0*img_speed.getHeight() - 0);
        buttons.add(b2);
        buttons.add(b1);
        buttons.add(b0);
        buttons.add(bm1);
        
        SwitchWeaponButtonBounds bsw = new SwitchWeaponButtonBounds(this, android.view.MotionEvent.ACTION_DOWN, Constants.S_W/2, 0, Constants.S_W, Constants.S_H);
        buttons.add(bsw);
        
        MapButtonBounds bm = new MapButtonBounds(this, android.view.MotionEvent.ACTION_DOWN, 0, 0, Constants.S_W/3, Constants.S_H/3);
        buttons.add(bm);
    }
	
	@Override
	public void update() {
		//System.out.println("u mp =" + mapPhase);
		switch(mapPhase) {
			case PHASE_BIG_MAP:
				int lenTES = Constants.touchEvents.size();
				for(int j = 0; j < lenTES; j++) {
					if(Constants.touchEvents.get(j).action == android.view.MotionEvent.ACTION_DOWN) {
						mapPhase = PHASE_SMALL_MAP;
					}
				}
				break;
			case PHASE_SMALL_MAP:
				Constants.planets.update();
				Constants.planets.checkIfContainsInCenter(-newPositionBitmapX + Constants.positionJetOnTheScreenX/scale, -newPositionBitmapY + Constants.positionJetOnTheScreenY/scale, 14);
				objectsToShoot.update();
				
		    	int len = Constants.touchEvents.size();
		    	ButtonBounds buttonBounds;
				for(int i = 0; i < buttons.size(); i++) {
					for(int j = 0; j < len; j++) {
						buttonBounds = buttons.get(i);
						if(buttonBounds.actionInBounds(Constants.touchEvents.get(j))) {
							buttonBounds.doAction();
							//System.out.println("+++++++++++");
							j = 1000;
							i = 1000;							
							break;
						}
					}
				}
				
		        for(int i = 0; i < numberOfBullets;i++) {
		        	bullet[i].update();
		        	if(objectsToShoot.checkIfContainsBullet(scale*bullet[i].positionBulletX, scale*bullet[i].positionBulletY, bullet[i].typeActualWeapon)) {
		        		bullet[i].outOfScene = true;
		        	}
		        }
		        
		        gatheredCrystalType = objectsToShoot.checkIfContainsJetPositionAndPhase2(-oldPositionBitmapX*scale + Constants.positionJetOnTheScreenX, -oldPositionBitmapY*scale + Constants.positionJetOnTheScreenY);
		        if(gatheredCrystalType > -1) {
		        	Constants.user.gatheredCrystals[gatheredCrystalType]++;
		        	//System.out.println("gCT = " + gatheredCrystalType);
		        }
		        break;
		}
	}
	
	@Override
	public void draw(Canvas g) {
		//System.out.println("d mp =" + mapPhase);
		switch(mapPhase) {
			case PHASE_BIG_MAP:
    			scaleM = (Constants.S_H - 4)/(3*768.0f);
    			g.drawColor(Color.BLACK);
    			drawMap(g, true, 0, 0, true);
				break;
			case PHASE_SMALL_MAP:		
				drawSpace(g);
				scaleM = 1f/20f;
				drawMap(g, true, 0, 0, false);
				//drawbuttons
		    	//for(int i = 0; i < buttons.size(); i++) {
		    	//	buttons.get(i).draw(g);
		    	//}
		    	break;
		}
	}


    
    public void drawSpace(Canvas g) {
    	float angleLocal = Constants.angle;
    	newPositionBitmapX = oldPositionBitmapX + (float)(Constants.speed*Math.sin(angleLocal*Math.PI/180.0));
    	newPositionBitmapY = oldPositionBitmapY + (float)(Constants.speed*Math.cos(angleLocal*Math.PI/180.0));
    	
    	Constants.user.positionJetInSpaceX = newPositionBitmapX;
    	Constants.user.positionJetInSpaceY = newPositionBitmapY;
    	
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
    	
        oldPositionBitmapX = newPositionBitmapX;
        oldPositionBitmapY = newPositionBitmapY;

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
        
        //animowana linia przerywana
        switch((Constants.animationFrame/10)%3) {
        	case 0: g.drawLine(15, 250, 50, 50, paintRedLine);
        			g.drawLine(50, 50, 500, 350, paintRedLine);
        			g.drawLine(500, 350, 750, 750, paintRedLine);
        		break;
        	case 1: g.drawLine(15, 250, 50, 50, paintRedLine2); 
        			g.drawLine(50, 50, 500, 350, paintRedLine2);
        			g.drawLine(500, 350, 750, 750, paintRedLine2);
        		break;
        	case 2: g.drawLine(15, 250, 50, 50, paintRedLine3);
        			g.drawLine(50, 50, 500, 350, paintRedLine3);
        			g.drawLine(500, 350, 750, 750, paintRedLine3);
        		break;
        }

        g.drawBitmap(img_ast1, 600, 50, null);
        g.drawBitmap(img_ast4, 150, 700, paintOnlyAntiAlias);
        
        g.scale(1/scale, 1/scale);
        Constants.planets.draw(g);
        objectsToShoot.draw(g);
        
        g.scale(scale, scale);
        for(int i = 0; i < numberOfBullets;i++) {
        	bullet[i].draw(g);
        }

        //blackhole
        g.setMatrix(null);
        g.rotate(angleLocal, Constants.positionJetOnTheScreenX, Constants.positionJetOnTheScreenY);
        g.translate(newPositionBitmapX*scale + 15*scale, newPositionBitmapY*scale + 250*scale);
        g.rotate(2*(Constants.animationFrame%360), 0, 0);
        g.drawBitmap(img_blackhole, -img_blackhole.getWidth()/2, -img_blackhole.getHeight()/2, null);

        
        g.setMatrix(null);
        g.drawBitmap(img_jet, (Constants.positionJetOnTheScreenX * 2 - img_jet.getWidth())/2, Constants.positionJetOnTheScreenY, null);
        
        g.drawBitmap(img_speed, Constants.S_W/20, Constants.S_H - 4*img_speed.getHeight() - 15, null);
        g.drawBitmap(img_speed, Constants.S_W/20, Constants.S_H - 3*img_speed.getHeight() - 10, null);
        g.drawRect(Constants.S_W/20, Constants.S_H - 2*img_speed.getHeight() - 5,
        		Constants.S_W/20 + img_speed.getWidth(), Constants.S_H - 2*img_speed.getHeight() - 5 + img_speed.getHeight(), paintRedAlpha);
        g.drawBitmap(img_speed, Constants.S_W/20, Constants.S_H - img_speed.getHeight(), null);
        if(Constants.planets.checkStayInCenterOfPlanet >= 0) {
        	//System.out.println("p=" + Constants.planets.checkStayInCenterOfPlanet);
        	g.drawText("Land", Constants.S_W/20 + (img_speed.getWidth() - paintYellowLandText.measureText("Land"))/2, Constants.S_H - 2*img_speed.getHeight() + img_speed.getHeight()*16/24f, paintYellowLandText);
        }

		switch(weapon_phase) {
			case PHASE_HIDDEN_WEAPON:
		        g.drawCircle(Constants.S_W, Constants.S_H, 50, paintBlueSelectWeapon);
		        g.drawCircle(Constants.S_W, Constants.S_H, 36, Bullet.getPaintNewWeapon());
				break;
			case PHASE_SELECT_WEAPON:
				g.drawCircle(Constants.S_W, Constants.S_H, 10 + Constants.S_W*2/5, paintBlueSelectWeapon);
				g.drawArc(selectWeaponOval, 249, 19, true, Bullet.paintCyanWeapon);
				g.drawArc(selectWeaponOval, 226, 19, true, Bullet.paintGreenWeapon);
				g.drawArc(selectWeaponOval, 204, 19, true, Bullet.paintBrownWeapon);
				g.drawArc(selectWeaponOval, 182, 19, true, Bullet.paintBlueWeapon);
				//img_weapon = Bitmap.createScaledBitmap(img_weapon, 150, 75, false);
				g.drawBitmap(img_weapon, Constants.S_W - img_weapon.getWidth() - 10, Constants.S_H - img_weapon.getHeight() - 10, null);
		        break;
		}
		
		g.drawText("" + Constants.user.gatheredCrystals[0], Constants.S_W - 100 - Bullet.paintGreenWeapon.measureText("" + Constants.user.gatheredCrystals[0]), 35, Bullet.paintGreenWeapon);
		g.drawText("" + Constants.user.gatheredCrystals[1], Constants.S_W -  50 - Bullet.paintBrownWeapon.measureText("" + Constants.user.gatheredCrystals[1]), 35, Bullet.paintBrownWeapon);
		g.drawText("" + Constants.user.gatheredCrystals[2], Constants.S_W -   5  - Bullet.paintBlueWeapon.measureText("" + Constants.user.gatheredCrystals[2]), 35, Bullet.paintBlueWeapon);
    }
    
    public void drawMap(Canvas g, boolean drawIndicator, int topMap, int leftMap, boolean drawTitle) {
    	float angleLocal = Constants.angle;
        //przesuniecie_mapy
        int przesMapy = 768;
        
        g.setMatrix(null);
        g.drawRect(topMap*scaleM, leftMap*scaleM, 4 + 3*768*scaleM + topMap*scaleM, 4 + 3*768*scaleM + leftMap*scaleM, paintBlue);
        g.scale(scaleM, scaleM);

        for(int j=0; j<3; j++) {
        	for(int i=0; i<3; i++) {
        		for(int k=0; k<3; k++) {
        			for(int l=0; l<3; l++) {
        				g.drawBitmap(img_bkg[k*3+l], topMap + mapDistanceX/scaleM + i*768 + k*256, leftMap + mapDistanceY/scaleM + j*768 + l*256, null);
        			}
        		}
        	}
        }
        
        g.drawLine(topMap + przesMapy + 15, leftMap + przesMapy + 250, topMap + przesMapy + 50, leftMap + przesMapy + 50, paintRedLineMap);
        g.drawLine(topMap + przesMapy + 50, leftMap + przesMapy + 50, topMap + przesMapy + 500, leftMap + przesMapy + 350, paintRedLineMap);
		g.drawLine(topMap + przesMapy + 500, leftMap + przesMapy + 350, topMap + przesMapy + 750, leftMap + przesMapy + 750, paintRedLineMap);
        
		g.drawBitmap(img_blackhole, topMap + przesMapy + 15 -img_blackhole.getWidth()/2, leftMap + przesMapy + 250 -img_blackhole.getHeight()/2, null);
        g.drawBitmap(img_ast1, topMap + przesMapy + 600, leftMap + przesMapy + 50, null);
        g.drawBitmap(img_ast4, topMap + przesMapy + 150, leftMap + przesMapy + 700, null);
        
        Constants.planets.drawOnMap(g, topMap, leftMap, przesMapy, drawTitle);
        
        if(drawTitle) {
        	g.drawText("BH", leftMap + przesMapy + 15 - 2*img_blackhole.getWidth(), topMap + przesMapy + 250, paintBlackHoleName);
        }
        
        if(drawIndicator) {
	        g.setMatrix(null);
	        //System.out.println("dst[0]=" + dstJet[0] + " dst[1]=" + dstJet[1]);
	        float redIndicatorX = (przesMapy-newPositionBitmapX + Constants.positionJetOnTheScreenX/scale)*scaleM;
	        float redIndicatorY = (przesMapy-newPositionBitmapY + Constants.positionJetOnTheScreenY/scale)*scaleM;
	        
	        matrixFire.reset();
	        matrixFire.setRotate(angleLocal, 0, 0);
	        float[] src = {0.0f, -30.0f};
	        float[] dst = new float[2];
	        matrixFire.mapPoints(dst, src);
	        
	        float cyanIndicatorX = (przesMapy-newPositionBitmapX + (Constants.positionJetOnTheScreenX+dst[0]*scale)/scale)*scaleM;
	        float cyanIndicatorY = (przesMapy-newPositionBitmapY + (Constants.positionJetOnTheScreenY-dst[1]*scale)/scale)*scaleM;
	        
	        if(redIndicatorX < mapDistanceX) {
	        	redIndicatorX += 3*3*img_bkg[0].getWidth()*scaleM;
	        	cyanIndicatorX += 3*3*img_bkg[0].getWidth()*scaleM;
	        } else if(redIndicatorX > mapDistanceX + 3*3*img_bkg[0].getWidth()*scaleM) {
	        	redIndicatorX -= 3*3*img_bkg[0].getWidth()*scaleM;
	        	cyanIndicatorX -= 3*3*img_bkg[0].getWidth()*scaleM;
	        }
	
	        if(redIndicatorY < mapDistanceY) {
	        	redIndicatorY += 3*3*img_bkg[0].getHeight()*scaleM;
	        	cyanIndicatorY += 3*3*img_bkg[0].getHeight()*scaleM;
	        } else if(redIndicatorX > mapDistanceX + 3*3*img_bkg[0].getHeight()*scaleM) {
	        	redIndicatorY -= 3*3*img_bkg[0].getHeight()*scaleM;
	        	cyanIndicatorY -= 3*3*img_bkg[0].getHeight()*scaleM;
	        }
	        
	        g.drawCircle(cyanIndicatorX, topMap + cyanIndicatorY, 1.5f, paintCyan);
	        g.drawCircle(redIndicatorX, leftMap + redIndicatorY, 1.5f, paintRed);
        }
    }

    public void shotTheBullet() {
    	bullet[lastBullet] = new Bullet(Constants.angle, -newPositionBitmapX + Constants.positionJetOnTheScreenX/scale , -newPositionBitmapY + Constants.positionJetOnTheScreenY/scale);
    	if(lastBullet < numberOfBullets - 1) {
    		lastBullet++;
    	} else {
    		lastBullet = 0;
    	}
    }
}

