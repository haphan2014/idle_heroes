package org.cocos2dx.lib;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build.VERSION;
import android.view.WindowManager;

public class Cocos2dxAccelerometer implements SensorEventListener {
    private static final String TAG = Cocos2dxAccelerometer.class.getSimpleName();
    private final Sensor mAccelerometer = this.mSensorManager.getDefaultSensor(1);
    private final Context mContext;
    private final int mNaturalOrientation = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getOrientation();
    private final SensorManager mSensorManager = ((SensorManager) this.mContext.getSystemService("sensor"));

    public static native void onSensorChanged(float f, float f2, float f3, long j);

    public Cocos2dxAccelerometer(Context pContext) {
        this.mContext = pContext;
    }

    public void enable() {
        this.mSensorManager.registerListener(this, this.mAccelerometer, 1);
    }

    public void setInterval(float interval) {
        if (VERSION.SDK_INT < 11) {
            this.mSensorManager.registerListener(this, this.mAccelerometer, 1);
        } else {
            this.mSensorManager.registerListener(this, this.mAccelerometer, (int) (100000.0f * interval));
        }
    }

    public void disable() {
        this.mSensorManager.unregisterListener(this);
    }

    public void onSensorChanged(SensorEvent pSensorEvent) {
        if (pSensorEvent.sensor.getType() == 1) {
            float x = pSensorEvent.values[0];
            float y = pSensorEvent.values[1];
            float z = pSensorEvent.values[2];
            int orientation = this.mContext.getResources().getConfiguration().orientation;
            float tmp;
            if (orientation == 2 && this.mNaturalOrientation != 0) {
                tmp = x;
                x = -y;
                y = tmp;
            } else if (orientation == 1 && this.mNaturalOrientation != 0) {
                tmp = x;
                x = y;
                y = -tmp;
            }
            Cocos2dxGLSurfaceView.queueAccelerometer(x, y, z, pSensorEvent.timestamp);
        }
    }

    public void onAccuracyChanged(Sensor pSensor, int pAccuracy) {
    }
}
