package org.cocos2dx.lib;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.inputmethod.InputMethodManager;
import com.google.android.gms.location.places.Place;

public class Cocos2dxGLSurfaceView extends GLSurfaceView {
    private static final int HANDLER_CLOSE_IME_KEYBOARD = 3;
    private static final int HANDLER_OPEN_IME_KEYBOARD = 2;
    private static final String TAG = Cocos2dxGLSurfaceView.class.getSimpleName();
    private static Cocos2dxGLSurfaceView mCocos2dxGLSurfaceView;
    private static Cocos2dxTextInputWraper sCocos2dxTextInputWraper;
    private static Handler sHandler;
    private Cocos2dxEditText mCocos2dxEditText;
    private Cocos2dxRenderer mCocos2dxRenderer;

    class C19351 extends Handler {
        C19351() {
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 2:
                    if (Cocos2dxGLSurfaceView.this.mCocos2dxEditText != null && Cocos2dxGLSurfaceView.this.mCocos2dxEditText.requestFocus()) {
                        Cocos2dxGLSurfaceView.this.mCocos2dxEditText.removeTextChangedListener(Cocos2dxGLSurfaceView.sCocos2dxTextInputWraper);
                        Cocos2dxGLSurfaceView.this.mCocos2dxEditText.setText("");
                        String text = msg.obj;
                        Cocos2dxGLSurfaceView.this.mCocos2dxEditText.append(text);
                        Cocos2dxGLSurfaceView.sCocos2dxTextInputWraper.setOriginText(text);
                        Cocos2dxGLSurfaceView.this.mCocos2dxEditText.addTextChangedListener(Cocos2dxGLSurfaceView.sCocos2dxTextInputWraper);
                        ((InputMethodManager) Cocos2dxGLSurfaceView.mCocos2dxGLSurfaceView.getContext().getSystemService("input_method")).showSoftInput(Cocos2dxGLSurfaceView.this.mCocos2dxEditText, 0);
                        Log.d("GLSurfaceView", "showSoftInput");
                        return;
                    }
                    return;
                case 3:
                    if (Cocos2dxGLSurfaceView.this.mCocos2dxEditText != null) {
                        Cocos2dxGLSurfaceView.this.mCocos2dxEditText.removeTextChangedListener(Cocos2dxGLSurfaceView.sCocos2dxTextInputWraper);
                        ((InputMethodManager) Cocos2dxGLSurfaceView.mCocos2dxGLSurfaceView.getContext().getSystemService("input_method")).hideSoftInputFromWindow(Cocos2dxGLSurfaceView.this.mCocos2dxEditText.getWindowToken(), 0);
                        Cocos2dxGLSurfaceView.this.requestFocus();
                        Log.d("GLSurfaceView", "HideSoftInput");
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    class C19373 implements Runnable {
        C19373() {
        }

        public void run() {
            Cocos2dxGLSurfaceView.this.mCocos2dxRenderer.handleOnResume();
        }
    }

    class C19384 implements Runnable {
        C19384() {
        }

        public void run() {
            Cocos2dxGLSurfaceView.this.mCocos2dxRenderer.handleOnPause();
        }
    }

    public Cocos2dxGLSurfaceView(Context context) {
        super(context);
        initView();
    }

    public Cocos2dxGLSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    protected void initView() {
        setEGLContextClientVersion(2);
        setFocusableInTouchMode(true);
        mCocos2dxGLSurfaceView = this;
        sCocos2dxTextInputWraper = new Cocos2dxTextInputWraper(this);
        sHandler = new C19351();
    }

    public static Cocos2dxGLSurfaceView getInstance() {
        return mCocos2dxGLSurfaceView;
    }

    public static void queueAccelerometer(float x, float y, float z, long timestamp) {
        final float f = x;
        final float f2 = y;
        final float f3 = z;
        final long j = timestamp;
        mCocos2dxGLSurfaceView.queueEvent(new Runnable() {
            public void run() {
                Cocos2dxAccelerometer.onSensorChanged(f, f2, f3, j);
            }
        });
    }

    public void setCocos2dxRenderer(Cocos2dxRenderer renderer) {
        this.mCocos2dxRenderer = renderer;
        setRenderer(this.mCocos2dxRenderer);
    }

    private String getContentText() {
        return this.mCocos2dxRenderer.getContentText();
    }

    public Cocos2dxEditText getCocos2dxEditText() {
        return this.mCocos2dxEditText;
    }

    public void setCocos2dxEditText(Cocos2dxEditText pCocos2dxEditText) {
        this.mCocos2dxEditText = pCocos2dxEditText;
        if (this.mCocos2dxEditText != null && sCocos2dxTextInputWraper != null) {
            this.mCocos2dxEditText.setOnEditorActionListener(sCocos2dxTextInputWraper);
            this.mCocos2dxEditText.setCocos2dxGLSurfaceView(this);
            requestFocus();
        }
    }

    public void onResume() {
        super.onResume();
        setRenderMode(1);
        queueEvent(new C19373());
    }

    public void onPause() {
        queueEvent(new C19384());
        setRenderMode(0);
    }

    public boolean onTouchEvent(MotionEvent pMotionEvent) {
        int pointerNumber = pMotionEvent.getPointerCount();
        final int[] ids = new int[pointerNumber];
        float[] xs = new float[pointerNumber];
        float[] ys = new float[pointerNumber];
        for (int i = 0; i < pointerNumber; i++) {
            ids[i] = pMotionEvent.getPointerId(i);
            xs[i] = pMotionEvent.getX(i);
            ys[i] = pMotionEvent.getY(i);
        }
        final float f;
        final float[] fArr;
        final float[] fArr2;
        switch (pMotionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
            case 0:
                final int idDown = pMotionEvent.getPointerId(0);
                final float xDown = xs[0];
                f = ys[0];
                queueEvent(new Runnable() {
                    public void run() {
                        Cocos2dxGLSurfaceView.this.mCocos2dxRenderer.handleActionDown(idDown, xDown, f);
                    }
                });
                break;
            case 1:
                final int idUp = pMotionEvent.getPointerId(0);
                f = xs[0];
                final float f2 = ys[0];
                queueEvent(new Runnable() {
                    public void run() {
                        Cocos2dxGLSurfaceView.this.mCocos2dxRenderer.handleActionUp(idUp, f, f2);
                    }
                });
                break;
            case 2:
                fArr = xs;
                fArr2 = ys;
                queueEvent(new Runnable() {
                    public void run() {
                        Cocos2dxGLSurfaceView.this.mCocos2dxRenderer.handleActionMove(ids, fArr, fArr2);
                    }
                });
                break;
            case 3:
                fArr = xs;
                fArr2 = ys;
                queueEvent(new Runnable() {
                    public void run() {
                        Cocos2dxGLSurfaceView.this.mCocos2dxRenderer.handleActionCancel(ids, fArr, fArr2);
                    }
                });
                break;
            case 5:
                int indexPointerDown = pMotionEvent.getAction() >> 8;
                final int idPointerDown = pMotionEvent.getPointerId(indexPointerDown);
                final float xPointerDown = pMotionEvent.getX(indexPointerDown);
                f = pMotionEvent.getY(indexPointerDown);
                queueEvent(new Runnable() {
                    public void run() {
                        Cocos2dxGLSurfaceView.this.mCocos2dxRenderer.handleActionDown(idPointerDown, xPointerDown, f);
                    }
                });
                break;
            case 6:
                int indexPointUp = pMotionEvent.getAction() >> 8;
                final int idPointerUp = pMotionEvent.getPointerId(indexPointUp);
                final float xPointerUp = pMotionEvent.getX(indexPointUp);
                f = pMotionEvent.getY(indexPointUp);
                queueEvent(new Runnable() {
                    public void run() {
                        Cocos2dxGLSurfaceView.this.mCocos2dxRenderer.handleActionUp(idPointerUp, xPointerUp, f);
                    }
                });
                break;
        }
        return true;
    }

    protected void onSizeChanged(int pNewSurfaceWidth, int pNewSurfaceHeight, int pOldSurfaceWidth, int pOldSurfaceHeight) {
        if (!isInEditMode()) {
            this.mCocos2dxRenderer.setScreenWidthAndHeight(pNewSurfaceWidth, pNewSurfaceHeight);
        }
    }

    public boolean onKeyDown(final int pKeyCode, KeyEvent pKeyEvent) {
        switch (pKeyCode) {
            case 4:
            case Place.TYPE_SCHOOL /*82*/:
                queueEvent(new Runnable() {
                    public void run() {
                        Cocos2dxGLSurfaceView.this.mCocos2dxRenderer.handleKeyDown(pKeyCode);
                    }
                });
                return true;
            default:
                return super.onKeyDown(pKeyCode, pKeyEvent);
        }
    }

    public static void openIMEKeyboard() {
        Message msg = new Message();
        msg.what = 2;
        msg.obj = mCocos2dxGLSurfaceView.getContentText();
        sHandler.sendMessage(msg);
    }

    public static void closeIMEKeyboard() {
        Message msg = new Message();
        msg.what = 3;
        sHandler.sendMessage(msg);
    }

    public void insertText(final String pText) {
        queueEvent(new Runnable() {
            public void run() {
                Cocos2dxGLSurfaceView.this.mCocos2dxRenderer.handleInsertText(pText);
            }
        });
    }

    public void deleteBackward() {
        queueEvent(new Runnable() {
            public void run() {
                Cocos2dxGLSurfaceView.this.mCocos2dxRenderer.handleDeleteBackward();
            }
        });
    }

    private static void dumpMotionEvent(MotionEvent event) {
        String[] names = new String[]{"DOWN", "UP", "MOVE", "CANCEL", "OUTSIDE", "POINTER_DOWN", "POINTER_UP", "7?", "8?", "9?"};
        StringBuilder sb = new StringBuilder();
        int action = event.getAction();
        int actionCode = action & MotionEventCompat.ACTION_MASK;
        sb.append("event ACTION_").append(names[actionCode]);
        if (actionCode == 5 || actionCode == 6) {
            sb.append("(pid ").append(action >> 8);
            sb.append(")");
        }
        sb.append("[");
        for (int i = 0; i < event.getPointerCount(); i++) {
            sb.append("#").append(i);
            sb.append("(pid ").append(event.getPointerId(i));
            sb.append(")=").append((int) event.getX(i));
            sb.append(",").append((int) event.getY(i));
            if (i + 1 < event.getPointerCount()) {
                sb.append(";");
            }
        }
        sb.append("]");
        Log.d(TAG, sb.toString());
    }
}
