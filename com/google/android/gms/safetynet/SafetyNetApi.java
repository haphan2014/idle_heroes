package com.google.android.gms.safetynet;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;

public interface SafetyNetApi {

    public interface AttestationResult extends Result {
        String getJwsResult();
    }

    PendingResult<AttestationResult> attest(GoogleApiClient googleApiClient, byte[] bArr);
}
