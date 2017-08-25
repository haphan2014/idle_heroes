package com.vungle.publisher;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: vungle */
public enum Orientation implements Parcelable {
    autoRotate,
    matchVideo;
    
    public static final Creator<Orientation> CREATOR = null;

    /* compiled from: vungle */
    static class C16191 implements Creator<Orientation> {
        C16191() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new Orientation[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return Orientation.values()[parcel.readInt()];
        }
    }

    static {
        CREATOR = new C16191();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(ordinal());
    }
}
