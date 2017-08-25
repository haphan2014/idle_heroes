package com.vungle.publisher;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: vungle */
public class ab extends C1639y implements Parcelable {
    public static final Creator<ab> CREATOR = new C16381();
    static final Orientation f913c = Orientation.matchVideo;

    /* compiled from: vungle */
    static class C16381 implements Creator<ab> {
        C16381() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ab[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ab(new C1639y[0]).m908a(parcel);
        }
    }

    public ab(C1639y... c1639yArr) {
        for (C1639y c1639y : c1639yArr) {
            if (c1639y != null) {
                this.a.putAll(c1639y.f911a);
                this.b.putAll(c1639y.f912b);
            }
        }
    }

    public boolean isBackButtonImmediatelyEnabled() {
        return this.a.getBoolean("isBackButtonEnabled", false);
    }

    public boolean isImmersiveMode() {
        return this.a.getBoolean("isImmersiveMode", false);
    }

    public boolean isIncentivized() {
        return this.a.getBoolean("isIncentivized", false);
    }

    public String getIncentivizedCancelDialogBodyText() {
        String string = this.a.getString("incentivizedCancelDialogBodyText");
        if (string == null) {
            return "Closing this video early will prevent you from earning your reward. Are you sure?";
        }
        return string;
    }

    public String getIncentivizedCancelDialogCloseButtonText() {
        String string = this.a.getString("incentivizedCancelDialogNegativeButtonText");
        if (agf.m1219a(string)) {
            return string;
        }
        return "Close video";
    }

    public String getIncentivizedCancelDialogKeepWatchingButtonText() {
        String string = this.a.getString("incentivizedCancelDialogPositiveButtonText");
        if (agf.m1219a(string)) {
            return string;
        }
        return "Keep watching";
    }

    public String getIncentivizedCancelDialogTitle() {
        String string = this.a.getString("incentivizedCancelDialogTitle");
        if (string == null) {
            return "Close video?";
        }
        return string;
    }

    public Orientation getOrientation() {
        Orientation orientation = (Orientation) this.a.getParcelable("orientation");
        return orientation == null ? f913c : orientation;
    }

    public boolean isSoundEnabled() {
        return this.a.getBoolean("isSoundEnabled", true);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.a);
        parcel.writeBundle(this.b);
    }

    protected final ab m908a(Parcel parcel) {
        ClassLoader classLoader = ab.class.getClassLoader();
        this.a = parcel.readBundle(classLoader);
        this.b = parcel.readBundle(classLoader);
        return this;
    }
}
