package com.heyzap.mediation.filters;

import android.content.SharedPreferences;

public abstract class SharedPreferenceStore<V> implements Store<V> {
    private final String key;
    private final SharedPreferences sharedPreferences;
    private V value;

    public abstract V parse(String str);

    public SharedPreferenceStore(SharedPreferences sharedPreferences, String key, V defaultValue) {
        this.sharedPreferences = sharedPreferences;
        this.key = key;
        this.value = parse(sharedPreferences.getString(key, toString(defaultValue)));
    }

    public void set(V value) {
        this.value = value;
        this.sharedPreferences.edit().putString(this.key, toString(value)).commit();
    }

    public String getString() {
        return this.value.toString();
    }

    public V get() {
        return this.value;
    }

    public String toString(V in) {
        return in.toString();
    }
}
