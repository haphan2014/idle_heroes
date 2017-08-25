package org.cocos2dx.utils;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Vibrator;
import android.telephony.TelephonyManager;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import java.util.Vector;
import org.cocos2dx.lib.Cocos2dxActivity;
import org.cocos2dx.utils.PSDialog.PSDialogListener;

public class PSNative {
    static Drawable mAppIcon = null;
    static Cocos2dxActivity mContext = null;
    static PSDialog mCreatingDialog = null;
    static Dialog mIndicatorDialog = null;
    static PSDialogListener mPSDialogListener = new C19481();
    static ProgressBar mProgressBar = null;
    static PSDialog mShowingDialog = null;
    static Vector<PSDialog> mShowingDialogs = null;
    static TelephonyManager mTelephonyManager = null;
    static Vibrator mVibrator = null;

    static class C19481 implements PSDialogListener {
        C19481() {
        }

        public void onDismiss(PSDialog dialog) {
            PSNative.showPreAlert();
        }
    }

    static class C19514 implements Runnable {
        C19514() {
        }

        public void run() {
            if (PSNative.mShowingDialog != null && PSNative.mShowingDialog.isShowing()) {
                PSNative.mShowingDialogs.add(PSNative.mShowingDialog);
                PSNative.mShowingDialog.hide();
            }
            PSNative.mCreatingDialog.show();
            PSNative.mShowingDialog = PSNative.mCreatingDialog;
            PSNative.mCreatingDialog = null;
        }
    }

    static class C19536 implements Runnable {
        C19536() {
        }

        public void run() {
            PSNative.mShowingDialog.dismiss();
            PSNative.mShowingDialog = null;
        }
    }

    static class C19547 implements Runnable {
        C19547() {
        }

        public void run() {
            PSNative.mIndicatorDialog = new Dialog(PSNative.mContext);
            PSNative.mIndicatorDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            PSNative.mIndicatorDialog.requestWindowFeature(1);
            ProgressBar pb = new ProgressBar(PSNative.mContext);
            LayoutParams lp = new LayoutParams(-2, -2);
            lp.addRule(13, -1);
            PSNative.mIndicatorDialog.addContentView(pb, lp);
            PSNative.mIndicatorDialog.show();
        }
    }

    public static void init(Cocos2dxActivity context) {
        mContext = context;
        mTelephonyManager = (TelephonyManager) context.getSystemService("phone");
        mVibrator = (Vibrator) context.getSystemService("vibrator");
        mShowingDialogs = new Vector();
    }

    public static void setAppIcon(Drawable icon) {
        mAppIcon = icon;
    }

    public static void createAlert(final String title, final String message, final Vector<String> buttonTitles, final int listener) {
        if (mContext != null) {
            mContext.runOnUiThread(new Runnable() {
                public void run() {
                    PSNative.mCreatingDialog = new PSDialog(PSNative.mContext).setCancelable(false).setMessage(message).setTitle(title).setLuaListener(listener).setListener(PSNative.mPSDialogListener).setIcon(PSNative.mAppIcon);
                    for (int i = 0; i < buttonTitles.size(); i++) {
                        PSNative.addAlertButton((String) buttonTitles.get(i));
                    }
                    if (PSNative.mShowingDialog != null && PSNative.mShowingDialog.isShowing()) {
                        PSNative.mShowingDialogs.add(PSNative.mShowingDialog);
                        PSNative.mShowingDialog.hide();
                    }
                    PSNative.mCreatingDialog.show();
                    PSNative.mShowingDialog = PSNative.mCreatingDialog;
                    PSNative.mCreatingDialog = null;
                }
            });
        }
    }

    @Deprecated
    public static void createAlert(final String title, final String message, final String defalutButtonTitle, final int listener) {
        if (mContext != null) {
            mContext.runOnUiThread(new Runnable() {
                public void run() {
                    PSNative.mCreatingDialog = new PSDialog(PSNative.mContext).setCancelable(false).setMessage(message).setTitle(title).setLuaListener(listener).setListener(PSNative.mPSDialogListener);
                    PSNative.addAlertButton(defalutButtonTitle);
                    if (PSNative.mShowingDialog != null && PSNative.mShowingDialog.isShowing()) {
                        PSNative.mShowingDialogs.add(PSNative.mShowingDialog);
                        PSNative.mShowingDialog.hide();
                    }
                    PSNative.mCreatingDialog.show();
                    PSNative.mShowingDialog = PSNative.mCreatingDialog;
                    PSNative.mCreatingDialog = null;
                }
            });
        }
    }

    public static int addAlertButton(String buttonTitle) {
        if (mCreatingDialog == null) {
            return 0;
        }
        return mCreatingDialog.addAlertButton(buttonTitle);
    }

    public static void showAlert() {
        if (mCreatingDialog != null) {
            mContext.runOnUiThread(new C19514());
        }
    }

    public static void showAlertLua(final int luaFunctionId) {
        if (mCreatingDialog != null) {
            mContext.runOnGLThread(new Runnable() {
                public void run() {
                    PSNative.mCreatingDialog.setLuaListener(luaFunctionId);
                    PSNative.showAlert();
                }
            });
        }
    }

    public static void cancelAlert() {
        if (mShowingDialog != null) {
            mContext.runOnUiThread(new C19536());
        }
    }

    public static void showPreAlert() {
        if (mShowingDialogs.size() > 0) {
            mShowingDialog = (PSDialog) mShowingDialogs.firstElement();
            mShowingDialogs.remove(0);
            mShowingDialog.show();
            return;
        }
        mShowingDialog = null;
    }

    public static void openURL(String url) {
        if (mContext != null) {
            mContext.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)));
        }
    }

    public static String getInputText(String title, String message, String defaultValue) {
        return "";
    }

    private static String getMacAddress() {
        WifiInfo info = ((WifiManager) mContext.getSystemService("wifi")).getConnectionInfo();
        if (info == null) {
            return null;
        }
        return info.getMacAddress();
    }

    public static String getOpenUDID() {
        String id = null;
        if (mTelephonyManager != null) {
            id = mTelephonyManager.getDeviceId();
        }
        if (id == null) {
            id = getMacAddress();
        }
        if (id == null) {
            return "";
        }
        return id;
    }

    public static String getDeviceName() {
        return Build.USER;
    }

    public static void vibrate(int time) {
        if (mVibrator != null) {
            mVibrator.vibrate((long) time);
        }
    }

    public static void vibrate(long[] pattern, int repeatcout) {
        if (mVibrator != null) {
            mVibrator.vibrate(pattern, repeatcout);
        }
    }

    public static Context getAppContext() {
        return mContext;
    }

    public static void showActivityIndicator() {
        if (mIndicatorDialog == null) {
            mContext.runOnUiThread(new C19547());
        }
    }

    public static void hideActivityIndicator() {
        if (mIndicatorDialog != null) {
            mIndicatorDialog.dismiss();
            mIndicatorDialog = null;
        }
    }
}
