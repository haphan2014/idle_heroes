package com.applovin.impl.sdk;

import android.util.Log;
import com.applovin.sdk.AppLovinLogger;

class C0160k implements AppLovinLogger {
    private cg f688a;
    private C0161l f689b;

    C0160k() {
    }

    void m717a(cg cgVar) {
        this.f688a = cgVar;
    }

    void m718a(C0161l c0161l) {
        this.f689b = c0161l;
    }

    boolean m719a() {
        return this.f688a != null ? ((Boolean) this.f688a.m501a(cd.f570i)).booleanValue() : false;
    }

    public void mo635d(String str, String str2) {
        if (m719a()) {
            Log.d(AppLovinLogger.SDK_TAG, "[" + str + "] " + str2);
        }
        if (this.f689b != null) {
            this.f689b.m726a("DEBUG  [" + str + "] " + str2);
        }
    }

    public void mo636e(String str, String str2) {
        mo637e(str, str2, null);
    }

    public void mo637e(String str, String str2, Throwable th) {
        if (m719a()) {
            Log.e(AppLovinLogger.SDK_TAG, "[" + str + "] " + str2, th);
        }
        if (this.f689b != null) {
            this.f689b.m726a("ERROR  [" + str + "] " + str2 + (th != null ? ": " + th.getMessage() : ""));
        }
    }

    public void mo638i(String str, String str2) {
        if (m719a()) {
            Log.i(AppLovinLogger.SDK_TAG, "[" + str + "] " + str2);
        }
        if (this.f689b != null) {
            this.f689b.m726a("INFO  [" + str + "] " + str2);
        }
    }

    public void userError(String str, String str2) {
        userError(str, str2, null);
    }

    public void userError(String str, String str2, Throwable th) {
        Log.e(AppLovinLogger.SDK_TAG, "[" + str + "] " + str2, th);
        if (this.f689b != null) {
            this.f689b.m726a("USER  [" + str + "] " + str2 + (th != null ? ": " + th.getMessage() : ""));
        }
    }

    public void mo641w(String str, String str2) {
        mo642w(str, str2, null);
    }

    public void mo642w(String str, String str2, Throwable th) {
        if (m719a()) {
            Log.w(AppLovinLogger.SDK_TAG, "[" + str + "] " + str2, th);
        }
        if (this.f689b != null) {
            this.f689b.m726a("WARN  [" + str + "] " + str2);
        }
    }
}
