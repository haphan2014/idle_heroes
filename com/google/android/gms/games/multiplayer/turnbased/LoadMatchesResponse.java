package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.constants.TurnBasedMatchTurnStatus;
import com.google.android.gms.games.multiplayer.InvitationBuffer;

public final class LoadMatchesResponse {
    private final InvitationBuffer zzauD;
    private final TurnBasedMatchBuffer zzauE;
    private final TurnBasedMatchBuffer zzauF;
    private final TurnBasedMatchBuffer zzauG;

    public LoadMatchesResponse(Bundle matchData) {
        DataHolder zza = zza(matchData, 0);
        if (zza != null) {
            this.zzauD = new InvitationBuffer(zza);
        } else {
            this.zzauD = null;
        }
        zza = zza(matchData, 1);
        if (zza != null) {
            this.zzauE = new TurnBasedMatchBuffer(zza);
        } else {
            this.zzauE = null;
        }
        zza = zza(matchData, 2);
        if (zza != null) {
            this.zzauF = new TurnBasedMatchBuffer(zza);
        } else {
            this.zzauF = null;
        }
        zza = zza(matchData, 3);
        if (zza != null) {
            this.zzauG = new TurnBasedMatchBuffer(zza);
        } else {
            this.zzauG = null;
        }
    }

    private static DataHolder zza(Bundle bundle, int i) {
        String zzfG = TurnBasedMatchTurnStatus.zzfG(i);
        return !bundle.containsKey(zzfG) ? null : (DataHolder) bundle.getParcelable(zzfG);
    }

    @Deprecated
    public void close() {
        release();
    }

    public TurnBasedMatchBuffer getCompletedMatches() {
        return this.zzauG;
    }

    public InvitationBuffer getInvitations() {
        return this.zzauD;
    }

    public TurnBasedMatchBuffer getMyTurnMatches() {
        return this.zzauE;
    }

    public TurnBasedMatchBuffer getTheirTurnMatches() {
        return this.zzauF;
    }

    public boolean hasData() {
        return (this.zzauD == null || this.zzauD.getCount() <= 0) ? (this.zzauE == null || this.zzauE.getCount() <= 0) ? (this.zzauF == null || this.zzauF.getCount() <= 0) ? this.zzauG != null && this.zzauG.getCount() > 0 : true : true : true;
    }

    public void release() {
        if (this.zzauD != null) {
            this.zzauD.release();
        }
        if (this.zzauE != null) {
            this.zzauE.release();
        }
        if (this.zzauF != null) {
            this.zzauF.release();
        }
        if (this.zzauG != null) {
            this.zzauG.release();
        }
    }
}
