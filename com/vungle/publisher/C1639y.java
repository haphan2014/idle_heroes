package com.vungle.publisher;

import android.os.Bundle;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: vungle */
public class C1639y implements C1617z {
    protected Bundle f911a = new Bundle();
    protected Bundle f912b = new Bundle();

    @Inject
    public C1639y() {
        m905e(true);
    }

    public boolean isBackButtonImmediatelyEnabled() {
        return this.f911a.getBoolean("isBackButtonEnabled");
    }

    public final void m897a(boolean z) {
        this.f911a.putBoolean("isBackButtonEnabled", z);
    }

    public final String m894a(String str) {
        return this.f912b.getString(str);
    }

    public final void m896a(String str, String str2) {
        this.f912b.putString(str, str2);
    }

    public Map<String, String> getExtras() {
        Map<String, String> hashMap = new HashMap();
        for (String str : this.f912b.keySet()) {
            hashMap.put(str, this.f912b.getString(str));
        }
        return hashMap;
    }

    public boolean isImmersiveMode() {
        return this.f911a.getBoolean("isImmersiveMode", true);
    }

    public final void m899b(boolean z) {
        this.f911a.putBoolean("isImmersiveMode", z);
    }

    public boolean isIncentivized() {
        return this.f911a.getBoolean("isIncentivized");
    }

    public final void m901c(boolean z) {
        this.f911a.putBoolean("isIncentivized", z);
    }

    public String getIncentivizedCancelDialogBodyText() {
        return this.f911a.getString("incentivizedCancelDialogBodyText");
    }

    public final void m898b(String str) {
        this.f911a.putString("incentivizedCancelDialogBodyText", str);
    }

    public String getIncentivizedCancelDialogCloseButtonText() {
        return this.f911a.getString("incentivizedCancelDialogNegativeButtonText");
    }

    public final void m900c(String str) {
        this.f911a.putString("incentivizedCancelDialogNegativeButtonText", str);
    }

    public String getIncentivizedCancelDialogKeepWatchingButtonText() {
        return this.f911a.getString("incentivizedCancelDialogPositiveButtonText");
    }

    public final void m902d(String str) {
        this.f911a.putString("incentivizedCancelDialogPositiveButtonText", str);
    }

    public String getIncentivizedCancelDialogTitle() {
        return this.f911a.getString("incentivizedCancelDialogTitle");
    }

    public final void m904e(String str) {
        this.f911a.putString("incentivizedCancelDialogTitle", str);
    }

    public final void m906f(String str) {
        this.f911a.putString("incentivizedUserId", str);
    }

    public String getIncentivizedUserId() {
        return this.f911a.getString("incentivizedUserId");
    }

    public Orientation getOrientation() {
        return (Orientation) this.f911a.getParcelable("orientation");
    }

    public final void m895a(Orientation orientation) {
        this.f911a.putParcelable("orientation", orientation);
    }

    public String getPlacement() {
        return this.f911a.getString("placement");
    }

    public final void m907g(String str) {
        this.f911a.putString("placement", str);
    }

    public boolean isSoundEnabled() {
        return this.f911a.getBoolean("isSoundEnabled");
    }

    public final void m903d(boolean z) {
        this.f911a.putBoolean("isSoundEnabled", z);
    }

    public boolean isTransitionAnimationEnabled() {
        return this.f911a.getBoolean("isTransitionAnimationEnabled");
    }

    public final void m905e(boolean z) {
        this.f911a.putBoolean("isTransitionAnimationEnabled", z);
    }

    public int hashCode() {
        return this.f911a.hashCode() ^ this.f912b.hashCode();
    }

    public boolean equals(Object object) {
        if (object != null && (object instanceof C1639y)) {
            boolean z;
            C1639y c1639y = (C1639y) object;
            if (c1639y != null && c1639y.f911a.equals(this.f911a) && c1639y.f912b.equals(this.f912b)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(123);
        C1639y.m893a(stringBuilder, this.f911a);
        C1639y.m893a(stringBuilder, this.f912b);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    private static void m893a(StringBuilder stringBuilder, Bundle bundle) {
        Object obj = 1;
        for (String str : bundle.keySet()) {
            if (obj != null) {
                obj = null;
            } else {
                stringBuilder.append(", ");
            }
            stringBuilder.append(str).append(" = ").append(bundle.get(str));
        }
    }
}
