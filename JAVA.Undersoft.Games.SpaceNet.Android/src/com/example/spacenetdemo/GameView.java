package com.example.spacenetdemo;

import com.example.spacenetdemo.abstractclass.ButtonBounds;
import com.example.spacenetdemo.common.TouchEvent;
import com.example.spacenetdemo.common.User;
import com.example.spacenetdemo.marketbuyscreen.MarketBuyScreen;
import com.example.spacenetdemo.marketbuysellscreen.MarketBuySellScreen;
import com.example.spacenetdemo.marketsellscreen.MarketSellScreen;
import com.example.spacenetdemo.splash.SplashScreen;
import com.example.spacenetdemo.startscreen.StartScreen;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;

public class GameView extends SurfaceView {


    private SurfaceHolder holder;
    public GameLoopThread gameLoopThread;

    //public int numer_nacisnietego_przycisku = 0;
    public int klatkaAnimacji = 0;
    public int money = 0;

    public boolean drawingEnable = true;

    Context contextGameView = null;

    public static final int PHASE_HIDDEN_WEAPON = 0;
    public static final int PHASE_SELECT_WEAPON = 1;
    
    public GameView(Context context) {
        super(context);

        contextGameView = context;
        //SharedPreferences settings = contextGameView.getSharedPreferences(PREFS_NAME, 0);
        //najlepszy_wynik = settings.getInt("najlepszy_wynik", 0);

    	WindowManager windowManager = (WindowManager)contextGameView.getSystemService(Context.WINDOW_SERVICE);
    	Constants.S_W = windowManager.getDefaultDisplay().getWidth();
    	Constants.S_H = windowManager.getDefaultDisplay().getHeight();

    	System.out.println("-------sz=" + Constants.S_W);
    	System.out.println("------wys=" + Constants.S_H);

    	initializeVariables();
    	
        this.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent e) {
				//TouchValues.setValues(e.getAction(), e.getX(), e.getY());
				TouchEvent touchEvent = new TouchEvent(e.getAction(), e.getX(), e.getY());
				Constants.touchEventBuffer.add(touchEvent);
				//System.out.println("TV a x y = " + e.getAction() + " " + e.getX() + " " + e.getY());
				return true;
			}
        });       
        gameLoopThread = new GameLoopThread(this);
	    holder = getHolder();
	    holder.addCallback(new SurfaceHolder.Callback() {
	    	
            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
            }

            @Override
            public void surfaceCreated(SurfaceHolder holder) {
            	//System.out.println("surfaceCreated");
                gameLoopThread.setRunning(true);
                if(!gameLoopThread.started)
                	gameLoopThread.start();
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            	//System.out.println("surfaceChanged");
            }
        });
    }

    public void initializeVariables() {
    	Constants.SZ = Constants.S_W/480f;
    	Constants.WY = Constants.S_H/320f;
    	
    	Constants.ctx = contextGameView;
    	
    	Constants.positionJetOnTheScreenY = Constants.S_H*40/48;
    	Constants.positionJetOnTheScreenX = Constants.S_W/2;
    	
    	Constants.user = new User();
    	
    	//Constants.screen = new StartScreen();
    	Constants.screen = new SplashScreen();
    	//Constants.screen = new InSpaceAntaresScreen();
    	//Constants.screen = new MarketSellScreen();
    	Constants.screen.prepare();
    }
    
    @Override
    protected void onDraw(Canvas g) {
    	//System.out.println("gvoD");
//    	if(!drawingEnable)return;
    	Constants.animationFrame++;
    	Constants.copyTouchEvents();
    	
    	boolean buttonClicked = false;
    	int len = Constants.touchEvents.size();
    	ButtonBounds buttonBounds;
		for(int i = 0; i < Constants.buttons.size(); i++) {
			for(int j = 0; j < len; j++) {
				buttonBounds = Constants.buttons.get(i);
				if(buttonBounds.actionInBounds(Constants.touchEvents.get(j))) {
					buttonBounds.doAction();
					Constants.touchEventBuffer.clear();
					//System.out.println("--------------");
					j = 1000;
					i = 1000;
					buttonClicked = true;
					break;
				}
			}
		}
		if(buttonClicked) {
			Constants.touchEvents.clear();
		}
    	//
    	Constants.screen.update();
    	Constants.screen.draw(g);
    	
    	//System.out.println("CBS = " + Constants.buttons.size());
    	for(int i = 0; i < Constants.buttons.size(); i++) {
//    		Constants.buttons.get(i).draw(g);
    	}
    }

	public void onChangeAzimuth(float degree) {
		//System.out.println("GV a=" + azimuth);
		Constants.angle -= degree;
	}
}
