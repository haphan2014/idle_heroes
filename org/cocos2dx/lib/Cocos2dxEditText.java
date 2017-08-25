package org.cocos2dx.lib;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.EditText;

public class Cocos2dxEditText extends EditText {
    private Cocos2dxGLSurfaceView mCocos2dxGLSurfaceView;

    public Cocos2dxEditText(Context context) {
        super(context);
    }

    public Cocos2dxEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Cocos2dxEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setCocos2dxGLSurfaceView(Cocos2dxGLSurfaceView pCocos2dxGLSurfaceView) {
        this.mCocos2dxGLSurfaceView = pCocos2dxGLSurfaceView;
    }

    public boolean onKeyDown(int pKeyCode, KeyEvent pKeyEvent) {
        super.onKeyDown(pKeyCode, pKeyEvent);
        if (pKeyCode == 4) {
            this.mCocos2dxGLSurfaceView.requestFocus();
        }
        return true;
    }
}
