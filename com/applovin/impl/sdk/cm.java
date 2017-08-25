package com.applovin.impl.sdk;

import android.net.Uri;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinSdkUtils;
import java.io.File;
import java.util.Collection;
import java.util.HashSet;

class cm extends cc {
    private final AppLovinAdImpl f602a;
    private final String f603b;
    private boolean f604c;
    private AppLovinAdLoadListener f605d;
    private final aa f606i;
    private final Collection f607j = m579g();

    cm(AppLovinAdImpl appLovinAdImpl, String str, AppLovinAdLoadListener appLovinAdLoadListener, AppLovinSdkImpl appLovinSdkImpl) {
        super("TaskCacheAd", appLovinSdkImpl);
        this.f602a = appLovinAdImpl;
        this.f603b = str;
        this.f605d = appLovinAdLoadListener;
        this.f606i = appLovinSdkImpl.getFileManager();
    }

    private Uri m570a(Uri uri, String str) {
        if (uri != null) {
            String uri2 = uri.toString();
            if (AppLovinSdkUtils.isValidString(uri2)) {
                this.g.mo635d(this.e, "Caching " + str + " image...");
                return m571a(uri2);
            }
            this.g.mo635d(this.e, "Failed to cache " + str + " image");
        } else {
            this.g.mo635d(this.e, "No " + str + " image to cache");
        }
        return null;
    }

    private Uri m571a(String str) {
        try {
            String a = this.f.getFileManager().m277a(this.h, str);
            if (AppLovinSdkUtils.isValidString(a)) {
                File a2 = this.f.getFileManager().m276a(a, this.h, false);
                if (a2 != null) {
                    Uri fromFile = Uri.fromFile(a2);
                    if (fromFile != null) {
                        return fromFile;
                    }
                    this.g.mo636e(this.e, "Unable to extract Uri from image file");
                } else {
                    this.g.mo636e(this.e, "Unable to retrieve File from cached image filename = " + a);
                }
            }
        } catch (Throwable e) {
            this.g.mo637e(this.e, "Failed to cache image at url = " + str, e);
        }
        return null;
    }

    private String m572a(String str, String str2) {
        File a = this.f606i.m276a(str2.replace("/", "_"), this.f.getApplicationContext(), true);
        if (a == null) {
            return null;
        }
        if (a.exists()) {
            this.g.mo635d(this.e, "Loaded " + str2 + " from cache: file://" + a.getAbsolutePath());
            return "file://" + a.getAbsolutePath();
        }
        return this.f606i.m284a(a, new StringBuilder().append(str).append(str2).toString()) ? "file://" + a.getAbsolutePath() : null;
    }

    private String m573b(String str) {
        return ((Boolean) this.f.m253a(cd.f537B)).booleanValue() ? m574c(str) : str;
    }

    private String m574c(String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        for (String str2 : ((String) this.f.m253a(cd.f539D)).split(",")) {
            int i = 0;
            int i2 = 0;
            while (i2 < stringBuilder.length()) {
                i2 = stringBuilder.indexOf(str2, i);
                if (i2 == -1) {
                    break;
                }
                int length = stringBuilder.length();
                i = i2;
                while (!this.f607j.contains(Character.valueOf(stringBuilder.charAt(i))) && i < length) {
                    i++;
                }
                if (i <= i2 || i == length) {
                    this.g.mo636e(this.e, "Unable to cache resource; ad HTML is invalid.");
                } else {
                    String a = m572a(str2, stringBuilder.substring(str2.length() + i2, i));
                    if (a != null) {
                        stringBuilder.replace(i2, i, a);
                    }
                }
            }
        }
        return stringBuilder.toString();
    }

    private void m575c() {
        this.g.mo635d(this.e, "Caching mute images...");
        Uri a = m570a(this.f602a.getMuteImageUri(), "mute");
        if (a != null) {
            this.f602a.setMuteImageUri(a);
        }
        a = m570a(this.f602a.getUnmuteImageUri(), "unmute");
        if (a != null) {
            this.f602a.setUnmuteImageUri(a);
        }
        this.g.mo635d(this.e, "Ad updated with muteImageFilename = " + this.f602a.getMuteImageUri() + ", unmuteImageFilename = " + this.f602a.getUnmuteImageUri());
    }

    private void m576d() {
        this.g.mo635d(this.e, "Caching HTML resources...");
        this.f602a.setHtmlSource(m573b(this.f602a.getHtmlSource()));
        this.g.mo635d(this.e, "Finish caching HTML resources for ad #" + this.f602a.getAdIdNumber());
        this.g.mo635d(this.e, "Ad updated with cachedHTML = " + this.f602a.getHtmlSource());
    }

    private void m577e() {
        try {
            if (AppLovinSdkUtils.isValidString(this.f603b)) {
                this.g.mo635d(this.e, "Caching video " + this.f603b + "...");
                String a = this.f606i.m277a(this.h, this.f603b);
                if (AppLovinSdkUtils.isValidString(a)) {
                    File a2 = this.f.getFileManager().m276a(a, this.h, false);
                    if (a2 != null) {
                        Uri fromFile = Uri.fromFile(a2);
                        if (fromFile != null) {
                            this.g.mo635d(this.e, "Finish caching video for ad #" + this.f602a.getAdIdNumber() + ". Updating ad with cachedVideoFilename = " + a);
                            this.f602a.setVideoStream(false);
                            this.f602a.setVideoUri(fromFile);
                            return;
                        }
                        this.g.mo636e(this.e, "Unable to create URI from cached video file = " + a2);
                        return;
                    }
                    this.g.mo636e(this.e, "Unable to cache video = " + this.f603b + "Video file was missing or null - please make sure your app has the WRITE_EXTERNAL_STORAGE permission!");
                } else if (((Boolean) this.f.m253a(cd.f538C)).booleanValue()) {
                    this.g.mo636e(this.e, "Failed to cache video");
                    dp.m702a(this.f605d, new C0150c(this.f602a.getSize(), this.f602a.getType()), AppLovinErrorCodes.UNABLE_TO_PRECACHE_VIDEO_RESOURCES, this.f);
                    this.f605d = null;
                } else {
                    this.g.mo636e(this.e, "Failed to cache video, but not failing ad load");
                }
            }
        } catch (Throwable e) {
            this.g.mo637e(this.e, "Encountered exception while attempting to cache video.", e);
        }
    }

    private void m578f() {
        if (this.f605d != null) {
            this.f.getLogger().mo635d(m471a(), "Rendered new ad:" + this.f602a);
            this.f605d.adReceived(this.f602a);
            this.f605d = null;
        }
    }

    private Collection m579g() {
        Collection hashSet = new HashSet();
        for (char valueOf : ((String) this.f.m253a(cd.ai)).toCharArray()) {
            hashSet.add(Character.valueOf(valueOf));
        }
        hashSet.add(Character.valueOf('\"'));
        return hashSet;
    }

    public void m580a(boolean z) {
        this.f604c = z;
    }

    public void run() {
        if (this.f602a.isVideoStream()) {
            this.g.mo635d(this.e, "Begin caching for streaming ad #" + this.f602a.getAdIdNumber() + "...");
            m575c();
            if (this.f604c) {
                this.g.mo635d(this.e, "Calling back ad load immediately");
                m578f();
            }
            m576d();
            if (!this.f604c) {
                this.g.mo635d(this.e, "Calling back ad load AFTER caching endcard");
                m578f();
            }
            m577e();
            return;
        }
        this.g.mo635d(this.e, "Begin processing for non-streaming ad #" + this.f602a.getAdIdNumber() + "...");
        m575c();
        m576d();
        m577e();
        this.g.mo635d(this.e, "Caching finished. Calling back ad load success...");
        m578f();
    }
}
