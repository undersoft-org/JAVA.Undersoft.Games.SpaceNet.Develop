package com.example.spacenetdemo;

import android.os.Bundle;
import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;

public class MainActivity extends Activity implements SensorEventListener {

	private SensorManager mSensorManager;
    private GameView gameView = null;
    private boolean firstSensorValue = true;
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
        		WindowManager.LayoutParams.FLAG_FULLSCREEN);

        this.getWindow().addFlags(LayoutParams.FLAG_KEEP_SCREEN_ON);
        
        mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        gameView = new GameView(this); 
        setContentView(gameView);
    }

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
	}
	
//	float[] mGravity = new float[3];
//	float[] mGeomagnetic = new float[3];
//    float[] R = new float[9];
//    float[] I = new float[9];
	
//    float last = 0;
    
    
    float[] accelValues = new float[3];
//    float[] compassValues = new float[3];
//    float[] prefValues = new float[3];
//    boolean ready = false;
//    int counter = 0;
    
	@Override
	public void onSensorChanged(SensorEvent event) {
		switch (event.sensor.getType()) {
		    case Sensor.TYPE_ACCELEROMETER:
//		    	System.out.println("1");
		    	accelValues = lowPass( event.values.clone(), accelValues );
		    	//System.out.println("aV=" + accelValues[0] + " " + accelValues[1] + " " + accelValues[2]);
		    	//Constants.speed = -1.5f*accelValues[0]/3f + 3;
		    	Constants.speed = -3.0f * accelValues[0]/3f + 6;
		    	gameView.onChangeAzimuth(accelValues[1]/2f);
		        break;
		    }
	}

	@Override
	protected void onDestroy() {
		//System.out.println("onDestroy");
		//gameView.objectsToShoot.listObjectsToShoot.clear();
		
        boolean retry = true;
        gameView.gameLoopThread.setRunning(false);
        while (retry) {
            try {
            	gameView.gameLoopThread.join();
                retry = false;
            } catch (InterruptedException e) {
            }
        }

	    // Unregister the listener on the onPause() event to preserve battery life;
	    mSensorManager.unregisterListener(this);
	    gameView.drawingEnable = false;
	    gameView.gameLoopThread.drawingEnable = false;
	    super.onPause();
	}
	
	@Override
	protected void onPause() {
	    // Unregister the listener on the onPause() event to preserve battery life;
	    mSensorManager.unregisterListener(this);
	    gameView.drawingEnable = false;
	    gameView.gameLoopThread.drawingEnable = false;
	    super.onPause();
	}

	@Override
	protected void onResume() {
		System.out.println("onResume");
	    //mSensorManager.registerListener(this, mCompass, SensorManager.SENSOR_DELAY_GAME);
	    mSensorManager.registerListener(
	            this, 
	            mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
	             SensorManager.SENSOR_DELAY_GAME );
	    		
	    gameView.gameLoopThread.drawingEnable = true;
	    gameView.drawingEnable = true;
	    super.onResume();
	}
	
	static final float ALPHA = 0.15f;
	
	protected float[] lowPass(float[] input, float[] output)
	{
	    if (output == null)
	        return input;

	    for (int i = 0; i < input.length; i++)
	    {
	        output[i] = output[i] + ALPHA * (input[i] - output[i]);
	    }
	    return output;
	}
/*	
	static final float SmoothFactorCompass = 0.5f;
	static final float SmoothThresholdCompass = 30.0f;
	float oldCompass = 0.0f;
	
	private float smoothValues (float newCompass){
	    if (Math.abs(newCompass - oldCompass) < 180) {
	        if (Math.abs(newCompass - oldCompass) > SmoothThresholdCompass) {
	            oldCompass = newCompass;
	        }
	        else {
	            oldCompass = oldCompass + SmoothFactorCompass * (newCompass - oldCompass);
	        }
	    }
	    else {
	        if (360.0 - Math.abs(newCompass - oldCompass) > SmoothThresholdCompass) {
	            oldCompass = newCompass;
	        }
	        else {
	            if (oldCompass > newCompass) {
	                oldCompass = (oldCompass + SmoothFactorCompass * ((360 + newCompass - oldCompass) % 360) + 360) % 360;
	            } 
	            else {
	                oldCompass = (oldCompass - SmoothFactorCompass * ((360 - newCompass + oldCompass) % 360) + 360) % 360;
	            }
	        }
	    }
	    return oldCompass;
	}
*/	
}
