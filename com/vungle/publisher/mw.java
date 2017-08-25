package com.vungle.publisher;

import android.app.AlertDialog;
import android.app.Fragment;
import com.vungle.publisher.gx.C1778a;
import javax.inject.Inject;

/* compiled from: vungle */
public abstract class mw extends Fragment {
    AlertDialog f2590a;
    C1617z f2591b;
    @Inject
    C1778a f2592c;
    @Inject
    nd f2593d;

    public abstract void mo4505a();

    public abstract String mo4507b();

    public void mo4506a(boolean z) {
        String str;
        String str2 = "VungleAd";
        StringBuilder stringBuilder = new StringBuilder();
        if (z) {
            str = "gained";
        } else {
            str = "lost";
        }
        so.m2470a(2, str2, stringBuilder.append(str).append(" window focus").toString(), null);
    }
}
