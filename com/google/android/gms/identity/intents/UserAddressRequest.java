package com.google.android.gms.identity.intents;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.CountrySpecification;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class UserAddressRequest implements SafeParcelable {
    public static final Creator<UserAddressRequest> CREATOR = new zza();
    private final int zzCY;
    List<CountrySpecification> zzawx;

    public final class Builder {
        final /* synthetic */ UserAddressRequest zzawy;

        private Builder(UserAddressRequest userAddressRequest) {
            this.zzawy = userAddressRequest;
        }

        public Builder addAllowedCountrySpecification(CountrySpecification countrySpecification) {
            if (this.zzawy.zzawx == null) {
                this.zzawy.zzawx = new ArrayList();
            }
            this.zzawy.zzawx.add(countrySpecification);
            return this;
        }

        public Builder addAllowedCountrySpecifications(Collection<CountrySpecification> countrySpecifications) {
            if (this.zzawy.zzawx == null) {
                this.zzawy.zzawx = new ArrayList();
            }
            this.zzawy.zzawx.addAll(countrySpecifications);
            return this;
        }

        public UserAddressRequest build() {
            if (this.zzawy.zzawx != null) {
                this.zzawy.zzawx = Collections.unmodifiableList(this.zzawy.zzawx);
            }
            return this.zzawy;
        }
    }

    UserAddressRequest() {
        this.zzCY = 1;
    }

    UserAddressRequest(int versionCode, List<CountrySpecification> allowedCountrySpecifications) {
        this.zzCY = versionCode;
        this.zzawx = allowedCountrySpecifications;
    }

    public static Builder newBuilder() {
        UserAddressRequest userAddressRequest = new UserAddressRequest();
        userAddressRequest.getClass();
        return new Builder();
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    public void writeToParcel(Parcel out, int flags) {
        zza.zza(this, out, flags);
    }
}
