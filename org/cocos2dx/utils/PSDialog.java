package org.cocos2dx.utils;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.drawable.Drawable;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import org.cocos2dx.lib.Cocos2dxActivity;
import org.cocos2dx.lib.Cocos2dxLuaJavaBridge;
import org.json.JSONObject;

public class PSDialog {
    private Vector<String> mButtonLabels = new Vector();
    private boolean mCancelable = true;
    private Cocos2dxActivity mContext = null;
    private AlertDialog mDialog = null;
    private OnClickListener mDialogClickListener = null;
    private int mDialogLuaListener = 0;
    private Drawable mIcon = null;
    private String mMessage = null;
    private PSDialogListener mPSDialogListener = null;
    private String mTitle = null;

    class C19471 implements OnClickListener {
        C19471() {
        }

        public void onClick(DialogInterface dialog, final int which) {
            if (PSDialog.this.mDialogLuaListener != 0) {
                PSDialog.this.mContext.runOnGLThread(new Runnable() {
                    public void run() {
                        Map<String, String> map = new HashMap();
                        map.put("buttonIndex", String.valueOf(-which));
                        System.out.println(-which);
                        Cocos2dxLuaJavaBridge.callLuaFunctionWithString(PSDialog.this.mDialogLuaListener, new JSONObject(map).toString());
                        Cocos2dxLuaJavaBridge.releaseLuaFunction(PSDialog.this.mDialogLuaListener);
                    }
                });
            }
            PSDialog.this.dismiss();
        }
    }

    public interface PSDialogListener {
        void onDismiss(PSDialog pSDialog);
    }

    public PSDialog(Cocos2dxActivity context) {
        this.mContext = context;
        this.mDialogClickListener = new C19471();
    }

    public PSDialog setListener(PSDialogListener listener) {
        this.mPSDialogListener = listener;
        return this;
    }

    public PSDialog setCancelable(boolean flag) {
        this.mCancelable = flag;
        return this;
    }

    public PSDialog setTitle(String title) {
        this.mTitle = title;
        return this;
    }

    public PSDialog setMessage(String msg) {
        this.mMessage = msg;
        return this;
    }

    public PSDialog setLuaListener(int listener) {
        this.mDialogLuaListener = listener;
        return this;
    }

    public PSDialog setIcon(Drawable icon) {
        this.mIcon = icon;
        return this;
    }

    public int getButtonsCount() {
        return this.mButtonLabels.size();
    }

    public int addAlertButton(String buttonTitle) {
        if (this.mButtonLabels.size() >= 3) {
            return this.mButtonLabels.size();
        }
        this.mButtonLabels.add(buttonTitle);
        return this.mButtonLabels.size();
    }

    public boolean isShowing() {
        if (this.mDialog == null) {
            return false;
        }
        return this.mDialog.isShowing();
    }

    public void hide() {
        if (this.mDialog != null && isShowing()) {
            this.mDialog.dismiss();
            this.mDialog = null;
        }
    }

    public void dismiss() {
        if (this.mDialog != null && isShowing()) {
            this.mDialog.dismiss();
            if (this.mPSDialogListener != null) {
                this.mPSDialogListener.onDismiss(this);
            }
            this.mDialog = null;
        }
    }

    public void show() {
        if (this.mDialog == null || !isShowing()) {
            this.mDialog = new Builder(this.mContext).setCancelable(this.mCancelable).setTitle(this.mTitle).setMessage(this.mMessage).create();
            if (!(this.mTitle == null || this.mTitle.length() <= 0 || this.mIcon == null)) {
                this.mDialog.setIcon(this.mIcon);
            }
            for (int i = 0; i < this.mButtonLabels.size(); i++) {
                switch (i) {
                    case 0:
                        this.mDialog.setButton((CharSequence) this.mButtonLabels.elementAt(i), this.mDialogClickListener);
                        break;
                    case 1:
                        this.mDialog.setButton2((CharSequence) this.mButtonLabels.elementAt(i), this.mDialogClickListener);
                        break;
                    case 2:
                        this.mDialog.setButton3((CharSequence) this.mButtonLabels.elementAt(i), this.mDialogClickListener);
                        break;
                    default:
                        break;
                }
            }
            this.mDialog.show();
            return;
        }
        this.mDialog.dismiss();
    }
}
