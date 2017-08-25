package com.heyzap.house.model;

import android.content.Context;
import android.net.Uri;
import com.facebook.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.games.Games;
import com.heyzap.common.cache.Entry;
import com.heyzap.common.net.APIClient;
import com.heyzap.common.video.Cacher;
import com.heyzap.common.video.VideoDisplayOptions;
import com.heyzap.common.video.VideoModelInterface;
import com.heyzap.house.Manager;
import com.heyzap.house.model.AdModel.HtmlAssetFetcher;
import com.heyzap.house.model.AdModel.ModelPostFetchCompleteListener;
import com.heyzap.http.JsonHttpResponseHandler;
import com.heyzap.http.RequestParams;
import com.heyzap.internal.Constants.AdUnit;
import com.heyzap.internal.GenericCallback;
import com.heyzap.internal.Logger;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VideoModel extends AdModel implements Serializable, VideoModelInterface {
    public static String FORMAT = "video";
    private static final long serialVersionUID = -8117677567047791235L;
    private Boolean allowStreamingFallback;
    private Entry cacheEntry;
    private Context context;
    private Boolean disableGlobalTouch;
    private HashMap<AdUnit, VideoDisplayOptions> displayOptions;
    private Boolean forceStreaming;
    private Integer interstitialBackgroundOverlayColor;
    private int interstitialHeight;
    private int interstitialWidth;
    private Boolean manualSize;
    private int percentDownloaded;
    private Boolean sentVideoComplete;
    public int size;
    private ArrayList<String> staticUrls;
    private ArrayList<String> streamingUrls;
    private Integer videoHeight;
    private Integer videoLength;
    private Integer videoWidth;

    class C13491 extends JsonHttpResponseHandler {
        C13491() {
        }

        public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
            if (response.optInt(Games.EXTRA_STATUS, 0) == 200) {
                Logger.format("(COMPLETE) %s", VideoModel.this);
                VideoModel.this.sentVideoComplete = Boolean.valueOf(true);
                return;
            }
            Logger.warn("Video completion not received by server.");
        }
    }

    class C13502 implements GenericCallback {
        C13502() {
        }

        public void onCallback(Object object, Throwable e) {
            Logger.format("(HTML ASSETS CACHED) %s", VideoModel.this);
        }
    }

    public VideoModel(JSONObject response) throws Exception, JSONException {
        super(response);
        this.sentVideoComplete = Boolean.valueOf(false);
        this.interstitialBackgroundOverlayColor = Integer.valueOf(0);
        this.interstitialHeight = -1;
        this.interstitialWidth = -1;
        this.staticUrls = new ArrayList();
        this.streamingUrls = new ArrayList();
        this.videoWidth = Integer.valueOf(0);
        this.videoHeight = Integer.valueOf(0);
        this.videoLength = Integer.valueOf(0);
        this.allowStreamingFallback = Boolean.valueOf(false);
        this.forceStreaming = Boolean.valueOf(false);
        this.cacheEntry = null;
        this.displayOptions = new HashMap();
        this.creativeType = FORMAT;
        if (response.has("interstitial")) {
            JSONObject interstitialObj = response.getJSONObject("interstitial");
            if (interstitialObj.has("meta")) {
                JSONObject interstitialMeta = interstitialObj.getJSONObject("meta");
                this.interstitialHeight = interstitialMeta.optInt("height", this.interstitialHeight);
                this.interstitialWidth = interstitialMeta.optInt("width", this.interstitialWidth);
            }
            setHtmlData(interstitialObj.getString("html_data"));
            this.interstitialBackgroundOverlayColor = Integer.valueOf(interstitialObj.optInt("background_color", this.interstitialBackgroundOverlayColor.intValue()));
        }
        if (response.has("video")) {
            int i;
            JSONObject videoObj = response.getJSONObject("video");
            if (videoObj.has("meta")) {
                JSONObject videoMeta = videoObj.getJSONObject("meta");
                this.videoWidth = Integer.valueOf(videoMeta.optInt("width", this.videoWidth.intValue()));
                this.videoHeight = Integer.valueOf(videoMeta.optInt("height", this.videoHeight.intValue()));
                this.videoLength = Integer.valueOf(videoMeta.optInt("length", this.videoLength.intValue()));
            }
            VideoDisplayOptions defaultOptions = new VideoDisplayOptions();
            defaultOptions.setOptions(videoObj);
            if (videoObj.has("ad_unit")) {
                JSONObject adUnitOverrides = videoObj.getJSONObject("ad_unit");
                for (AdUnit adUnit : AdUnit.values()) {
                    VideoDisplayOptions adUnitOptions = (VideoDisplayOptions) defaultOptions.clone();
                    String lcAdUnit = adUnit.toString().toLowerCase(Locale.US);
                    if (adUnitOverrides.has(lcAdUnit)) {
                        adUnitOptions.setOptions(adUnitOverrides.getJSONObject(lcAdUnit));
                    }
                    this.displayOptions.put(adUnit, adUnitOptions);
                }
            }
            if (videoObj.has("static_url")) {
                JSONArray staticUrls = videoObj.getJSONArray("static_url");
                for (i = 0; i < staticUrls.length(); i++) {
                    this.staticUrls.add(staticUrls.getString(i));
                }
            }
            if (videoObj.has("streaming_url")) {
                JSONArray streamingUrls = videoObj.getJSONArray("streaming_url");
                for (i = 0; i < streamingUrls.length(); i++) {
                    this.streamingUrls.add(streamingUrls.getString(i));
                }
            }
            if (this.staticUrls.size() == 0 && this.streamingUrls.size() == 0) {
                throw new Exception("No video URLs.");
            }
        }
        setShouldRefetchIfNotReady(response.optBoolean("should_refetch_if_not_ready", true));
    }

    public VideoDisplayOptions getVideoDisplayOptions() {
        if (getAdUnit() == null) {
            return (VideoDisplayOptions) this.displayOptions.get(AdUnit.UNKNOWN);
        }
        if (this.displayOptions.containsKey(getAdUnit())) {
            return (VideoDisplayOptions) this.displayOptions.get(getAdUnit());
        }
        return (VideoDisplayOptions) this.displayOptions.get(AdUnit.UNKNOWN);
    }

    public int getInterstitialWidth() {
        return this.interstitialWidth;
    }

    public int getInterstitialHeight() {
        return this.interstitialHeight;
    }

    public int getInterstitialBackgroundOverlayColor() {
        return this.interstitialBackgroundOverlayColor.intValue();
    }

    public Entry getCacheEntry() {
        return this.cacheEntry;
    }

    public void setCacheEntry(Entry entry) {
        this.cacheEntry = entry;
    }

    public void setIsReady(Boolean isReady) {
        super.setIsReady(isReady.booleanValue());
    }

    public void setPercentDownloaded(Integer percent) {
        this.percentDownloaded = percent.intValue();
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Uri getStreamingUri() {
        if (this.streamingUrls.size() > 0) {
            return Uri.parse((String) this.streamingUrls.get(0));
        }
        return null;
    }

    public Uri getStaticUri() {
        if (this.staticUrls.size() > 0) {
            return Uri.parse((String) this.staticUrls.get(0));
        }
        return null;
    }

    public Boolean isFileCached() {
        boolean z = this.cacheEntry != null && this.cacheEntry.fileExists().booleanValue();
        return Boolean.valueOf(z);
    }

    public Boolean shouldAllowFallbackToStreaming() {
        return this.allowStreamingFallback;
    }

    public void cleanup(Context context) throws Exception {
        Logger.log("(CLEANUP) " + getImpressionId());
    }

    public void onInterstitialFallback() {
        HashMap<String, String> additionalParams = new HashMap();
        additionalParams.put("interstitial_fallback", AppEventsConstants.EVENT_PARAM_VALUE_YES);
        super.setAdditionalEventParams(additionalParams);
    }

    public Boolean onComplete(Context context, int totalTimeWatched, int totalVideoDuration, Boolean videoComplete) {
        if (this.sentVideoComplete.booleanValue()) {
            Logger.log("Already sent video complete successfully");
            return Boolean.valueOf(false);
        }
        RequestParams params = super.getEventRequestParams();
        params.put("video_duration_ms", Integer.valueOf(totalVideoDuration));
        if (videoComplete.booleanValue()) {
            totalTimeWatched = totalVideoDuration;
        }
        params.put("watched_duration_ms", Integer.valueOf(totalTimeWatched));
        params.put("video_finished", videoComplete.booleanValue() ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false");
        params.put("lockout_time_seconds", Integer.valueOf((int) (((double) getVideoDisplayOptions().lockoutTime) / 1000.0d)));
        if (getAdUnit() == AdUnit.INCENTIVIZED) {
            params.put("incentivized", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        }
        APIClient.post(context.getApplicationContext(), Manager.AD_SERVER + "/event/video_impression_complete", params, new C13491());
        return Boolean.valueOf(true);
    }

    public void doPostFetchActions(Context context, ModelPostFetchCompleteListener listener) {
        try {
            HtmlAssetFetcher.fetch(this, new C13502());
            if (!getVideoDisplayOptions().forceStreaming) {
                Cacher.start(context, this, listener);
            } else if (listener != null) {
                listener.onComplete(this, null);
            }
        } catch (Throwable e) {
            Logger.trace(e);
            if (listener != null) {
                listener.onComplete(null, e);
            }
        }
    }

    public String getCreativeUniqueIdentifier() {
        return String.format("%s", new Object[]{Integer.valueOf(getCreativeId())});
    }
}
