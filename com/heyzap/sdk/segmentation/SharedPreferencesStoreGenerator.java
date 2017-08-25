package com.heyzap.sdk.segmentation;

import android.content.SharedPreferences;
import com.heyzap.mediation.filters.SharedPreferenceStore;
import com.heyzap.mediation.filters.Store;

public class SharedPreferencesStoreGenerator {
    private final SharedPreferences prefs;

    public SharedPreferencesStoreGenerator(SharedPreferences prefs) {
        this.prefs = prefs;
    }

    public Store<Integer> getIntStore(String name, Integer defaultValue) {
        final Integer num = defaultValue;
        return new SharedPreferenceStore<Integer>(this.prefs, name, defaultValue) {
            public Integer parse(String in) {
                try {
                    return Integer.valueOf(Integer.parseInt(in));
                } catch (NumberFormatException e) {
                    return num;
                }
            }
        };
    }

    public Store<Long> getLongStore(String name, Long defaultValue) {
        final Long l = defaultValue;
        return new SharedPreferenceStore<Long>(this.prefs, name, defaultValue) {
            public Long parse(String in) {
                try {
                    return Long.valueOf(Long.parseLong(in));
                } catch (NumberFormatException e) {
                    return l;
                }
            }
        };
    }

    public Store<String> getStringStore(String name, String defaultValue) {
        return new SharedPreferenceStore<String>(this.prefs, name, defaultValue) {
            public String parse(String in) {
                return in;
            }
        };
    }
}
