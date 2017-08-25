package com.heyzap.house;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Handler;
import android.os.Looper;
import com.heyzap.common.cache.FileCache;
import com.heyzap.common.concurrency.ExecutorPool;
import com.heyzap.common.concurrency.FutureUtils;
import com.heyzap.common.concurrency.SettableFuture;
import com.heyzap.common.net.APIClient;
import com.heyzap.house.abstr.AbstractActivity;
import com.heyzap.house.model.AdModel;
import com.heyzap.house.request.DisplayCache;
import com.heyzap.house.request.FetchRequest;
import com.heyzap.internal.ContextReference;
import com.heyzap.internal.Logger;
import com.heyzap.internal.PackageManager;
import com.heyzap.internal.Utils;
import com.heyzap.sdk.ads.HeyzapAds;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class Manager {
    public static final String ACTION_URL_PLACEHOLDER = "market://details?id=%s&referrer=%s";
    public static final String ACTION_URL_REFERRER = "utm_source%3Dheyzap%26utm_medium%3Dmobile%26utm_campaign%3Dheyzap_ad_network";
    public static String AD_SERVER = "http://ads.heyzap.com/in_game_api/ads";
    public static final String FIRST_RUN_KEY = "HeyzapAdsFirstRun";
    public static final long MAX_CACHE_SIZE = 30000000;
    public static Boolean SLOW_CLOSE = Boolean.valueOf(false);
    public static Context applicationContext;
    private static DisplayCache displayCache;
    private static FileCache fileCache;
    public static final Handler handler = new Handler(Looper.getMainLooper());
    private static AtomicReference<SettableFuture> initializationFutureRef = new AtomicReference();
    public static AbstractActivity lastActivity = null;
    public static long maxClickDifference = 1000;
    private static volatile Manager ref;
    public static Boolean started = Boolean.valueOf(false);
    private ContextReference contextRef = null;
    public long lastClickedTime = 0;

    static class C13291 implements Runnable {
        C13291() {
        }

        public void run() {
            Manager.ref.getFileCache().flush();
        }
    }

    static class C13302 implements Runnable {
        C13302() {
        }

        public void run() {
            Manager.started = Boolean.valueOf(true);
            Logger.log("Heyzap Ad Manager started.");
        }
    }

    private Manager(ContextReference contextRef, String publisherId) {
        setPublisherId(publisherId);
        setContextRef(contextRef);
        clearAndCreateImageFileCache();
        displayCache = new DisplayCache();
        fileCache = new FileCache(ExecutorPool.getInstance(), new File(Utils.getCacheDirAbsolutePath(contextRef.getApp())), Long.valueOf(MAX_CACHE_SIZE));
    }

    public static void runOnUiThread(Runnable runnable) {
        new Handler(Looper.getMainLooper()).post(runnable);
    }

    public static Boolean isStarted() {
        return started;
    }

    public static SettableFuture start(ContextReference contextRef, String publisherId) {
        if (initializationFutureRef.compareAndSet(null, SettableFuture.create())) {
            if (contextRef.getApp() == null) {
                throw new IllegalArgumentException();
            }
            applicationContext = contextRef.getApp();
            ref = new Manager(contextRef, publisherId);
            PackageManager.checkInstalledPackages(contextRef.getApp());
            SettableFuture<Boolean> cacheIsOpen = ref.getFileCache().open();
            cacheIsOpen.addListener(new C13291(), ExecutorPool.getInstance());
            FutureUtils.bind(cacheIsOpen, (SettableFuture) initializationFutureRef.get(), ExecutorPool.getInstance());
            ((SettableFuture) initializationFutureRef.get()).addListener(new C13302(), ExecutorPool.getInstance());
        }
        return (SettableFuture) initializationFutureRef.get();
    }

    public DisplayCache getDisplayCache() {
        return displayCache;
    }

    public FileCache getFileCache() {
        return fileCache;
    }

    public List<String> getLocalPackages() {
        if (applicationContext == null) {
            return null;
        }
        List<PackageInfo> packages = applicationContext.getPackageManager().getInstalledPackages(0);
        List<String> packageNames = new ArrayList();
        for (PackageInfo packageInfo : packages) {
            if (!(packageInfo.packageName.startsWith("android.") || packageInfo.packageName.startsWith("com.google.android") || packageInfo.packageName.startsWith("com.android") || packageInfo.packageName.startsWith("com.htc") || packageInfo.packageName.startsWith("com.samsung") || packageInfo.packageName.startsWith("com.sec") || packageInfo.packageName.startsWith("com.monotype") || packageInfo.packageName.startsWith("com.verizon") || packageInfo.packageName.startsWith("com.qualcomm") || packageInfo.packageName.startsWith("com.vzw"))) {
                packageNames.add(packageInfo.packageName);
            }
        }
        return packageNames;
    }

    public void installHeyzap(AdModel referringAdModel) {
    }

    public void clearAndCreateFileCache() {
        String directoryPath = Utils.getCacheDirAbsolutePath(applicationContext);
        try {
            if (new File(directoryPath).exists()) {
                Utils.deleteDirectory(new File(directoryPath));
            }
            new File(directoryPath).mkdirs();
        } catch (Throwable e) {
            Logger.trace(e);
        }
    }

    public void clearAndCreateImageFileCache() {
        String directoryPath = Utils.getImageCacheDirAbsolutePath(applicationContext);
        try {
            if (new File(directoryPath).exists()) {
                Utils.deleteDirectory(new File(directoryPath));
            }
            new File(directoryPath).mkdirs();
        } catch (Throwable e) {
            Logger.trace(e);
        }
    }

    public void setPublisherId(String publisherId) {
        HeyzapAds.config.publisherId = publisherId;
    }

    public String getPublisherId() {
        return HeyzapAds.config.publisherId;
    }

    public void setContextRef(ContextReference contextRef) {
        this.contextRef = contextRef;
    }

    public static synchronized Manager getInstance() {
        Manager manager;
        synchronized (Manager.class) {
            if (ref == null) {
                throw new RuntimeException("Heyzap has not been started yet! Start Heyzap by calling HeyzapAds.start(<your-publisher-id>) in your launch Activity.");
            }
            manager = ref;
        }
        return manager;
    }

    public Object clone() {
        return null;
    }

    public static void setAdsHost(String stage) {
        FetchRequest.setDefaultHost(stage);
        APIClient.DOMAIN = stage;
        AD_SERVER = "http://" + stage + "/in_game_api/ads";
    }
}
