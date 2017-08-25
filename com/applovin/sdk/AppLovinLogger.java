package com.applovin.sdk;

public interface AppLovinLogger {
    public static final String SDK_TAG = "AppLovinSdk";

    void mo635d(String str, String str2);

    void mo636e(String str, String str2);

    void mo637e(String str, String str2, Throwable th);

    void mo638i(String str, String str2);

    void userError(String str, String str2);

    void userError(String str, String str2, Throwable th);

    void mo641w(String str, String str2);

    void mo642w(String str, String str2, Throwable th);
}
