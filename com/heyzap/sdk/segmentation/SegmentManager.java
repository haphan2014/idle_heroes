package com.heyzap.sdk.segmentation;

import com.heyzap.common.lifecycle.DisplayOptions;
import com.heyzap.common.lifecycle.FetchOptions;
import com.heyzap.common.lifecycle.ImpressionOptions;
import com.heyzap.internal.Constants.AuctionType;
import com.heyzap.internal.Constants.CreativeType;
import com.heyzap.internal.LargeSet;
import com.heyzap.internal.Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SegmentManager {
    private static final List<String> RULE_TYPES = Arrays.asList(new String[]{"CrossPromoFrequency", "Frequency", "PlacementId", "DisabledNetworks"});
    private static final List<String> TARGET_TYPES = Arrays.asList(new String[]{"Tag"});
    private final List<Segment> segments = new ArrayList();
    private final PastImpressionStore store;

    public SegmentManager(JSONArray segments, PastImpressionStore store) {
        this.store = store;
        int i = 0;
        while (i < segments.length()) {
            try {
                Segment segment = parseSegment(segments.getJSONObject(i));
                if (segment != null) {
                    this.segments.add(segment);
                }
                i++;
            } catch (JSONException e) {
                Logger.error("Failed to parse Segment List", e);
                return;
            }
        }
    }

    public List<Segment> getSegments() {
        return this.segments;
    }

    public Set<String> getTagsEffectedByFetchSegments() {
        HashSet<String> output = new HashSet();
        for (Segment segment : this.segments) {
            boolean effectsFetch = false;
            for (SegmentRule rule : segment.getRules()) {
                effectsFetch |= rule.transformsFetch();
            }
            if (effectsFetch) {
                for (SegmentTarget target : segment.getTargets()) {
                    if (target instanceof TagTarget) {
                        output.addAll(((TagTarget) target).getTags());
                    }
                }
            }
        }
        return output;
    }

    public void onImpression(ImpressionOptions options) {
        AuctionType auctionType = options.getAuctionType();
        this.store.putImpression(options.getCreativeType(), auctionType, options.getTag());
    }

    public List<DisplayOptions> transform(DisplayOptions in) {
        List<DisplayOptions> options = new ArrayList();
        for (AuctionType auctionType : in.getAuctionTypes().intersect(EnumSet.allOf(AuctionType.class))) {
            DisplayOptions option = new DisplayOptions(in.getAdUnit(), in.getTag(), LargeSet.of(auctionType), in.getNetworks(), in.getCreativeTypes());
            for (Segment segment : this.segments) {
                if (option != null) {
                    option = segment.transform(option);
                }
            }
            options.add(option);
        }
        return options;
    }

    public FetchOptions transform(FetchOptions in) {
        FetchOptions option = in;
        for (Segment segment : this.segments) {
            if (option != null) {
                option = segment.transform(option);
            }
        }
        if (!fetchOptionsEffectedBySegmentation(option)) {
            option.getTags().addAll();
            option.getTags().removeAll(getTagsEffectedByFetchSegments());
        }
        return option;
    }

    private boolean fetchOptionsEffectedBySegmentation(FetchOptions options) {
        boolean tagMatches = false;
        for (String tag : getTagsEffectedByFetchSegments()) {
            if (options.getTags().contains(tag)) {
                tagMatches = true;
            }
        }
        if (tagMatches && options.getCustomPlacementId() != null) {
            return true;
        }
        return false;
    }

    private Segment parseSegment(JSONObject in) {
        try {
            String name = in.getString("name");
            List<SegmentTarget> targets = new ArrayList();
            List<SegmentRule> rules = new ArrayList();
            JSONArray jsonRules = in.getJSONArray("rules");
            for (int i = 0; i < jsonRules.length(); i++) {
                JSONObject rule = jsonRules.getJSONObject(i);
                String type = rule.getString("type");
                if (RULE_TYPES.contains(type)) {
                    SegmentRule segmentRule = parseSegmentRule(rule);
                    if (segmentRule != null) {
                        rules.add(segmentRule);
                    }
                } else if (TARGET_TYPES.contains(type)) {
                    SegmentTarget segmentTarget = parseSegmentTarget(rule);
                    if (segmentTarget != null) {
                        targets.add(segmentTarget);
                    }
                } else {
                    Logger.error("Could not parse " + rule.toString());
                }
            }
            return new Segment(rules, targets, name);
        } catch (JSONException e) {
            Logger.error("Failed to parse segment", e);
            return null;
        }
    }

    private SegmentTarget parseSegmentTarget(JSONObject in) {
        try {
            JSONArray jsonTags = in.getJSONObject("options").getJSONArray("tags");
            List<String> tags = new ArrayList();
            for (int i = 0; i < jsonTags.length(); i++) {
                tags.add(jsonTags.getString(i));
            }
            return new TagTarget(tags);
        } catch (JSONException e) {
            Logger.error("Failed to parse segment target", e);
            return null;
        }
    }

    private SegmentRule parseSegmentRule(JSONObject in) {
        try {
            String type = in.getString("type");
            if (type.contains("Frequency")) {
                return parseFrequencyRule(in);
            }
            if ("PlacementId".equals(type)) {
                return parseCustomPlacementIds(in);
            }
            if ("DisabledNetworks".equals(type)) {
                return parseDisabledNetworks(in);
            }
            Logger.error("Failed to find SegmentRule type: " + type);
            return null;
        } catch (JSONException e) {
            Logger.error("Failed to parse segment rule", e);
            return null;
        }
    }

    private NetworkDisableRule parseDisabledNetworks(JSONObject in) {
        try {
            JSONArray disabledNetworks = in.getJSONObject("options").getJSONArray("disabled_networks");
            List<String> networks = new ArrayList(disabledNetworks.length());
            for (int i = 0; i < disabledNetworks.length(); i++) {
                networks.add(disabledNetworks.getString(i));
            }
            return new NetworkDisableRule(networks);
        } catch (JSONException e) {
            Logger.error("Failed to parse segment rule", e);
            return null;
        }
    }

    private CustomPlacementSegmentRule parseCustomPlacementIds(JSONObject in) {
        try {
            JSONObject options = in.getJSONObject("options");
            Map<String, Map<CreativeType, String>> customPlacementId = new HashMap();
            JSONArray mapEntries = options.getJSONArray("placement_ids");
            for (int i = 0; i < mapEntries.length(); i++) {
                JSONObject entry = mapEntries.getJSONObject(i);
                String network = entry.getString("network");
                String placementId = entry.getString("placement_id");
                CreativeType creativeType = CreativeType.parseInt(entry.getInt("creative_type"));
                if (!customPlacementId.containsKey(network)) {
                    customPlacementId.put(network, new HashMap());
                }
                ((Map) customPlacementId.get(network)).put(creativeType, placementId);
            }
            return new CustomPlacementSegmentRule(customPlacementId);
        } catch (JSONException e) {
            Logger.error("Failed to parse segment rule", e);
            return null;
        }
    }

    private SegmentRule parseFrequencyRule(JSONObject in) {
        try {
            JSONObject options = in.getJSONObject("options");
            boolean enabled = options.getBoolean("ads_enabled");
            AuctionType auctionType = "Frequency".equals(in.getString("type")) ? AuctionType.MONETIZATION : AuctionType.CROSS_PROMO;
            List<FrequencyRulePart> ruleParts = new ArrayList();
            try {
                JSONArray jsonRuleParts = options.getJSONArray("frequency_limits");
                for (int i = 0; i < jsonRuleParts.length(); i++) {
                    FrequencyRulePart rulePart = parseFrequencyRulePart(jsonRuleParts.getJSONObject(i));
                    if (rulePart != null) {
                        ruleParts.add(rulePart);
                    }
                }
            } catch (JSONException e) {
            }
            return new FrequencyRule(auctionType, ruleParts, enabled, this.store);
        } catch (JSONException e2) {
            Logger.error("Failed to parse segment rule", e2);
            return null;
        }
    }

    private FrequencyRulePart parseFrequencyRulePart(JSONObject in) {
        try {
            int adLimit = in.getInt("ads_quantity");
            int seconds = in.getInt("seconds");
            CreativeType type = CreativeType.parseInt(in.getInt("ad_format"));
            if (type != null) {
                return new FrequencyRulePart(type, adLimit, seconds);
            }
            throw new JSONException("invalid creative type");
        } catch (JSONException e) {
            Logger.error("Failed to parse frequency rule part", e);
            return null;
        }
    }
}
