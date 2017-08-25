package com.google.android.gms.search;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;

public interface SearchAuthApi {

    public interface GoogleNowAuthResult extends Result {
        GoogleNowAuthState getGoogleNowAuthState();
    }

    PendingResult<GoogleNowAuthResult> getGoogleNowAuth(GoogleApiClient googleApiClient, String str);
}
