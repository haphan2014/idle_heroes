package com.google.android.gms.wearable;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import java.util.Map;

public interface CapabilityApi {
    public static final int FILTER_ALL = 0;
    public static final int FILTER_REACHABLE = 1;

    public interface AddLocalCapabilityResult extends Result {
    }

    public interface CapabilityListener {
        void onCapabilityChanged(CapabilityInfo capabilityInfo);
    }

    public interface GetAllCapabilitiesResult extends Result {
        Map<String, CapabilityInfo> getAllCapabilities();
    }

    public interface GetCapabilityResult extends Result {
        CapabilityInfo getCapability();
    }

    public interface RemoveLocalCapabilityResult extends Result {
    }

    PendingResult<Status> addCapabilityListener(GoogleApiClient googleApiClient, CapabilityListener capabilityListener, String str);

    PendingResult<AddLocalCapabilityResult> addLocalCapability(GoogleApiClient googleApiClient, String str);

    PendingResult<GetAllCapabilitiesResult> getAllCapabilities(GoogleApiClient googleApiClient, int i);

    PendingResult<GetCapabilityResult> getCapability(GoogleApiClient googleApiClient, String str, int i);

    PendingResult<Status> removeCapabilityListener(GoogleApiClient googleApiClient, CapabilityListener capabilityListener, String str);

    PendingResult<RemoveLocalCapabilityResult> removeLocalCapability(GoogleApiClient googleApiClient, String str);
}
