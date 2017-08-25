package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza.zzb;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.Players;
import com.google.android.gms.games.Players.LoadPlayersResult;
import com.google.android.gms.games.Players.LoadProfileSettingsResult;
import com.google.android.gms.games.Players.LoadXpForGameCategoriesResult;
import com.google.android.gms.games.Players.LoadXpStreamResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class PlayersImpl implements Players {

    private static abstract class LoadPlayersImpl extends BaseGamesApiMethodImpl<LoadPlayersResult> {
        private LoadPlayersImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result createFailedResult(Status x0) {
            return zzaj(x0);
        }

        public LoadPlayersResult zzaj(final Status status) {
            return new LoadPlayersResult(this) {
                final /* synthetic */ LoadPlayersImpl zzarB;

                public PlayerBuffer getPlayers() {
                    return new PlayerBuffer(DataHolder.zzbi(14));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    class AnonymousClass10 extends LoadPlayersImpl {
        final /* synthetic */ String zzaqA;
        final /* synthetic */ int zzarv;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, "nearby", this.zzaqA, this.zzarv, true, false);
        }
    }

    class AnonymousClass11 extends LoadPlayersImpl {
        final /* synthetic */ String zzaqA;
        final /* synthetic */ boolean zzaqy;
        final /* synthetic */ int zzarv;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, "played_with", this.zzaqA, this.zzarv, false, this.zzaqy);
        }
    }

    class AnonymousClass12 extends LoadPlayersImpl {
        final /* synthetic */ String zzaqA;
        final /* synthetic */ int zzarv;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, "played_with", this.zzaqA, this.zzarv, true, false);
        }
    }

    class AnonymousClass13 extends LoadPlayersImpl {
        final /* synthetic */ boolean zzaqy;
        final /* synthetic */ int zzarv;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb((zzb) this, this.zzarv, false, this.zzaqy);
        }
    }

    class AnonymousClass14 extends LoadPlayersImpl {
        final /* synthetic */ int zzarv;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb((zzb) this, this.zzarv, true, false);
        }
    }

    class AnonymousClass15 extends LoadPlayersImpl {
        final /* synthetic */ boolean zzaqy;
        final /* synthetic */ int zzarv;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzc((zzb) this, this.zzarv, false, this.zzaqy);
        }
    }

    class AnonymousClass16 extends LoadPlayersImpl {
        final /* synthetic */ int zzarv;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzc((zzb) this, this.zzarv, true, false);
        }
    }

    class AnonymousClass17 extends LoadPlayersImpl {
        final /* synthetic */ boolean zzaqy;
        final /* synthetic */ int zzarv;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzd(this, this.zzarv, false, this.zzaqy);
        }
    }

    class AnonymousClass18 extends LoadPlayersImpl {
        final /* synthetic */ int zzarv;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzd(this, this.zzarv, true, false);
        }
    }

    class AnonymousClass19 extends LoadPlayersImpl {
        final /* synthetic */ String zzaqR;
        final /* synthetic */ boolean zzaqy;
        final /* synthetic */ int zzarv;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb(this, this.zzaqR, this.zzarv, false, this.zzaqy);
        }
    }

    class AnonymousClass20 extends LoadPlayersImpl {
        final /* synthetic */ String zzaqR;
        final /* synthetic */ int zzarv;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb(this, this.zzaqR, this.zzarv, true, false);
        }
    }

    class AnonymousClass21 extends LoadPlayersImpl {
        final /* synthetic */ boolean zzaqy;
        final /* synthetic */ String zzarm;
        final /* synthetic */ int zzarv;
        final /* synthetic */ String zzarw;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb((zzb) this, this.zzarw, this.zzarm, this.zzarv, false, this.zzaqy);
        }
    }

    class AnonymousClass22 extends LoadPlayersImpl {
        final /* synthetic */ String zzarm;
        final /* synthetic */ int zzarv;
        final /* synthetic */ String zzarw;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb((zzb) this, this.zzarw, this.zzarm, this.zzarv, true, false);
        }
    }

    private static abstract class LoadXpForGameCategoriesResultImpl extends BaseGamesApiMethodImpl<LoadXpForGameCategoriesResult> {
        public /* synthetic */ Result createFailedResult(Status x0) {
            return zzal(x0);
        }

        public LoadXpForGameCategoriesResult zzal(final Status status) {
            return new LoadXpForGameCategoriesResult(this) {
                final /* synthetic */ LoadXpForGameCategoriesResultImpl zzarD;

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    class AnonymousClass23 extends LoadXpForGameCategoriesResultImpl {
        final /* synthetic */ String zzarx;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzl(this, this.zzarx);
        }
    }

    private static abstract class LoadXpStreamResultImpl extends BaseGamesApiMethodImpl<LoadXpStreamResult> {
        public /* synthetic */ Result createFailedResult(Status x0) {
            return zzam(x0);
        }

        public LoadXpStreamResult zzam(final Status status) {
            return new LoadXpStreamResult(this) {
                final /* synthetic */ LoadXpStreamResultImpl zzarE;

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    class AnonymousClass24 extends LoadXpStreamResultImpl {
        final /* synthetic */ String zzarx;
        final /* synthetic */ int zzary;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzc((zzb) this, this.zzarx, this.zzary);
        }
    }

    class AnonymousClass25 extends LoadXpStreamResultImpl {
        final /* synthetic */ String zzarx;
        final /* synthetic */ int zzary;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzd((zzb) this, this.zzarx, this.zzary);
        }
    }

    private static abstract class LoadProfileSettingsResultImpl extends BaseGamesApiMethodImpl<LoadProfileSettingsResult> {
        protected /* synthetic */ Result createFailedResult(Status x0) {
            return zzak(x0);
        }

        protected LoadProfileSettingsResult zzak(final Status status) {
            return new LoadProfileSettingsResult(this) {
                final /* synthetic */ LoadProfileSettingsResultImpl zzarC;

                public Status getStatus() {
                    return status;
                }

                public boolean isProfileVisible() {
                    return true;
                }

                public boolean isVisibilityExplicitlySet() {
                    return false;
                }
            };
        }
    }

    class AnonymousClass26 extends LoadProfileSettingsResultImpl {
        final /* synthetic */ boolean zzaqy;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzf((zzb) this, this.zzaqy);
        }
    }

    private static abstract class UpdateProfileSettingsResultImpl extends BaseGamesApiMethodImpl<Status> {
        protected /* synthetic */ Result createFailedResult(Status x0) {
            return zzb(x0);
        }

        protected Status zzb(Status status) {
            return status;
        }
    }

    class AnonymousClass27 extends UpdateProfileSettingsResultImpl {
        final /* synthetic */ boolean zzarz;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzg((zzb) this, this.zzarz);
        }
    }

    class C07533 extends LoadPlayersImpl {
        final /* synthetic */ String[] zzarA;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzarA);
        }
    }

    class C07599 extends LoadPlayersImpl {
        final /* synthetic */ String zzaqA;
        final /* synthetic */ int zzarv;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, "nearby", this.zzaqA, this.zzarv, false, false);
        }
    }

    public Intent getCompareProfileIntent(GoogleApiClient apiClient, Player player) {
        return Games.zzd(apiClient).zza(new PlayerEntity(player));
    }

    public Player getCurrentPlayer(GoogleApiClient apiClient) {
        return Games.zzd(apiClient).zzsx();
    }

    public String getCurrentPlayerId(GoogleApiClient apiClient) {
        return Games.zzd(apiClient).zzsw();
    }

    public Intent getPlayerSearchIntent(GoogleApiClient apiClient) {
        return Games.zzd(apiClient).zzsH();
    }

    public PendingResult<LoadPlayersResult> loadConnectedPlayers(GoogleApiClient apiClient, final boolean forceReload) {
        return apiClient.zza(new LoadPlayersImpl(this, apiClient) {
            final /* synthetic */ PlayersImpl zzaru;

            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb) this, forceReload);
            }
        });
    }

    public PendingResult<LoadPlayersResult> loadInvitablePlayers(GoogleApiClient apiClient, final int pageSize, final boolean forceReload) {
        return apiClient.zza(new LoadPlayersImpl(this, apiClient) {
            final /* synthetic */ PlayersImpl zzaru;

            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb) this, pageSize, false, forceReload);
            }
        });
    }

    public PendingResult<LoadPlayersResult> loadMoreInvitablePlayers(GoogleApiClient apiClient, final int pageSize) {
        return apiClient.zza(new LoadPlayersImpl(this, apiClient) {
            final /* synthetic */ PlayersImpl zzaru;

            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb) this, pageSize, true, false);
            }
        });
    }

    public PendingResult<LoadPlayersResult> loadMoreRecentlyPlayedWithPlayers(GoogleApiClient apiClient, final int pageSize) {
        return apiClient.zza(new LoadPlayersImpl(this, apiClient) {
            final /* synthetic */ PlayersImpl zzaru;

            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb) this, "played_with", pageSize, true, false);
            }
        });
    }

    public PendingResult<LoadPlayersResult> loadPlayer(GoogleApiClient apiClient, final String playerId) {
        return apiClient.zza(new LoadPlayersImpl(this, apiClient) {
            final /* synthetic */ PlayersImpl zzaru;

            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb) this, playerId, false);
            }
        });
    }

    public PendingResult<LoadPlayersResult> loadPlayer(GoogleApiClient apiClient, final String playerId, final boolean forceReload) {
        return apiClient.zza(new LoadPlayersImpl(this, apiClient) {
            final /* synthetic */ PlayersImpl zzaru;

            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb) this, playerId, forceReload);
            }
        });
    }

    public PendingResult<LoadPlayersResult> loadRecentlyPlayedWithPlayers(GoogleApiClient apiClient, final int pageSize, final boolean forceReload) {
        return apiClient.zza(new LoadPlayersImpl(this, apiClient) {
            final /* synthetic */ PlayersImpl zzaru;

            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb) this, "played_with", pageSize, false, forceReload);
            }
        });
    }
}
