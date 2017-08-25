package com.heyzap.internal;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;

public class ContextReference {
    private Activity activity;
    private final Set<Runnable> activityChangeCallbacks = new HashSet();
    private Context applicationContext;
    private Activity foregroundActivity;
    private Activity previousActivity;

    class C13831 implements ActivityLifecycleCallbacks {
        C13831() {
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
            Logger.debug("ContextReference - onActivityResumed: " + activity);
            ContextReference.this.foregroundActivity = activity;
        }

        public void onActivityPaused(Activity activity) {
            Logger.debug("ContextReference - onActivityPaused: " + activity);
            if (ContextReference.this.foregroundActivity == activity) {
                Logger.debug("ContextReference - onActivityPaused - was foreground activity");
                ContextReference.this.foregroundActivity = null;
            }
        }

        public void onActivityStopped(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }
    }

    public static class UpdateCallbackWrapper implements Runnable {
        public final Runnable callback;
        public final ExecutorService executorService;

        public UpdateCallbackWrapper(Runnable callback, ExecutorService executorService) {
            this.executorService = executorService;
            this.callback = callback;
        }

        public void run() {
            this.executorService.submit(this.callback);
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            UpdateCallbackWrapper that = (UpdateCallbackWrapper) o;
            if (!this.callback.equals(that.callback)) {
                return false;
            }
            if (this.executorService.equals(that.executorService)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.executorService.hashCode() * 31) + this.callback.hashCode();
        }
    }

    public Context getApp() {
        return this.applicationContext;
    }

    public Activity getActivity() {
        return this.activity;
    }

    public Activity getForegroundActivity() {
        return this.foregroundActivity;
    }

    public void updateContext(Context context) {
        if (this.applicationContext == null) {
            this.applicationContext = context.getApplicationContext();
            Logger.debug("ContextReference - updateContext - applicationContext: " + this.applicationContext);
            if (this.applicationContext instanceof Application) {
                registerApplicationCallbacks((Application) this.applicationContext);
            }
        }
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (!activity.equals(this.activity)) {
                this.previousActivity = activity;
                this.activity = activity;
                for (Runnable callback : this.activityChangeCallbacks) {
                    callback.run();
                }
            }
        }
    }

    public void registerApplicationCallbacks(Application application) {
        Logger.debug("ContextReference - registerApplicationCallbacks - hit");
        if (VERSION.SDK_INT >= 14) {
            application.registerActivityLifecycleCallbacks(new C13831());
        } else {
            Logger.debug("ContextReference - registerApplicationCallbacks -  SDK < 14, not registering callbacks");
        }
    }

    public boolean addActivityUpdateListener(Runnable callback, ExecutorService executorService) {
        return this.activityChangeCallbacks.add(new UpdateCallbackWrapper(callback, executorService));
    }

    public boolean removeActivityUpdateListener(Runnable callback) {
        return this.activityChangeCallbacks.remove(new UpdateCallbackWrapper(callback, null));
    }

    public Activity getPreviousActivity() {
        return this.previousActivity;
    }
}
