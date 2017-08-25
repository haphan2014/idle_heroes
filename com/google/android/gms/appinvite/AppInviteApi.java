package com.google.android.gms.appinvite;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

public interface AppInviteApi {
    PendingResult<Status> convertInvitation(GoogleApiClient googleApiClient, String str);

    PendingResult<Status> updateInvitationOnInstall(GoogleApiClient googleApiClient, String str);
}
