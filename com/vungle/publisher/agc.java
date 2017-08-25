package com.vungle.publisher;

import android.content.Intent;
import android.net.Uri;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: vungle */
public final class agc {
    @Inject
    agc() {
    }

    public static Intent m1209a(String str, Uri uri) {
        return new Intent(str, uri);
    }
}
