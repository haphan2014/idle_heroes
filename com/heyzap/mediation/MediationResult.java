package com.heyzap.mediation;

import com.heyzap.common.lifecycle.AdDisplay;
import com.heyzap.common.lifecycle.DisplayOptions;
import com.heyzap.common.lifecycle.FetchResult;
import com.heyzap.internal.Constants.CreativeType;
import com.heyzap.mediation.abstr.NetworkAdapter;
import java.util.ArrayList;
import java.util.List;

public class MediationResult {
    public AdDisplay display = null;
    public DisplayOptions displayOptions;
    private String error;
    public String id;
    public List<NetworkResult> networkResults = new ArrayList();
    public NetworkResult selectedNetwork;

    public static class NetworkResult {
        public final NetworkAdapter adapter;
        public final CreativeType creativeType;
        public DisplayOptions displayOptions;
        public final FetchResult fetchResult;
        public final String id;
        public final String network;
        public final int ordinal;
        public final Double score;

        public NetworkResult(String id, Double score, NetworkAdapter adapter, String networkName, FetchResult fetchResult, int ordinal, CreativeType creativeType, DisplayOptions displayOptions) {
            this.id = id;
            this.score = score;
            this.network = networkName;
            this.fetchResult = fetchResult;
            this.adapter = adapter;
            this.ordinal = ordinal;
            this.creativeType = creativeType;
            this.displayOptions = displayOptions;
        }

        public String toString() {
            Object[] objArr = new Object[2];
            objArr[0] = this.network;
            objArr[1] = String.format("%.3f", new Object[]{this.score});
            return String.format("<NetworkResult: %s score: %s>", objArr);
        }
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getError() {
        return this.error;
    }
}
