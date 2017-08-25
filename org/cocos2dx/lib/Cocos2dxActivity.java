package org.cocos2dx.lib;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import org.cocos2dx.lib.Cocos2dxHandler.DialogMessage;
import org.cocos2dx.lib.Cocos2dxHandler.EditBoxMessage;
import org.cocos2dx.lib.Cocos2dxHelper.Cocos2dxHelperListener;
import org.cocos2dx.utils.PSNative;
import org.cocos2dx.utils.PSNetwork;

public abstract class Cocos2dxActivity extends Activity implements Cocos2dxHelperListener {
    public static final int GLVIEW_ID = 1000;
    private static final String TAG = Cocos2dxActivity.class.getSimpleName();
    protected static FrameLayout mFrameLayout;
    private static Context sContext = null;
    protected Cocos2dxGLSurfaceView mGLSurfaceView;
    private Cocos2dxHandler mHandler;

    public static Context getContext() {
        return sContext;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sContext = this;
        this.mHandler = new Cocos2dxHandler(this);
        init();
        Cocos2dxHelper.init(this, this);
        PSNetwork.init(this);
        PSNative.init(this);
    }

    protected void onResume() {
        super.onResume();
        Cocos2dxHelper.onResume();
        this.mGLSurfaceView.onResume();
    }

    protected void onPause() {
        super.onPause();
        Cocos2dxHelper.onPause();
        this.mGLSurfaceView.onPause();
    }

    public void showDialog(String pTitle, String pMessage) {
        Message msg = new Message();
        msg.what = 1;
        msg.obj = new DialogMessage(pTitle, pMessage);
        this.mHandler.sendMessage(msg);
    }

    public void showEditTextDialog(String pTitle, String pContent, int pInputMode, int pInputFlag, int pReturnType, int pMaxLength) {
        Message msg = new Message();
        msg.what = 2;
        msg.obj = new EditBoxMessage(pTitle, pContent, pInputMode, pInputFlag, pReturnType, pMaxLength);
        this.mHandler.sendMessage(msg);
    }

    public void runOnGLThread(Runnable pRunnable) {
        this.mGLSurfaceView.queueEvent(pRunnable);
    }

    public void init() {
        LayoutParams framelayout_params = new LayoutParams(-1, -1);
        mFrameLayout = new FrameLayout(this);
        mFrameLayout.setLayoutParams(framelayout_params);
        LayoutParams edittext_layout_params = new LayoutParams(-1, -2);
        Cocos2dxEditText edittext = new Cocos2dxEditText(this);
        edittext.setLayoutParams(edittext_layout_params);
        mFrameLayout.addView(edittext);
        this.mGLSurfaceView = onCreateView();
        this.mGLSurfaceView.setId(1000);
        mFrameLayout.addView(this.mGLSurfaceView);
        if (isAndroidEmulator()) {
            this.mGLSurfaceView.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        }
        this.mGLSurfaceView.setCocos2dxRenderer(new Cocos2dxRenderer());
        this.mGLSurfaceView.setCocos2dxEditText(edittext);
        setContentView(mFrameLayout);
    }

    public Cocos2dxGLSurfaceView onCreateView() {
        return new Cocos2dxGLSurfaceView(this);
    }

    private static final boolean isAndroidEmulator() {
        Log.d(TAG, "model=" + Build.MODEL);
        String product = Build.PRODUCT;
        Log.d(TAG, "product=" + product);
        boolean isEmulator = false;
        if (product != null) {
            isEmulator = product.equals("sdk") || product.contains("_sdk") || product.contains("sdk_");
        }
        Log.d(TAG, "isEmulator=" + isEmulator);
        return isEmulator;
    }
}
