package com.google.android.gms.games.internal.api;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.GamesMetadata;
import com.google.android.gms.games.GamesMetadata.LoadGameInstancesResult;
import com.google.android.gms.games.GamesMetadata.LoadGameSearchSuggestionsResult;
import com.google.android.gms.games.GamesMetadata.LoadGamesResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class GamesMetadataImpl implements GamesMetadata {

    private static abstract class LoadGamesImpl extends BaseGamesApiMethodImpl<LoadGamesResult> {
        private LoadGamesImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result createFailedResult(Status x0) {
            return zzZ(x0);
        }

        public LoadGamesResult zzZ(final Status status) {
            return new LoadGamesResult(this) {
                final /* synthetic */ LoadGamesImpl zzaqU;

                public GameBuffer getGames() {
                    return new GameBuffer(DataHolder.zzbi(14));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    private static abstract class LoadGameInstancesImpl extends BaseGamesApiMethodImpl<LoadGameInstancesResult> {
        public /* synthetic */ Result createFailedResult(Status x0) {
            return zzX(x0);
        }

        public LoadGameInstancesResult zzX(final Status status) {
            return new LoadGameInstancesResult(this) {
                final /* synthetic */ LoadGameInstancesImpl zzaqS;

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    class C07182 extends LoadGameInstancesImpl {
        final /* synthetic */ String zzaqA;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzj(this, this.zzaqA);
        }
    }

    private static abstract class LoadGameSearchSuggestionsImpl extends BaseGamesApiMethodImpl<LoadGameSearchSuggestionsResult> {
        public /* synthetic */ Result createFailedResult(Status x0) {
            return zzY(x0);
        }

        public LoadGameSearchSuggestionsResult zzY(final Status status) {
            return new LoadGameSearchSuggestionsResult(this) {
                final /* synthetic */ LoadGameSearchSuggestionsImpl zzaqT;

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    class C07193 extends LoadGameSearchSuggestionsImpl {
        final /* synthetic */ String zzaqR;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzk(this, this.zzaqR);
        }
    }

    public Game getCurrentGame(GoogleApiClient apiClient) {
        return Games.zzd(apiClient).zzsy();
    }

    public PendingResult<LoadGamesResult> loadGame(GoogleApiClient apiClient) {
        return apiClient.zza(new LoadGamesImpl(this, apiClient) {
            final /* synthetic */ GamesMetadataImpl zzaqQ;

            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzf(this);
            }
        });
    }
}
