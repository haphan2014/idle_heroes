package org.cocos2dx.lib;

import android.opengl.GLSurfaceView.Renderer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class Cocos2dxRenderer implements Renderer {
    private static final long NANOSECONDSPERMICROSECOND = 1000000;
    private static final long NANOSECONDSPERSECOND = 1000000000;
    private static long sAnimationInterval = 16666666;
    private long mLastTickInNanoSeconds;
    private int mScreenHeight;
    private int mScreenWidth;

    private static native void nativeDeleteBackward();

    private static native String nativeGetContentText();

    private static native void nativeInit(int i, int i2);

    private static native void nativeInsertText(String str);

    private static native boolean nativeKeyDown(int i);

    private static native void nativeOnPause();

    private static native void nativeOnResume();

    private static native void nativeRender();

    private static native void nativeTouchesBegin(int i, float f, float f2);

    private static native void nativeTouchesCancel(int[] iArr, float[] fArr, float[] fArr2);

    private static native void nativeTouchesEnd(int i, float f, float f2);

    private static native void nativeTouchesMove(int[] iArr, float[] fArr, float[] fArr2);

    public static void setAnimationInterval(double pAnimationInterval) {
        sAnimationInterval = (long) (1.0E9d * pAnimationInterval);
    }

    public void setScreenWidthAndHeight(int pSurfaceWidth, int pSurfaceHeight) {
        this.mScreenWidth = pSurfaceWidth;
        this.mScreenHeight = pSurfaceHeight;
    }

    public void onSurfaceCreated(GL10 pGL10, EGLConfig pEGLConfig) {
        nativeInit(this.mScreenWidth, this.mScreenHeight);
        this.mLastTickInNanoSeconds = System.nanoTime();
    }

    public void onSurfaceChanged(GL10 pGL10, int pWidth, int pHeight) {
    }

    public void onDrawFrame(GL10 gl) {
        if (((double) sAnimationInterval) <= 1.6666666666666666E7d) {
            nativeRender();
            return;
        }
        long remain = (this.mLastTickInNanoSeconds + sAnimationInterval) - System.nanoTime();
        if (remain > 0) {
            try {
                Thread.sleep(remain / NANOSECONDSPERMICROSECOND);
            } catch (Exception e) {
            }
        }
        this.mLastTickInNanoSeconds = System.nanoTime();
        nativeRender();
    }

    public void handleActionDown(int pID, float pX, float pY) {
        nativeTouchesBegin(pID, pX, pY);
    }

    public void handleActionUp(int pID, float pX, float pY) {
        nativeTouchesEnd(pID, pX, pY);
    }

    public void handleActionCancel(int[] pIDs, float[] pXs, float[] pYs) {
        nativeTouchesCancel(pIDs, pXs, pYs);
    }

    public void handleActionMove(int[] pIDs, float[] pXs, float[] pYs) {
        nativeTouchesMove(pIDs, pXs, pYs);
    }

    public void handleKeyDown(int pKeyCode) {
        nativeKeyDown(pKeyCode);
    }

    public void handleOnPause() {
        nativeOnPause();
    }

    public void handleOnResume() {
        nativeOnResume();
    }

    public void handleInsertText(String pText) {
        nativeInsertText(pText);
    }

    public void handleDeleteBackward() {
        nativeDeleteBackward();
    }

    public String getContentText() {
        return nativeGetContentText();
    }
}
