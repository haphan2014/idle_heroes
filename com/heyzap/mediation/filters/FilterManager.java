package com.heyzap.mediation.filters;

import com.heyzap.common.lifecycle.AdDisplay;
import com.heyzap.internal.Constants.AdUnit;
import com.heyzap.internal.ContextReference;
import com.heyzap.internal.Logger;
import com.heyzap.sdk.segmentation.SharedPreferencesStoreGenerator;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;

public class FilterManager {
    private final ContextReference contextRef;
    private final ExecutorService executorService;
    private final List<Filter> filters = new ArrayList();

    public FilterManager(ContextReference contextReference, ExecutorService executorService) {
        this.contextRef = contextReference;
        this.executorService = executorService;
    }

    public void configure(JSONArray filterConfig) {
    }

    public void addIncentiveDailyLimitFilter(int incentivizedDailyLimit) {
        if (incentivizedDailyLimit >= 0) {
            addFilter(new Filter(new AdUnitMatcher(AdUnit.INCENTIVIZED), new IncentivizedRateLimitFilterPolicy(this.executorService, incentivizedDailyLimit, 1, TimeUnit.DAYS, new SharedPreferencesStoreGenerator(this.contextRef.getApp().getSharedPreferences("heyzap.filter", 0)).getStringStore("incentive_history", ""))));
        }
    }

    public void addRateLimitIntervalFilter(int rateLimitInterval) {
        if (rateLimitInterval >= 0) {
            addFilter(new Filter(new AnyMatcher(), new RateLimitFilterPolicy(this.executorService, 1, rateLimitInterval, TimeUnit.SECONDS, new SharedPreferencesStoreGenerator(this.contextRef.getApp().getSharedPreferences("heyzap.filter", 0)).getStringStore("ad_display_history", ""))));
        }
    }

    public void addDisabledTagsFilter(JSONArray jsonDisabledTags) {
        if (jsonDisabledTags != null) {
            Set<String> disabledTags = new HashSet();
            for (int i = 0; i < jsonDisabledTags.length(); i++) {
                try {
                    disabledTags.add(jsonDisabledTags.getString(i));
                } catch (JSONException e) {
                    Logger.log("Failed to get disabled tag at index", Integer.valueOf(i));
                }
            }
            addFilter(new Filter(new TagMatcher(disabledTags), new RejectFilterPolicy()));
        }
    }

    public void addFilter(Filter filter) {
        this.filters.add(filter);
    }

    public boolean accept(FilterContext context) {
        for (Filter filter : this.filters) {
            if (filter.matcher.match(context) && !filter.policy.accept()) {
                return false;
            }
        }
        return true;
    }

    public void addDisplay(FilterContext context, AdDisplay adDisplay) {
        for (Filter filter : this.filters) {
            if (filter.matcher.match(context)) {
                filter.policy.addDisplay(adDisplay);
            }
        }
    }
}
