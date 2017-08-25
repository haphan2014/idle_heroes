package com.vungle.publisher;

import com.heyzap.house.abstr.AbstractActivity;
import javax.inject.Inject;
import javax.inject.Singleton;

/* compiled from: vungle */
public enum ti {
    CLOSE("close"),
    EXPAND {
    },
    USE_CUSTOM_CLOSE("useCustomClose"),
    OPEN {
    },
    RESIZE {
    },
    SET_ORIENTATION_PROPERTIES("setOrientationProperties"),
    PLAY_VIDEO {
    },
    STORE_PICTURE {
    },
    CREATE_CALENDAR_EVENT {
    },
    PROPERTIES_SET("propertiesChangeCompleted"),
    SUCCESSFUL_VIEW_EVENT("successfulView"),
    TPAT_EVENT("tpat"),
    USER_ACTION_EVENT(AbstractActivity.ACTIVITY_INTENT_ACTION_KEY),
    USER_VALUE_ACTION_EVENT("actionWithValue"),
    ERROR_EVENT("error"),
    PRIVACY_PAGE_EVENT("openPrivacy"),
    PLAY_HTML_VIDEO_EVENT("playHTML5Video"),
    USE_CUSTOM_PRIVACY("useCustomPrivacy"),
    THROW_INCENTIVIZED_DIALOG("throwIncentivizedDialog"),
    UNSPECIFIED("");
    
    private final String f3288u;

    @Singleton
    /* compiled from: vungle */
    public static class C1887a {
        @Inject
        C1887a() {
        }

        public static ti m2500a(String str) {
            for (ti tiVar : ti.values()) {
                if (tiVar.f3288u.equals(str)) {
                    return tiVar;
                }
            }
            return ti.UNSPECIFIED;
        }
    }

    private ti(String str) {
        this.f3288u = str;
    }
}
