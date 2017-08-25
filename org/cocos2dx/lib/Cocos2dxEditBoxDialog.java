package org.cocos2dx.lib;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.widget.ExploreByTouchHelper;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.google.android.gms.drive.DriveFile;

public class Cocos2dxEditBoxDialog extends Dialog {
    private final int kEditBoxInputFlagInitialCapsAllCharacters = 4;
    private final int kEditBoxInputFlagInitialCapsSentence = 3;
    private final int kEditBoxInputFlagInitialCapsWord = 2;
    private final int kEditBoxInputFlagPassword = 0;
    private final int kEditBoxInputFlagSensitive = 1;
    private final int kEditBoxInputModeAny = 0;
    private final int kEditBoxInputModeDecimal = 5;
    private final int kEditBoxInputModeEmailAddr = 1;
    private final int kEditBoxInputModeNumeric = 2;
    private final int kEditBoxInputModePhoneNumber = 3;
    private final int kEditBoxInputModeSingleLine = 6;
    private final int kEditBoxInputModeUrl = 4;
    private final int kKeyboardReturnTypeDefault = 0;
    private final int kKeyboardReturnTypeDone = 1;
    private final int kKeyboardReturnTypeGo = 4;
    private final int kKeyboardReturnTypeSearch = 3;
    private final int kKeyboardReturnTypeSend = 2;
    private EditText mInputEditText;
    private final int mInputFlag;
    private int mInputFlagConstraints;
    private final int mInputMode;
    private int mInputModeContraints;
    private boolean mIsMultiline;
    private final int mMaxLength;
    private final String mMessage;
    private final int mReturnType;
    private TextView mTextViewTitle;
    private final String mTitle;

    class C19331 implements Runnable {
        C19331() {
        }

        public void run() {
            Cocos2dxEditBoxDialog.this.mInputEditText.requestFocus();
            Cocos2dxEditBoxDialog.this.mInputEditText.setSelection(Cocos2dxEditBoxDialog.this.mInputEditText.length());
            Cocos2dxEditBoxDialog.this.openKeyboard();
        }
    }

    class C19342 implements OnEditorActionListener {
        C19342() {
        }

        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            if (actionId == 0 && (actionId != 0 || event == null || event.getAction() != 0)) {
                return false;
            }
            Cocos2dxHelper.setEditTextDialogResult(Cocos2dxEditBoxDialog.this.mInputEditText.getText().toString());
            Cocos2dxEditBoxDialog.this.closeKeyboard();
            Cocos2dxEditBoxDialog.this.dismiss();
            return true;
        }
    }

    public Cocos2dxEditBoxDialog(Context pContext, String pTitle, String pMessage, int pInputMode, int pInputFlag, int pReturnType, int pMaxLength) {
        super(pContext, 16973841);
        this.mTitle = pTitle;
        this.mMessage = pMessage;
        this.mInputMode = pInputMode;
        this.mInputFlag = pInputFlag;
        this.mReturnType = pReturnType;
        this.mMaxLength = pMaxLength;
    }

    protected void onCreate(Bundle pSavedInstanceState) {
        super.onCreate(pSavedInstanceState);
        getWindow().setBackgroundDrawable(new ColorDrawable(ExploreByTouchHelper.INVALID_ID));
        LinearLayout layout = new LinearLayout(getContext());
        layout.setOrientation(1);
        LayoutParams layoutParams = new LayoutParams(-1, -1);
        this.mTextViewTitle = new TextView(getContext());
        LayoutParams textviewParams = new LayoutParams(-2, -2);
        int convertDipsToPixels = convertDipsToPixels(10.0f);
        textviewParams.rightMargin = convertDipsToPixels;
        textviewParams.leftMargin = convertDipsToPixels;
        this.mTextViewTitle.setTextSize(1, 20.0f);
        layout.addView(this.mTextViewTitle, textviewParams);
        this.mInputEditText = new EditText(getContext());
        LayoutParams editTextParams = new LayoutParams(-1, -2);
        convertDipsToPixels = convertDipsToPixels(10.0f);
        editTextParams.rightMargin = convertDipsToPixels;
        editTextParams.leftMargin = convertDipsToPixels;
        layout.addView(this.mInputEditText, editTextParams);
        setContentView(layout, layoutParams);
        getWindow().addFlags(1024);
        this.mTextViewTitle.setText(this.mTitle);
        this.mInputEditText.setText(this.mMessage);
        this.mInputEditText.setImeOptions(DriveFile.MODE_READ_ONLY | this.mInputEditText.getImeOptions());
        int oldImeOptions = this.mInputEditText.getImeOptions();
        switch (this.mInputMode) {
            case 0:
                this.mInputModeContraints = 131073;
                break;
            case 1:
                this.mInputModeContraints = 33;
                break;
            case 2:
                this.mInputModeContraints = 4098;
                break;
            case 3:
                this.mInputModeContraints = 3;
                break;
            case 4:
                this.mInputModeContraints = 17;
                break;
            case 5:
                this.mInputModeContraints = 12290;
                break;
            case 6:
                this.mInputModeContraints = 1;
                break;
        }
        if (this.mIsMultiline) {
            this.mInputModeContraints |= 131072;
        }
        this.mInputEditText.setInputType(this.mInputModeContraints | this.mInputFlagConstraints);
        switch (this.mInputFlag) {
            case 0:
                this.mInputFlagConstraints = 129;
                break;
            case 1:
                this.mInputFlagConstraints = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
                break;
            case 2:
                this.mInputFlagConstraints = 8192;
                break;
            case 3:
                this.mInputFlagConstraints = 16384;
                break;
            case 4:
                this.mInputFlagConstraints = 4096;
                break;
        }
        this.mInputEditText.setInputType(this.mInputFlagConstraints | this.mInputModeContraints);
        switch (this.mReturnType) {
            case 0:
                this.mInputEditText.setImeOptions(oldImeOptions | 1);
                break;
            case 1:
                this.mInputEditText.setImeOptions(oldImeOptions | 6);
                break;
            case 2:
                this.mInputEditText.setImeOptions(oldImeOptions | 4);
                break;
            case 3:
                this.mInputEditText.setImeOptions(oldImeOptions | 3);
                break;
            case 4:
                this.mInputEditText.setImeOptions(oldImeOptions | 2);
                break;
            default:
                this.mInputEditText.setImeOptions(oldImeOptions | 1);
                break;
        }
        if (this.mMaxLength > 0) {
            this.mInputEditText.setFilters(new InputFilter[]{new LengthFilter(this.mMaxLength)});
        }
        new Handler().postDelayed(new C19331(), 200);
        this.mInputEditText.setOnEditorActionListener(new C19342());
    }

    private int convertDipsToPixels(float pDIPs) {
        return Math.round(pDIPs * getContext().getResources().getDisplayMetrics().density);
    }

    private void openKeyboard() {
        ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this.mInputEditText, 0);
    }

    private void closeKeyboard() {
        ((InputMethodManager) getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.mInputEditText.getWindowToken(), 0);
    }
}
