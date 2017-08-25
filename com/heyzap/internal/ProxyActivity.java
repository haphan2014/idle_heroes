package com.heyzap.internal;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.IntentSender.SendIntentException;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.drive.DriveFile;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ProxyActivity extends Activity {
    private final Activity context;

    public ProxyActivity(Activity context) {
        this.context = context;
    }

    public Context getRealContext() {
        return this.context;
    }

    public void onCreate(Bundle savedInstanceState) {
    }

    public void startActivityForResult(Intent intent, int requestCode) {
        intent.setFlags(intent.getFlags() | DriveFile.MODE_READ_ONLY);
        this.context.startActivityForResult(intent, requestCode);
    }

    @SuppressLint({"NewApi"})
    public void startActivityForResult(Intent intent, int requestCode, Bundle options) {
        intent.setFlags(intent.getFlags() | DriveFile.MODE_READ_ONLY);
        this.context.startActivityForResult(intent, requestCode, options);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
    }

    public AssetManager getAssets() {
        return this.context.getAssets();
    }

    public Resources getResources() {
        return this.context.getResources();
    }

    public PackageManager getPackageManager() {
        return this.context.getPackageManager();
    }

    public ContentResolver getContentResolver() {
        return this.context.getContentResolver();
    }

    public Looper getMainLooper() {
        return this.context.getMainLooper();
    }

    public Context getApplicationContext() {
        return this.context.getApplicationContext();
    }

    public void registerComponentCallbacks(ComponentCallbacks callback) {
        this.context.registerComponentCallbacks(callback);
    }

    public void unregisterComponentCallbacks(ComponentCallbacks callback) {
        this.context.unregisterComponentCallbacks(callback);
    }

    public void setTheme(int resid) {
        this.context.setTheme(resid);
    }

    public Theme getTheme() {
        return this.context.getTheme();
    }

    public ClassLoader getClassLoader() {
        return this.context.getClassLoader();
    }

    public String getPackageName() {
        return this.context.getPackageName();
    }

    public ApplicationInfo getApplicationInfo() {
        return this.context.getApplicationInfo();
    }

    public String getPackageResourcePath() {
        return this.context.getPackageResourcePath();
    }

    public String getPackageCodePath() {
        return this.context.getPackageCodePath();
    }

    public SharedPreferences getSharedPreferences(String name, int mode) {
        return this.context.getSharedPreferences(name, mode);
    }

    public FileInputStream openFileInput(String name) throws FileNotFoundException {
        return this.context.openFileInput(name);
    }

    public FileOutputStream openFileOutput(String name, int mode) throws FileNotFoundException {
        return this.context.openFileOutput(name, mode);
    }

    public boolean deleteFile(String name) {
        return this.context.deleteFile(name);
    }

    public File getFileStreamPath(String name) {
        return this.context.getFileStreamPath(name);
    }

    public File getFilesDir() {
        return this.context.getFilesDir();
    }

    public File getExternalFilesDir(String type) {
        return this.context.getExternalFilesDir(type);
    }

    public File getObbDir() {
        return this.context.getObbDir();
    }

    public File getCacheDir() {
        return this.context.getCacheDir();
    }

    public File getExternalCacheDir() {
        return this.context.getExternalCacheDir();
    }

    public String[] fileList() {
        return this.context.fileList();
    }

    public File getDir(String name, int mode) {
        return this.context.getDir(name, mode);
    }

    public SQLiteDatabase openOrCreateDatabase(String name, int mode, CursorFactory factory) {
        return this.context.openOrCreateDatabase(name, mode, factory);
    }

    public SQLiteDatabase openOrCreateDatabase(String name, int mode, CursorFactory factory, DatabaseErrorHandler errorHandler) {
        return this.context.openOrCreateDatabase(name, mode, factory, errorHandler);
    }

    public boolean deleteDatabase(String name) {
        return this.context.deleteDatabase(name);
    }

    public File getDatabasePath(String name) {
        return this.context.getDatabasePath(name);
    }

    public String[] databaseList() {
        return this.context.databaseList();
    }

    @Deprecated
    public Drawable getWallpaper() {
        return this.context.getWallpaper();
    }

    @Deprecated
    public Drawable peekWallpaper() {
        return this.context.peekWallpaper();
    }

    @Deprecated
    public int getWallpaperDesiredMinimumWidth() {
        return this.context.getWallpaperDesiredMinimumWidth();
    }

    @Deprecated
    public int getWallpaperDesiredMinimumHeight() {
        return this.context.getWallpaperDesiredMinimumHeight();
    }

    @Deprecated
    public void setWallpaper(Bitmap bitmap) throws IOException {
        this.context.setWallpaper(bitmap);
    }

    @Deprecated
    public void setWallpaper(InputStream data) throws IOException {
        this.context.setWallpaper(data);
    }

    @Deprecated
    public void clearWallpaper() throws IOException {
        this.context.clearWallpaper();
    }

    public void startActivity(Intent intent) {
        this.context.startActivity(intent);
    }

    public void startActivity(Intent intent, Bundle options) {
        this.context.startActivity(intent, options);
    }

    public void startActivities(Intent[] intents) {
        this.context.startActivities(intents);
    }

    public void startActivities(Intent[] intents, Bundle options) {
        this.context.startActivities(intents, options);
    }

    public void startIntentSender(IntentSender intent, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws SendIntentException {
        this.context.startIntentSender(intent, fillInIntent, flagsMask, flagsValues, extraFlags);
    }

    public void startIntentSender(IntentSender intent, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, Bundle options) throws SendIntentException {
        this.context.startIntentSender(intent, fillInIntent, flagsMask, flagsValues, extraFlags, options);
    }

    public void sendBroadcast(Intent intent) {
        this.context.sendBroadcast(intent);
    }

    public void sendBroadcast(Intent intent, String receiverPermission) {
        this.context.sendBroadcast(intent, receiverPermission);
    }

    public void sendOrderedBroadcast(Intent intent, String receiverPermission) {
        this.context.sendOrderedBroadcast(intent, receiverPermission);
    }

    public void sendOrderedBroadcast(Intent intent, String receiverPermission, BroadcastReceiver resultReceiver, Handler scheduler, int initialCode, String initialData, Bundle initialExtras) {
        this.context.sendOrderedBroadcast(intent, receiverPermission, resultReceiver, scheduler, initialCode, initialData, initialExtras);
    }

    public void sendStickyBroadcast(Intent intent) {
        this.context.sendStickyBroadcast(intent);
    }

    public void sendStickyOrderedBroadcast(Intent intent, BroadcastReceiver resultReceiver, Handler scheduler, int initialCode, String initialData, Bundle initialExtras) {
        this.context.sendStickyOrderedBroadcast(intent, resultReceiver, scheduler, initialCode, initialData, initialExtras);
    }

    public void removeStickyBroadcast(Intent intent) {
        this.context.removeStickyBroadcast(intent);
    }

    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter) {
        return this.context.registerReceiver(receiver, filter);
    }

    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter, String broadcastPermission, Handler scheduler) {
        return this.context.registerReceiver(receiver, filter, broadcastPermission, scheduler);
    }

    public void unregisterReceiver(BroadcastReceiver receiver) {
        this.context.unregisterReceiver(receiver);
    }

    public ComponentName startService(Intent service) {
        return this.context.startService(service);
    }

    public boolean stopService(Intent service) {
        return this.context.stopService(service);
    }

    public boolean bindService(Intent service, ServiceConnection conn, int flags) {
        return this.context.bindService(service, conn, flags);
    }

    public void unbindService(ServiceConnection conn) {
        this.context.unbindService(conn);
    }

    public boolean startInstrumentation(ComponentName className, String profileFile, Bundle arguments) {
        return this.context.startInstrumentation(className, profileFile, arguments);
    }

    public Object getSystemService(String name) {
        return this.context.getSystemService(name);
    }

    public int checkPermission(String permission, int pid, int uid) {
        return this.context.checkPermission(permission, pid, uid);
    }

    public int checkCallingPermission(String permission) {
        return this.context.checkCallingPermission(permission);
    }

    public int checkCallingOrSelfPermission(String permission) {
        return this.context.checkCallingOrSelfPermission(permission);
    }

    public void enforcePermission(String permission, int pid, int uid, String message) {
        this.context.enforcePermission(permission, pid, uid, message);
    }

    public void enforceCallingPermission(String permission, String message) {
        this.context.enforceCallingPermission(permission, message);
    }

    public void enforceCallingOrSelfPermission(String permission, String message) {
        this.context.enforceCallingOrSelfPermission(permission, message);
    }

    public void grantUriPermission(String toPackage, Uri uri, int modeFlags) {
        this.context.grantUriPermission(toPackage, uri, modeFlags);
    }

    public void revokeUriPermission(Uri uri, int modeFlags) {
        this.context.revokeUriPermission(uri, modeFlags);
    }

    public int checkUriPermission(Uri uri, int pid, int uid, int modeFlags) {
        return this.context.checkUriPermission(uri, pid, uid, modeFlags);
    }

    public int checkCallingUriPermission(Uri uri, int modeFlags) {
        return this.context.checkCallingUriPermission(uri, modeFlags);
    }

    public int checkCallingOrSelfUriPermission(Uri uri, int modeFlags) {
        return this.context.checkCallingOrSelfUriPermission(uri, modeFlags);
    }

    public int checkUriPermission(Uri uri, String readPermission, String writePermission, int pid, int uid, int modeFlags) {
        return this.context.checkUriPermission(uri, readPermission, writePermission, pid, uid, modeFlags);
    }

    public void enforceUriPermission(Uri uri, int pid, int uid, int modeFlags, String message) {
        this.context.enforceUriPermission(uri, pid, uid, modeFlags, message);
    }

    public void enforceCallingUriPermission(Uri uri, int modeFlags, String message) {
        this.context.enforceCallingUriPermission(uri, modeFlags, message);
    }

    public void enforceCallingOrSelfUriPermission(Uri uri, int modeFlags, String message) {
        this.context.enforceCallingOrSelfUriPermission(uri, modeFlags, message);
    }

    public void enforceUriPermission(Uri uri, String readPermission, String writePermission, int pid, int uid, int modeFlags, String message) {
        this.context.enforceUriPermission(uri, readPermission, writePermission, pid, uid, modeFlags, message);
    }

    public Context createPackageContext(String packageName, int flags) throws NameNotFoundException {
        return this.context.createPackageContext(packageName, flags);
    }

    public boolean isRestricted() {
        return this.context.isRestricted();
    }
}
