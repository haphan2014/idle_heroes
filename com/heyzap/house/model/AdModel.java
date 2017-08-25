package com.heyzap.house.model;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.games.Games;
import com.heyzap.common.cache.Entry;
import com.heyzap.common.concurrency.ExecutorPool;
import com.heyzap.common.net.APIClient;
import com.heyzap.house.Manager;
import com.heyzap.house.abstr.AbstractActivity;
import com.heyzap.house.handler.AttributionHandler;
import com.heyzap.house.request.AdRequest;
import com.heyzap.http.JsonHttpResponseHandler;
import com.heyzap.http.RequestParams;
import com.heyzap.internal.Constants.AdUnit;
import com.heyzap.internal.GenericCallback;
import com.heyzap.internal.Logger;
import com.heyzap.internal.Utils;
import com.heyzap.sdk.ads.HeyzapAds.OnStatusListener;
import com.heyzap.sdk.mediation.adapter.HeyzapAdapter.AdListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class AdModel implements Serializable {
    public static String DEFAULT_TAG_NAME = "default";
    public static String FORMAT = null;
    private static final long serialVersionUID = 5832972902300807723L;
    public String actionUrl;
    private transient AdRequest adRequest;
    private AdUnit adUnit;
    private Map<String, String> additionalEventParams = new HashMap();
    private Integer creativeId;
    private int creativeSuccess;
    protected String creativeType;
    private int displayTtl = 0;
    private boolean fetchOnDisplay = false;
    private long fetchTime = System.currentTimeMillis();
    private String gamePackage;
    private transient boolean hasBeenShown = false;
    private AtomicReference<String> htmlData = new AtomicReference("");
    private transient String htmlPath;
    protected String impressionId;
    private transient boolean isFullyCached = false;
    private boolean isReady = false;
    private transient Runnable nextFetchCallback;
    public String preCacheHtmlData;
    protected int requiredOrientation = 0;
    private Boolean sentClick = Boolean.valueOf(false);
    private Boolean sentImpression = Boolean.valueOf(false);
    private Boolean sentIncentiveComplete = Boolean.valueOf(false);
    private boolean shouldRefetchIfNotReady = false;
    private boolean showOnlyAfterContentLoaded = false;
    private String strategy;
    private String tag;
    private long ttl = 0;
    public String userIdentifier;

    public interface ModelPostFetchCompleteListener {
        void onComplete(Object obj, Throwable th);
    }

    class C13441 extends JsonHttpResponseHandler {
        C13441() {
        }

        public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
            if (response.optInt(Games.EXTRA_STATUS, 0) == 200) {
                Logger.format("(CLICK) %s", AdModel.this);
                AdModel.this.sentClick = Boolean.valueOf(true);
            }
        }
    }

    class C13452 extends JsonHttpResponseHandler {
        C13452() {
        }

        public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
            if (AdModel.this.adRequest != null) {
                OnStatusListener statusListener = AdModel.this.adRequest.getOnStatusListener();
                if (statusListener instanceof AdListener) {
                    ((AdListener) statusListener).onImpressed();
                }
            }
            if (response.optInt(Games.EXTRA_STATUS, 0) == 200) {
                Logger.format("(IMPRESSION) %s", AdModel.this);
                AdModel.this.sentImpression = Boolean.valueOf(true);
            }
        }
    }

    public static class HtmlAssetFetcher {
        public static void fetch(final AdModel model, final GenericCallback callback) {
            String htmlData = model.getHtmlData();
            if (htmlData != null) {
                final List<String> imgUrls = new ArrayList();
                final List<String> cssUrls = new ArrayList();
                Matcher m = Pattern.compile("url\\((\"[^\"]+\")\\)").matcher(htmlData);
                while (m.find()) {
                    String url = m.group(1);
                    imgUrls.add(url.substring(1, url.length() - 1));
                }
                m = Pattern.compile("img.*src=\"([^\"]+)\"").matcher(htmlData);
                while (m.find()) {
                    imgUrls.add(m.group(1));
                }
                ExecutorPool.getInstance().execute(new Runnable() {
                    public void run() {
                        boolean creativeSuccess = false;
                        boolean creativeFailure = false;
                        for (String urlString : imgUrls) {
                            Uri newUrl = null;
                            try {
                                newUrl = HtmlAssetFetcher.saveUrlAsFile(urlString, model);
                            } catch (MalformedURLException e) {
                                creativeFailure = true;
                            } catch (Throwable e2) {
                                creativeFailure = true;
                                try {
                                    Logger.trace(e2);
                                } catch (Throwable e22) {
                                    Logger.log("HtmlAssetFetcher interrupted");
                                    Logger.trace(e22);
                                    return;
                                }
                            }
                            if (newUrl != null) {
                                creativeSuccess = true;
                                model.setHtmlData(model.getHtmlData().replace(urlString, newUrl.toString()));
                            }
                        }
                        for (String urlString2 : cssUrls) {
                            newUrl = null;
                            try {
                                newUrl = HtmlAssetFetcher.saveUrlAsFile(newUrl.toString(), model);
                            } catch (Throwable e222) {
                                creativeFailure = true;
                                Logger.trace(e222);
                            } catch (Throwable e2222) {
                                creativeFailure = true;
                                Logger.trace(e2222);
                            }
                            if (newUrl != null) {
                                creativeSuccess = true;
                                model.setHtmlData(model.getHtmlData().replace(String.format("\"%s\"", new Object[]{urlString2}), newUrl.toString()));
                            }
                        }
                        if (!creativeSuccess) {
                            model.creativeSuccess = 0;
                        } else if (creativeFailure) {
                            model.creativeSuccess = 1;
                        } else {
                            model.creativeSuccess = 2;
                        }
                        if (callback != null) {
                            callback.onCallback(model, null);
                        }
                    }
                });
            }
        }

        private static Uri saveUrlAsFile(String urlString, AdModel model) throws IOException, MalformedURLException, HtmlAssetFetcherInterruptException {
            if (model.hasBeenShown()) {
                throw new HtmlAssetFetcherInterruptException();
            }
            URL remoteLoc = new URL(urlString);
            try {
                byte[] hash = MessageDigest.getInstance("MD5").digest(remoteLoc.getPath().getBytes());
                String identifier = String.format("%032x", new Object[]{new BigInteger(1, hash)});
                File outputFile = new File(Manager.getInstance().getFileCache().getDirectory(), identifier);
                Entry entry = Manager.getInstance().getFileCache().get(identifier);
                if (entry != null) {
                    return entry.getUri();
                }
                OutputStream file = new FileOutputStream(outputFile);
                byte[] readBuffer = new byte[65536];
                InputStream stream = remoteLoc.openStream();
                while (true) {
                    int bytesRead = stream.read(readBuffer);
                    if (bytesRead > 0) {
                        file.write(readBuffer, 0, bytesRead);
                    } else {
                        file.close();
                        entry = new Entry();
                        entry.setFilename(outputFile.getAbsolutePath());
                        entry.setIdentifier(identifier);
                        entry.setDirty(Boolean.valueOf(false));
                        Manager.getInstance().getFileCache().put(entry);
                        return entry.getUri();
                    }
                }
            } catch (NoSuchAlgorithmException e) {
                return Uri.parse(remoteLoc.toString());
            } catch (FileNotFoundException e2) {
                return Uri.parse(remoteLoc.toString());
            }
        }
    }

    public static class HtmlAssetFetcherInterruptException extends Exception {
    }

    public abstract void cleanup(Context context) throws Exception;

    public abstract void doPostFetchActions(Context context, ModelPostFetchCompleteListener modelPostFetchCompleteListener);

    public AdModel(JSONObject response) throws Exception, JSONException {
        this.strategy = response.optString("ad_strategy", this.strategy);
        this.gamePackage = response.optString("promoted_game_package", "");
        this.impressionId = response.getString(AbstractActivity.ACTIVITY_INTENT_IMPRESSION_KEY);
        this.actionUrl = response.optString("click_url", null);
        this.ttl = response.optLong("refresh_time", 0) * 1000;
        this.creativeId = Integer.valueOf(response.optInt("creative_id", 0));
        if (response.has("display_ttl")) {
            this.displayTtl = response.optInt("display_ttl");
        }
        this.showOnlyAfterContentLoaded = response.optBoolean("show_only_after_content_loaded", true);
    }

    public void onClick(Context context) {
        onClick(context, null);
    }

    public Boolean onClick(Context context, String customGamePackage) {
        if (this.sentClick.booleanValue()) {
            Logger.log("Already sent click successfully.");
            return Boolean.valueOf(true);
        } else if (System.currentTimeMillis() - Manager.getInstance().lastClickedTime < Manager.maxClickDifference) {
            return Boolean.valueOf(false);
        } else {
            RequestParams params = getEventRequestParams();
            if (customGamePackage != null) {
                params.put("custom_game_package", customGamePackage);
            }
            APIClient.post(context.getApplicationContext(), Manager.AD_SERVER + "/register_click", params, new C13441());
            return Boolean.valueOf(true);
        }
    }

    public void onImpression(Context context) {
        if (this.sentImpression.booleanValue()) {
            Logger.log("Already sent impression successfully.");
            return;
        }
        AttributionHandler.getInstance().didImpression(context, this);
        APIClient.post(context.getApplicationContext(), Manager.AD_SERVER + "/register_impression", getEventRequestParams(), new C13452());
    }

    public static void onManyImpressions(Context context, final List<AdModel> models) {
        if (models.size() != 0) {
            AdUnit firstAdUnit;
            ArrayList<String> impressionIds = new ArrayList();
            for (AdModel model : models) {
                if (!model.sentImpression.booleanValue()) {
                    impressionIds.add(model.getImpressionId());
                }
            }
            try {
                firstAdUnit = ((AdModel) models.get(0)).getAdUnit();
            } catch (Exception e) {
                firstAdUnit = AdUnit.UNKNOWN;
            }
            String adUnit = firstAdUnit.toString().toLowerCase(Locale.US);
            if (impressionIds.size() == 0) {
                Logger.log("Already sent impression(s)");
                return;
            }
            RequestParams params = new RequestParams();
            params.put("impression_ids", TextUtils.join(",", impressionIds));
            params.put("ad_unit", adUnit);
            APIClient.post(context, Manager.AD_SERVER + "/register_impression", params, new JsonHttpResponseHandler() {
                public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                    Iterator it;
                    if (response.optInt(Games.EXTRA_STATUS, 0) == 200) {
                        for (AdModel ad : models) {
                            if (!ad.sentImpression.booleanValue()) {
                                Logger.format("(IMPRESSION) %s", ad);
                                ad.setSentImpression(Boolean.valueOf(true));
                            }
                        }
                        return;
                    }
                    it = models.iterator();
                    while (it.hasNext()) {
                        Logger.format("(IMPRESSION ERROR) Bad Response: %s", (AdModel) it.next());
                    }
                }

                public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                }

                public void onFailure(Throwable e) {
                    Logger.trace(e);
                }

                public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                    onFailure(throwable);
                }

                public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray errorResponse) {
                    onFailure(throwable);
                }
            });
        }
    }

    public void setSentImpression(Boolean sent) {
        this.sentImpression = sent;
    }

    public Boolean sentImpression() {
        return this.sentImpression;
    }

    protected RequestParams getEventRequestParams() {
        RequestParams params;
        if (this.additionalEventParams != null) {
            params = new RequestParams(this.additionalEventParams);
        } else {
            params = new RequestParams();
        }
        params.put("ad_unit", getAdUnit().toString().toLowerCase(Locale.US));
        params.put(AbstractActivity.ACTIVITY_INTENT_IMPRESSION_KEY, getImpressionId());
        params.put("promoted_game_package", getGamePackage());
        if (this.tag != null) {
            params.put("tag", normalizeTag(this.tag));
        }
        return params;
    }

    public void setAdditionalEventParams(Map<String, String> params) {
        this.additionalEventParams = params;
    }

    public Map<String, String> getAdditionalEventParams() {
        return this.additionalEventParams;
    }

    public void setAdUnit(AdUnit adUnit) {
        this.adUnit = adUnit;
    }

    public String getCreativeSuccess() {
        if (this.creativeSuccess == 0) {
            return "all";
        }
        if (this.creativeSuccess == 1) {
            return "some";
        }
        if (this.creativeSuccess == 2) {
            return "none";
        }
        return null;
    }

    public AdUnit getAdUnit() {
        return this.adUnit;
    }

    public String getTag() {
        return this.tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getImpressionId() {
        return this.impressionId;
    }

    public void setImpressionId(String id) throws IllegalArgumentException {
        if (id == null) {
            throw new IllegalArgumentException("Invalid impression ID");
        }
        this.impressionId = id;
    }

    public String getGamePackage() {
        return this.gamePackage;
    }

    public String getFormat() {
        return this.creativeType;
    }

    public int getCreativeId() {
        return this.creativeId.intValue();
    }

    public String getCreativeType() {
        return this.creativeType;
    }

    public Boolean hasSentImpression() {
        return this.sentImpression;
    }

    public Boolean isExpired() {
        boolean z = false;
        if (this.ttl <= 0) {
            return Boolean.valueOf(false);
        }
        if (System.currentTimeMillis() > this.fetchTime + this.ttl) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    public Boolean isInstalled(Context context) {
        return Boolean.valueOf(Utils.packageIsInstalled(this.gamePackage, context.getApplicationContext()));
    }

    public Boolean isReady() {
        return Boolean.valueOf(this.isReady);
    }

    public void setIsReady(boolean ready) {
        this.isReady = ready;
    }

    public boolean isFullyCached() {
        return this.isFullyCached;
    }

    public void setIsFullyCached(boolean isFullyCached) {
        this.isFullyCached = isFullyCached;
    }

    public Boolean supportsCurrentOrientation(Context context) {
        boolean z = this.requiredOrientation == 0 || context.getResources().getConfiguration().orientation == this.requiredOrientation;
        return Boolean.valueOf(z);
    }

    public int getRequiredOrientation() {
        return this.requiredOrientation;
    }

    public int getDisplayTtl() {
        return this.displayTtl;
    }

    public void setNextFetchCallback(Runnable nextFetchCallback) {
        this.nextFetchCallback = nextFetchCallback;
    }

    public boolean showOnlyAfterContentLoaded() {
        return this.showOnlyAfterContentLoaded;
    }

    public boolean shouldRefetchIfNotReady() {
        return this.shouldRefetchIfNotReady;
    }

    public void setShouldRefetchIfNotReady(boolean shouldRefetchIfNotReady) {
        this.shouldRefetchIfNotReady = shouldRefetchIfNotReady;
    }

    public AdRequest getAdRequest() {
        return this.adRequest;
    }

    public void setAdRequest(AdRequest adRequest) {
        this.adRequest = adRequest;
    }

    public static String normalizeTag(String tag) {
        if (tag == null || tag.trim().equals("")) {
            tag = DEFAULT_TAG_NAME;
        }
        return tag.trim();
    }

    public String getHtmlData() {
        return (String) this.htmlData.get();
    }

    public void setHtmlData(String data) {
        this.htmlData.set(data);
    }

    public String toString() {
        return String.format("<%s T:%s I:%s CID: %s>", new Object[]{getClass().getName(), getCreativeType(), getImpressionId(), String.valueOf(this.creativeId)});
    }

    public boolean hasBeenShown() {
        return this.hasBeenShown;
    }

    public void setHasBeenShown(boolean hasBeenShown) {
        this.hasBeenShown = hasBeenShown;
    }
}
