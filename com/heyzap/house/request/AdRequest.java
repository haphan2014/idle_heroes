package com.heyzap.house.request;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.heyzap.common.net.Connectivity;
import com.heyzap.house.Manager;
import com.heyzap.house.abstr.AbstractActivity;
import com.heyzap.house.model.AdModel;
import com.heyzap.house.model.VideoModel;
import com.heyzap.house.request.FetchRequest.Factory;
import com.heyzap.house.request.FetchRequest.OnFetchResponse;
import com.heyzap.internal.Constants.AdUnit;
import com.heyzap.internal.Constants.AuctionType;
import com.heyzap.internal.Constants.CreativeType;
import com.heyzap.internal.Logger;
import com.heyzap.internal.Utils;
import com.heyzap.sdk.ads.HeyzapAds.OnIncentiveResultListener;
import com.heyzap.sdk.ads.HeyzapAds.OnStatusListener;
import com.heyzap.sdk.ads.HeyzapInterstitialActivity;
import com.heyzap.sdk.ads.HeyzapVideoActivity;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;

public class AdRequest {
    public static OnIncentiveResultListener DEFAULT_INCENTIVE_LISTENER = new C13522();
    public static OnStatusListener DEFAULT_STATUS_LISTENER = new C13511();
    private AdModel adModel;
    private AuctionType auctionType = null;
    private Integer campaignId;
    private boolean cancelled = false;
    private Integer creativeId;
    private EnumSet<CreativeType> creativeTypes = EnumSet.of(CreativeType.STATIC);
    private HashMap<String, Object> debug = new HashMap();
    private Boolean debuggable = Boolean.valueOf(false);
    private OnIncentiveResultListener incentiveListener = DEFAULT_INCENTIVE_LISTENER;
    private boolean isImmediate = false;
    private OnStatusListener statusListener = DEFAULT_STATUS_LISTENER;
    private String tag;
    private String userIdentifier = null;

    static class C13511 implements OnStatusListener {
        C13511() {
        }

        public void onShow(String tag) {
        }

        public void onHide(String tag) {
        }

        public void onFailedToShow(String tag) {
        }

        public void onFailedToFetch(String tag) {
        }

        public void onClick(String tag) {
        }

        public void onAvailable(String tag) {
        }

        public void onAudioStarted() {
        }

        public void onAudioFinished() {
        }
    }

    static class C13522 implements OnIncentiveResultListener {
        C13522() {
        }

        public void onIncomplete(String tag) {
        }

        public void onComplete(String tag) {
        }
    }

    class C13533 implements OnFetchResponse {
        C13533() {
        }

        public void onModelsReceived(List<AdModel> models) {
            for (AdModel model : models) {
                model.setAdRequest(AdRequest.this);
            }
        }

        public void onFetchResponse(List<AdModel> models, FetchRequest request, Throwable e) {
            if (models == null || models.size() <= 0) {
                if (AdRequest.this.isImmediate) {
                    AdRequest.this.getOnStatusListener().onFailedToFetch(AdRequest.this.getTag());
                } else {
                    AdRequest.this.getOnStatusListener().onFailedToFetch(AdRequest.this.getTag());
                }
                return;
            }
            for (AdModel model : models) {
                if (AdRequest.this.adModel == null && !AdRequest.this.cancelled) {
                    AdRequest.this.setAdModel(model);
                }
            }
        }
    }

    public AdRequest(EnumSet<CreativeType> creativeTypes, String tag) {
        this.tag = tag;
        this.creativeTypes = creativeTypes;
    }

    public void setOnStatusListener(OnStatusListener listener) {
        if (listener != null) {
            this.statusListener = listener;
        } else {
            this.statusListener = DEFAULT_STATUS_LISTENER;
        }
    }

    public void setOnIncentiveListener(OnIncentiveResultListener listener) {
        if (listener != null) {
            this.incentiveListener = listener;
        } else {
            this.incentiveListener = DEFAULT_INCENTIVE_LISTENER;
        }
    }

    public OnStatusListener getOnStatusListener() {
        return this.statusListener;
    }

    public OnIncentiveResultListener getOnIncentiveListener() {
        return this.incentiveListener;
    }

    public void setIsImmediate(boolean isImmediate) {
        this.isImmediate = isImmediate;
    }

    public void setDebugable(Boolean debuggable) {
        this.debuggable = debuggable;
    }

    public void setCreativeId(Integer creativeId) {
        this.creativeId = creativeId;
    }

    public void setCampaignId(Integer campaignId) {
        this.campaignId = campaignId;
    }

    public void setUserIdentifier(String userIdentifier) {
        this.userIdentifier = userIdentifier;
    }

    private void setAdModel(AdModel model) {
        this.adModel = model;
        this.adModel.setAdRequest(this);
        if (this.adModel.isReady().booleanValue()) {
            getOnStatusListener().onAvailable(getTag());
        }
    }

    public Boolean isReady() {
        if (this.adModel != null) {
            return this.adModel.isReady();
        }
        return Boolean.valueOf(false);
    }

    public void fetch(Context context) {
        FetchRequest request = Factory.build(this);
        request.setResponseHandler(new C13533());
        request.execute(context);
    }

    public void show(Activity activity, AdUnit adUnit, String tag) {
        if (!Connectivity.isConnected(activity)) {
            Logger.log("NO CONNECTIVITY");
            this.statusListener.onFailedToShow(this.tag);
        } else if (this.adModel != null) {
            Boolean isReady = this.adModel.isReady();
            if (!isReady.booleanValue() && adUnit.equals(AdUnit.INTERSTITIAL)) {
                isReady = Boolean.valueOf(true);
            }
            if (isReady.booleanValue()) {
                this.adModel.setAdRequest(this);
                this.adModel.setAdUnit(adUnit);
                this.adModel.setTag(tag);
                FetchRequest.updateOrientation(activity);
                if (this.adModel.getFormat().equals(VideoModel.FORMAT)) {
                    VideoModel videoModel = (VideoModel) this.adModel;
                }
                startActivity(activity, this.adModel);
                return;
            }
            this.statusListener.onFailedToShow(tag);
        }
    }

    private static void startActivity(final Activity parentActivity, final AdModel ad) {
        parentActivity.runOnUiThread(new Runnable() {
            public void run() {
                Class klass;
                Manager.getInstance().getDisplayCache().set(ad);
                if (ad.getFormat().equals(VideoModel.FORMAT)) {
                    klass = HeyzapVideoActivity.class;
                } else {
                    klass = HeyzapInterstitialActivity.class;
                }
                Intent intent = new Intent(parentActivity, klass);
                intent.setFlags(603979776);
                intent.putExtra(AbstractActivity.ACTIVITY_INTENT_IMPRESSION_KEY, ad.getImpressionId());
                intent.putExtra(AbstractActivity.ACTIVITY_INTENT_ACTION_KEY, 1);
                intent.putExtra(AbstractActivity.ACTIVITY_INTENT_ORIGINAL_ORIENTATION, parentActivity.getResources().getConfiguration().orientation);
                parentActivity.startActivity(intent);
                if (Utils.getSdkVersion() >= 5) {
                    parentActivity.overridePendingTransition(17432578, 17432579);
                }
            }
        });
    }

    public void setAuctionType(AuctionType auctionType) {
        this.auctionType = auctionType;
    }

    public String getTag() {
        return this.tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
        AdModel model = this.adModel;
        if (model != null) {
            model.setTag(tag);
        }
    }

    public AdModel getAdModel() {
        return this.adModel;
    }

    public void cancel() {
        if (this.adModel != null) {
            this.adModel = null;
        }
        this.cancelled = true;
    }

    public Boolean getDebuggable() {
        return this.debuggable;
    }

    public AuctionType getAuctionType() {
        return this.auctionType;
    }

    public boolean isImmediate() {
        return this.isImmediate;
    }

    public EnumSet<CreativeType> getCreativeTypes() {
        return this.creativeTypes;
    }

    public Integer getCreativeId() {
        return this.creativeId;
    }

    public Integer getCampaignId() {
        return this.campaignId;
    }
}
