package com.heyzap.house.request;

import android.content.Context;
import android.util.DisplayMetrics;
import com.facebook.AppEventsConstants;
import com.heyzap.common.concurrency.ExecutorPool;
import com.heyzap.common.net.APIClient;
import com.heyzap.house.abstr.AbstractFetchHandler;
import com.heyzap.house.handler.InterstitialFetchHandler;
import com.heyzap.house.handler.NativeFetchHandler;
import com.heyzap.house.model.AdModel;
import com.heyzap.http.RequestParams;
import com.heyzap.internal.Constants.CreativeType;
import com.heyzap.mediation.MediationManager;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

public class FetchRequest {
    private static String gameOrientation;
    private static String host = "ads.heyzap.com";
    private Map<String, String> additionalParams = new HashMap();
    private Integer campaignId = Integer.valueOf(0);
    private Integer creativeId = Integer.valueOf(0);
    private EnumSet<CreativeType> creativeTypes = EnumSet.of(CreativeType.STATIC);
    private Boolean debugEnabled = Boolean.valueOf(false);
    private String endpoint = "/in_game_api/ads/fetch_ad";
    private Boolean isImmediate = Boolean.valueOf(false);
    private int maxCount = 1;
    private Boolean randomStrategyEnabled = Boolean.valueOf(false);
    private String rejectedImpressionId = null;
    private int remainingTries = 3;
    private AdRequest request;
    private JSONObject response = null;
    private OnFetchResponse responseHandler;
    private String tag;

    public interface OnFetchResponse {
        void onFetchResponse(List<AdModel> list, FetchRequest fetchRequest, Throwable th);

        void onModelsReceived(List<AdModel> list);
    }

    public static class Factory {
        public static FetchRequest build(AdRequest adRequest) {
            FetchRequest request = new FetchRequest(adRequest.getCreativeTypes(), adRequest.getTag(), Boolean.valueOf(adRequest.isImmediate()), adRequest);
            if (adRequest.getDebuggable().booleanValue()) {
                request.setDebugEnabled(Boolean.valueOf(true));
                request.setRandomStrategyEnabled(Boolean.valueOf(true));
            }
            HashMap<String, String> additionalParams = new HashMap();
            if (adRequest.getAuctionType() != null) {
                additionalParams.put("auction_type", adRequest.getAuctionType().toString().toLowerCase(Locale.US));
            }
            if (adRequest.getCreativeId() != null) {
                additionalParams.put("creative_id", String.valueOf(adRequest.getCreativeId()));
            }
            if (adRequest.getCampaignId() != null) {
                additionalParams.put("campaign_id", String.valueOf(adRequest.getCampaignId()));
            }
            request.setAdditionalParams(additionalParams);
            return request;
        }
    }

    public FetchRequest(EnumSet<CreativeType> creativeTypes, String tag, Boolean isImmediate, AdRequest request) {
        this.tag = tag;
        this.creativeTypes = creativeTypes;
        this.isImmediate = isImmediate;
        this.request = request;
    }

    public Boolean isValid() {
        return Boolean.valueOf(this.remainingTries > 0);
    }

    public void setResponseHandler(OnFetchResponse handler) {
        this.responseHandler = handler;
    }

    public static void updateOrientation(Context context) {
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        gameOrientation = dm.widthPixels > dm.heightPixels ? "landscape" : "portrait";
    }

    public RequestParams getParams(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Context is NULL.");
        }
        String creativeTypeStr;
        RequestParams requestParams = new RequestParams(this.additionalParams);
        if (this.creativeTypes.contains(CreativeType.NATIVE)) {
            creativeTypeStr = CreativeType.requestString(EnumSet.of(CreativeType.NATIVE));
        } else if (this.isImmediate.booleanValue()) {
            creativeTypeStr = CreativeType.requestString(EnumSet.of(CreativeType.STATIC));
        } else {
            creativeTypeStr = CreativeType.requestString(this.creativeTypes);
        }
        requestParams.put("creative_type", creativeTypeStr);
        if (!requestParams.containsKey("orientation").booleanValue()) {
            if (gameOrientation == null) {
                updateOrientation(context);
            }
            requestParams.put("orientation", gameOrientation);
        }
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        int height = dm.heightPixels;
        int width = dm.widthPixels;
        String reportedOrientation = requestParams.get("orientation");
        boolean z = (reportedOrientation.equals("landscape") && height > width) || (reportedOrientation.equals("portrait") && width > height);
        if (Boolean.valueOf(z).booleanValue()) {
            width = dm.heightPixels;
            height = dm.widthPixels;
        }
        requestParams.put("device_width", String.valueOf(width));
        requestParams.put("device_height", String.valueOf(height));
        requestParams.put("supported_features", "chromeless,js_visibility_callback");
        if (this.tag != null) {
            requestParams.put("tag", AdModel.normalizeTag(this.tag));
        } else {
            requestParams.put("tag", AdModel.DEFAULT_TAG_NAME);
        }
        if (this.rejectedImpressionId != null) {
            requestParams.put("rejected_impression_id", this.rejectedImpressionId);
        }
        if (this.maxCount > 1) {
            requestParams.put("max_count", String.valueOf(this.maxCount));
        }
        if (this.creativeId.intValue() > 0) {
            requestParams.put("creative_id", String.valueOf(this.creativeId));
        }
        if (this.campaignId.intValue() > 0) {
            requestParams.put("campaign_id", String.valueOf(this.campaignId));
        }
        if (this.debugEnabled.booleanValue()) {
            requestParams.put("debug", AppEventsConstants.EVENT_PARAM_VALUE_YES);
        }
        if (this.randomStrategyEnabled.booleanValue()) {
            requestParams.put("use_random_strategy_v2", AppEventsConstants.EVENT_PARAM_VALUE_YES);
        }
        if (!this.creativeTypes.contains(CreativeType.NATIVE)) {
            requestParams.put("session_fullscreen_mediated", Integer.valueOf(MediationManager.getSessionFullscreenAdImpressions()));
        }
        return requestParams;
    }

    public void execute(final Context context) {
        if (isValid().booleanValue()) {
            AbstractFetchHandler fetchHandler;
            incrementTries();
            if (this.creativeTypes.contains(CreativeType.NATIVE)) {
                fetchHandler = new NativeFetchHandler(context, this);
            } else {
                fetchHandler = new InterstitialFetchHandler(context, this);
            }
            fetchHandler.setCallback(this.responseHandler);
            ExecutorPool.getInstance().execute(new Runnable() {
                public void run() {
                    APIClient.post(context, FetchRequest.this.getUrl(), FetchRequest.this.getParams(context), fetchHandler);
                }
            });
        } else if (this.responseHandler != null) {
            this.responseHandler.onFetchResponse(null, this, new Throwable("bad_request"));
        }
    }

    public void incrementTries() {
        this.remainingTries--;
    }

    public void setRejectedImpressionId(String impressionId) {
        this.rejectedImpressionId = impressionId;
    }

    public void setAdditionalParams(Map<String, String> params) {
        this.additionalParams = params;
    }

    public void setCreativeId(Integer creativeId) {
        this.creativeId = creativeId;
    }

    public Integer getCreativeId() {
        return this.creativeId;
    }

    public AdRequest getAdRequest() {
        return this.request;
    }

    public void setDebugEnabled(Boolean enabled) {
        this.debugEnabled = enabled;
    }

    public Boolean getDebugEnabled() {
        return this.debugEnabled;
    }

    public void setRandomStrategyEnabled(Boolean enabled) {
        this.randomStrategyEnabled = enabled;
    }

    public Boolean getRandomStrategyEnabled() {
        return this.randomStrategyEnabled;
    }

    public void setCampaignId(Integer campaignId) {
        this.campaignId = campaignId;
    }

    public Integer getCampaignId() {
        return this.campaignId;
    }

    public String getTag() {
        return this.tag;
    }

    public void setMaxCount(int count) {
        this.maxCount = count;
    }

    public Integer getMaxCount() {
        return Integer.valueOf(this.maxCount);
    }

    public String getUrl() {
        return String.format("https://%s%s", new Object[]{host, this.endpoint});
    }

    public static void setDefaultHost(String host) {
        if (host == null) {
            host = "ads.heyzap.com";
        }
        host = host;
    }
}
