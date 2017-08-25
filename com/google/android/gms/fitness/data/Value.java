package com.google.android.gms.fitness.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.fitness.FitnessActivities;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public final class Value implements SafeParcelable {
    public static final Creator<Value> CREATOR = new zzt();
    private final int zzCY;
    private final int zzakB;
    private float zzakF;
    private boolean zzakR;
    private String zzakS;
    private Map<String, MapValue> zzakT;

    public Value(int format) {
        this(2, format, false, 0.0f, null, null);
    }

    Value(int versionCode, int format, boolean isSet, float value, String stringValue, Bundle mapValue) {
        this.zzCY = versionCode;
        this.zzakB = format;
        this.zzakR = isSet;
        this.zzakF = value;
        this.zzakS = stringValue;
        this.zzakT = zzr(mapValue);
    }

    private boolean zza(Value value) {
        if (this.zzakB != value.zzakB || this.zzakR != value.zzakR) {
            return false;
        }
        switch (this.zzakB) {
            case 1:
                return asInt() == value.asInt();
            case 2:
                return asFloat() == value.asFloat();
            case 3:
                return asString().equals(value.asString());
            case 4:
                return zzpT().equals(value.zzpT());
            default:
                return this.zzakF == value.zzakF;
        }
    }

    private static Map<String, MapValue> zzr(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        bundle.setClassLoader(MapValue.class.getClassLoader());
        Map<String, MapValue> arrayMap = new ArrayMap(bundle.size());
        for (String str : bundle.keySet()) {
            arrayMap.put(str, bundle.getParcelable(str));
        }
        return arrayMap;
    }

    public String asActivity() {
        return FitnessActivities.getName(asInt());
    }

    public float asFloat() {
        zzu.zza(this.zzakB == 2, (Object) "Value is not in float format");
        return this.zzakF;
    }

    public int asInt() {
        boolean z = true;
        if (this.zzakB != 1) {
            z = false;
        }
        zzu.zza(z, (Object) "Value is not in int format");
        return Float.floatToRawIntBits(this.zzakF);
    }

    public String asString() {
        zzu.zza(this.zzakB == 3, (Object) "Value is not in string format");
        return this.zzakS;
    }

    public void clearKey(String key) {
        zzu.zza(this.zzakB == 4, (Object) "Attempting to set a key's value to a field that is not in FLOAT_MAP format.  Please check the data type definition and use the right format.");
        if (this.zzakT != null) {
            this.zzakT.remove(key);
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return this == o || ((o instanceof Value) && zza((Value) o));
    }

    public int getFormat() {
        return this.zzakB;
    }

    public Float getKeyValue(String key) {
        zzu.zza(this.zzakB == 4, (Object) "Value is not in float map format");
        return (this.zzakT == null || !this.zzakT.containsKey(key)) ? null : Float.valueOf(((MapValue) this.zzakT.get(key)).asFloat());
    }

    int getVersionCode() {
        return this.zzCY;
    }

    public int hashCode() {
        return zzt.hashCode(Float.valueOf(this.zzakF), this.zzakS, this.zzakT);
    }

    public boolean isSet() {
        return this.zzakR;
    }

    public void setActivity(String activity) {
        setInt(FitnessActivities.zzcF(activity));
    }

    public void setFloat(float value) {
        zzu.zza(this.zzakB == 2, (Object) "Attempting to set an float value to a field that is not in FLOAT format.  Please check the data type definition and use the right format.");
        this.zzakR = true;
        this.zzakF = value;
    }

    public void setInt(int value) {
        zzu.zza(this.zzakB == 1, (Object) "Attempting to set an int value to a field that is not in INT32 format.  Please check the data type definition and use the right format.");
        this.zzakR = true;
        this.zzakF = Float.intBitsToFloat(value);
    }

    public void setKeyValue(String key, float value) {
        zzu.zza(this.zzakB == 4, (Object) "Attempting to set a key's value to a field that is not in FLOAT_MAP format.  Please check the data type definition and use the right format.");
        this.zzakR = true;
        if (this.zzakT == null) {
            this.zzakT = new HashMap();
        }
        this.zzakT.put(key, MapValue.zzc(value));
    }

    public void setString(String value) {
        zzu.zza(this.zzakB == 3, (Object) "Attempting to set a string value to a field that is not in STRING format.  Please check the data type definition and use the right format.");
        this.zzakR = true;
        this.zzakS = value;
    }

    public String toString() {
        if (!this.zzakR) {
            return "unset";
        }
        switch (this.zzakB) {
            case 1:
                return Integer.toString(asInt());
            case 2:
                return Float.toString(asFloat());
            case 3:
                return this.zzakS;
            case 4:
                return new TreeMap(this.zzakT).toString();
            default:
                return "unknown";
        }
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzt.zza(this, dest, flags);
    }

    public Map<String, MapValue> zzpT() {
        zzu.zza(this.zzakB == 4, (Object) "Value is not in float map format");
        return this.zzakT == null ? Collections.emptyMap() : this.zzakT;
    }

    float zzqI() {
        return this.zzakF;
    }

    String zzqO() {
        return this.zzakS;
    }

    Bundle zzqP() {
        if (this.zzakT == null) {
            return null;
        }
        Bundle bundle = new Bundle(this.zzakT.size());
        for (Entry entry : this.zzakT.entrySet()) {
            bundle.putParcelable((String) entry.getKey(), (Parcelable) entry.getValue());
        }
        return bundle;
    }
}
