package com.heyzap.mediation.display;

import android.content.Context;
import android.util.DisplayMetrics;
import com.heyzap.common.concurrency.ExecutorPool;
import com.heyzap.common.concurrency.SettableFuture;
import com.heyzap.common.net.APIClient;
import com.heyzap.http.JsonHttpResponseHandler;
import com.heyzap.http.RequestParams;
import com.heyzap.internal.Constants.CreativeType;
import com.heyzap.internal.ContextReference;
import com.heyzap.internal.Logger;
import com.heyzap.internal.RetryManager;
import com.heyzap.internal.RetryManager.ExponentialSchedule;
import com.heyzap.internal.RetryManager.RetryableTask;
import com.heyzap.mediation.display.DisplayConfig.Network;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

public class MediatedDisplayConfigLoader implements DisplayConfigLoader {
    protected static final int MAX_MEDIATION_ATTEMPTS = 3;
    private static final String MEDIATION_CACHE_KEY = "mediation_cache";
    private static final String SHARED_PREFS = "heyzap.mediation_display_config_loader";
    private final ContextReference contextRef;
    private SettableFuture<DisplayConfig> latestConfig;
    private final ScheduledExecutorService scheduledExecutorService;

    public MediatedDisplayConfigLoader(ContextReference contextReference) {
        this(contextReference, ExecutorPool.getInstance());
    }

    public MediatedDisplayConfigLoader(ContextReference contextReference, ScheduledExecutorService scheduledExecutorService) {
        this.contextRef = contextReference;
        this.scheduledExecutorService = scheduledExecutorService;
    }

    public void start() {
        consume();
    }

    public SettableFuture<DisplayConfig> peek() {
        return this.latestConfig;
    }

    public synchronized SettableFuture<DisplayConfig> consume() {
        SettableFuture<DisplayConfig> config;
        config = fetchNext();
        this.latestConfig = config;
        return config;
    }

    private static DisplayConfig makeDisplayConfig(Context context, JSONObject response) throws JSONException {
        DisplayConfig mediationResponse = new DisplayConfig(response, context);
        Map<CreativeType, List<String>> waterfalls = new HashMap();
        for (Network network : mediationResponse.networks) {
            if (!waterfalls.containsKey(network.creativeType)) {
                waterfalls.put(network.creativeType, new ArrayList());
            }
            ((List) waterfalls.get(network.creativeType)).add(network.network);
        }
        return mediationResponse;
    }

    protected static JSONObject getMediateCache(Context context) {
        try {
            return new JSONObject(context.getSharedPreferences(SHARED_PREFS, 0).getString(MEDIATION_CACHE_KEY, ""));
        } catch (JSONException e) {
            Logger.error("Invalid Mediation Cache");
            return new JSONObject();
        }
    }

    protected static void storeMediateCache(Context context, JSONObject response) {
        context.getSharedPreferences(SHARED_PREFS, 0).edit().putString(MEDIATION_CACHE_KEY, response.toString()).apply();
        Logger.info("Cached new mediation waterfall.");
    }

    private SettableFuture<DisplayConfig> fetchNext() {
        final SettableFuture<DisplayConfig> config = SettableFuture.create();
        final RequestParams params = getParams();
        new RetryManager(new RetryableTask() {
            private int currentAttempt = 1;

            class C14241 extends JsonHttpResponseHandler {
                C14241() {
                }

                public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                    try {
                        DisplayConfig displayConfig = MediatedDisplayConfigLoader.makeDisplayConfig(MediatedDisplayConfigLoader.this.contextRef.getApp(), response);
                        MediatedDisplayConfigLoader.storeMediateCache(MediatedDisplayConfigLoader.this.contextRef.getApp(), response);
                        if (!config.isDone()) {
                            Logger.info("Using mediation response instead of cache! Nice!");
                            config.set(displayConfig);
                        }
                    } catch (JSONException e) {
                        Logger.error("Could not load mediation response, retrying.", e);
                        C14251.this.retry();
                    }
                }

                public void onFailure(int statusCode, Header[] headers, byte[] responseBytes, Throwable throwable) {
                    Logger.error("Display config loader failed to load /mediate, status: " + statusCode, throwable);
                    C14251.this.retry();
                }
            }

            public boolean retry() {
                if (this.currentAttempt < 3) {
                    this.currentAttempt++;
                    return super.retry();
                }
                Logger.warn("Could not refresh mediation waterfall after 3 attempts.  Cache will be used if available.");
                if (MediatedDisplayConfigLoader.getMediateCache(MediatedDisplayConfigLoader.this.contextRef.getApp()) != null) {
                    return false;
                }
                Logger.error("No cached waterfall.  Retrying.");
                this.currentAttempt = 1;
                return super.retry();
            }

            public void run() {
                APIClient.get(MediatedDisplayConfigLoader.this.contextRef.getApp(), "https://med.heyzap.com/mediate", params, new C14241());
            }
        }, new ExponentialSchedule(1.5d, 5, TimeUnit.SECONDS), this.scheduledExecutorService).start();
        try {
            DisplayConfig displayConfig = makeDisplayConfig(this.contextRef.getApp(), getMediateCache(this.contextRef.getApp()));
            if (!config.isDone()) {
                config.set(displayConfig);
            }
        } catch (JSONException e) {
            Logger.error("Could not load Cached Mediation Waterfall!", e);
        }
        return config;
    }

    private RequestParams getParams() {
        RequestParams params = new RequestParams();
        DisplayMetrics dm = this.contextRef.getApp().getResources().getDisplayMetrics();
        params.put("orientation", dm.widthPixels > dm.heightPixels ? "landscape" : "portrait");
        return params;
    }
}
