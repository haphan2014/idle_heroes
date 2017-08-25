package com.heyzap.sdk.ads;

import android.content.Context;
import android.view.View;
import com.heyzap.common.lifecycle.FetchFailure;
import com.heyzap.house.Manager;
import com.heyzap.house.handler.ClickHandler;
import com.heyzap.house.model.AdModel;
import com.heyzap.house.model.NativeModel;
import com.heyzap.house.request.FetchRequest;
import com.heyzap.house.request.FetchRequest.OnFetchResponse;
import com.heyzap.internal.Constants.AdUnit;
import com.heyzap.internal.Constants.AuctionType;
import com.heyzap.internal.Constants.CreativeType;
import com.heyzap.sdk.ads.NativeAd.Image;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class HeyzapNativeAd {
    private static AdUnit AD_UNIT = AdUnit.NATIVE;
    private static final ArrayList<String> CREATIVE_TYPES = new ArrayList(Arrays.asList(new String[]{"native"}));
    private static Integer campaignId = Integer.valueOf(0);
    private static Integer creativeId = Integer.valueOf(0);
    private static Boolean debugEnabled = Boolean.valueOf(false);
    private static FetchResponse lastResponse = null;

    public static class Ad extends NativeAdResult implements Serializable {
        private static final long serialVersionUID = 3487495942989497789L;
        private NativeModel model;

        public static class AdException extends Exception {
            private static final long serialVersionUID = 1;
        }

        private Ad(NativeModel model) {
            this.model = model;
        }

        private NativeModel getModel() {
            return this.model;
        }

        public void doImpression() {
            this.model.onImpression(Manager.applicationContext);
        }

        public void doClick(Context context) {
            new ClickHandler(this.model).doClick(context);
        }

        protected String getImpressionId() {
            return this.model.getImpressionId();
        }

        @Deprecated
        public Boolean has(String name) {
            return Boolean.valueOf(this.model.data.has(name));
        }

        @Deprecated
        public Boolean isNull(String name) {
            return Boolean.valueOf(this.model.data.isNull(name));
        }

        @Deprecated
        public String getString(String name) throws AdException {
            try {
                return this.model.data.getString(name);
            } catch (JSONException e) {
                throw new AdException();
            } catch (IllegalArgumentException e2) {
                throw new AdException();
            } catch (Exception e3) {
                throw new AdException();
            }
        }

        @Deprecated
        public String optString(String name) {
            return optString(name, "");
        }

        @Deprecated
        public String optString(String name, String fallback) {
            try {
                fallback = getString(name);
            } catch (Exception e) {
            }
            return fallback;
        }

        @Deprecated
        public Integer getInt(String name) throws AdException {
            try {
                return Integer.valueOf(this.model.data.getInt(name));
            } catch (JSONException e) {
                throw new AdException();
            } catch (IllegalArgumentException e2) {
                throw new AdException();
            } catch (Exception e3) {
                throw new AdException();
            }
        }

        @Deprecated
        public Integer optInt(String name) {
            return optInt(name, Integer.valueOf(0));
        }

        @Deprecated
        public Integer optInt(String name, Integer fallback) {
            try {
                fallback = getInt(name);
            } catch (Exception e) {
            }
            return fallback;
        }

        @Deprecated
        public Boolean getBoolean(String name) throws AdException {
            try {
                return Boolean.valueOf(this.model.data.getBoolean(name));
            } catch (JSONException e) {
                throw new AdException();
            } catch (IllegalArgumentException e2) {
                throw new AdException();
            } catch (Exception e3) {
                throw new AdException();
            }
        }

        @Deprecated
        public Boolean optBoolean(String name) {
            return optBoolean(name, Boolean.valueOf(false));
        }

        @Deprecated
        public Boolean optBoolean(String name, Boolean fallback) {
            try {
                fallback = getBoolean(name);
            } catch (Exception e) {
            }
            return fallback;
        }

        @Deprecated
        public Double getDouble(String name) throws AdException {
            try {
                return Double.valueOf(this.model.data.getDouble(name));
            } catch (JSONException e) {
                throw new AdException();
            } catch (IllegalArgumentException e2) {
                throw new AdException();
            } catch (Exception e3) {
                throw new AdException();
            }
        }

        @Deprecated
        public Double optDouble(String name) {
            return optDouble(name, Double.valueOf(Double.NaN));
        }

        @Deprecated
        public Double optDouble(String name, Double fallback) {
            try {
                fallback = getDouble(name);
            } catch (Exception e) {
            }
            return fallback;
        }

        @Deprecated
        public long getLong(String name) throws AdException {
            try {
                return this.model.data.getLong(name);
            } catch (JSONException e) {
                throw new AdException();
            } catch (IllegalArgumentException e2) {
                throw new AdException();
            } catch (Exception e3) {
                throw new AdException();
            }
        }

        @Deprecated
        public long optLong(String name) {
            return optLong(name, Long.valueOf(0));
        }

        @Deprecated
        public long optLong(String name, Long fallback) {
            try {
                return getLong(name);
            } catch (Exception e) {
                return fallback.longValue();
            }
        }

        public JSONObject getData() {
            return this.model.data;
        }

        public String getDisplayName() {
            return this.model.data.optString("display_name");
        }

        public String getDeveloperName() {
            return this.model.data.optString("developer_name");
        }

        public double getGameRating() {
            return Double.parseDouble(this.model.data.optString("rating", "0.0"));
        }

        public String getIconUri() {
            return this.model.data.optString("icon_uri");
        }

        public void registerView(View view) {
        }

        public String getTitle() {
            return getDisplayName();
        }

        public Image getIcon() {
            String url;
            int width;
            int height;
            try {
                JSONObject iconImage = this.model.data.getJSONObject("icon_image");
                url = iconImage.getString("uri");
                width = iconImage.getInt("width");
                height = iconImage.getInt("height");
            } catch (JSONException e) {
                url = "";
                width = 0;
                height = 0;
            }
            final String u = url;
            final int w = width;
            final int h = height;
            return new Image() {
                public int getWidth() {
                    return w;
                }

                public String getUrl() {
                    return u;
                }

                public int getHeight() {
                    return h;
                }
            };
        }

        public Image getCoverImage() {
            String url;
            int width;
            int height;
            try {
                JSONObject coverImage = this.model.data.getJSONObject("landscape_image");
                url = coverImage.getString("uri");
                width = coverImage.getInt("width");
                height = coverImage.getInt("height");
            } catch (JSONException e) {
                url = "";
                width = 0;
                height = 0;
            }
            final String u = url;
            final int w = width;
            final int h = height;
            return new Image() {
                public int getWidth() {
                    return w;
                }

                public String getUrl() {
                    return u;
                }

                public int getHeight() {
                    return h;
                }
            };
        }

        public String getBody() {
            return optString("description", "");
        }

        public void onClick(View view) {
            doClick(view.getContext());
        }

        public void onImpression() {
            doImpression();
        }

        public FetchFailure getFetchFailure() {
            return null;
        }

        public String getCallToAction() {
            return this.model.data.optString("call_to_action", "Install Now");
        }

        public String getSocialContext() {
            return "";
        }

        public Image getAdChoicesImage() {
            return null;
        }

        public String getAdChoicesUrl() {
            return null;
        }

        public Object getNativeAdObject() {
            return null;
        }
    }

    public static class FetchResponse {
        private List<Ad> ads;
        private String tag;

        private FetchResponse(List<Ad> ads, String tag) {
            this.ads = null;
            this.tag = AdModel.DEFAULT_TAG_NAME;
            if (tag != null) {
                tag = AdModel.DEFAULT_TAG_NAME;
            }
            if (ads != null) {
                this.ads = ads;
            } else {
                this.ads = new ArrayList();
            }
        }

        public void doImpressionOnAll() {
            if (this.ads != null) {
                ArrayList<AdModel> models = new ArrayList();
                for (Ad ad : this.ads) {
                    models.add(ad.getModel());
                }
                AdModel.onManyImpressions(Manager.applicationContext, models);
            }
        }

        public Integer getCount() {
            if (this.ads != null) {
                return Integer.valueOf(this.ads.size());
            }
            return Integer.valueOf(0);
        }

        public String getTag() {
            return this.tag;
        }

        public List<Ad> getAds() {
            return this.ads;
        }
    }

    public interface OnFetchListener {
        void onResponse(FetchResponse fetchResponse, String str, Throwable th);
    }

    private HeyzapNativeAd() {
    }

    public static void fetch(String tag, int maxCount, AuctionType auctionType, final OnFetchListener listener) {
        FetchRequest request = createRequest(tag, auctionType);
        request.setMaxCount(maxCount);
        request.setResponseHandler(new OnFetchResponse() {
            public void onModelsReceived(List<AdModel> list) {
            }

            public void onFetchResponse(List<AdModel> models, FetchRequest request, Throwable e) {
                ArrayList<Ad> ads = null;
                if (e == null) {
                    ads = new ArrayList();
                    for (int i = 0; i < models.size(); i++) {
                        NativeModel model = (NativeModel) models.get(i);
                        if (model != null) {
                            ads.add(new Ad(model));
                        }
                    }
                }
                FetchResponse response = null;
                if (ads != null) {
                    response = new FetchResponse(ads, request.getTag());
                }
                HeyzapNativeAd.lastResponse = response;
                if (listener != null) {
                    listener.onResponse(response, request.getTag(), e);
                }
            }
        });
        request.execute(Manager.applicationContext);
    }

    public static FetchResponse getLastResponse() {
        return lastResponse;
    }

    private static FetchRequest createRequest(String tag, AuctionType auctionType) {
        FetchRequest request = new FetchRequest(EnumSet.of(CreativeType.NATIVE), tag, Boolean.valueOf(true), null);
        Map<String, String> additionalParams = new HashMap();
        additionalParams.put("auction_type", auctionType.toString().toLowerCase(Locale.US));
        request.setAdditionalParams(additionalParams);
        if (debugEnabled.booleanValue()) {
            request.setDebugEnabled(debugEnabled);
            request.setRandomStrategyEnabled(Boolean.valueOf(true));
        }
        request.setCreativeId(creativeId);
        request.setCampaignId(campaignId);
        return request;
    }
}
