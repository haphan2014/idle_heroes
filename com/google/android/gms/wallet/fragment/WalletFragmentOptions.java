package com.google.android.gms.wallet.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import com.google.android.gms.C0346R;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class WalletFragmentOptions implements SafeParcelable {
    public static final Creator<WalletFragmentOptions> CREATOR = new zzb();
    private int mTheme;
    final int zzCY;
    private int zzaRH;
    private WalletFragmentStyle zzaSk;
    private int zzacS;

    public final class Builder {
        final /* synthetic */ WalletFragmentOptions zzaSl;

        private Builder(WalletFragmentOptions walletFragmentOptions) {
            this.zzaSl = walletFragmentOptions;
        }

        public WalletFragmentOptions build() {
            return this.zzaSl;
        }

        public Builder setEnvironment(int environment) {
            this.zzaSl.zzaRH = environment;
            return this;
        }

        public Builder setFragmentStyle(int styleResourceId) {
            this.zzaSl.zzaSk = new WalletFragmentStyle().setStyleResourceId(styleResourceId);
            return this;
        }

        public Builder setFragmentStyle(WalletFragmentStyle fragmentStyle) {
            this.zzaSl.zzaSk = fragmentStyle;
            return this;
        }

        public Builder setMode(int mode) {
            this.zzaSl.zzacS = mode;
            return this;
        }

        public Builder setTheme(int theme) {
            this.zzaSl.mTheme = theme;
            return this;
        }
    }

    private WalletFragmentOptions() {
        this.zzCY = 1;
    }

    WalletFragmentOptions(int versionCode, int environment, int theme, WalletFragmentStyle fragmentStyle, int mode) {
        this.zzCY = versionCode;
        this.zzaRH = environment;
        this.mTheme = theme;
        this.zzaSk = fragmentStyle;
        this.zzacS = mode;
    }

    public static Builder newBuilder() {
        WalletFragmentOptions walletFragmentOptions = new WalletFragmentOptions();
        walletFragmentOptions.getClass();
        return new Builder();
    }

    public static WalletFragmentOptions zza(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0346R.styleable.WalletFragmentOptions);
        int i = obtainStyledAttributes.getInt(C0346R.styleable.WalletFragmentOptions_appTheme, 0);
        int i2 = obtainStyledAttributes.getInt(C0346R.styleable.WalletFragmentOptions_environment, 1);
        int resourceId = obtainStyledAttributes.getResourceId(C0346R.styleable.WalletFragmentOptions_fragmentStyle, 0);
        int i3 = obtainStyledAttributes.getInt(C0346R.styleable.WalletFragmentOptions_fragmentMode, 1);
        obtainStyledAttributes.recycle();
        WalletFragmentOptions walletFragmentOptions = new WalletFragmentOptions();
        walletFragmentOptions.mTheme = i;
        walletFragmentOptions.zzaRH = i2;
        walletFragmentOptions.zzaSk = new WalletFragmentStyle().setStyleResourceId(resourceId);
        walletFragmentOptions.zzaSk.zzaL(context);
        walletFragmentOptions.zzacS = i3;
        return walletFragmentOptions;
    }

    public int describeContents() {
        return 0;
    }

    public int getEnvironment() {
        return this.zzaRH;
    }

    public WalletFragmentStyle getFragmentStyle() {
        return this.zzaSk;
    }

    public int getMode() {
        return this.zzacS;
    }

    public int getTheme() {
        return this.mTheme;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzb.zza(this, dest, flags);
    }

    public void zzaL(Context context) {
        if (this.zzaSk != null) {
            this.zzaSk.zzaL(context);
        }
    }
}
