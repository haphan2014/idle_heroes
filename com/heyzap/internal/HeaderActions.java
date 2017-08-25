package com.heyzap.internal;

import android.app.Activity;
import android.content.Intent;
import com.heyzap.sdk.ads.MediationTestActivity;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.http.Header;

public class HeaderActions {
    private final ContextReference contextReference;
    private final AtomicBoolean debugShown = new AtomicBoolean(false);
    private final ScheduledExecutorService scheduledExecutorService;
    private final ExecutorService uiExecutorService;

    public HeaderActions(ExecutorService uiExecutorService, ScheduledExecutorService scheduledExecutorService, ContextReference contextReference) {
        this.uiExecutorService = uiExecutorService;
        this.scheduledExecutorService = scheduledExecutorService;
        this.contextReference = contextReference;
    }

    public void onHeaders(Header[] headers) {
        if (headers != null) {
            boolean showDebug = false;
            int debugDelay = 0;
            int i = 0;
            while (i < headers.length) {
                try {
                    Header h = headers[i];
                    if ("heyzapLogging".equals(h.getName())) {
                        Utils.setDebug(true);
                        Logger.debug("heyzapLogging header found, enabling verbose output");
                    }
                    if ("showMediationDebugSuite".equals(h.getName())) {
                        showDebug = true;
                        Logger.debug("showMediationDebugSuite header found, showing debug suite");
                    }
                    if ("showMediationDebugSuiteDelay".equals(h.getName())) {
                        try {
                            Logger.debug("showMediationDebugSuiteDelay header found, delaying debug suite by " + h.getValue() + " seconds");
                            debugDelay = Integer.parseInt(h.getValue());
                        } catch (NumberFormatException e) {
                            Logger.debug("Invalid value for showMediationDebugSuiteDelay: " + h.getValue());
                        }
                    }
                    i++;
                } catch (Exception e2) {
                    Logger.debug("Exception in HeaderActions", e2);
                    return;
                }
            }
            final Activity activity = this.contextReference.getActivity();
            if (showDebug && activity != null && this.debugShown.compareAndSet(false, true)) {
                this.scheduledExecutorService.schedule(new Runnable() {

                    class C13851 implements Runnable {
                        C13851() {
                        }

                        public void run() {
                            activity.startActivity(new Intent(activity, MediationTestActivity.class));
                        }
                    }

                    public void run() {
                        HeaderActions.this.uiExecutorService.execute(new C13851());
                    }
                }, (long) debugDelay, TimeUnit.SECONDS);
            }
        }
    }
}
