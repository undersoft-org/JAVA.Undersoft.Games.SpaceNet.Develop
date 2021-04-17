package com.example.spacenetdemo;

import android.graphics.Canvas;

public class GameLoopThread extends Thread {
    static final long FPS = 30;
    private GameView view;
    private boolean running = false;
    public boolean drawingEnable = true;
    public boolean started = false;
   
    public GameLoopThread(GameView view) {
        this.view = view;
    }

	public void setRunning(boolean run) {
	    running = run;
    }

    @Override
    public void run() {
        long ticksPS = 1000 / FPS;
        long startTime;
        long sleepTime;
        started = true;
        while (running) {
        	//System.out.println("r");
            Canvas c = null;
            startTime = System.currentTimeMillis();
            if(drawingEnable) {
            try {
                c = view.getHolder().lockCanvas();
                
                synchronized (view.getHolder()) {
                    view.onDraw(c);
                }
            } finally {
                if (c != null) {
                    view.getHolder().unlockCanvasAndPost(c);
                }
            }
            }
            sleepTime = ticksPS-(System.currentTimeMillis() - startTime);
            try {
                if (sleepTime > 0)
                    sleep(sleepTime);
                else
                    sleep(10);
            } catch (Exception e) {}
        }
    }
}
