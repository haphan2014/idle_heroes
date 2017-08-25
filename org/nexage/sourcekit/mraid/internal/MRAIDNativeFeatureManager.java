package org.nexage.sourcekit.mraid.internal;

import android.content.Context;
import android.os.Build.VERSION;
import java.util.ArrayList;
import org.nexage.sourcekit.mraid.MRAIDNativeFeature;

public class MRAIDNativeFeatureManager {
    private static final String TAG = "MRAIDNativeFeatureManager";
    private Context context;
    private ArrayList<String> supportedNativeFeatures;

    public MRAIDNativeFeatureManager(Context context, ArrayList<String> supportedNativeFeatures) {
        this.context = context;
        this.supportedNativeFeatures = supportedNativeFeatures;
    }

    public boolean isCalendarSupported() {
        boolean retval = this.supportedNativeFeatures.contains(MRAIDNativeFeature.CALENDAR) && VERSION.SDK_INT >= 14 && this.context.checkCallingOrSelfPermission("android.permission.WRITE_CALENDAR") == 0;
        MRAIDLog.m2730d(TAG, "isCalendarSupported " + retval);
        return retval;
    }

    public boolean isInlineVideoSupported() {
        boolean retval = this.supportedNativeFeatures.contains(MRAIDNativeFeature.INLINE_VIDEO);
        MRAIDLog.m2730d(TAG, "isInlineVideoSupported " + retval);
        return retval;
    }

    public boolean isSmsSupported() {
        boolean retval = this.supportedNativeFeatures.contains(MRAIDNativeFeature.SMS) && this.context.checkCallingOrSelfPermission("android.permission.SEND_SMS") == 0;
        MRAIDLog.m2730d(TAG, "isSmsSupported " + retval);
        return retval;
    }

    public boolean isStorePictureSupported() {
        boolean retval = this.supportedNativeFeatures.contains(MRAIDNativeFeature.STORE_PICTURE);
        MRAIDLog.m2730d(TAG, "isStorePictureSupported " + retval);
        return retval;
    }

    public boolean isTelSupported() {
        boolean retval = this.supportedNativeFeatures.contains(MRAIDNativeFeature.TEL) && this.context.checkCallingOrSelfPermission("android.permission.CALL_PHONE") == 0;
        MRAIDLog.m2730d(TAG, "isTelSupported " + retval);
        return retval;
    }

    public ArrayList<String> getSupportedNativeFeatures() {
        return this.supportedNativeFeatures;
    }
}
