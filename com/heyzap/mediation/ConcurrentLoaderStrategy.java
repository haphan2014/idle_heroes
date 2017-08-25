package com.heyzap.mediation;

import com.heyzap.common.concurrency.FutureUtils;
import com.heyzap.common.concurrency.ListenableFuture;
import com.heyzap.common.concurrency.PausableRunnable;
import com.heyzap.common.concurrency.PausableRunnable.PauseSignal;
import com.heyzap.common.concurrency.SettableFuture;
import com.heyzap.common.lifecycle.FetchOptions;
import com.heyzap.common.lifecycle.FetchResult;
import com.heyzap.internal.Constants.AdUnit;
import com.heyzap.internal.Constants.AuctionType;
import com.heyzap.internal.Constants.CreativeType;
import com.heyzap.internal.Logger;
import com.heyzap.mediation.abstr.NetworkAdapter;
import com.heyzap.mediation.adapter.AdapterPool;
import com.heyzap.mediation.adapter.FetchRequestConsumer;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ConcurrentLoaderStrategy {
    private static double defaultMaxLoad = 1.0d;
    private final AdapterPool adapterPool;
    private double currentLoad = 0.0d;
    private final FetchRequestConsumer fetchRequestConsumer;
    private final FetchRequestStore fetchRequestStore;
    private double maxLoad;
    private final ArrayList<NetworkConfig> networkConfigs;
    private final PauseSignal pauseSignal;
    private final ScheduledExecutorService scheduledExecutorService;

    class C13911 implements Runnable {
        C13911() {
        }

        public void run() {
            ConcurrentLoaderStrategy.this.startNextAdapter();
        }
    }

    public static class LoaderValidationException extends Exception {
        public LoaderValidationException(String message) {
            super(message);
        }

        public LoaderValidationException(Exception e) {
            super(e);
        }
    }

    public static class NetworkConfig {
        private static int DEFAULT_TTL = 10000;
        public List<AdUnit> adUnits;
        public NetworkAdapter adapter;
        public String adapterName;
        public EnumSet<CreativeType> creativeTypes;
        public Map<String, String> data = new HashMap();
        public double load = 1.0d;
        public SettableFuture<Boolean> loadingFuture;
        public int ttl = DEFAULT_TTL;

        public NetworkConfig(JSONObject jconfig) throws Exception {
            int i;
            this.adapterName = jconfig.getString("network");
            this.load = jconfig.optDouble("load", 1.0d);
            this.ttl = jconfig.optInt("ttl", DEFAULT_TTL);
            this.creativeTypes = EnumSet.noneOf(CreativeType.class);
            JSONArray creativeTypeArray = jconfig.optJSONArray("creative_types");
            if (creativeTypeArray != null) {
                for (i = 0; i < creativeTypeArray.length(); i++) {
                    try {
                        this.creativeTypes.add(CreativeType.valueOf(creativeTypeArray.getString(i).toUpperCase(Locale.US)));
                    } catch (IllegalArgumentException e) {
                        Logger.trace(String.format("Unable to understand CreativeType: %s", new Object[]{creativeTypeArray.getString(i).toUpperCase(Locale.US)}), e);
                    }
                }
            }
            if (this.creativeTypes.size() == 0) {
                throw new LoaderValidationException("No valid creative types found.");
            }
            this.adUnits = new ArrayList();
            JSONArray jadUnits = jconfig.getJSONArray("ad_units");
            for (i = 0; i < jadUnits.length(); i++) {
                try {
                    this.adUnits.add(AdUnit.valueOf(jadUnits.getString(i).toUpperCase(Locale.US)));
                } catch (IllegalArgumentException e2) {
                    Logger.trace(String.format("Unable to understand AdUnit: %s", new Object[]{jadUnits.getString(i).toUpperCase(Locale.US)}), e2);
                }
            }
            this.adUnits.retainAll(((CreativeType) this.creativeTypes.iterator().next()).adUnits());
            if (this.adUnits.size() == 0) {
                throw new LoaderValidationException("No valid adunits.");
            }
            try {
                JSONObject jdata = jconfig.optJSONObject("data");
                if (jdata != null) {
                    Iterator keys = jdata.keys();
                    while (keys.hasNext()) {
                        Object key = keys.next();
                        if (key instanceof String) {
                            this.data.put((String) key, jdata.optString((String) key));
                        } else {
                            throw new JSONException("Key not a string.");
                        }
                    }
                }
            } catch (Exception e3) {
                throw new LoaderValidationException(e3);
            }
        }

        public FetchOptions getFetchOptions() {
            return FetchOptions.builder(this.adapter.getCanonicalName(), (CreativeType) this.creativeTypes.iterator().next(), this.adapter.getCanonicalName().endsWith("cross_promo") ? AuctionType.CROSS_PROMO : AuctionType.MONETIZATION).build();
        }

        public NetworkConfig(String network, double load, int ttl, List<AdUnit> adUnits, EnumSet<CreativeType> creativeTypes) {
            this.adapterName = network;
            this.load = load;
            this.ttl = ttl;
            this.adUnits = adUnits;
            this.creativeTypes = creativeTypes;
        }
    }

    public ConcurrentLoaderStrategy(AdapterPool adapterPool, ScheduledExecutorService scheduledExecutorService, PauseSignal pauseSignal, FetchRequestStore fetchRequestStore) {
        this.adapterPool = adapterPool;
        this.scheduledExecutorService = scheduledExecutorService;
        this.pauseSignal = pauseSignal;
        this.fetchRequestStore = fetchRequestStore;
        this.fetchRequestConsumer = new FetchRequestConsumer(fetchRequestStore);
        this.networkConfigs = new ArrayList();
    }

    public void configureFromJson(JSONObject config) throws JSONException {
        this.maxLoad = config.optDouble("max_load", defaultMaxLoad);
        JSONArray jNetworkConfigs = config.getJSONArray("networks");
        for (int i = 0; i < jNetworkConfigs.length(); i++) {
            try {
                this.networkConfigs.add(new NetworkConfig(jNetworkConfigs.getJSONObject(i)));
            } catch (LoaderValidationException e) {
                Logger.warn(String.format("Failed to load loader config: %s", new Object[]{jNetworkConfigs.optJSONObject(i)}) + " - " + e.getMessage());
            } catch (Exception e2) {
                Logger.trace(String.format("Failed to load loader config: %s", new Object[]{jNetworkConfigs.optJSONObject(i)}), e2);
            }
        }
    }

    public void start() {
        this.fetchRequestStore.addUpdateCallback(new C13911(), this.scheduledExecutorService);
        startNextAdapter();
    }

    private void startNextAdapter() {
        while (this.currentLoad < this.maxLoad) {
            NetworkConfig networkConfig = findNextNetworkConfig();
            if (networkConfig != null) {
                startAdapter(networkConfig);
            } else {
                return;
            }
        }
    }

    private void startAdapter(final NetworkConfig networkConfig) {
        this.currentLoad += networkConfig.load;
        new PausableRunnable(this.pauseSignal, this.scheduledExecutorService) {
            public void runWhenUnpaused() {
                final ListenableFuture<FetchResult> fetchFuture = FutureUtils.wrapTimeout(networkConfig.adapter.start(networkConfig.getFetchOptions()), ConcurrentLoaderStrategy.this.scheduledExecutorService, (long) networkConfig.ttl, TimeUnit.MILLISECONDS);
                fetchFuture.addListener(new Runnable() {
                    public void run() {
                        String skippingReason = "finished";
                        try {
                            fetchFuture.get();
                        } catch (InterruptedException e) {
                            skippingReason = "fetch failed: " + String.valueOf(e);
                        } catch (ExecutionException e2) {
                            if (e2.getCause() instanceof TimeoutException) {
                                skippingReason = "fetch timed out";
                            } else {
                                skippingReason = "fetch failed: " + String.valueOf(e2);
                            }
                        }
                        Logger.debug("ConcurrentLoaderStrategy - " + networkConfig.adapterName + " " + skippingReason + " loading next network");
                        ConcurrentLoaderStrategy.this.currentLoad = ConcurrentLoaderStrategy.this.currentLoad - networkConfig.load;
                        ConcurrentLoaderStrategy.this.startNextAdapter();
                    }
                }, ConcurrentLoaderStrategy.this.scheduledExecutorService);
            }
        }.run();
    }

    private NetworkConfig findNextNetworkConfig() {
        Iterator it = this.networkConfigs.iterator();
        while (it.hasNext()) {
            NetworkConfig networkConfig = (NetworkConfig) it.next();
            int fetchCount = 0;
            for (AdUnit adUnit : networkConfig.adUnits) {
                fetchCount += this.fetchRequestStore.getCount(adUnit);
            }
            if (fetchCount > 0) {
                NetworkAdapter adapter = this.adapterPool.get(networkConfig.adapterName);
                if (adapter != null) {
                    networkConfig.adapter = adapter;
                    if (!adapter.isReadyForFetch(networkConfig.getFetchOptions())) {
                        return networkConfig;
                    }
                } else {
                    continue;
                }
            }
        }
        return null;
    }
}
