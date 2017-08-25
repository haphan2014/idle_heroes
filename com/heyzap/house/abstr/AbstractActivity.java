package com.heyzap.house.abstr;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.view.View;
import com.heyzap.house.Manager;
import com.heyzap.house.handler.ClickHandler;
import com.heyzap.house.model.AdModel;
import com.heyzap.internal.Constants.AdUnit;
import com.heyzap.internal.Logger;
import com.heyzap.internal.Utils;

public abstract class AbstractActivity extends Activity {
    public static final int ACTIVITY_ACTION_HIDE = 2;
    public static final int ACTIVITY_ACTION_SHOW = 1;
    public static final String ACTIVITY_INTENT_ACTION_KEY = "action";
    public static final String ACTIVITY_INTENT_CONTEXT_KEY = "ad_context";
    public static final String ACTIVITY_INTENT_IMPRESSION_KEY = "impression_id";
    public static final String ACTIVITY_INTENT_ORIGINAL_ORIENTATION = "original_orientation";
    protected AdModel currentAd;
    protected Boolean currentAdComplete = Boolean.valueOf(false);
    protected String currentAdImpressionId = null;
    protected String currentAdTag = null;
    protected AdUnit currentAdUnit = AdUnit.UNKNOWN;
    private int originalOrientation = 0;
    private ProgressDialog progressDialog = null;

    public interface AdActionListener {
        void click();

        void clickUrl(String str, String str2);

        void completed();

        void error();

        void hide();

        void progress(int i, float f);

        void restart();

        void resume();

        void show();

        void skip(Integer num);
    }

    public abstract View getContentView();

    public abstract Boolean onPrepared();

    public abstract void prepare();

    @SuppressLint({"NewApi"})
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        getWindow().getDecorView().setBackgroundColor(0);
        if (Utils.getSdkVersion() >= 11) {
            getWindow().setFlags(ViewCompat.MEASURED_STATE_TOO_SMALL, ViewCompat.MEASURED_STATE_TOO_SMALL);
        }
        if (Manager.isStarted().booleanValue()) {
            handleIntent(getIntent());
        } else {
            finish();
        }
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        handleIntent(intent);
    }

    protected void handleIntent(Intent intent) {
        if (intent.getExtras() == null) {
            finish();
        }
        if (!intent.getExtras().containsKey(ACTIVITY_INTENT_ACTION_KEY)) {
            finish();
        }
        if (intent.getExtras().containsKey(ACTIVITY_INTENT_ORIGINAL_ORIENTATION)) {
            this.originalOrientation = intent.getExtras().getInt(ACTIVITY_INTENT_ORIGINAL_ORIENTATION);
        }
        if (intent.getExtras().containsKey(ACTIVITY_INTENT_ACTION_KEY)) {
            switch (intent.getExtras().getInt(ACTIVITY_INTENT_ACTION_KEY)) {
                case 2:
                    if (this.currentAd == null) {
                        finish();
                        return;
                    } else {
                        onHide();
                        return;
                    }
                default:
                    this.currentAdImpressionId = intent.getStringExtra(ACTIVITY_INTENT_IMPRESSION_KEY);
                    this.currentAd = Manager.getInstance().getDisplayCache().get();
                    if (this.currentAd == null || this.currentAd.isExpired().booleanValue()) {
                        if (this.currentAd != null) {
                            try {
                                this.currentAd.getAdRequest().getOnStatusListener().onFailedToShow(null);
                            } catch (Throwable e) {
                                Logger.trace(e);
                            }
                        }
                        finish();
                        return;
                    }
                    this.currentAdTag = this.currentAd.getTag();
                    this.currentAdUnit = this.currentAd.getAdUnit();
                    lockCurrentAdOrientation();
                    prepare();
                    setContentView(getContentView());
                    onShow();
                    Manager.lastActivity = this;
                    return;
            }
        }
    }

    @SuppressLint({"InlinedApi"})
    private void lockCurrentAdOrientation() {
        int orientation = this.currentAd.getRequiredOrientation();
        if (orientation != 0) {
            switch (orientation) {
                case 1:
                    if (Utils.getSdkVersion() > 8) {
                        setRequestedOrientation(7);
                        return;
                    } else {
                        setRequestedOrientation(1);
                        return;
                    }
                case 2:
                    if (Utils.getSdkVersion() > 8) {
                        setRequestedOrientation(6);
                        return;
                    } else {
                        setRequestedOrientation(0);
                        return;
                    }
                default:
                    return;
            }
        }
    }

    public void onHide() {
        if (this.currentAd != null) {
            Logger.format("(HIDE) %s", this.currentAd);
            try {
                this.currentAd.cleanup(this);
            } catch (Throwable e) {
                Logger.trace(e);
            }
            if (Manager.SLOW_CLOSE.booleanValue()) {
                this.progressDialog = new ProgressDialog(this);
                this.progressDialog.setTitle("Please wait...");
                this.progressDialog.setMessage("");
                this.progressDialog.setIndeterminate(true);
                this.progressDialog.setCancelable(false);
                this.progressDialog.show();
            }
            finish();
            Manager.getInstance().getDisplayCache().clear();
            this.currentAd.getAdRequest().getOnStatusListener().onHide(this.currentAd.getTag());
            switch (this.currentAdUnit) {
            }
            Manager.lastActivity = null;
        }
    }

    public void finish() {
        super.finish();
    }

    public void onClick() {
        onClick(this.currentAd.actionUrl, null);
    }

    public void onClick(String adUrl, String customPackageName) {
        new ClickHandler(this.currentAd).doClick(this, adUrl, customPackageName);
    }

    public void onShow() {
        this.currentAd.setHasBeenShown(true);
        this.currentAd.onImpression(this);
        this.currentAd.getAdRequest().getOnStatusListener().onShow(this.currentAd.getTag());
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onDestroy() {
        if (this.progressDialog != null && this.progressDialog.isShowing()) {
            this.progressDialog.cancel();
        }
        super.onDestroy();
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
}
