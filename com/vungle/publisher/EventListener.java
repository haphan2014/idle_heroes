package com.vungle.publisher;

/* compiled from: vungle */
public interface EventListener {
    void onAdEnd(boolean z, boolean z2);

    void onAdPlayableChanged(boolean z);

    void onAdStart();

    void onAdUnavailable(String str);
}
