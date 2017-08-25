package org.cocos2dx.lib;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public class Cocos2dxTextInputWraper implements TextWatcher, OnEditorActionListener {
    private static final String TAG = Cocos2dxTextInputWraper.class.getSimpleName();
    private final Cocos2dxGLSurfaceView mCocos2dxGLSurfaceView;
    private String mOriginText;
    private String mText;

    public Cocos2dxTextInputWraper(Cocos2dxGLSurfaceView pCocos2dxGLSurfaceView) {
        this.mCocos2dxGLSurfaceView = pCocos2dxGLSurfaceView;
    }

    private boolean isFullScreenEdit() {
        return ((InputMethodManager) this.mCocos2dxGLSurfaceView.getCocos2dxEditText().getContext().getSystemService("input_method")).isFullscreenMode();
    }

    public void setOriginText(String pOriginText) {
        this.mOriginText = pOriginText;
    }

    public void afterTextChanged(Editable s) {
        if (!isFullScreenEdit()) {
            int nModified = s.length() - this.mText.length();
            if (nModified > 0) {
                this.mCocos2dxGLSurfaceView.insertText(s.subSequence(this.mText.length(), s.length()).toString());
            } else {
                while (nModified < 0) {
                    this.mCocos2dxGLSurfaceView.deleteBackward();
                    nModified++;
                }
            }
            this.mText = s.toString();
        }
    }

    public void beforeTextChanged(CharSequence pCharSequence, int start, int count, int after) {
        this.mText = pCharSequence.toString();
    }

    public void onTextChanged(CharSequence pCharSequence, int start, int before, int count) {
    }

    public boolean onEditorAction(TextView pTextView, int pActionID, KeyEvent pKeyEvent) {
        if (this.mCocos2dxGLSurfaceView.getCocos2dxEditText() == pTextView && isFullScreenEdit()) {
            for (int i = this.mOriginText.length(); i > 0; i--) {
                this.mCocos2dxGLSurfaceView.deleteBackward();
            }
            String text = pTextView.getText().toString();
            if (text.compareTo("") == 0) {
                text = "\n";
            }
            if ('\n' != text.charAt(text.length() - 1)) {
                text = text + '\n';
            }
            this.mCocos2dxGLSurfaceView.insertText(text);
        }
        if (pActionID == 6) {
            this.mCocos2dxGLSurfaceView.requestFocus();
        }
        return false;
    }
}
