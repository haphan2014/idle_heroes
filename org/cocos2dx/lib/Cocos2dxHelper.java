package org.cocos2dx.lib;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Process;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Locale;

public class Cocos2dxHelper {
    private static final String PREFS_NAME = "Cocos2dxPrefsFile";
    private static boolean sAccelerometerEnabled;
    private static AssetManager sAssetManager;
    private static Cocos2dxMusic sCocos2dMusic;
    private static Cocos2dxSound sCocos2dSound;
    private static Cocos2dxAccelerometer sCocos2dxAccelerometer;
    private static Cocos2dxHelperListener sCocos2dxHelperListener;
    private static Context sContext = null;
    private static String sFileDirectory;
    private static String sPackageName;

    public interface Cocos2dxHelperListener {
        void runOnGLThread(Runnable runnable);

        void showDialog(String str, String str2);

        void showEditTextDialog(String str, String str2, int i, int i2, int i3, int i4);
    }

    private static native void nativeSetApkPath(String str);

    private static native void nativeSetEditTextDialogResult(byte[] bArr);

    public static void init(Context pContext, Cocos2dxHelperListener pCocos2dxHelperListener) {
        ApplicationInfo applicationInfo = pContext.getApplicationInfo();
        sContext = pContext;
        sCocos2dxHelperListener = pCocos2dxHelperListener;
        sPackageName = applicationInfo.packageName;
        sFileDirectory = pContext.getFilesDir().getAbsolutePath();
        nativeSetApkPath(applicationInfo.sourceDir);
        sCocos2dxAccelerometer = new Cocos2dxAccelerometer(pContext);
        sCocos2dMusic = new Cocos2dxMusic(pContext);
        int simultaneousStreams = 5;
        if (getDeviceModel().indexOf("GT-I9100") != -1) {
            simultaneousStreams = 3;
        }
        sCocos2dSound = new Cocos2dxSound(pContext, simultaneousStreams);
        sAssetManager = pContext.getAssets();
        Cocos2dxBitmap.setContext(pContext);
        Cocos2dxETCLoader.setContext(pContext);
    }

    public static String getCocos2dxPackageName() {
        return sPackageName;
    }

    public static String getCocos2dxWritablePath() {
        return sFileDirectory;
    }

    public static String getCurrentLanguage() {
        String lan = Locale.getDefault().getLanguage();
        if (!lan.equals("zh")) {
            return lan;
        }
        if (Locale.getDefault().getCountry().toUpperCase().equals("TW")) {
            return lan + "-Hant";
        }
        return lan + "-Hans";
    }

    public static String getDeviceModel() {
        return Build.MODEL;
    }

    public static AssetManager getAssetManager() {
        return sAssetManager;
    }

    public static void enableAccelerometer() {
        sAccelerometerEnabled = true;
        sCocos2dxAccelerometer.enable();
    }

    public static void setAccelerometerInterval(float interval) {
        sCocos2dxAccelerometer.setInterval(interval);
    }

    public static void disableAccelerometer() {
        sAccelerometerEnabled = false;
        sCocos2dxAccelerometer.disable();
    }

    public static void preloadBackgroundMusic(String pPath) {
        sCocos2dMusic.preloadBackgroundMusic(pPath);
    }

    public static void playBackgroundMusic(String pPath, boolean isLoop) {
        sCocos2dMusic.playBackgroundMusic(pPath, isLoop);
    }

    public static void resumeBackgroundMusic() {
        sCocos2dMusic.resumeBackgroundMusic();
    }

    public static void pauseBackgroundMusic() {
        sCocos2dMusic.pauseBackgroundMusic();
    }

    public static void stopBackgroundMusic() {
        sCocos2dMusic.stopBackgroundMusic();
    }

    public static void rewindBackgroundMusic() {
        sCocos2dMusic.rewindBackgroundMusic();
    }

    public static boolean isBackgroundMusicPlaying() {
        return sCocos2dMusic.isBackgroundMusicPlaying();
    }

    public static float getBackgroundMusicVolume() {
        return sCocos2dMusic.getBackgroundVolume();
    }

    public static void setBackgroundMusicVolume(float volume) {
        sCocos2dMusic.setBackgroundVolume(volume);
    }

    public static void preloadEffect(String path) {
        sCocos2dSound.preloadEffect(path);
    }

    public static int playEffect(String path, boolean isLoop) {
        return sCocos2dSound.playEffect(path, isLoop);
    }

    public static void resumeEffect(int soundId) {
        sCocos2dSound.resumeEffect(soundId);
    }

    public static void pauseEffect(int soundId) {
        sCocos2dSound.pauseEffect(soundId);
    }

    public static void stopEffect(int soundId) {
        sCocos2dSound.stopEffect(soundId);
    }

    public static float getEffectsVolume() {
        return sCocos2dSound.getEffectsVolume();
    }

    public static void setEffectsVolume(float volume) {
        sCocos2dSound.setEffectsVolume(volume);
    }

    public static void unloadEffect(String path) {
        sCocos2dSound.unloadEffect(path);
    }

    public static void pauseAllEffects() {
        sCocos2dSound.pauseAllEffects();
    }

    public static void resumeAllEffects() {
        sCocos2dSound.resumeAllEffects();
    }

    public static void stopAllEffects() {
        sCocos2dSound.stopAllEffects();
    }

    public static void end() {
        sCocos2dMusic.end();
        sCocos2dSound.end();
    }

    public static void onResume() {
        if (sAccelerometerEnabled) {
            sCocos2dxAccelerometer.enable();
        }
    }

    public static void onPause() {
        if (sAccelerometerEnabled) {
            sCocos2dxAccelerometer.disable();
        }
    }

    public static void terminateProcess() {
        Process.killProcess(Process.myPid());
    }

    private static void showDialog(String pTitle, String pMessage) {
        sCocos2dxHelperListener.showDialog(pTitle, pMessage);
    }

    private static void showEditTextDialog(String pTitle, String pMessage, int pInputMode, int pInputFlag, int pReturnType, int pMaxLength) {
        sCocos2dxHelperListener.showEditTextDialog(pTitle, pMessage, pInputMode, pInputFlag, pReturnType, pMaxLength);
    }

    public static void setEditTextDialogResult(String pResult) {
        try {
            final byte[] bytesUTF8 = pResult.getBytes("UTF8");
            sCocos2dxHelperListener.runOnGLThread(new Runnable() {
                public void run() {
                    Cocos2dxHelper.nativeSetEditTextDialogResult(bytesUTF8);
                }
            });
        } catch (UnsupportedEncodingException e) {
        }
    }

    public static int getDPI() {
        if (sContext != null) {
            DisplayMetrics metrics = new DisplayMetrics();
            WindowManager wm = ((Activity) sContext).getWindowManager();
            if (wm != null) {
                Display d = wm.getDefaultDisplay();
                if (d != null) {
                    d.getMetrics(metrics);
                    return (int) (metrics.density * 160.0f);
                }
            }
        }
        return -1;
    }

    public static boolean inDirectoryExists(String path) {
        return new File(path).isDirectory();
    }

    public static boolean getBoolForKey(String key, boolean defaultValue) {
        return ((Activity) sContext).getSharedPreferences(PREFS_NAME, 0).getBoolean(key, defaultValue);
    }

    public static int getIntegerForKey(String key, int defaultValue) {
        return ((Activity) sContext).getSharedPreferences(PREFS_NAME, 0).getInt(key, defaultValue);
    }

    public static float getFloatForKey(String key, float defaultValue) {
        return ((Activity) sContext).getSharedPreferences(PREFS_NAME, 0).getFloat(key, defaultValue);
    }

    public static double getDoubleForKey(String key, double defaultValue) {
        return (double) ((Activity) sContext).getSharedPreferences(PREFS_NAME, 0).getFloat(key, (float) defaultValue);
    }

    public static String getStringForKey(String key, String defaultValue) {
        return ((Activity) sContext).getSharedPreferences(PREFS_NAME, 0).getString(key, defaultValue);
    }

    public static void setBoolForKey(String key, boolean value) {
        Editor editor = ((Activity) sContext).getSharedPreferences(PREFS_NAME, 0).edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    public static void setIntegerForKey(String key, int value) {
        Editor editor = ((Activity) sContext).getSharedPreferences(PREFS_NAME, 0).edit();
        editor.putInt(key, value);
        editor.commit();
    }

    public static void setFloatForKey(String key, float value) {
        Editor editor = ((Activity) sContext).getSharedPreferences(PREFS_NAME, 0).edit();
        editor.putFloat(key, value);
        editor.commit();
    }

    public static void setDoubleForKey(String key, double value) {
        Editor editor = ((Activity) sContext).getSharedPreferences(PREFS_NAME, 0).edit();
        editor.putFloat(key, (float) value);
        editor.commit();
    }

    public static void setStringForKey(String key, String value) {
        Editor editor = ((Activity) sContext).getSharedPreferences(PREFS_NAME, 0).edit();
        editor.putString(key, value);
        editor.commit();
    }
}
