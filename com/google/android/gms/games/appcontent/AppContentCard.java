package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import java.util.List;

public interface AppContentCard extends Parcelable, Freezable<AppContentCard> {
    List<AppContentAction> getActions();

    String getDescription();

    Bundle getExtras();

    String getId();

    String getTitle();

    String getType();

    List<AppContentCondition> zzrO();

    String zzrP();

    List<AppContentAnnotation> zzrZ();

    int zzsa();

    String zzsb();

    int zzsc();
}
