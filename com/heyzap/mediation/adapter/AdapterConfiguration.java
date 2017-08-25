package com.heyzap.mediation.adapter;

import android.support.annotation.Nullable;
import com.heyzap.internal.Constants.AdUnit;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONObject;

public class AdapterConfiguration {
    private EnumSet<AdUnit> adUnits = null;
    private String adapterClassName;
    private LinkedList<String> classNames = new LinkedList();
    private Map<String, String> data;
    private String networkName;

    public class AdapterConfigurationError extends Exception {
        private static final long serialVersionUID = 1;

        public AdapterConfigurationError(String string) {
            super(string);
        }
    }

    public AdapterConfiguration(JSONObject configuration) throws AdapterConfigurationError {
        String name = configuration.optString("name", null);
        String className = configuration.optString("custom_class", null);
        HashMap<String, String> objData = new HashMap();
        JSONObject obj = configuration.optJSONObject("data");
        if (obj != null) {
            Iterator<?> keys = obj.keys();
            while (keys.hasNext()) {
                String key = (String) keys.next();
                String value = obj.optString(key, null);
                if (value != null) {
                    objData.put(key, value);
                }
            }
        }
        initialize(name, className, objData);
    }

    public AdapterConfiguration(String name, String adapterClassName, Map<String, String> data) throws AdapterConfigurationError {
        initialize(name, adapterClassName, data);
    }

    private void initialize(String name, String adapterClassName, Map<String, String> data) throws AdapterConfigurationError {
        if (name == null) {
            throw new AdapterConfigurationError("No canonical name.");
        }
        this.adapterClassName = adapterClassName;
        this.networkName = name;
        this.data = data;
    }

    public String optValue(String keyName, String defaultValue) {
        if (this.data.containsKey(keyName)) {
            String value = (String) this.data.get(keyName);
            if (keyName != null) {
                return (String) this.data.get(keyName);
            }
        }
        return defaultValue;
    }

    @Nullable
    public String getValue(String keyName) {
        if (this.data.containsKey(keyName)) {
            return (String) this.data.get(keyName);
        }
        return null;
    }

    public String getCanonicalName() {
        return this.networkName.toLowerCase();
    }

    public void setCanonicalName(String canonicalName) {
        this.networkName = canonicalName;
    }

    public String getAdapterClassName() {
        return this.adapterClassName;
    }

    public String toString() {
        return String.format("<AdapterConfiguration name: %s, kl: %s>", new Object[]{getCanonicalName(), getAdapterClassName()});
    }
}
