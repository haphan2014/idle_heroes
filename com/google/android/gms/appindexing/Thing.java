package com.google.android.gms.appindexing;

import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.internal.zzu;

public class Thing {
    final Bundle zzNV;

    public static class Builder {
        final Bundle zzNW = new Bundle();

        public Thing build() {
            return new Thing(this.zzNW);
        }

        public Builder put(String key, Thing value) {
            zzu.zzu(key);
            if (value != null) {
                this.zzNW.putParcelable(key, value.zzNV);
            }
            return this;
        }

        public Builder put(String key, String value) {
            zzu.zzu(key);
            if (value != null) {
                this.zzNW.putString(key, value);
            }
            return this;
        }

        public Builder setDescription(String description) {
            put("description", description);
            return this;
        }

        public Builder setId(String id) {
            if (id != null) {
                put("id", id);
            }
            return this;
        }

        public Builder setName(String name) {
            zzu.zzu(name);
            put("name", name);
            return this;
        }

        public Builder setType(String type) {
            put("type", type);
            return this;
        }

        public Builder setUrl(Uri url) {
            zzu.zzu(url);
            put("url", url.toString());
            return this;
        }
    }

    Thing(Bundle propertyBundle) {
        this.zzNV = propertyBundle;
    }

    public Bundle zzkP() {
        return this.zzNV;
    }
}
