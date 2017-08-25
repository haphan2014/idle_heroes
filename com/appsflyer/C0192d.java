package com.appsflyer;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import java.lang.ref.WeakReference;

@RequiresApi(api = 14)
class C0192d implements ActivityLifecycleCallbacks {
    private static C0192d instance;
    private boolean foreground = false;
    private C0176a listener = null;
    private boolean paused = true;

    interface C0176a {
        void onBecameBackground(WeakReference<Activity> weakReference);

        void onBecameForeground(Activity activity);
    }

    C0192d() {
    }

    public static C0192d init(Application application) {
        if (instance == null) {
            instance = new C0192d();
            if (VERSION.SDK_INT >= 14) {
                application.registerActivityLifecycleCallbacks(instance);
            }
        }
        return instance;
    }

    public static C0192d getInstance() {
        if (instance != null) {
            return instance;
        }
        throw new IllegalStateException("Foreground is not initialised - invoke at least once with parameter init/get");
    }

    public void registerListener(C0176a listener) {
        this.listener = listener;
    }

    public void onActivityResumed(Activity activity) {
        boolean z = false;
        this.paused = false;
        if (!this.foreground) {
            z = true;
        }
        this.foreground = true;
        if (z) {
            try {
                this.listener.onBecameForeground(activity);
            } catch (Throwable e) {
                C0188a.afLogE("Listener threw exception! ", e);
            }
        }
    }

    public void onActivityPaused(final Activity activity) {
        this.paused = true;
        new AsyncTask<Void, Void, Void>() {
            protected Void doInBackground(Void... params) {
                try {
                    Thread.sleep(500);
                } catch (Throwable e) {
                    C0188a.afLogE("Sleeping attempt failed (essential for background state verification)\n", e);
                }
                if (C0192d.this.foreground && C0192d.this.paused) {
                    C0192d.this.foreground = false;
                    try {
                        WeakReference weakReference = new WeakReference(activity);
                        C0192d.this.listener.onBecameBackground(weakReference);
                        weakReference.clear();
                    } catch (Throwable e2) {
                        C0188a.afLogE("Listener threw exception! ", e2);
                        cancel(true);
                    }
                }
                return null;
            }
        }.execute(new Void[0]);
    }

    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
    }

    public void onActivityDestroyed(Activity activity) {
    }
}
