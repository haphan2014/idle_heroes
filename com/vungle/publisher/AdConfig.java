package com.vungle.publisher;

import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: vungle */
public class AdConfig implements C1617z {
    private final C1639y f745a = new C1639y();

    @Inject
    public AdConfig() {
        setTransitionAnimationEnabled(true);
    }

    public C1639y getDelegateAdConfig() {
        return this.f745a;
    }

    public boolean isBackButtonImmediatelyEnabled() {
        return this.f745a.isBackButtonImmediatelyEnabled();
    }

    public void setBackButtonImmediatelyEnabled(boolean isBackButtonImmediatelyEnabled) {
        this.f745a.m897a(isBackButtonImmediatelyEnabled);
    }

    public String getExtra1() {
        return m798a(1);
    }

    public void setExtra1(String value) {
        m799a(1, value);
    }

    public String getExtra2() {
        return m798a(2);
    }

    public void setExtra2(String value) {
        m799a(2, value);
    }

    public String getExtra3() {
        return m798a(3);
    }

    public void setExtra3(String value) {
        m799a(3, value);
    }

    public String getExtra4() {
        return m798a(4);
    }

    public void setExtra4(String value) {
        m799a(4, value);
    }

    public String getExtra5() {
        return m798a(5);
    }

    public void setExtra5(String value) {
        m799a(5, value);
    }

    public String getExtra6() {
        return m798a(6);
    }

    public void setExtra6(String value) {
        m799a(6, value);
    }

    public String getExtra7() {
        return m798a(7);
    }

    public void setExtra7(String value) {
        m799a(7, value);
    }

    public String getExtra8() {
        return m798a(8);
    }

    public void setExtra8(String value) {
        m799a(8, value);
    }

    private String m798a(int i) {
        return this.f745a.m894a("extra" + i);
    }

    private void m799a(int i, String str) {
        this.f745a.m896a("extra" + i, str);
    }

    public Map<String, String> getExtras() {
        return this.f745a.getExtras();
    }

    public boolean isImmersiveMode() {
        return this.f745a.isImmersiveMode();
    }

    public void setImmersiveMode(boolean isImmersiveMode) {
        this.f745a.m899b(isImmersiveMode);
    }

    public boolean isIncentivized() {
        return this.f745a.isIncentivized();
    }

    public void setIncentivized(boolean isIncentivized) {
        this.f745a.m901c(isIncentivized);
    }

    public String getIncentivizedCancelDialogBodyText() {
        return this.f745a.getIncentivizedCancelDialogBodyText();
    }

    public void setIncentivizedCancelDialogBodyText(String bodyText) {
        this.f745a.m898b(bodyText);
    }

    public String getIncentivizedCancelDialogCloseButtonText() {
        return this.f745a.getIncentivizedCancelDialogCloseButtonText();
    }

    public void setIncentivizedCancelDialogCloseButtonText(String closeButtonText) {
        this.f745a.m900c(closeButtonText);
    }

    public String getIncentivizedCancelDialogKeepWatchingButtonText() {
        return this.f745a.getIncentivizedCancelDialogKeepWatchingButtonText();
    }

    public void setIncentivizedCancelDialogKeepWatchingButtonText(String keepWatchingButtonText) {
        this.f745a.m902d(keepWatchingButtonText);
    }

    public String getIncentivizedCancelDialogTitle() {
        return this.f745a.getIncentivizedCancelDialogTitle();
    }

    public void setIncentivizedCancelDialogTitle(String title) {
        this.f745a.m904e(title);
    }

    public String getIncentivizedUserId() {
        return this.f745a.getIncentivizedUserId();
    }

    public void setIncentivizedUserId(String incentivizedUserId) {
        this.f745a.m906f(incentivizedUserId);
    }

    public Orientation getOrientation() {
        return this.f745a.getOrientation();
    }

    public void setOrientation(Orientation orientation) {
        this.f745a.m895a(orientation);
    }

    public String getPlacement() {
        return this.f745a.getPlacement();
    }

    public void setPlacement(String placement) {
        this.f745a.m907g(placement);
    }

    public boolean isSoundEnabled() {
        return this.f745a.isSoundEnabled();
    }

    public void setSoundEnabled(boolean isSoundEnabled) {
        this.f745a.m903d(isSoundEnabled);
    }

    public boolean isTransitionAnimationEnabled() {
        return this.f745a.isTransitionAnimationEnabled();
    }

    public void setTransitionAnimationEnabled(boolean isTransitionAnimationEnabled) {
        this.f745a.m905e(isTransitionAnimationEnabled);
    }

    public int hashCode() {
        return this.f745a.hashCode();
    }

    public boolean equals(Object obj) {
        return this.f745a.equals(obj);
    }

    public String toString() {
        return this.f745a.toString();
    }
}
