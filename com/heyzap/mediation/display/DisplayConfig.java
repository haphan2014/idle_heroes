package com.heyzap.mediation.display;

import android.content.Context;
import com.heyzap.internal.Constants.CreativeType;
import com.heyzap.internal.Logger;
import com.heyzap.internal.Utils;
import com.heyzap.sdk.ads.MediationTestActivityDisabledNetworks;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DisplayConfig {
    private static int defaultDisplayTtl = 1500;
    private static int defaultInterstitialVideoInterval = 30000;
    public int displayTtl = defaultDisplayTtl;
    public String id;
    public boolean interstitialVideoEnabled = true;
    public int interstitialVideoInterval = defaultInterstitialVideoInterval;
    public List<Network> networks = new ArrayList();
    public boolean sortNetworksOnScore = false;

    public static class Network {
        public final CreativeType creativeType;
        public final String id;
        public final String network;
        public final Double score;

        public Network(String id, Double score, String network, CreativeType creativeType) {
            this.id = id;
            this.score = score;
            this.network = network;
            this.creativeType = creativeType;
        }

        public static List<Network> fromJsonObject(JSONObject jobj) throws JSONException {
            String id = jobj.optString("id", "none");
            Double score = Double.valueOf(jobj.optDouble("score", 0.0d));
            String network = jobj.getString("network");
            List<Network> networks = new ArrayList();
            JSONArray creativeTypeArray = jobj.optJSONArray("creative_types");
            if (creativeTypeArray != null) {
                for (int i = 0; i < creativeTypeArray.length(); i++) {
                    networks.add(new Network(id, score, network, CreativeType.valueOf(creativeTypeArray.getString(i).toUpperCase(Locale.US))));
                }
            }
            return networks;
        }

        public String toString() {
            return "{network:\"" + this.network + "\", score:" + String.format("%.3f", new Object[]{this.score}) + "}";
        }

        public Double getScore() {
            return this.score;
        }
    }

    public DisplayConfig(JSONObject jobj, Context context) throws JSONException {
        this.id = jobj.getString("id");
        this.interstitialVideoInterval = jobj.optInt("interstitial_video_interval", defaultInterstitialVideoInterval);
        this.interstitialVideoEnabled = jobj.optBoolean("interstitial_video_enabled", true);
        this.displayTtl = jobj.optInt("display_ttl", this.displayTtl);
        this.sortNetworksOnScore = jobj.optBoolean("sort", this.sortNetworksOnScore);
        JSONArray networkArray = jobj.getJSONArray("networks");
        int i = 0;
        while (i < networkArray.length()) {
            JSONObject networkObj = networkArray.getJSONObject(i);
            try {
                String canonicalName = networkObj.getString("network");
                if (Utils.isDebug(context).booleanValue() && MediationTestActivityDisabledNetworks.isNetworkDisabled(context, canonicalName)) {
                    i++;
                } else {
                    this.networks.addAll(Network.fromJsonObject(networkObj));
                    i++;
                }
            } catch (JSONException e) {
                Logger.error("failed to load network json: ", e);
            }
        }
    }

    public DisplayConfig(String id, boolean interstitialVideoEnabled, int interstitialVideoInterval, int displayTtl, boolean sortNetworksOnScore, List<Network> networks) {
        this.id = id;
        this.interstitialVideoEnabled = interstitialVideoEnabled;
        this.interstitialVideoInterval = interstitialVideoInterval;
        this.displayTtl = displayTtl;
        this.sortNetworksOnScore = sortNetworksOnScore;
        this.networks = networks;
    }
}
