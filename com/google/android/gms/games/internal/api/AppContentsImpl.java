package com.google.android.gms.games.internal.api;

import android.os.RemoteException;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza.zzb;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.appcontent.AppContents;
import com.google.android.gms.games.appcontent.AppContents.LoadAppContentResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class AppContentsImpl implements AppContents {

    private static abstract class LoadsImpl extends BaseGamesApiMethodImpl<LoadAppContentResult> {
        public /* synthetic */ Result createFailedResult(Status x0) {
            return zzV(x0);
        }

        public LoadAppContentResult zzV(final Status status) {
            return new LoadAppContentResult(this) {
                final /* synthetic */ LoadsImpl zzaqJ;

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    class C07101 extends LoadsImpl {
        final /* synthetic */ int zzaqG;
        final /* synthetic */ String zzaqH;
        final /* synthetic */ String[] zzaqI;
        final /* synthetic */ boolean zzaqy;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzaqG, this.zzaqH, this.zzaqI, this.zzaqy);
        }
    }
}
