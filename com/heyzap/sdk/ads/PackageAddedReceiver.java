package com.heyzap.sdk.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.heyzap.house.Manager;
import com.heyzap.house.handler.AttributionHandler;
import com.heyzap.internal.Logger;
import com.heyzap.internal.Preconditions;

public class PackageAddedReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        try {
            Preconditions.checkNotNull(context, "Invalid Context");
            Preconditions.checkNotNull(intent, "Invalid Intent");
            if (!intent.getBooleanExtra("android.intent.extra.REPLACING", false)) {
                String packageName = intent.getDataString();
                if (packageName != null) {
                    packageName = packageName.replaceFirst(intent.getScheme() + ":", "");
                }
                Logger.debug("Registering Installation for " + packageName);
                Manager.applicationContext = context.getApplicationContext();
                AttributionHandler.getInstance().didInstall(context.getApplicationContext(), packageName);
            }
        } catch (NullPointerException e) {
            Logger.error("Invalid intent or context for package install", e);
        }
    }
}
