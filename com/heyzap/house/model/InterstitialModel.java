package com.heyzap.house.model;

import android.content.Context;
import com.heyzap.house.model.AdModel.HtmlAssetFetcher;
import com.heyzap.house.model.AdModel.ModelPostFetchCompleteListener;
import com.heyzap.internal.GenericCallback;
import com.heyzap.internal.Logger;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public class InterstitialModel extends AdModel implements Serializable {
    public static String FORMAT = "interstitial";
    private Integer backgroundOverlay;
    private Boolean disableGlobalTouch;
    private int height;
    private Boolean manualSize;
    private int width;

    public InterstitialModel(JSONObject response) throws JSONException, Exception {
        boolean z;
        super(response);
        this.creativeType = FORMAT;
        setHtmlData(response.getString("ad_html"));
        this.height = response.optInt("ad_height");
        this.width = response.optInt("ad_width");
        if (this.height == 0 && response.optString("ad_height").equals("fill_parent")) {
            this.height = -1;
        }
        if (this.width == 0 && response.optString("ad_width").equals("fill_parent")) {
            this.width = -1;
        }
        if (this.height == 0 || this.width == 0) {
            z = false;
        } else {
            z = true;
        }
        this.manualSize = Boolean.valueOf(z);
        String orientation = response.optString("required_orientation", "portrait");
        if (Boolean.valueOf(response.optBoolean("hide_on_orientation_change", true)).booleanValue()) {
            if (orientation.equals("landscape")) {
                this.requiredOrientation = 2;
            } else if (orientation.equals("portrait")) {
                this.requiredOrientation = 1;
            } else {
                this.requiredOrientation = 0;
            }
        }
        this.disableGlobalTouch = Boolean.valueOf(response.optBoolean("disable_global_touch", false));
        this.backgroundOverlay = Integer.valueOf(response.optInt("background_overlay", -1));
        setShouldRefetchIfNotReady(response.optBoolean("should_refetch_if_not_ready", false));
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public Integer getBackgroundOverlayColor() {
        if (this.backgroundOverlay.intValue() == -1) {
            return Integer.valueOf(0);
        }
        return this.backgroundOverlay;
    }

    public void cleanup(Context context) throws Exception {
    }

    public void doPostFetchActions(Context context, final ModelPostFetchCompleteListener listener) {
        HtmlAssetFetcher.fetch(this, new GenericCallback() {
            public void onCallback(Object object, Throwable e) {
                Logger.format("(HTML ASSETS CACHED) %s", InterstitialModel.this);
                InterstitialModel.this.setIsFullyCached(true);
                InterstitialModel.this.setIsReady(true);
                if (listener != null) {
                    listener.onComplete(InterstitialModel.this, null);
                }
            }
        });
    }
}
