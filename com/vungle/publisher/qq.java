package com.vungle.publisher;

import java.io.File;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: vungle */
public final class qq {
    @Inject
    public Provider<String> f3020a;
    @Inject
    public Provider<String> f3021b;

    @Inject
    qq() {
    }

    public static void m2366a(String str) {
        try {
            if (new File(str).exists()) {
                qt.m2372a(str);
            } else {
                so.m2470a(2, "VungleFile", "ad temp directory does not exist " + str, null);
            }
        } catch (Exception e) {
            so.m2470a(3, "VungleFile", "error deleting ad temp directory " + str, null);
        }
    }
}
