package com.google.android.gms.drive.metadata;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class CustomPropertyKey implements SafeParcelable {
    public static final Creator<CustomPropertyKey> CREATOR = new zzc();
    public static final int PRIVATE = 1;
    public static final int PUBLIC = 0;
    private static final Pattern zzagC = Pattern.compile("[\\w.!@$%^&*()/-]+");
    final int mVisibility;
    final int zzCY;
    final String zztw;

    CustomPropertyKey(int versionCode, String key, int visibility) {
        boolean z = true;
        zzu.zzb((Object) key, (Object) "key");
        zzu.zzb(zzagC.matcher(key).matches(), (Object) "key name characters must be alphanumeric or one of .!@$%^&*()-_/");
        if (!(visibility == 0 || visibility == 1)) {
            z = false;
        }
        zzu.zzb(z, (Object) "visibility must be either PUBLIC or PRIVATE");
        this.zzCY = versionCode;
        this.zztw = key;
        this.mVisibility = visibility;
    }

    public CustomPropertyKey(String key, int visibility) {
        this(1, key, visibility);
    }

    public static CustomPropertyKey fromJson(JSONObject jsonObject) throws JSONException {
        return new CustomPropertyKey(jsonObject.getString("key"), jsonObject.getInt("visibility"));
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CustomPropertyKey)) {
            return false;
        }
        CustomPropertyKey customPropertyKey = (CustomPropertyKey) obj;
        if (!(customPropertyKey.getKey().equals(this.zztw) && customPropertyKey.getVisibility() == this.mVisibility)) {
            z = false;
        }
        return z;
    }

    public String getKey() {
        return this.zztw;
    }

    public int getVisibility() {
        return this.mVisibility;
    }

    public int hashCode() {
        return (this.zztw + this.mVisibility).hashCode();
    }

    public JSONObject toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("key", getKey());
        jSONObject.put("visibility", getVisibility());
        return jSONObject;
    }

    public String toString() {
        return "CustomPropertyKey(" + this.zztw + "," + this.mVisibility + ")";
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzc.zza(this, dest, flags);
    }
}
