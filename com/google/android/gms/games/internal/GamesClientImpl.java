package com.google.android.gms.games.internal;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionProgressReportCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza;
import com.google.android.gms.common.api.zzb;
import com.google.android.gms.common.api.zzc;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.BinderWrapper;
import com.google.android.gms.common.internal.zze;
import com.google.android.gms.common.internal.zzi;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Games.GamesOptions;
import com.google.android.gms.games.GamesMetadata.LoadGameInstancesResult;
import com.google.android.gms.games.GamesMetadata.LoadGameSearchSuggestionsResult;
import com.google.android.gms.games.GamesMetadata.LoadGamesResult;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.Notifications.ContactSettingLoadResult;
import com.google.android.gms.games.Notifications.GameMuteStatusChangeResult;
import com.google.android.gms.games.Notifications.GameMuteStatusLoadResult;
import com.google.android.gms.games.Notifications.InboxCountResult;
import com.google.android.gms.games.OnNearbyPlayerDetectedListener;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.Players.LoadPlayersResult;
import com.google.android.gms.games.Players.LoadProfileSettingsResult;
import com.google.android.gms.games.Players.LoadXpForGameCategoriesResult;
import com.google.android.gms.games.Players.LoadXpStreamResult;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.Achievements.LoadAchievementsResult;
import com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult;
import com.google.android.gms.games.appcontent.AppContents.LoadAppContentResult;
import com.google.android.gms.games.event.EventBuffer;
import com.google.android.gms.games.event.Events.LoadEventsResult;
import com.google.android.gms.games.internal.IGamesService.Stub;
import com.google.android.gms.games.internal.constants.RequestType;
import com.google.android.gms.games.internal.events.EventIncrementCache;
import com.google.android.gms.games.internal.events.EventIncrementManager;
import com.google.android.gms.games.internal.experience.ExperienceEventBuffer;
import com.google.android.gms.games.internal.game.Acls.LoadAclResult;
import com.google.android.gms.games.internal.game.GameInstanceBuffer;
import com.google.android.gms.games.internal.game.GameSearchSuggestionBuffer;
import com.google.android.gms.games.internal.request.RequestUpdateOutcomes;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardEntity;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScoreEntity;
import com.google.android.gms.games.leaderboard.Leaderboards.LeaderboardMetadataResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadPlayerScoreResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult;
import com.google.android.gms.games.leaderboard.Leaderboards.SubmitScoreResult;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.games.multiplayer.Invitations.LoadInvitationsResult;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessage;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessageReceivedListener;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer.ReliableMessageSentCallback;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomBuffer;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.realtime.RoomEntity;
import com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;
import com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchBuffer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.CancelMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.InitiateMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LeaveMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchesResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.UpdateMatchResult;
import com.google.android.gms.games.quest.Milestone;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.games.quest.QuestBuffer;
import com.google.android.gms.games.quest.QuestEntity;
import com.google.android.gms.games.quest.QuestUpdateListener;
import com.google.android.gms.games.quest.Quests.AcceptQuestResult;
import com.google.android.gms.games.quest.Quests.ClaimMilestoneResult;
import com.google.android.gms.games.quest.Quests.LoadQuestsResult;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestBuffer;
import com.google.android.gms.games.request.OnRequestReceivedListener;
import com.google.android.gms.games.request.Requests.LoadRequestSummariesResult;
import com.google.android.gms.games.request.Requests.LoadRequestsResult;
import com.google.android.gms.games.request.Requests.SendRequestResult;
import com.google.android.gms.games.request.Requests.UpdateRequestsResult;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotContentsEntity;
import com.google.android.gms.games.snapshot.SnapshotEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.games.snapshot.SnapshotMetadataChangeEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;
import com.google.android.gms.games.snapshot.Snapshots.CommitSnapshotResult;
import com.google.android.gms.games.snapshot.Snapshots.DeleteSnapshotResult;
import com.google.android.gms.games.snapshot.Snapshots.LoadSnapshotsResult;
import com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult;
import com.google.android.gms.signin.internal.zzh;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executors;

public final class GamesClientImpl extends zzi<IGamesService> {
    EventIncrementManager zzaoQ = new C06941(this);
    private final String zzaoR;
    private PlayerEntity zzaoS;
    private GameEntity zzaoT;
    private final PopupManager zzaoU;
    private boolean zzaoV = false;
    private final Binder zzaoW;
    private final long zzaoX;
    private final GamesOptions zzaoY;

    class C06941 extends EventIncrementManager {
        final /* synthetic */ GamesClientImpl zzaoZ;

        C06941(GamesClientImpl gamesClientImpl) {
            this.zzaoZ = gamesClientImpl;
        }

        public EventIncrementCache zzsS() {
            return new GameClientEventIncrementCache(this.zzaoZ);
        }
    }

    private static abstract class AbstractRoomStatusNotifier extends zzb<RoomStatusUpdateListener> {
        AbstractRoomStatusNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        protected void zza(RoomStatusUpdateListener roomStatusUpdateListener, DataHolder dataHolder) {
            zza(roomStatusUpdateListener, GamesClientImpl.zzU(dataHolder));
        }

        protected abstract void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room);
    }

    private static abstract class AbstractPeerStatusNotifier extends AbstractRoomStatusNotifier {
        private final ArrayList<String> zzapa = new ArrayList();

        AbstractPeerStatusNotifier(DataHolder dataHolder, String[] participantIds) {
            super(dataHolder);
            for (Object add : participantIds) {
                this.zzapa.add(add);
            }
        }

        protected void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            zza(roomStatusUpdateListener, room, this.zzapa);
        }

        protected abstract void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList);
    }

    private static abstract class AbstractRoomNotifier extends zzb<RoomUpdateListener> {
        AbstractRoomNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        protected void zza(RoomUpdateListener roomUpdateListener, DataHolder dataHolder) {
            zza(roomUpdateListener, GamesClientImpl.zzU(dataHolder), dataHolder.getStatusCode());
        }

        protected abstract void zza(RoomUpdateListener roomUpdateListener, Room room, int i);
    }

    private static abstract class GamesDataHolderResult extends zzc {
        protected GamesDataHolderResult(DataHolder dataHolder) {
            super(dataHolder, GamesStatusCodes.zzfn(dataHolder.getStatusCode()));
        }
    }

    private static final class AcceptQuestResultImpl extends GamesDataHolderResult implements AcceptQuestResult {
        private final Quest zzapb;

        AcceptQuestResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            QuestBuffer questBuffer = new QuestBuffer(dataHolder);
            try {
                if (questBuffer.getCount() > 0) {
                    this.zzapb = new QuestEntity((Quest) questBuffer.get(0));
                } else {
                    this.zzapb = null;
                }
                questBuffer.release();
            } catch (Throwable th) {
                questBuffer.release();
            }
        }

        public Quest getQuest() {
            return this.zzapb;
        }
    }

    private static final class AchievementUpdatedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<UpdateAchievementResult> zzOs;

        AchievementUpdatedBinderCallback(zza.zzb<UpdateAchievementResult> resultHolder) {
            this.zzOs = (zza.zzb) zzu.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzf(int i, String str) {
            this.zzOs.zzm(new UpdateAchievementResultImpl(i, str));
        }
    }

    private static final class AchievementsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<LoadAchievementsResult> zzOs;

        AchievementsLoadedBinderCallback(zza.zzb<LoadAchievementsResult> resultHolder) {
            this.zzOs = (zza.zzb) zzu.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzf(DataHolder dataHolder) {
            this.zzOs.zzm(new LoadAchievementsResultImpl(dataHolder));
        }
    }

    private static final class AppContentLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<LoadAppContentResult> zzapc;

        public AppContentLoadedBinderCallbacks(zza.zzb<LoadAppContentResult> resultHolder) {
            this.zzapc = (zza.zzb) zzu.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zza(DataHolder[] dataHolderArr) {
            this.zzapc.zzm(new LoadAppContentsResultImpl(dataHolderArr));
        }
    }

    private static final class CancelMatchResultImpl implements CancelMatchResult {
        private final Status zzOt;
        private final String zzapd;

        CancelMatchResultImpl(Status status, String externalMatchId) {
            this.zzOt = status;
            this.zzapd = externalMatchId;
        }

        public String getMatchId() {
            return this.zzapd;
        }

        public Status getStatus() {
            return this.zzOt;
        }
    }

    private static final class ClaimMilestoneResultImpl extends GamesDataHolderResult implements ClaimMilestoneResult {
        private final Quest zzapb;
        private final Milestone zzape;

        ClaimMilestoneResultImpl(DataHolder dataHolder, String milestoneId) {
            super(dataHolder);
            QuestBuffer questBuffer = new QuestBuffer(dataHolder);
            try {
                if (questBuffer.getCount() > 0) {
                    this.zzapb = new QuestEntity((Quest) questBuffer.get(0));
                    List zztN = this.zzapb.zztN();
                    int size = zztN.size();
                    for (int i = 0; i < size; i++) {
                        if (((Milestone) zztN.get(i)).getMilestoneId().equals(milestoneId)) {
                            this.zzape = (Milestone) zztN.get(i);
                            return;
                        }
                    }
                    this.zzape = null;
                } else {
                    this.zzape = null;
                    this.zzapb = null;
                }
                questBuffer.release();
            } finally {
                questBuffer.release();
            }
        }

        public Milestone getMilestone() {
            return this.zzape;
        }

        public Quest getQuest() {
            return this.zzapb;
        }
    }

    private static final class CommitSnapshotResultImpl extends GamesDataHolderResult implements CommitSnapshotResult {
        private final SnapshotMetadata zzapf;

        CommitSnapshotResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            SnapshotMetadataBuffer snapshotMetadataBuffer = new SnapshotMetadataBuffer(dataHolder);
            try {
                if (snapshotMetadataBuffer.getCount() > 0) {
                    this.zzapf = new SnapshotMetadataEntity(snapshotMetadataBuffer.get(0));
                } else {
                    this.zzapf = null;
                }
                snapshotMetadataBuffer.release();
            } catch (Throwable th) {
                snapshotMetadataBuffer.release();
            }
        }

        public SnapshotMetadata getSnapshotMetadata() {
            return this.zzapf;
        }
    }

    private static final class ConnectedToRoomNotifier extends AbstractRoomStatusNotifier {
        ConnectedToRoomNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        public void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onConnectedToRoom(room);
        }
    }

    private static final class ContactSettingLoadResultImpl extends GamesDataHolderResult implements ContactSettingLoadResult {
        ContactSettingLoadResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class ContactSettingsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<ContactSettingLoadResult> zzOs;

        ContactSettingsLoadedBinderCallback(zza.zzb<ContactSettingLoadResult> holder) {
            this.zzOs = (zza.zzb) zzu.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zzG(DataHolder dataHolder) {
            this.zzOs.zzm(new ContactSettingLoadResultImpl(dataHolder));
        }
    }

    private static final class ContactSettingsUpdatedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<Status> zzOs;

        ContactSettingsUpdatedBinderCallback(zza.zzb<Status> holder) {
            this.zzOs = (zza.zzb) zzu.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zzfz(int i) {
            this.zzOs.zzm(GamesStatusCodes.zzfn(i));
        }
    }

    private static final class DeleteSnapshotResultImpl implements DeleteSnapshotResult {
        private final Status zzOt;
        private final String zzapg;

        DeleteSnapshotResultImpl(int statusCode, String snapshotId) {
            this.zzOt = GamesStatusCodes.zzfn(statusCode);
            this.zzapg = snapshotId;
        }

        public String getSnapshotId() {
            return this.zzapg;
        }

        public Status getStatus() {
            return this.zzOt;
        }
    }

    private static final class DisconnectedFromRoomNotifier extends AbstractRoomStatusNotifier {
        DisconnectedFromRoomNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        public void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onDisconnectedFromRoom(room);
        }
    }

    private static final class EventsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<LoadEventsResult> zzOs;

        EventsLoadedBinderCallback(zza.zzb<LoadEventsResult> resultHolder) {
            this.zzOs = (zza.zzb) zzu.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzg(DataHolder dataHolder) {
            this.zzOs.zzm(new LoadEventResultImpl(dataHolder));
        }
    }

    private class GameClientEventIncrementCache extends EventIncrementCache {
        final /* synthetic */ GamesClientImpl zzaoZ;

        public GameClientEventIncrementCache(GamesClientImpl gamesClientImpl) {
            this.zzaoZ = gamesClientImpl;
            super(gamesClientImpl.getContext().getMainLooper(), 1000);
        }

        protected void zzs(String str, int i) {
            try {
                if (this.zzaoZ.isConnected()) {
                    ((IGamesService) this.zzaoZ.zznM()).zzp(str, i);
                } else {
                    GamesLog.zzv("GamesClientImpl", "Unable to increment event " + str + " by " + i + " because the games client is no longer connected");
                }
            } catch (RemoteException e) {
                this.zzaoZ.zzb(e);
            }
        }
    }

    private static final class GameInstancesLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<LoadGameInstancesResult> zzOs;

        GameInstancesLoadedBinderCallback(zza.zzb<LoadGameInstancesResult> holder) {
            this.zzOs = (zza.zzb) zzu.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zzn(DataHolder dataHolder) {
            this.zzOs.zzm(new LoadGameInstancesResultImpl(dataHolder));
        }
    }

    private static final class GameMuteStatusChangeResultImpl implements GameMuteStatusChangeResult {
        private final Status zzOt;
        private final String zzaph;
        private final boolean zzapi;

        public GameMuteStatusChangeResultImpl(int statusCode, String externalGameId, boolean isMuted) {
            this.zzOt = GamesStatusCodes.zzfn(statusCode);
            this.zzaph = externalGameId;
            this.zzapi = isMuted;
        }

        public Status getStatus() {
            return this.zzOt;
        }
    }

    private static final class GameMuteStatusChangedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<GameMuteStatusChangeResult> zzOs;

        GameMuteStatusChangedBinderCallback(zza.zzb<GameMuteStatusChangeResult> holder) {
            this.zzOs = (zza.zzb) zzu.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zza(int i, String str, boolean z) {
            this.zzOs.zzm(new GameMuteStatusChangeResultImpl(i, str, z));
        }
    }

    private static final class GameMuteStatusLoadResultImpl implements GameMuteStatusLoadResult {
        private final Status zzOt;
        private final String zzaph;
        private final boolean zzapi;

        public GameMuteStatusLoadResultImpl(DataHolder dataHolder) {
            try {
                this.zzOt = GamesStatusCodes.zzfn(dataHolder.getStatusCode());
                if (dataHolder.getCount() > 0) {
                    this.zzaph = dataHolder.zzd("external_game_id", 0, 0);
                    this.zzapi = dataHolder.zze("muted", 0, 0);
                } else {
                    this.zzaph = null;
                    this.zzapi = false;
                }
                dataHolder.close();
            } catch (Throwable th) {
                dataHolder.close();
            }
        }

        public Status getStatus() {
            return this.zzOt;
        }
    }

    private static final class GameMuteStatusLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<GameMuteStatusLoadResult> zzOs;

        GameMuteStatusLoadedBinderCallback(zza.zzb<GameMuteStatusLoadResult> holder) {
            this.zzOs = (zza.zzb) zzu.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zzE(DataHolder dataHolder) {
            this.zzOs.zzm(new GameMuteStatusLoadResultImpl(dataHolder));
        }
    }

    private static final class GameSearchSuggestionsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<LoadGameSearchSuggestionsResult> zzOs;

        GameSearchSuggestionsLoadedBinderCallback(zza.zzb<LoadGameSearchSuggestionsResult> holder) {
            this.zzOs = (zza.zzb) zzu.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zzo(DataHolder dataHolder) {
            this.zzOs.zzm(new LoadGameSearchSuggestionsResultImpl(dataHolder));
        }
    }

    private static final class GamesLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<LoadGamesResult> zzOs;

        GamesLoadedBinderCallback(zza.zzb<LoadGamesResult> holder) {
            this.zzOs = (zza.zzb) zzu.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zzl(DataHolder dataHolder) {
            this.zzOs.zzm(new LoadGamesResultImpl(dataHolder));
        }
    }

    private static final class InboxCountResultImpl implements InboxCountResult {
        private final Status zzOt;
        private final Bundle zzapj;

        InboxCountResultImpl(Status status, Bundle inboxCounts) {
            this.zzOt = status;
            this.zzapj = inboxCounts;
        }

        public Status getStatus() {
            return this.zzOt;
        }
    }

    private static final class InboxCountsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<InboxCountResult> zzOs;

        InboxCountsLoadedBinderCallback(zza.zzb<InboxCountResult> holder) {
            this.zzOs = (zza.zzb) zzu.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zzg(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.zzOs.zzm(new InboxCountResultImpl(GamesStatusCodes.zzfn(i), bundle));
        }
    }

    private static abstract class TurnBasedMatchResult extends GamesDataHolderResult {
        final TurnBasedMatch zzapG;

        TurnBasedMatchResult(DataHolder dataHolder) {
            super(dataHolder);
            TurnBasedMatchBuffer turnBasedMatchBuffer = new TurnBasedMatchBuffer(dataHolder);
            try {
                if (turnBasedMatchBuffer.getCount() > 0) {
                    this.zzapG = (TurnBasedMatch) ((TurnBasedMatch) turnBasedMatchBuffer.get(0)).freeze();
                } else {
                    this.zzapG = null;
                }
                turnBasedMatchBuffer.release();
            } catch (Throwable th) {
                turnBasedMatchBuffer.release();
            }
        }

        public TurnBasedMatch getMatch() {
            return this.zzapG;
        }
    }

    private static final class InitiateMatchResultImpl extends TurnBasedMatchResult implements InitiateMatchResult {
        InitiateMatchResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class InvitationReceivedBinderCallback extends AbstractGamesCallbacks {
        private final com.google.android.gms.common.api.zzi<OnInvitationReceivedListener> zzafi;

        InvitationReceivedBinderCallback(com.google.android.gms.common.api.zzi<OnInvitationReceivedListener> listener) {
            this.zzafi = listener;
        }

        public void onInvitationRemoved(String invitationId) {
            this.zzafi.zza(new InvitationRemovedNotifier(invitationId));
        }

        public void zzq(DataHolder dataHolder) {
            InvitationBuffer invitationBuffer = new InvitationBuffer(dataHolder);
            Invitation invitation = null;
            try {
                if (invitationBuffer.getCount() > 0) {
                    invitation = (Invitation) ((Invitation) invitationBuffer.get(0)).freeze();
                }
                invitationBuffer.release();
                if (invitation != null) {
                    this.zzafi.zza(new InvitationReceivedNotifier(invitation));
                }
            } catch (Throwable th) {
                invitationBuffer.release();
            }
        }
    }

    private static final class InvitationReceivedNotifier implements com.google.android.gms.common.api.zzi.zzb<OnInvitationReceivedListener> {
        private final Invitation zzapk;

        InvitationReceivedNotifier(Invitation invitation) {
            this.zzapk = invitation;
        }

        public void zza(OnInvitationReceivedListener onInvitationReceivedListener) {
            onInvitationReceivedListener.onInvitationReceived(this.zzapk);
        }

        public void zzmw() {
        }

        public /* synthetic */ void zzn(Object obj) {
            zza((OnInvitationReceivedListener) obj);
        }
    }

    private static final class InvitationRemovedNotifier implements com.google.android.gms.common.api.zzi.zzb<OnInvitationReceivedListener> {
        private final String zzapl;

        InvitationRemovedNotifier(String invitationId) {
            this.zzapl = invitationId;
        }

        public void zza(OnInvitationReceivedListener onInvitationReceivedListener) {
            onInvitationReceivedListener.onInvitationRemoved(this.zzapl);
        }

        public void zzmw() {
        }

        public /* synthetic */ void zzn(Object obj) {
            zza((OnInvitationReceivedListener) obj);
        }
    }

    private static final class InvitationsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<LoadInvitationsResult> zzOs;

        InvitationsLoadedBinderCallback(zza.zzb<LoadInvitationsResult> resultHolder) {
            this.zzOs = (zza.zzb) zzu.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzp(DataHolder dataHolder) {
            this.zzOs.zzm(new LoadInvitationsResultImpl(dataHolder));
        }
    }

    private static final class JoinedRoomNotifier extends AbstractRoomNotifier {
        public JoinedRoomNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        public void zza(RoomUpdateListener roomUpdateListener, Room room, int i) {
            roomUpdateListener.onJoinedRoom(i, room);
        }
    }

    private static final class LeaderboardMetadataResultImpl extends GamesDataHolderResult implements LeaderboardMetadataResult {
        private final LeaderboardBuffer zzapm;

        LeaderboardMetadataResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzapm = new LeaderboardBuffer(dataHolder);
        }

        public LeaderboardBuffer getLeaderboards() {
            return this.zzapm;
        }
    }

    private static final class LeaderboardScoresLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<LoadScoresResult> zzOs;

        LeaderboardScoresLoadedBinderCallback(zza.zzb<LoadScoresResult> resultHolder) {
            this.zzOs = (zza.zzb) zzu.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zza(DataHolder dataHolder, DataHolder dataHolder2) {
            this.zzOs.zzm(new LoadScoresResultImpl(dataHolder, dataHolder2));
        }
    }

    private static final class LeaderboardsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<LeaderboardMetadataResult> zzOs;

        LeaderboardsLoadedBinderCallback(zza.zzb<LeaderboardMetadataResult> resultHolder) {
            this.zzOs = (zza.zzb) zzu.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzh(DataHolder dataHolder) {
            this.zzOs.zzm(new LeaderboardMetadataResultImpl(dataHolder));
        }
    }

    private static final class LeaveMatchResultImpl extends TurnBasedMatchResult implements LeaveMatchResult {
        LeaveMatchResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class LeftRoomNotifier implements com.google.android.gms.common.api.zzi.zzb<RoomUpdateListener> {
        private final int zzTS;
        private final String zzapn;

        LeftRoomNotifier(int statusCode, String roomId) {
            this.zzTS = statusCode;
            this.zzapn = roomId;
        }

        public void zza(RoomUpdateListener roomUpdateListener) {
            roomUpdateListener.onLeftRoom(this.zzTS, this.zzapn);
        }

        public void zzmw() {
        }

        public /* synthetic */ void zzn(Object obj) {
            zza((RoomUpdateListener) obj);
        }
    }

    private static final class LoadAchievementsResultImpl extends GamesDataHolderResult implements LoadAchievementsResult {
        private final AchievementBuffer zzapo;

        LoadAchievementsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzapo = new AchievementBuffer(dataHolder);
        }

        public AchievementBuffer getAchievements() {
            return this.zzapo;
        }
    }

    private static final class LoadAclResultImpl extends GamesDataHolderResult implements LoadAclResult {
        LoadAclResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class LoadAppContentsResultImpl extends GamesDataHolderResult implements LoadAppContentResult {
        private final ArrayList<DataHolder> zzapp;

        LoadAppContentsResultImpl(DataHolder[] appContentData) {
            super(appContentData[0]);
            this.zzapp = new ArrayList(Arrays.asList(appContentData));
        }
    }

    private static final class LoadEventResultImpl extends GamesDataHolderResult implements LoadEventsResult {
        private final EventBuffer zzapq;

        LoadEventResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzapq = new EventBuffer(dataHolder);
        }

        public EventBuffer getEvents() {
            return this.zzapq;
        }
    }

    private static final class LoadGameInstancesResultImpl extends GamesDataHolderResult implements LoadGameInstancesResult {
        private final GameInstanceBuffer zzapr;

        LoadGameInstancesResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzapr = new GameInstanceBuffer(dataHolder);
        }
    }

    private static final class LoadGameSearchSuggestionsResultImpl extends GamesDataHolderResult implements LoadGameSearchSuggestionsResult {
        private final GameSearchSuggestionBuffer zzaps;

        LoadGameSearchSuggestionsResultImpl(DataHolder data) {
            super(data);
            this.zzaps = new GameSearchSuggestionBuffer(data);
        }
    }

    private static final class LoadGamesResultImpl extends GamesDataHolderResult implements LoadGamesResult {
        private final GameBuffer zzapt;

        LoadGamesResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzapt = new GameBuffer(dataHolder);
        }

        public GameBuffer getGames() {
            return this.zzapt;
        }
    }

    private static final class LoadInvitationsResultImpl extends GamesDataHolderResult implements LoadInvitationsResult {
        private final InvitationBuffer zzapu;

        LoadInvitationsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzapu = new InvitationBuffer(dataHolder);
        }

        public InvitationBuffer getInvitations() {
            return this.zzapu;
        }
    }

    private static final class LoadMatchResultImpl extends TurnBasedMatchResult implements LoadMatchResult {
        LoadMatchResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class LoadMatchesResultImpl implements LoadMatchesResult {
        private final Status zzOt;
        private final LoadMatchesResponse zzapv;

        LoadMatchesResultImpl(Status status, Bundle matchData) {
            this.zzOt = status;
            this.zzapv = new LoadMatchesResponse(matchData);
        }

        public LoadMatchesResponse getMatches() {
            return this.zzapv;
        }

        public Status getStatus() {
            return this.zzOt;
        }

        public void release() {
            this.zzapv.release();
        }
    }

    private static final class LoadPlayerScoreResultImpl extends GamesDataHolderResult implements LoadPlayerScoreResult {
        private final LeaderboardScoreEntity zzapw;

        LoadPlayerScoreResultImpl(DataHolder scoreHolder) {
            super(scoreHolder);
            LeaderboardScoreBuffer leaderboardScoreBuffer = new LeaderboardScoreBuffer(scoreHolder);
            try {
                if (leaderboardScoreBuffer.getCount() > 0) {
                    this.zzapw = (LeaderboardScoreEntity) leaderboardScoreBuffer.get(0).freeze();
                } else {
                    this.zzapw = null;
                }
                leaderboardScoreBuffer.release();
            } catch (Throwable th) {
                leaderboardScoreBuffer.release();
            }
        }

        public LeaderboardScore getScore() {
            return this.zzapw;
        }
    }

    private static final class LoadPlayersResultImpl extends GamesDataHolderResult implements LoadPlayersResult {
        private final PlayerBuffer zzapx;

        LoadPlayersResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzapx = new PlayerBuffer(dataHolder);
        }

        public PlayerBuffer getPlayers() {
            return this.zzapx;
        }
    }

    private static final class LoadProfileSettingsResultImpl extends GamesDataHolderResult implements LoadProfileSettingsResult {
        private final boolean zzaoN;
        private final boolean zzapy;

        LoadProfileSettingsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            try {
                if (dataHolder.getCount() > 0) {
                    int zzbh = dataHolder.zzbh(0);
                    this.zzaoN = dataHolder.zze("profile_visible", 0, zzbh);
                    this.zzapy = dataHolder.zze("profile_visibility_explicitly_set", 0, zzbh);
                } else {
                    this.zzaoN = true;
                    this.zzapy = false;
                }
                dataHolder.close();
            } catch (Throwable th) {
                dataHolder.close();
            }
        }

        public Status getStatus() {
            return this.zzOt;
        }

        public boolean isProfileVisible() {
            return this.zzaoN;
        }

        public boolean isVisibilityExplicitlySet() {
            return this.zzapy;
        }
    }

    private static final class LoadQuestsResultImpl extends GamesDataHolderResult implements LoadQuestsResult {
        private final DataHolder zzWu;

        LoadQuestsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzWu = dataHolder;
        }

        public QuestBuffer getQuests() {
            return new QuestBuffer(this.zzWu);
        }
    }

    private static final class LoadRequestSummariesResultImpl extends GamesDataHolderResult implements LoadRequestSummariesResult {
        LoadRequestSummariesResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class LoadRequestsResultImpl implements LoadRequestsResult {
        private final Status zzOt;
        private final Bundle zzapz;

        LoadRequestsResultImpl(Status status, Bundle requestData) {
            this.zzOt = status;
            this.zzapz = requestData;
        }

        public GameRequestBuffer getRequests(int requestType) {
            String zzfG = RequestType.zzfG(requestType);
            return !this.zzapz.containsKey(zzfG) ? null : new GameRequestBuffer((DataHolder) this.zzapz.get(zzfG));
        }

        public Status getStatus() {
            return this.zzOt;
        }

        public void release() {
            for (String parcelable : this.zzapz.keySet()) {
                DataHolder dataHolder = (DataHolder) this.zzapz.getParcelable(parcelable);
                if (dataHolder != null) {
                    dataHolder.close();
                }
            }
        }
    }

    private static final class LoadScoresResultImpl extends GamesDataHolderResult implements LoadScoresResult {
        private final LeaderboardEntity zzapA;
        private final LeaderboardScoreBuffer zzapB;

        LoadScoresResultImpl(DataHolder leaderboard, DataHolder scores) {
            super(scores);
            LeaderboardBuffer leaderboardBuffer = new LeaderboardBuffer(leaderboard);
            try {
                if (leaderboardBuffer.getCount() > 0) {
                    this.zzapA = (LeaderboardEntity) ((Leaderboard) leaderboardBuffer.get(0)).freeze();
                } else {
                    this.zzapA = null;
                }
                leaderboardBuffer.release();
                this.zzapB = new LeaderboardScoreBuffer(scores);
            } catch (Throwable th) {
                leaderboardBuffer.release();
            }
        }

        public Leaderboard getLeaderboard() {
            return this.zzapA;
        }

        public LeaderboardScoreBuffer getScores() {
            return this.zzapB;
        }
    }

    private static final class LoadSnapshotsResultImpl extends GamesDataHolderResult implements LoadSnapshotsResult {
        LoadSnapshotsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }

        public SnapshotMetadataBuffer getSnapshots() {
            return new SnapshotMetadataBuffer(this.zzWu);
        }
    }

    private static final class LoadXpForGameCategoriesResultImpl implements LoadXpForGameCategoriesResult {
        private final Status zzOt;
        private final List<String> zzapC;
        private final Bundle zzapD;

        LoadXpForGameCategoriesResultImpl(Status status, Bundle xpData) {
            this.zzOt = status;
            this.zzapC = xpData.getStringArrayList("game_category_list");
            this.zzapD = xpData;
        }

        public Status getStatus() {
            return this.zzOt;
        }
    }

    private static final class LoadXpStreamResultImpl extends GamesDataHolderResult implements LoadXpStreamResult {
        private final ExperienceEventBuffer zzapE;

        LoadXpStreamResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzapE = new ExperienceEventBuffer(dataHolder);
        }
    }

    private static final class MatchRemovedNotifier implements com.google.android.gms.common.api.zzi.zzb<OnTurnBasedMatchUpdateReceivedListener> {
        private final String zzapF;

        MatchRemovedNotifier(String matchId) {
            this.zzapF = matchId;
        }

        public void zza(OnTurnBasedMatchUpdateReceivedListener onTurnBasedMatchUpdateReceivedListener) {
            onTurnBasedMatchUpdateReceivedListener.onTurnBasedMatchRemoved(this.zzapF);
        }

        public void zzmw() {
        }

        public /* synthetic */ void zzn(Object obj) {
            zza((OnTurnBasedMatchUpdateReceivedListener) obj);
        }
    }

    private static final class MatchUpdateReceivedBinderCallback extends AbstractGamesCallbacks {
        private final com.google.android.gms.common.api.zzi<OnTurnBasedMatchUpdateReceivedListener> zzafi;

        MatchUpdateReceivedBinderCallback(com.google.android.gms.common.api.zzi<OnTurnBasedMatchUpdateReceivedListener> listener) {
            this.zzafi = listener;
        }

        public void onTurnBasedMatchRemoved(String matchId) {
            this.zzafi.zza(new MatchRemovedNotifier(matchId));
        }

        public void zzw(DataHolder dataHolder) {
            TurnBasedMatchBuffer turnBasedMatchBuffer = new TurnBasedMatchBuffer(dataHolder);
            TurnBasedMatch turnBasedMatch = null;
            try {
                if (turnBasedMatchBuffer.getCount() > 0) {
                    turnBasedMatch = (TurnBasedMatch) ((TurnBasedMatch) turnBasedMatchBuffer.get(0)).freeze();
                }
                turnBasedMatchBuffer.release();
                if (turnBasedMatch != null) {
                    this.zzafi.zza(new MatchUpdateReceivedNotifier(turnBasedMatch));
                }
            } catch (Throwable th) {
                turnBasedMatchBuffer.release();
            }
        }
    }

    private static final class MatchUpdateReceivedNotifier implements com.google.android.gms.common.api.zzi.zzb<OnTurnBasedMatchUpdateReceivedListener> {
        private final TurnBasedMatch zzapG;

        MatchUpdateReceivedNotifier(TurnBasedMatch match) {
            this.zzapG = match;
        }

        public void zza(OnTurnBasedMatchUpdateReceivedListener onTurnBasedMatchUpdateReceivedListener) {
            onTurnBasedMatchUpdateReceivedListener.onTurnBasedMatchReceived(this.zzapG);
        }

        public void zzmw() {
        }

        public /* synthetic */ void zzn(Object obj) {
            zza((OnTurnBasedMatchUpdateReceivedListener) obj);
        }
    }

    private static final class MessageReceivedNotifier implements com.google.android.gms.common.api.zzi.zzb<RealTimeMessageReceivedListener> {
        private final RealTimeMessage zzapH;

        MessageReceivedNotifier(RealTimeMessage message) {
            this.zzapH = message;
        }

        public void zza(RealTimeMessageReceivedListener realTimeMessageReceivedListener) {
            realTimeMessageReceivedListener.onRealTimeMessageReceived(this.zzapH);
        }

        public void zzmw() {
        }

        public /* synthetic */ void zzn(Object obj) {
            zza((RealTimeMessageReceivedListener) obj);
        }
    }

    private static final class NearbyPlayerDetectedNotifier implements com.google.android.gms.common.api.zzi.zzb<OnNearbyPlayerDetectedListener> {
        private final Player zzapI;

        public void zza(OnNearbyPlayerDetectedListener onNearbyPlayerDetectedListener) {
            onNearbyPlayerDetectedListener.zza(this.zzapI);
        }

        public void zzmw() {
        }

        public /* synthetic */ void zzn(Object obj) {
            zza((OnNearbyPlayerDetectedListener) obj);
        }
    }

    private static final class NotifyAclLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<LoadAclResult> zzOs;

        NotifyAclLoadedBinderCallback(zza.zzb<LoadAclResult> resultHolder) {
            this.zzOs = (zza.zzb) zzu.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzF(DataHolder dataHolder) {
            this.zzOs.zzm(new LoadAclResultImpl(dataHolder));
        }
    }

    private static final class NotifyAclUpdatedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<Status> zzOs;

        NotifyAclUpdatedBinderCallback(zza.zzb<Status> resultHolder) {
            this.zzOs = (zza.zzb) zzu.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzfy(int i) {
            this.zzOs.zzm(GamesStatusCodes.zzfn(i));
        }
    }

    private static final class OpenSnapshotResultImpl extends GamesDataHolderResult implements OpenSnapshotResult {
        private final Snapshot zzapJ;
        private final String zzapK;
        private final Snapshot zzapL;
        private final Contents zzapM;
        private final SnapshotContents zzapN;

        OpenSnapshotResultImpl(DataHolder dataHolder, Contents currentContents) {
            this(dataHolder, null, currentContents, null, null);
        }

        OpenSnapshotResultImpl(DataHolder metadataHolder, String conflictId, Contents currentContents, Contents conflictContents, Contents resolutionContents) {
            boolean z = true;
            super(metadataHolder);
            SnapshotMetadataBuffer snapshotMetadataBuffer = new SnapshotMetadataBuffer(metadataHolder);
            try {
                if (snapshotMetadataBuffer.getCount() == 0) {
                    this.zzapJ = null;
                    this.zzapL = null;
                } else if (snapshotMetadataBuffer.getCount() == 1) {
                    if (metadataHolder.getStatusCode() == 4004) {
                        z = false;
                    }
                    com.google.android.gms.common.internal.zzb.zzU(z);
                    this.zzapJ = new SnapshotEntity(new SnapshotMetadataEntity(snapshotMetadataBuffer.get(0)), new SnapshotContentsEntity(currentContents));
                    this.zzapL = null;
                } else {
                    this.zzapJ = new SnapshotEntity(new SnapshotMetadataEntity(snapshotMetadataBuffer.get(0)), new SnapshotContentsEntity(currentContents));
                    this.zzapL = new SnapshotEntity(new SnapshotMetadataEntity(snapshotMetadataBuffer.get(1)), new SnapshotContentsEntity(conflictContents));
                }
                snapshotMetadataBuffer.release();
                this.zzapK = conflictId;
                this.zzapM = resolutionContents;
                this.zzapN = new SnapshotContentsEntity(resolutionContents);
            } catch (Throwable th) {
                snapshotMetadataBuffer.release();
            }
        }

        public String getConflictId() {
            return this.zzapK;
        }

        public Snapshot getConflictingSnapshot() {
            return this.zzapL;
        }

        public SnapshotContents getResolutionSnapshotContents() {
            return this.zzapN;
        }

        public Snapshot getSnapshot() {
            return this.zzapJ;
        }
    }

    private static final class P2PConnectedNotifier implements com.google.android.gms.common.api.zzi.zzb<RoomStatusUpdateListener> {
        private final String zzapO;

        P2PConnectedNotifier(String participantId) {
            this.zzapO = participantId;
        }

        public void zza(RoomStatusUpdateListener roomStatusUpdateListener) {
            roomStatusUpdateListener.onP2PConnected(this.zzapO);
        }

        public void zzmw() {
        }

        public /* synthetic */ void zzn(Object obj) {
            zza((RoomStatusUpdateListener) obj);
        }
    }

    private static final class P2PDisconnectedNotifier implements com.google.android.gms.common.api.zzi.zzb<RoomStatusUpdateListener> {
        private final String zzapO;

        P2PDisconnectedNotifier(String participantId) {
            this.zzapO = participantId;
        }

        public void zza(RoomStatusUpdateListener roomStatusUpdateListener) {
            roomStatusUpdateListener.onP2PDisconnected(this.zzapO);
        }

        public void zzmw() {
        }

        public /* synthetic */ void zzn(Object obj) {
            zza((RoomStatusUpdateListener) obj);
        }
    }

    private static final class PeerConnectedNotifier extends AbstractPeerStatusNotifier {
        PeerConnectedNotifier(DataHolder dataHolder, String[] participantIds) {
            super(dataHolder, participantIds);
        }

        protected void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeersConnected(room, arrayList);
        }
    }

    private static final class PeerDeclinedNotifier extends AbstractPeerStatusNotifier {
        PeerDeclinedNotifier(DataHolder dataHolder, String[] participantIds) {
            super(dataHolder, participantIds);
        }

        protected void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerDeclined(room, arrayList);
        }
    }

    private static final class PeerDisconnectedNotifier extends AbstractPeerStatusNotifier {
        PeerDisconnectedNotifier(DataHolder dataHolder, String[] participantIds) {
            super(dataHolder, participantIds);
        }

        protected void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeersDisconnected(room, arrayList);
        }
    }

    private static final class PeerInvitedToRoomNotifier extends AbstractPeerStatusNotifier {
        PeerInvitedToRoomNotifier(DataHolder dataHolder, String[] participantIds) {
            super(dataHolder, participantIds);
        }

        protected void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerInvitedToRoom(room, arrayList);
        }
    }

    private static final class PeerJoinedRoomNotifier extends AbstractPeerStatusNotifier {
        PeerJoinedRoomNotifier(DataHolder dataHolder, String[] participantIds) {
            super(dataHolder, participantIds);
        }

        protected void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerJoined(room, arrayList);
        }
    }

    private static final class PeerLeftRoomNotifier extends AbstractPeerStatusNotifier {
        PeerLeftRoomNotifier(DataHolder dataHolder, String[] participantIds) {
            super(dataHolder, participantIds);
        }

        protected void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerLeft(room, arrayList);
        }
    }

    private static final class PlayerLeaderboardScoreLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<LoadPlayerScoreResult> zzOs;

        PlayerLeaderboardScoreLoadedBinderCallback(zza.zzb<LoadPlayerScoreResult> resultHolder) {
            this.zzOs = (zza.zzb) zzu.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzH(DataHolder dataHolder) {
            this.zzOs.zzm(new LoadPlayerScoreResultImpl(dataHolder));
        }
    }

    private static final class PlayerXpForGameCategoriesLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<LoadXpForGameCategoriesResult> zzOs;

        PlayerXpForGameCategoriesLoadedBinderCallback(zza.zzb<LoadXpForGameCategoriesResult> holder) {
            this.zzOs = (zza.zzb) zzu.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zzf(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.zzOs.zzm(new LoadXpForGameCategoriesResultImpl(GamesStatusCodes.zzfn(i), bundle));
        }
    }

    static final class PlayerXpStreamLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<LoadXpStreamResult> zzOs;

        PlayerXpStreamLoadedBinderCallback(zza.zzb<LoadXpStreamResult> holder) {
            this.zzOs = (zza.zzb) zzu.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zzS(DataHolder dataHolder) {
            this.zzOs.zzm(new LoadXpStreamResultImpl(dataHolder));
        }
    }

    private static final class PlayersLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<LoadPlayersResult> zzOs;

        PlayersLoadedBinderCallback(zza.zzb<LoadPlayersResult> holder) {
            this.zzOs = (zza.zzb) zzu.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zzj(DataHolder dataHolder) {
            this.zzOs.zzm(new LoadPlayersResultImpl(dataHolder));
        }

        public void zzk(DataHolder dataHolder) {
            this.zzOs.zzm(new LoadPlayersResultImpl(dataHolder));
        }
    }

    private static final class PopupLocationInfoBinderCallbacks extends AbstractGamesClient {
        private final PopupManager zzaoU;

        public PopupLocationInfoBinderCallbacks(PopupManager popupManager) {
            this.zzaoU = popupManager;
        }

        public PopupLocationInfoParcelable zzsq() {
            return new PopupLocationInfoParcelable(this.zzaoU.zztg());
        }
    }

    static final class ProfileSettingsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<LoadProfileSettingsResult> zzOs;

        ProfileSettingsLoadedBinderCallback(zza.zzb<LoadProfileSettingsResult> holder) {
            this.zzOs = (zza.zzb) zzu.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zzT(DataHolder dataHolder) {
            this.zzOs.zzm(new LoadProfileSettingsResultImpl(dataHolder));
        }
    }

    private static final class ProfileSettingsUpdatedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<Status> zzOs;

        ProfileSettingsUpdatedBinderCallback(zza.zzb<Status> holder) {
            this.zzOs = (zza.zzb) zzu.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zzfA(int i) {
            this.zzOs.zzm(GamesStatusCodes.zzfn(i));
        }
    }

    private static final class QuestAcceptedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<AcceptQuestResult> zzapP;

        public QuestAcceptedBinderCallbacks(zza.zzb<AcceptQuestResult> resultHolder) {
            this.zzapP = (zza.zzb) zzu.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzO(DataHolder dataHolder) {
            this.zzapP.zzm(new AcceptQuestResultImpl(dataHolder));
        }
    }

    private static final class QuestCompletedNotifier implements com.google.android.gms.common.api.zzi.zzb<QuestUpdateListener> {
        private final Quest zzapb;

        QuestCompletedNotifier(Quest quest) {
            this.zzapb = quest;
        }

        public void zza(QuestUpdateListener questUpdateListener) {
            questUpdateListener.onQuestCompleted(this.zzapb);
        }

        public void zzmw() {
        }

        public /* synthetic */ void zzn(Object obj) {
            zza((QuestUpdateListener) obj);
        }
    }

    private static final class QuestMilestoneClaimBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<ClaimMilestoneResult> zzapQ;
        private final String zzapR;

        public QuestMilestoneClaimBinderCallbacks(zza.zzb<ClaimMilestoneResult> resultHolder, String milestoneId) {
            this.zzapQ = (zza.zzb) zzu.zzb((Object) resultHolder, (Object) "Holder must not be null");
            this.zzapR = (String) zzu.zzb((Object) milestoneId, (Object) "MilestoneId must not be null");
        }

        public void zzN(DataHolder dataHolder) {
            this.zzapQ.zzm(new ClaimMilestoneResultImpl(dataHolder, this.zzapR));
        }
    }

    private static final class QuestUpdateBinderCallback extends AbstractGamesCallbacks {
        private final com.google.android.gms.common.api.zzi<QuestUpdateListener> zzafi;

        QuestUpdateBinderCallback(com.google.android.gms.common.api.zzi<QuestUpdateListener> listener) {
            this.zzafi = listener;
        }

        private Quest zzW(DataHolder dataHolder) {
            QuestBuffer questBuffer = new QuestBuffer(dataHolder);
            Quest quest = null;
            try {
                if (questBuffer.getCount() > 0) {
                    quest = (Quest) ((Quest) questBuffer.get(0)).freeze();
                }
                questBuffer.release();
                return quest;
            } catch (Throwable th) {
                questBuffer.release();
            }
        }

        public void zzP(DataHolder dataHolder) {
            Quest zzW = zzW(dataHolder);
            if (zzW != null) {
                this.zzafi.zza(new QuestCompletedNotifier(zzW));
            }
        }
    }

    private static final class QuestsLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<LoadQuestsResult> zzapS;

        public QuestsLoadedBinderCallbacks(zza.zzb<LoadQuestsResult> resultHolder) {
            this.zzapS = (zza.zzb) zzu.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzR(DataHolder dataHolder) {
            this.zzapS.zzm(new LoadQuestsResultImpl(dataHolder));
        }
    }

    private static final class RealTimeMessageSentNotifier implements com.google.android.gms.common.api.zzi.zzb<ReliableMessageSentCallback> {
        private final int zzTS;
        private final String zzapT;
        private final int zzapU;

        RealTimeMessageSentNotifier(int statusCode, int token, String recipientParticipantId) {
            this.zzTS = statusCode;
            this.zzapU = token;
            this.zzapT = recipientParticipantId;
        }

        public void zza(ReliableMessageSentCallback reliableMessageSentCallback) {
            if (reliableMessageSentCallback != null) {
                reliableMessageSentCallback.onRealTimeMessageSent(this.zzTS, this.zzapU, this.zzapT);
            }
        }

        public void zzmw() {
        }

        public /* synthetic */ void zzn(Object obj) {
            zza((ReliableMessageSentCallback) obj);
        }
    }

    private static final class RealTimeReliableMessageBinderCallbacks extends AbstractGamesCallbacks {
        final com.google.android.gms.common.api.zzi<ReliableMessageSentCallback> zzapV;

        public RealTimeReliableMessageBinderCallbacks(com.google.android.gms.common.api.zzi<ReliableMessageSentCallback> messageSentCallbacks) {
            this.zzapV = messageSentCallbacks;
        }

        public void zzb(int i, int i2, String str) {
            if (this.zzapV != null) {
                this.zzapV.zza(new RealTimeMessageSentNotifier(i, i2, str));
            }
        }
    }

    private static final class RequestReceivedBinderCallback extends AbstractGamesCallbacks {
        private final com.google.android.gms.common.api.zzi<OnRequestReceivedListener> zzafi;

        RequestReceivedBinderCallback(com.google.android.gms.common.api.zzi<OnRequestReceivedListener> listener) {
            this.zzafi = listener;
        }

        public void onRequestRemoved(String requestId) {
            this.zzafi.zza(new RequestRemovedNotifier(requestId));
        }

        public void zzr(DataHolder dataHolder) {
            GameRequestBuffer gameRequestBuffer = new GameRequestBuffer(dataHolder);
            GameRequest gameRequest = null;
            try {
                if (gameRequestBuffer.getCount() > 0) {
                    gameRequest = (GameRequest) ((GameRequest) gameRequestBuffer.get(0)).freeze();
                }
                gameRequestBuffer.release();
                if (gameRequest != null) {
                    this.zzafi.zza(new RequestReceivedNotifier(gameRequest));
                }
            } catch (Throwable th) {
                gameRequestBuffer.release();
            }
        }
    }

    private static final class RequestReceivedNotifier implements com.google.android.gms.common.api.zzi.zzb<OnRequestReceivedListener> {
        private final GameRequest zzapW;

        RequestReceivedNotifier(GameRequest request) {
            this.zzapW = request;
        }

        public void zza(OnRequestReceivedListener onRequestReceivedListener) {
            onRequestReceivedListener.onRequestReceived(this.zzapW);
        }

        public void zzmw() {
        }

        public /* synthetic */ void zzn(Object obj) {
            zza((OnRequestReceivedListener) obj);
        }
    }

    private static final class RequestRemovedNotifier implements com.google.android.gms.common.api.zzi.zzb<OnRequestReceivedListener> {
        private final String zzDK;

        RequestRemovedNotifier(String requestId) {
            this.zzDK = requestId;
        }

        public void zza(OnRequestReceivedListener onRequestReceivedListener) {
            onRequestReceivedListener.onRequestRemoved(this.zzDK);
        }

        public void zzmw() {
        }

        public /* synthetic */ void zzn(Object obj) {
            zza((OnRequestReceivedListener) obj);
        }
    }

    private static final class RequestSentBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<SendRequestResult> zzapX;

        public RequestSentBinderCallbacks(zza.zzb<SendRequestResult> resultHolder) {
            this.zzapX = (zza.zzb) zzu.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzJ(DataHolder dataHolder) {
            this.zzapX.zzm(new SendRequestResultImpl(dataHolder));
        }
    }

    private static final class RequestSummariesLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<LoadRequestSummariesResult> zzapY;

        public RequestSummariesLoadedBinderCallbacks(zza.zzb<LoadRequestSummariesResult> resultHolder) {
            this.zzapY = (zza.zzb) zzu.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzK(DataHolder dataHolder) {
            this.zzapY.zzm(new LoadRequestSummariesResultImpl(dataHolder));
        }
    }

    private static final class RequestsLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<LoadRequestsResult> zzapZ;

        public RequestsLoadedBinderCallbacks(zza.zzb<LoadRequestsResult> resultHolder) {
            this.zzapZ = (zza.zzb) zzu.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzd(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.zzapZ.zzm(new LoadRequestsResultImpl(GamesStatusCodes.zzfn(i), bundle));
        }
    }

    private static final class RequestsUpdatedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<UpdateRequestsResult> zzaqa;

        public RequestsUpdatedBinderCallbacks(zza.zzb<UpdateRequestsResult> resultHolder) {
            this.zzaqa = (zza.zzb) zzu.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzI(DataHolder dataHolder) {
            this.zzaqa.zzm(new UpdateRequestsResultImpl(dataHolder));
        }
    }

    private static final class RoomAutoMatchingNotifier extends AbstractRoomStatusNotifier {
        RoomAutoMatchingNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        public void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onRoomAutoMatching(room);
        }
    }

    private static final class RoomBinderCallbacks extends AbstractGamesCallbacks {
        private final com.google.android.gms.common.api.zzi<? extends RoomUpdateListener> zzaqb;
        private final com.google.android.gms.common.api.zzi<? extends RoomStatusUpdateListener> zzaqc;
        private final com.google.android.gms.common.api.zzi<RealTimeMessageReceivedListener> zzaqd;

        public RoomBinderCallbacks(com.google.android.gms.common.api.zzi<RoomUpdateListener> roomCallbacks) {
            this.zzaqb = (com.google.android.gms.common.api.zzi) zzu.zzb((Object) roomCallbacks, (Object) "Callbacks must not be null");
            this.zzaqc = null;
            this.zzaqd = null;
        }

        public RoomBinderCallbacks(com.google.android.gms.common.api.zzi<? extends RoomUpdateListener> roomCallbacks, com.google.android.gms.common.api.zzi<? extends RoomStatusUpdateListener> roomStatusCallbacks, com.google.android.gms.common.api.zzi<RealTimeMessageReceivedListener> realTimeMessageReceivedCallbacks) {
            this.zzaqb = (com.google.android.gms.common.api.zzi) zzu.zzb((Object) roomCallbacks, (Object) "Callbacks must not be null");
            this.zzaqc = roomStatusCallbacks;
            this.zzaqd = realTimeMessageReceivedCallbacks;
        }

        public void onLeftRoom(int statusCode, String externalRoomId) {
            this.zzaqb.zza(new LeftRoomNotifier(statusCode, externalRoomId));
        }

        public void onP2PConnected(String participantId) {
            if (this.zzaqc != null) {
                this.zzaqc.zza(new P2PConnectedNotifier(participantId));
            }
        }

        public void onP2PDisconnected(String participantId) {
            if (this.zzaqc != null) {
                this.zzaqc.zza(new P2PDisconnectedNotifier(participantId));
            }
        }

        public void onRealTimeMessageReceived(RealTimeMessage message) {
            if (this.zzaqd != null) {
                this.zzaqd.zza(new MessageReceivedNotifier(message));
            }
        }

        public void zzA(DataHolder dataHolder) {
            if (this.zzaqc != null) {
                this.zzaqc.zza(new RoomAutoMatchingNotifier(dataHolder));
            }
        }

        public void zzB(DataHolder dataHolder) {
            this.zzaqb.zza(new RoomConnectedNotifier(dataHolder));
        }

        public void zzC(DataHolder dataHolder) {
            if (this.zzaqc != null) {
                this.zzaqc.zza(new ConnectedToRoomNotifier(dataHolder));
            }
        }

        public void zzD(DataHolder dataHolder) {
            if (this.zzaqc != null) {
                this.zzaqc.zza(new DisconnectedFromRoomNotifier(dataHolder));
            }
        }

        public void zza(DataHolder dataHolder, String[] strArr) {
            if (this.zzaqc != null) {
                this.zzaqc.zza(new PeerInvitedToRoomNotifier(dataHolder, strArr));
            }
        }

        public void zzb(DataHolder dataHolder, String[] strArr) {
            if (this.zzaqc != null) {
                this.zzaqc.zza(new PeerJoinedRoomNotifier(dataHolder, strArr));
            }
        }

        public void zzc(DataHolder dataHolder, String[] strArr) {
            if (this.zzaqc != null) {
                this.zzaqc.zza(new PeerLeftRoomNotifier(dataHolder, strArr));
            }
        }

        public void zzd(DataHolder dataHolder, String[] strArr) {
            if (this.zzaqc != null) {
                this.zzaqc.zza(new PeerDeclinedNotifier(dataHolder, strArr));
            }
        }

        public void zze(DataHolder dataHolder, String[] strArr) {
            if (this.zzaqc != null) {
                this.zzaqc.zza(new PeerConnectedNotifier(dataHolder, strArr));
            }
        }

        public void zzf(DataHolder dataHolder, String[] strArr) {
            if (this.zzaqc != null) {
                this.zzaqc.zza(new PeerDisconnectedNotifier(dataHolder, strArr));
            }
        }

        public void zzx(DataHolder dataHolder) {
            this.zzaqb.zza(new RoomCreatedNotifier(dataHolder));
        }

        public void zzy(DataHolder dataHolder) {
            this.zzaqb.zza(new JoinedRoomNotifier(dataHolder));
        }

        public void zzz(DataHolder dataHolder) {
            if (this.zzaqc != null) {
                this.zzaqc.zza(new RoomConnectingNotifier(dataHolder));
            }
        }
    }

    private static final class RoomConnectedNotifier extends AbstractRoomNotifier {
        RoomConnectedNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        public void zza(RoomUpdateListener roomUpdateListener, Room room, int i) {
            roomUpdateListener.onRoomConnected(i, room);
        }
    }

    private static final class RoomConnectingNotifier extends AbstractRoomStatusNotifier {
        RoomConnectingNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        public void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onRoomConnecting(room);
        }
    }

    private static final class RoomCreatedNotifier extends AbstractRoomNotifier {
        public RoomCreatedNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        public void zza(RoomUpdateListener roomUpdateListener, Room room, int i) {
            roomUpdateListener.onRoomCreated(i, room);
        }
    }

    private static final class SendRequestResultImpl extends GamesDataHolderResult implements SendRequestResult {
        private final GameRequest zzapW;

        SendRequestResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            GameRequestBuffer gameRequestBuffer = new GameRequestBuffer(dataHolder);
            try {
                if (gameRequestBuffer.getCount() > 0) {
                    this.zzapW = (GameRequest) ((GameRequest) gameRequestBuffer.get(0)).freeze();
                } else {
                    this.zzapW = null;
                }
                gameRequestBuffer.release();
            } catch (Throwable th) {
                gameRequestBuffer.release();
            }
        }
    }

    private static final class SignOutCompleteBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<Status> zzOs;

        public SignOutCompleteBinderCallbacks(zza.zzb<Status> resultHolder) {
            this.zzOs = (zza.zzb) zzu.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzkU() {
            this.zzOs.zzm(GamesStatusCodes.zzfn(0));
        }
    }

    private static final class SnapshotCommittedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<CommitSnapshotResult> zzaqe;

        public SnapshotCommittedBinderCallbacks(zza.zzb<CommitSnapshotResult> resultHolder) {
            this.zzaqe = (zza.zzb) zzu.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzM(DataHolder dataHolder) {
            this.zzaqe.zzm(new CommitSnapshotResultImpl(dataHolder));
        }
    }

    static final class SnapshotDeletedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<DeleteSnapshotResult> zzOs;

        public SnapshotDeletedBinderCallbacks(zza.zzb<DeleteSnapshotResult> resultHolder) {
            this.zzOs = (zza.zzb) zzu.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzh(int i, String str) {
            this.zzOs.zzm(new DeleteSnapshotResultImpl(i, str));
        }
    }

    private static final class SnapshotOpenedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<OpenSnapshotResult> zzaqf;

        public SnapshotOpenedBinderCallbacks(zza.zzb<OpenSnapshotResult> resultHolder) {
            this.zzaqf = (zza.zzb) zzu.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zza(DataHolder dataHolder, Contents contents) {
            this.zzaqf.zzm(new OpenSnapshotResultImpl(dataHolder, contents));
        }

        public void zza(DataHolder dataHolder, String str, Contents contents, Contents contents2, Contents contents3) {
            this.zzaqf.zzm(new OpenSnapshotResultImpl(dataHolder, str, contents, contents2, contents3));
        }
    }

    private static final class SnapshotsLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<LoadSnapshotsResult> zzaqg;

        public SnapshotsLoadedBinderCallbacks(zza.zzb<LoadSnapshotsResult> resultHolder) {
            this.zzaqg = (zza.zzb) zzu.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzL(DataHolder dataHolder) {
            this.zzaqg.zzm(new LoadSnapshotsResultImpl(dataHolder));
        }
    }

    private static final class SubmitScoreBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<SubmitScoreResult> zzOs;

        public SubmitScoreBinderCallbacks(zza.zzb<SubmitScoreResult> resultHolder) {
            this.zzOs = (zza.zzb) zzu.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzi(DataHolder dataHolder) {
            this.zzOs.zzm(new SubmitScoreResultImpl(dataHolder));
        }
    }

    private static final class SubmitScoreResultImpl extends GamesDataHolderResult implements SubmitScoreResult {
        private final ScoreSubmissionData zzaqh;

        public SubmitScoreResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            try {
                this.zzaqh = new ScoreSubmissionData(dataHolder);
            } finally {
                dataHolder.close();
            }
        }

        public ScoreSubmissionData getScoreData() {
            return this.zzaqh;
        }
    }

    private static final class TurnBasedMatchCanceledBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<CancelMatchResult> zzaqi;

        public TurnBasedMatchCanceledBinderCallbacks(zza.zzb<CancelMatchResult> resultHolder) {
            this.zzaqi = (zza.zzb) zzu.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzg(int i, String str) {
            this.zzaqi.zzm(new CancelMatchResultImpl(GamesStatusCodes.zzfn(i), str));
        }
    }

    private static final class TurnBasedMatchInitiatedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<InitiateMatchResult> zzaqj;

        public TurnBasedMatchInitiatedBinderCallbacks(zza.zzb<InitiateMatchResult> resultHolder) {
            this.zzaqj = (zza.zzb) zzu.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzt(DataHolder dataHolder) {
            this.zzaqj.zzm(new InitiateMatchResultImpl(dataHolder));
        }
    }

    private static final class TurnBasedMatchLeftBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<LeaveMatchResult> zzaqk;

        public TurnBasedMatchLeftBinderCallbacks(zza.zzb<LeaveMatchResult> resultHolder) {
            this.zzaqk = (zza.zzb) zzu.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzv(DataHolder dataHolder) {
            this.zzaqk.zzm(new LeaveMatchResultImpl(dataHolder));
        }
    }

    private static final class TurnBasedMatchLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<LoadMatchResult> zzaql;

        public TurnBasedMatchLoadedBinderCallbacks(zza.zzb<LoadMatchResult> resultHolder) {
            this.zzaql = (zza.zzb) zzu.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzs(DataHolder dataHolder) {
            this.zzaql.zzm(new LoadMatchResultImpl(dataHolder));
        }
    }

    private static final class TurnBasedMatchUpdatedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<UpdateMatchResult> zzaqm;

        public TurnBasedMatchUpdatedBinderCallbacks(zza.zzb<UpdateMatchResult> resultHolder) {
            this.zzaqm = (zza.zzb) zzu.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzu(DataHolder dataHolder) {
            this.zzaqm.zzm(new UpdateMatchResultImpl(dataHolder));
        }
    }

    private static final class TurnBasedMatchesLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<LoadMatchesResult> zzaqn;

        public TurnBasedMatchesLoadedBinderCallbacks(zza.zzb<LoadMatchesResult> resultHolder) {
            this.zzaqn = (zza.zzb) zzu.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzc(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.zzaqn.zzm(new LoadMatchesResultImpl(GamesStatusCodes.zzfn(i), bundle));
        }
    }

    private static final class UpdateAchievementResultImpl implements UpdateAchievementResult {
        private final Status zzOt;
        private final String zzanZ;

        UpdateAchievementResultImpl(int statusCode, String achievementId) {
            this.zzOt = GamesStatusCodes.zzfn(statusCode);
            this.zzanZ = achievementId;
        }

        public String getAchievementId() {
            return this.zzanZ;
        }

        public Status getStatus() {
            return this.zzOt;
        }
    }

    private static final class UpdateMatchResultImpl extends TurnBasedMatchResult implements UpdateMatchResult {
        UpdateMatchResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class UpdateRequestsResultImpl extends GamesDataHolderResult implements UpdateRequestsResult {
        private final RequestUpdateOutcomes zzaqo;

        UpdateRequestsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaqo = RequestUpdateOutcomes.zzX(dataHolder);
        }

        public Set<String> getRequestIds() {
            return this.zzaqo.getRequestIds();
        }

        public int getRequestOutcome(String requestId) {
            return this.zzaqo.getRequestOutcome(requestId);
        }
    }

    public GamesClientImpl(Context context, Looper looper, zze clientSettings, GamesOptions options, ConnectionCallbacks connectedListener, OnConnectionFailedListener connectionFailedListener) {
        super(context, looper, 1, connectedListener, connectionFailedListener, clientSettings);
        this.zzaoR = clientSettings.zzny();
        this.zzaoW = new Binder();
        this.zzaoU = PopupManager.zza(this, clientSettings.zznu());
        zzn(clientSettings.zznA());
        this.zzaoX = (long) hashCode();
        this.zzaoY = options;
    }

    private static Room zzU(DataHolder dataHolder) {
        RoomBuffer roomBuffer = new RoomBuffer(dataHolder);
        Room room = null;
        try {
            if (roomBuffer.getCount() > 0) {
                room = (Room) ((Room) roomBuffer.get(0)).freeze();
            }
            roomBuffer.release();
            return room;
        } catch (Throwable th) {
            roomBuffer.release();
        }
    }

    private void zzb(RemoteException remoteException) {
        GamesLog.zzb("GamesClientImpl", "service died", remoteException);
    }

    private void zzst() {
        this.zzaoS = null;
        this.zzaoT = null;
    }

    public void connect(ConnectionProgressReportCallbacks callbacks) {
        zzst();
        super.connect(callbacks);
    }

    public void disconnect() {
        this.zzaoV = false;
        if (isConnected()) {
            try {
                IGamesService iGamesService = (IGamesService) zznM();
                iGamesService.zzsR();
                this.zzaoQ.flush();
                iGamesService.zzE(this.zzaoX);
            } catch (RemoteException e) {
                GamesLog.zzu("GamesClientImpl", "Failed to notify client disconnect.");
            }
        }
        super.disconnect();
    }

    protected String getServiceDescriptor() {
        return "com.google.android.gms.games.internal.IGamesService";
    }

    protected String getStartServiceAction() {
        return "com.google.android.gms.games.service.START";
    }

    public void onConnectionFailed(ConnectionResult result) {
        super.onConnectionFailed(result);
        this.zzaoV = false;
    }

    public boolean requiresSignIn() {
        return true;
    }

    protected /* synthetic */ IInterface zzT(IBinder iBinder) {
        return zzbJ(iBinder);
    }

    public int zza(com.google.android.gms.common.api.zzi<ReliableMessageSentCallback> com_google_android_gms_common_api_zzi_com_google_android_gms_games_multiplayer_realtime_RealTimeMultiplayer_ReliableMessageSentCallback, byte[] bArr, String str, String str2) {
        try {
            return ((IGamesService) zznM()).zza(new RealTimeReliableMessageBinderCallbacks(com_google_android_gms_common_api_zzi_com_google_android_gms_games_multiplayer_realtime_RealTimeMultiplayer_ReliableMessageSentCallback), bArr, str, str2);
        } catch (RemoteException e) {
            zzb(e);
            return -1;
        }
    }

    public int zza(byte[] bArr, String str, String[] strArr) {
        zzu.zzb((Object) strArr, (Object) "Participant IDs must not be null");
        try {
            return ((IGamesService) zznM()).zzb(bArr, str, strArr);
        } catch (RemoteException e) {
            zzb(e);
            return -1;
        }
    }

    public Intent zza(int i, byte[] bArr, int i2, Bitmap bitmap, String str) {
        try {
            Intent zza = ((IGamesService) zznM()).zza(i, bArr, i2, str);
            zzu.zzb((Object) bitmap, (Object) "Must provide a non null icon");
            zza.putExtra("com.google.android.gms.games.REQUEST_ITEM_ICON", bitmap);
            return zza;
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public Intent zza(PlayerEntity playerEntity) {
        try {
            return ((IGamesService) zznM()).zza(playerEntity);
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public Intent zza(Room room, int i) {
        try {
            return ((IGamesService) zznM()).zza((RoomEntity) room.freeze(), i);
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public Intent zza(String str, boolean z, boolean z2, int i) {
        try {
            return ((IGamesService) zznM()).zza(str, z, z2, i);
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    protected Set<Scope> zza(Set<Scope> set) {
        Scope scope = new Scope(Scopes.GAMES);
        Scope scope2 = new Scope("https://www.googleapis.com/auth/games.firstparty");
        int i = 0;
        boolean z = false;
        for (Scope scope3 : set) {
            int i2;
            boolean z2;
            if (scope3.equals(scope)) {
                i2 = i;
                z2 = true;
            } else if (scope3.equals(scope2)) {
                i2 = 1;
                z2 = z;
            } else {
                i2 = i;
                z2 = z;
            }
            z = z2;
            i = i2;
        }
        if (i != 0) {
            zzu.zza(!z, "Cannot have both %s and %s!", Scopes.GAMES, "https://www.googleapis.com/auth/games.firstparty");
        } else {
            zzu.zza(z, "Games APIs requires %s to function.", Scopes.GAMES);
        }
        return set;
    }

    protected void zza(int i, IBinder iBinder, Bundle bundle, int i2) {
        if (i == 0 && bundle != null) {
            bundle.setClassLoader(GamesClientImpl.class.getClassLoader());
            this.zzaoV = bundle.getBoolean("show_welcome_popup");
            this.zzaoS = (PlayerEntity) bundle.getParcelable("com.google.android.gms.games.current_player");
            this.zzaoT = (GameEntity) bundle.getParcelable("com.google.android.gms.games.current_game");
        }
        super.zza(i, iBinder, bundle, i2);
    }

    public void zza(IBinder iBinder, Bundle bundle) {
        if (isConnected()) {
            try {
                ((IGamesService) zznM()).zza(iBinder, bundle);
            } catch (RemoteException e) {
                zzb(e);
            }
        }
    }

    public void zza(zza.zzb<LoadRequestsResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_request_Requests_LoadRequestsResult, int i, int i2, int i3) throws RemoteException {
        ((IGamesService) zznM()).zza(new RequestsLoadedBinderCallbacks(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_request_Requests_LoadRequestsResult), i, i2, i3);
    }

    public void zza(zza.zzb<LoadAppContentResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_appcontent_AppContents_LoadAppContentResult, int i, String str, String[] strArr, boolean z) throws RemoteException {
        ((IGamesService) zznM()).zza(new AppContentLoadedBinderCallbacks(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_appcontent_AppContents_LoadAppContentResult), i, str, strArr, z);
    }

    public void zza(zza.zzb<LoadPlayersResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Players_LoadPlayersResult, int i, boolean z, boolean z2) throws RemoteException {
        ((IGamesService) zznM()).zza(new PlayersLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Players_LoadPlayersResult), i, z, z2);
    }

    public void zza(zza.zzb<LoadMatchesResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LoadMatchesResult, int i, int[] iArr) throws RemoteException {
        ((IGamesService) zznM()).zza(new TurnBasedMatchesLoadedBinderCallbacks(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LoadMatchesResult), i, iArr);
    }

    public void zza(zza.zzb<LoadScoresResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadScoresResult, LeaderboardScoreBuffer leaderboardScoreBuffer, int i, int i2) throws RemoteException {
        ((IGamesService) zznM()).zza(new LeaderboardScoresLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadScoresResult), leaderboardScoreBuffer.zztF().asBundle(), i, i2);
    }

    public void zza(zza.zzb<InitiateMatchResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_InitiateMatchResult, TurnBasedMatchConfig turnBasedMatchConfig) throws RemoteException {
        ((IGamesService) zznM()).zza(new TurnBasedMatchInitiatedBinderCallbacks(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_InitiateMatchResult), turnBasedMatchConfig.getVariant(), turnBasedMatchConfig.zztL(), turnBasedMatchConfig.getInvitedPlayerIds(), turnBasedMatchConfig.getAutoMatchCriteria());
    }

    public void zza(zza.zzb<CommitSnapshotResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_snapshot_Snapshots_CommitSnapshotResult, Snapshot snapshot, SnapshotMetadataChange snapshotMetadataChange) throws RemoteException {
        SnapshotContents snapshotContents = snapshot.getSnapshotContents();
        zzu.zza(!snapshotContents.isClosed(), (Object) "Snapshot already closed");
        BitmapTeleporter zztQ = snapshotMetadataChange.zztQ();
        if (zztQ != null) {
            zztQ.zzc(getContext().getCacheDir());
        }
        Contents zzpe = snapshotContents.zzpe();
        snapshotContents.close();
        ((IGamesService) zznM()).zza(new SnapshotCommittedBinderCallbacks(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_snapshot_Snapshots_CommitSnapshotResult), snapshot.getMetadata().getSnapshotId(), (SnapshotMetadataChangeEntity) snapshotMetadataChange, zzpe);
    }

    public void zza(zza.zzb<UpdateAchievementResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult, String str) throws RemoteException {
        IGamesCallbacks iGamesCallbacks;
        if (com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult == null) {
            iGamesCallbacks = null;
        } else {
            Object achievementUpdatedBinderCallback = new AchievementUpdatedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult);
        }
        ((IGamesService) zznM()).zza(iGamesCallbacks, str, this.zzaoU.zztf(), this.zzaoU.zzte());
    }

    public void zza(zza.zzb<UpdateAchievementResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult, String str, int i) throws RemoteException {
        ((IGamesService) zznM()).zza(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult == null ? null : new AchievementUpdatedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult), str, i, this.zzaoU.zztf(), this.zzaoU.zzte());
    }

    public void zza(zza.zzb<LoadScoresResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadScoresResult, String str, int i, int i2, int i3, boolean z) throws RemoteException {
        ((IGamesService) zznM()).zza(new LeaderboardScoresLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadScoresResult), str, i, i2, i3, z);
    }

    public void zza(zza.zzb<LoadPlayersResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Players_LoadPlayersResult, String str, int i, boolean z, boolean z2) throws RemoteException {
        Object obj = -1;
        switch (str.hashCode()) {
            case 156408498:
                if (str.equals("played_with")) {
                    obj = null;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                ((IGamesService) zznM()).zzd(new PlayersLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Players_LoadPlayersResult), str, i, z, z2);
                return;
            default:
                throw new IllegalArgumentException("Invalid player collection: " + str);
        }
    }

    public void zza(zza.zzb<LoadMatchesResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LoadMatchesResult, String str, int i, int[] iArr) throws RemoteException {
        ((IGamesService) zznM()).zza(new TurnBasedMatchesLoadedBinderCallbacks(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LoadMatchesResult), str, i, iArr);
    }

    public void zza(zza.zzb<SubmitScoreResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_leaderboard_Leaderboards_SubmitScoreResult, String str, long j, String str2) throws RemoteException {
        ((IGamesService) zznM()).zza(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_leaderboard_Leaderboards_SubmitScoreResult == null ? null : new SubmitScoreBinderCallbacks(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_leaderboard_Leaderboards_SubmitScoreResult), str, j, str2);
    }

    public void zza(zza.zzb<LeaveMatchResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LeaveMatchResult, String str, String str2) throws RemoteException {
        ((IGamesService) zznM()).zzc(new TurnBasedMatchLeftBinderCallbacks(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LeaveMatchResult), str, str2);
    }

    public void zza(zza.zzb<LoadPlayerScoreResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadPlayerScoreResult, String str, String str2, int i, int i2) throws RemoteException {
        ((IGamesService) zznM()).zza(new PlayerLeaderboardScoreLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadPlayerScoreResult), str, str2, i, i2);
    }

    public void zza(zza.zzb<LoadRequestsResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_request_Requests_LoadRequestsResult, String str, String str2, int i, int i2, int i3) throws RemoteException {
        ((IGamesService) zznM()).zza(new RequestsLoadedBinderCallbacks(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_request_Requests_LoadRequestsResult), str, str2, i, i2, i3);
    }

    public void zza(zza.zzb<LoadScoresResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadScoresResult, String str, String str2, int i, int i2, int i3, boolean z) throws RemoteException {
        ((IGamesService) zznM()).zza(new LeaderboardScoresLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadScoresResult), str, str2, i, i2, i3, z);
    }

    public void zza(zza.zzb<LoadPlayersResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Players_LoadPlayersResult, String str, String str2, int i, boolean z, boolean z2) throws RemoteException {
        Object obj = -1;
        switch (str.hashCode()) {
            case -1049482625:
                if (str.equals("nearby")) {
                    obj = 2;
                    break;
                }
                break;
            case 156408498:
                if (str.equals("played_with")) {
                    obj = 1;
                    break;
                }
                break;
            case 782949780:
                if (str.equals("circled")) {
                    obj = null;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
            case 1:
            case 2:
                ((IGamesService) zznM()).zza(new PlayersLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Players_LoadPlayersResult), str, str2, i, z, z2);
                return;
            default:
                throw new IllegalArgumentException("Invalid player collection: " + str);
        }
    }

    public void zza(zza.zzb<OpenSnapshotResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_snapshot_Snapshots_OpenSnapshotResult, String str, String str2, SnapshotMetadataChange snapshotMetadataChange, SnapshotContents snapshotContents) throws RemoteException {
        zzu.zza(!snapshotContents.isClosed(), (Object) "SnapshotContents already closed");
        BitmapTeleporter zztQ = snapshotMetadataChange.zztQ();
        if (zztQ != null) {
            zztQ.zzc(getContext().getCacheDir());
        }
        Contents zzpe = snapshotContents.zzpe();
        snapshotContents.close();
        ((IGamesService) zznM()).zza(new SnapshotOpenedBinderCallbacks(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_snapshot_Snapshots_OpenSnapshotResult), str, str2, (SnapshotMetadataChangeEntity) snapshotMetadataChange, zzpe);
    }

    public void zza(zza.zzb<LeaderboardMetadataResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LeaderboardMetadataResult, String str, String str2, boolean z) throws RemoteException {
        ((IGamesService) zznM()).zzb(new LeaderboardsLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LeaderboardMetadataResult), str, str2, z);
    }

    public void zza(zza.zzb<LoadQuestsResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_quest_Quests_LoadQuestsResult, String str, String str2, boolean z, String[] strArr) throws RemoteException {
        this.zzaoQ.flush();
        ((IGamesService) zznM()).zza(new QuestsLoadedBinderCallbacks(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_quest_Quests_LoadQuestsResult), str, str2, strArr, z);
    }

    public void zza(zza.zzb<LoadQuestsResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_quest_Quests_LoadQuestsResult, String str, String str2, int[] iArr, int i, boolean z) throws RemoteException {
        this.zzaoQ.flush();
        ((IGamesService) zznM()).zza(new QuestsLoadedBinderCallbacks(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_quest_Quests_LoadQuestsResult), str, str2, iArr, i, z);
    }

    public void zza(zza.zzb<UpdateRequestsResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_request_Requests_UpdateRequestsResult, String str, String str2, String[] strArr) throws RemoteException {
        ((IGamesService) zznM()).zza(new RequestsUpdatedBinderCallbacks(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_request_Requests_UpdateRequestsResult), str, str2, strArr);
    }

    public void zza(zza.zzb<LoadPlayersResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Players_LoadPlayersResult, String str, boolean z) throws RemoteException {
        ((IGamesService) zznM()).zzf(new PlayersLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Players_LoadPlayersResult), str, z);
    }

    public void zza(zza.zzb<OpenSnapshotResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_snapshot_Snapshots_OpenSnapshotResult, String str, boolean z, int i) throws RemoteException {
        ((IGamesService) zznM()).zza(new SnapshotOpenedBinderCallbacks(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_snapshot_Snapshots_OpenSnapshotResult), str, z, i);
    }

    public void zza(zza.zzb<UpdateMatchResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_UpdateMatchResult, String str, byte[] bArr, String str2, ParticipantResult[] participantResultArr) throws RemoteException {
        ((IGamesService) zznM()).zza(new TurnBasedMatchUpdatedBinderCallbacks(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_UpdateMatchResult), str, bArr, str2, participantResultArr);
    }

    public void zza(zza.zzb<UpdateMatchResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_UpdateMatchResult, String str, byte[] bArr, ParticipantResult[] participantResultArr) throws RemoteException {
        ((IGamesService) zznM()).zza(new TurnBasedMatchUpdatedBinderCallbacks(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_UpdateMatchResult), str, bArr, participantResultArr);
    }

    public void zza(zza.zzb<SendRequestResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_request_Requests_SendRequestResult, String str, String[] strArr, int i, byte[] bArr, int i2) throws RemoteException {
        ((IGamesService) zznM()).zza(new RequestSentBinderCallbacks(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_request_Requests_SendRequestResult), str, strArr, i, bArr, i2);
    }

    public void zza(zza.zzb<LoadPlayersResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Players_LoadPlayersResult, boolean z) throws RemoteException {
        ((IGamesService) zznM()).zzc(new PlayersLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Players_LoadPlayersResult), z);
    }

    public void zza(zza.zzb<Status> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status, boolean z, Bundle bundle) throws RemoteException {
        ((IGamesService) zznM()).zza(new ContactSettingsUpdatedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status), z, bundle);
    }

    public void zza(zza.zzb<LoadEventsResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_event_Events_LoadEventsResult, boolean z, String... strArr) throws RemoteException {
        this.zzaoQ.flush();
        ((IGamesService) zznM()).zza(new EventsLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_event_Events_LoadEventsResult), z, strArr);
    }

    public void zza(zza.zzb<LoadQuestsResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_quest_Quests_LoadQuestsResult, int[] iArr, int i, boolean z) throws RemoteException {
        this.zzaoQ.flush();
        ((IGamesService) zznM()).zza(new QuestsLoadedBinderCallbacks(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_quest_Quests_LoadQuestsResult), iArr, i, z);
    }

    public void zza(zza.zzb<LoadPlayersResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Players_LoadPlayersResult, String[] strArr) throws RemoteException {
        ((IGamesService) zznM()).zzc(new PlayersLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Players_LoadPlayersResult), strArr);
    }

    public void zza(com.google.android.gms.common.api.zzi<OnInvitationReceivedListener> com_google_android_gms_common_api_zzi_com_google_android_gms_games_multiplayer_OnInvitationReceivedListener) {
        try {
            ((IGamesService) zznM()).zza(new InvitationReceivedBinderCallback(com_google_android_gms_common_api_zzi_com_google_android_gms_games_multiplayer_OnInvitationReceivedListener), this.zzaoX);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zza(com.google.android.gms.common.api.zzi<RoomUpdateListener> com_google_android_gms_common_api_zzi_com_google_android_gms_games_multiplayer_realtime_RoomUpdateListener, com.google.android.gms.common.api.zzi<RoomStatusUpdateListener> com_google_android_gms_common_api_zzi_com_google_android_gms_games_multiplayer_realtime_RoomStatusUpdateListener, com.google.android.gms.common.api.zzi<RealTimeMessageReceivedListener> com_google_android_gms_common_api_zzi_com_google_android_gms_games_multiplayer_realtime_RealTimeMessageReceivedListener, RoomConfig roomConfig) {
        try {
            ((IGamesService) zznM()).zza(new RoomBinderCallbacks(com_google_android_gms_common_api_zzi_com_google_android_gms_games_multiplayer_realtime_RoomUpdateListener, com_google_android_gms_common_api_zzi_com_google_android_gms_games_multiplayer_realtime_RoomStatusUpdateListener, com_google_android_gms_common_api_zzi_com_google_android_gms_games_multiplayer_realtime_RealTimeMessageReceivedListener), this.zzaoW, roomConfig.getVariant(), roomConfig.getInvitedPlayerIds(), roomConfig.getAutoMatchCriteria(), false, this.zzaoX);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zza(com.google.android.gms.common.api.zzi<RoomUpdateListener> com_google_android_gms_common_api_zzi_com_google_android_gms_games_multiplayer_realtime_RoomUpdateListener, String str) {
        try {
            ((IGamesService) zznM()).zzc(new RoomBinderCallbacks(com_google_android_gms_common_api_zzi_com_google_android_gms_games_multiplayer_realtime_RoomUpdateListener), str);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zza(Snapshot snapshot) {
        SnapshotContents snapshotContents = snapshot.getSnapshotContents();
        zzu.zza(!snapshotContents.isClosed(), (Object) "Snapshot already closed");
        Contents zzpe = snapshotContents.zzpe();
        snapshotContents.close();
        try {
            ((IGamesService) zznM()).zza(zzpe);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public Intent zzb(int i, int i2, boolean z) {
        try {
            return ((IGamesService) zznM()).zzb(i, i2, z);
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public Intent zzb(int[] iArr) {
        try {
            return ((IGamesService) zznM()).zzb(iArr);
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public void zzb(zza.zzb<Status> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status) throws RemoteException {
        this.zzaoQ.flush();
        ((IGamesService) zznM()).zza(new SignOutCompleteBinderCallbacks(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status));
    }

    public void zzb(zza.zzb<LoadPlayersResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Players_LoadPlayersResult, int i, boolean z, boolean z2) throws RemoteException {
        ((IGamesService) zznM()).zzb(new PlayersLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Players_LoadPlayersResult), i, z, z2);
    }

    public void zzb(zza.zzb<UpdateAchievementResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult, String str) throws RemoteException {
        IGamesCallbacks iGamesCallbacks;
        if (com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult == null) {
            iGamesCallbacks = null;
        } else {
            Object achievementUpdatedBinderCallback = new AchievementUpdatedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult);
        }
        ((IGamesService) zznM()).zzb(iGamesCallbacks, str, this.zzaoU.zztf(), this.zzaoU.zzte());
    }

    public void zzb(zza.zzb<UpdateAchievementResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult, String str, int i) throws RemoteException {
        ((IGamesService) zznM()).zzb(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult == null ? null : new AchievementUpdatedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult), str, i, this.zzaoU.zztf(), this.zzaoU.zzte());
    }

    public void zzb(zza.zzb<LoadScoresResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadScoresResult, String str, int i, int i2, int i3, boolean z) throws RemoteException {
        ((IGamesService) zznM()).zzb(new LeaderboardScoresLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadScoresResult), str, i, i2, i3, z);
    }

    public void zzb(zza.zzb<LoadPlayersResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Players_LoadPlayersResult, String str, int i, boolean z, boolean z2) throws RemoteException {
        ((IGamesService) zznM()).zzb(new PlayersLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Players_LoadPlayersResult), str, i, z, z2);
    }

    public void zzb(zza.zzb<ClaimMilestoneResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_quest_Quests_ClaimMilestoneResult, String str, String str2) throws RemoteException {
        this.zzaoQ.flush();
        ((IGamesService) zznM()).zzf(new QuestMilestoneClaimBinderCallbacks(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_quest_Quests_ClaimMilestoneResult, str2), str, str2);
    }

    public void zzb(zza.zzb<LoadScoresResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadScoresResult, String str, String str2, int i, int i2, int i3, boolean z) throws RemoteException {
        ((IGamesService) zznM()).zzb(new LeaderboardScoresLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadScoresResult), str, str2, i, i2, i3, z);
    }

    public void zzb(zza.zzb<LoadPlayersResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Players_LoadPlayersResult, String str, String str2, int i, boolean z, boolean z2) throws RemoteException {
        ((IGamesService) zznM()).zzb(new PlayersLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Players_LoadPlayersResult), str, str2, i, z, z2);
    }

    public void zzb(zza.zzb<LoadAchievementsResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_achievement_Achievements_LoadAchievementsResult, String str, String str2, boolean z) throws RemoteException {
        ((IGamesService) zznM()).zza(new AchievementsLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_achievement_Achievements_LoadAchievementsResult), str, str2, z);
    }

    public void zzb(zza.zzb<LeaderboardMetadataResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LeaderboardMetadataResult, String str, boolean z) throws RemoteException {
        ((IGamesService) zznM()).zzc(new LeaderboardsLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LeaderboardMetadataResult), str, z);
    }

    public void zzb(zza.zzb<LeaderboardMetadataResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LeaderboardMetadataResult, boolean z) throws RemoteException {
        ((IGamesService) zznM()).zzb(new LeaderboardsLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LeaderboardMetadataResult), z);
    }

    public void zzb(zza.zzb<LoadQuestsResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_quest_Quests_LoadQuestsResult, boolean z, String[] strArr) throws RemoteException {
        this.zzaoQ.flush();
        ((IGamesService) zznM()).zza(new QuestsLoadedBinderCallbacks(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_quest_Quests_LoadQuestsResult), strArr, z);
    }

    public void zzb(zza.zzb<UpdateRequestsResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_request_Requests_UpdateRequestsResult, String[] strArr) throws RemoteException {
        ((IGamesService) zznM()).zza(new RequestsUpdatedBinderCallbacks(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_request_Requests_UpdateRequestsResult), strArr);
    }

    public void zzb(com.google.android.gms.common.api.zzi<OnTurnBasedMatchUpdateReceivedListener> com_google_android_gms_common_api_zzi_com_google_android_gms_games_multiplayer_turnbased_OnTurnBasedMatchUpdateReceivedListener) {
        try {
            ((IGamesService) zznM()).zzb(new MatchUpdateReceivedBinderCallback(com_google_android_gms_common_api_zzi_com_google_android_gms_games_multiplayer_turnbased_OnTurnBasedMatchUpdateReceivedListener), this.zzaoX);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zzb(com.google.android.gms.common.api.zzi<RoomUpdateListener> com_google_android_gms_common_api_zzi_com_google_android_gms_games_multiplayer_realtime_RoomUpdateListener, com.google.android.gms.common.api.zzi<RoomStatusUpdateListener> com_google_android_gms_common_api_zzi_com_google_android_gms_games_multiplayer_realtime_RoomStatusUpdateListener, com.google.android.gms.common.api.zzi<RealTimeMessageReceivedListener> com_google_android_gms_common_api_zzi_com_google_android_gms_games_multiplayer_realtime_RealTimeMessageReceivedListener, RoomConfig roomConfig) {
        try {
            ((IGamesService) zznM()).zza(new RoomBinderCallbacks(com_google_android_gms_common_api_zzi_com_google_android_gms_games_multiplayer_realtime_RoomUpdateListener, com_google_android_gms_common_api_zzi_com_google_android_gms_games_multiplayer_realtime_RoomStatusUpdateListener, com_google_android_gms_common_api_zzi_com_google_android_gms_games_multiplayer_realtime_RealTimeMessageReceivedListener), this.zzaoW, roomConfig.getInvitationId(), false, this.zzaoX);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    protected IGamesService zzbJ(IBinder iBinder) {
        return Stub.zzbM(iBinder);
    }

    public Intent zzc(int i, int i2, boolean z) {
        try {
            return ((IGamesService) zznM()).zzc(i, i2, z);
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public void zzc(zza.zzb<LoadInvitationsResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_multiplayer_Invitations_LoadInvitationsResult, int i) throws RemoteException {
        ((IGamesService) zznM()).zza(new InvitationsLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_multiplayer_Invitations_LoadInvitationsResult), i);
    }

    public void zzc(zza.zzb<LoadPlayersResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Players_LoadPlayersResult, int i, boolean z, boolean z2) throws RemoteException {
        ((IGamesService) zznM()).zzc(new PlayersLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Players_LoadPlayersResult), i, z, z2);
    }

    public void zzc(zza.zzb<InitiateMatchResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_InitiateMatchResult, String str) throws RemoteException {
        ((IGamesService) zznM()).zzl(new TurnBasedMatchInitiatedBinderCallbacks(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_InitiateMatchResult), str);
    }

    public void zzc(zza.zzb<LoadXpStreamResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Players_LoadXpStreamResult, String str, int i) throws RemoteException {
        ((IGamesService) zznM()).zzb(new PlayerXpStreamLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Players_LoadXpStreamResult), str, i);
    }

    public void zzc(zza.zzb<InitiateMatchResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_InitiateMatchResult, String str, String str2) throws RemoteException {
        ((IGamesService) zznM()).zzd(new TurnBasedMatchInitiatedBinderCallbacks(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_InitiateMatchResult), str, str2);
    }

    public void zzc(zza.zzb<LoadSnapshotsResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_snapshot_Snapshots_LoadSnapshotsResult, String str, String str2, boolean z) throws RemoteException {
        ((IGamesService) zznM()).zzc(new SnapshotsLoadedBinderCallbacks(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_snapshot_Snapshots_LoadSnapshotsResult), str, str2, z);
    }

    public void zzc(zza.zzb<LeaderboardMetadataResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LeaderboardMetadataResult, String str, boolean z) throws RemoteException {
        ((IGamesService) zznM()).zzd(new LeaderboardsLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LeaderboardMetadataResult), str, z);
    }

    public void zzc(zza.zzb<LoadAchievementsResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_achievement_Achievements_LoadAchievementsResult, boolean z) throws RemoteException {
        ((IGamesService) zznM()).zza(new AchievementsLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_achievement_Achievements_LoadAchievementsResult), z);
    }

    public void zzc(zza.zzb<UpdateRequestsResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_request_Requests_UpdateRequestsResult, String[] strArr) throws RemoteException {
        ((IGamesService) zznM()).zzb(new RequestsUpdatedBinderCallbacks(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_request_Requests_UpdateRequestsResult), strArr);
    }

    public void zzc(com.google.android.gms.common.api.zzi<QuestUpdateListener> com_google_android_gms_common_api_zzi_com_google_android_gms_games_quest_QuestUpdateListener) {
        try {
            ((IGamesService) zznM()).zzd(new QuestUpdateBinderCallback(com_google_android_gms_common_api_zzi_com_google_android_gms_games_quest_QuestUpdateListener), this.zzaoX);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zzcN(String str) {
        try {
            ((IGamesService) zznM()).zzcV(str);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public Intent zzcO(String str) {
        try {
            return ((IGamesService) zznM()).zzcO(str);
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public void zzcP(String str) {
        try {
            ((IGamesService) zznM()).zza(str, this.zzaoU.zztf(), this.zzaoU.zzte());
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public int zzd(byte[] bArr, String str) {
        try {
            return ((IGamesService) zznM()).zzb(bArr, str, null);
        } catch (RemoteException e) {
            zzb(e);
            return -1;
        }
    }

    public void zzd(zza.zzb<LoadPlayersResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Players_LoadPlayersResult, int i, boolean z, boolean z2) throws RemoteException {
        ((IGamesService) zznM()).zze(new PlayersLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Players_LoadPlayersResult), i, z, z2);
    }

    public void zzd(zza.zzb<InitiateMatchResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_InitiateMatchResult, String str) throws RemoteException {
        ((IGamesService) zznM()).zzm(new TurnBasedMatchInitiatedBinderCallbacks(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_InitiateMatchResult), str);
    }

    public void zzd(zza.zzb<LoadXpStreamResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Players_LoadXpStreamResult, String str, int i) throws RemoteException {
        ((IGamesService) zznM()).zzc(new PlayerXpStreamLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Players_LoadXpStreamResult), str, i);
    }

    public void zzd(zza.zzb<InitiateMatchResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_InitiateMatchResult, String str, String str2) throws RemoteException {
        ((IGamesService) zznM()).zze(new TurnBasedMatchInitiatedBinderCallbacks(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_InitiateMatchResult), str, str2);
    }

    public void zzd(zza.zzb<GameMuteStatusChangeResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Notifications_GameMuteStatusChangeResult, String str, boolean z) throws RemoteException {
        ((IGamesService) zznM()).zza(new GameMuteStatusChangedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Notifications_GameMuteStatusChangeResult), str, z);
    }

    public void zzd(zza.zzb<LoadEventsResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_event_Events_LoadEventsResult, boolean z) throws RemoteException {
        this.zzaoQ.flush();
        ((IGamesService) zznM()).zzf(new EventsLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_event_Events_LoadEventsResult), z);
    }

    public void zzd(com.google.android.gms.common.api.zzi<OnRequestReceivedListener> com_google_android_gms_common_api_zzi_com_google_android_gms_games_request_OnRequestReceivedListener) {
        try {
            ((IGamesService) zznM()).zzc(new RequestReceivedBinderCallback(com_google_android_gms_common_api_zzi_com_google_android_gms_games_request_OnRequestReceivedListener), this.zzaoX);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zze(zza.zzb<LeaveMatchResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LeaveMatchResult, String str) throws RemoteException {
        ((IGamesService) zznM()).zzo(new TurnBasedMatchLeftBinderCallbacks(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LeaveMatchResult), str);
    }

    public void zze(zza.zzb<LoadInvitationsResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_multiplayer_Invitations_LoadInvitationsResult, String str, int i) throws RemoteException {
        ((IGamesService) zznM()).zzb(new InvitationsLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_multiplayer_Invitations_LoadInvitationsResult), str, i, false);
    }

    public void zze(zza.zzb<LoadSnapshotsResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_snapshot_Snapshots_LoadSnapshotsResult, boolean z) throws RemoteException {
        ((IGamesService) zznM()).zzd(new SnapshotsLoadedBinderCallbacks(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_snapshot_Snapshots_LoadSnapshotsResult), z);
    }

    public void zzf(zza.zzb<LoadGamesResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_GamesMetadata_LoadGamesResult) throws RemoteException {
        ((IGamesService) zznM()).zzd(new GamesLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_GamesMetadata_LoadGamesResult));
    }

    public void zzf(zza.zzb<CancelMatchResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_CancelMatchResult, String str) throws RemoteException {
        ((IGamesService) zznM()).zzn(new TurnBasedMatchCanceledBinderCallbacks(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_CancelMatchResult), str);
    }

    public void zzf(zza.zzb<LoadRequestSummariesResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_request_Requests_LoadRequestSummariesResult, String str, int i) throws RemoteException {
        ((IGamesService) zznM()).zza(new RequestSummariesLoadedBinderCallbacks(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_request_Requests_LoadRequestSummariesResult), str, i);
    }

    public void zzf(zza.zzb<LoadProfileSettingsResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Players_LoadProfileSettingsResult, boolean z) throws RemoteException {
        ((IGamesService) zznM()).zzg(new ProfileSettingsLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Players_LoadProfileSettingsResult), z);
    }

    public void zzfC(int i) {
        this.zzaoU.setGravity(i);
    }

    public void zzfD(int i) {
        try {
            ((IGamesService) zznM()).zzfD(i);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zzg(zza.zzb<LoadAclResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_internal_game_Acls_LoadAclResult) throws RemoteException {
        ((IGamesService) zznM()).zzh(new NotifyAclLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_internal_game_Acls_LoadAclResult));
    }

    public void zzg(zza.zzb<LoadMatchResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LoadMatchResult, String str) throws RemoteException {
        ((IGamesService) zznM()).zzp(new TurnBasedMatchLoadedBinderCallbacks(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LoadMatchResult), str);
    }

    public void zzg(zza.zzb<Status> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status, boolean z) throws RemoteException {
        ((IGamesService) zznM()).zzh(new ProfileSettingsUpdatedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status), z);
    }

    public void zzh(zza.zzb<InboxCountResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Notifications_InboxCountResult) throws RemoteException {
        ((IGamesService) zznM()).zzt(new InboxCountsLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Notifications_InboxCountResult), null);
    }

    public void zzh(zza.zzb<AcceptQuestResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_quest_Quests_AcceptQuestResult, String str) throws RemoteException {
        this.zzaoQ.flush();
        ((IGamesService) zznM()).zzu(new QuestAcceptedBinderCallbacks(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_quest_Quests_AcceptQuestResult), str);
    }

    public void zzh(zza.zzb<ContactSettingLoadResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Notifications_ContactSettingLoadResult, boolean z) throws RemoteException {
        ((IGamesService) zznM()).zze(new ContactSettingsLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Notifications_ContactSettingLoadResult), z);
    }

    public void zzi(zza.zzb<DeleteSnapshotResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_snapshot_Snapshots_DeleteSnapshotResult, String str) throws RemoteException {
        ((IGamesService) zznM()).zzr(new SnapshotDeletedBinderCallbacks(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_snapshot_Snapshots_DeleteSnapshotResult), str);
    }

    public void zzj(zza.zzb<LoadGameInstancesResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_GamesMetadata_LoadGameInstancesResult, String str) throws RemoteException {
        ((IGamesService) zznM()).zzf(new GameInstancesLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_GamesMetadata_LoadGameInstancesResult), str);
    }

    public void zzk(zza.zzb<LoadGameSearchSuggestionsResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_GamesMetadata_LoadGameSearchSuggestionsResult, String str) throws RemoteException {
        ((IGamesService) zznM()).zzq(new GameSearchSuggestionsLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_GamesMetadata_LoadGameSearchSuggestionsResult), str);
    }

    protected Bundle zzkR() {
        String locale = getContext().getResources().getConfiguration().locale.toString();
        Bundle zzrI = this.zzaoY.zzrI();
        zzrI.putString("com.google.android.gms.games.key.gamePackageName", this.zzaoR);
        zzrI.putString("com.google.android.gms.games.key.desiredLocale", locale);
        zzrI.putParcelable("com.google.android.gms.games.key.popupWindowToken", new BinderWrapper(this.zzaoU.zztf()));
        zzrI.putInt("com.google.android.gms.games.key.API_VERSION", 0);
        zze zznK = zznK();
        if (zznK.zznB() != null) {
            zzrI.putBundle("com.google.android.gms.games.key.signInOptions", zzh.zza(zznK.zznB(), zznK.zznC(), Executors.newSingleThreadExecutor()));
        }
        return zzrI;
    }

    public void zzl(zza.zzb<LoadXpForGameCategoriesResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Players_LoadXpForGameCategoriesResult, String str) throws RemoteException {
        ((IGamesService) zznM()).zzs(new PlayerXpForGameCategoriesLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Players_LoadXpForGameCategoriesResult), str);
    }

    public Bundle zzlM() {
        try {
            Bundle zzlM = ((IGamesService) zznM()).zzlM();
            if (zzlM == null) {
                return zzlM;
            }
            zzlM.setClassLoader(GamesClientImpl.class.getClassLoader());
            return zzlM;
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public void zzm(zza.zzb<LoadInvitationsResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_multiplayer_Invitations_LoadInvitationsResult, String str) throws RemoteException {
        ((IGamesService) zznM()).zzk(new InvitationsLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_multiplayer_Invitations_LoadInvitationsResult), str);
    }

    public void zzn(View view) {
        this.zzaoU.zzo(view);
    }

    public void zzn(zza.zzb<Status> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status, String str) throws RemoteException {
        ((IGamesService) zznM()).zzj(new NotifyAclUpdatedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status), str);
    }

    public void zznG() {
        super.zznG();
        if (this.zzaoV) {
            this.zzaoU.zztd();
            this.zzaoV = false;
        }
        if (!this.zzaoY.zzanC) {
            zzsu();
        }
    }

    public Intent zzo(String str, int i) {
        try {
            return ((IGamesService) zznM()).zzv(str, i);
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public void zzo(zza.zzb<GameMuteStatusLoadResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Notifications_GameMuteStatusLoadResult, String str) throws RemoteException {
        ((IGamesService) zznM()).zzi(new GameMuteStatusLoadedBinderCallback(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_games_Notifications_GameMuteStatusLoadResult), str);
    }

    public void zzp(String str, int i) {
        this.zzaoQ.zzp(str, i);
    }

    public void zzq(String str, int i) {
        try {
            ((IGamesService) zznM()).zzq(str, i);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zzr(String str, int i) {
        try {
            ((IGamesService) zznM()).zzr(str, i);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public Intent zzsA() {
        try {
            return ((IGamesService) zznM()).zzsA();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public Intent zzsB() {
        try {
            return ((IGamesService) zznM()).zzsB();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public Intent zzsC() {
        try {
            return ((IGamesService) zznM()).zzsC();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public void zzsD() {
        try {
            ((IGamesService) zznM()).zzF(this.zzaoX);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zzsE() {
        try {
            ((IGamesService) zznM()).zzG(this.zzaoX);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zzsF() {
        try {
            ((IGamesService) zznM()).zzI(this.zzaoX);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zzsG() {
        try {
            ((IGamesService) zznM()).zzH(this.zzaoX);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public Intent zzsH() {
        try {
            return ((IGamesService) zznM()).zzsH();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public Intent zzsI() {
        try {
            return ((IGamesService) zznM()).zzsI();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public int zzsJ() {
        try {
            return ((IGamesService) zznM()).zzsJ();
        } catch (RemoteException e) {
            zzb(e);
            return 4368;
        }
    }

    public String zzsK() {
        try {
            return ((IGamesService) zznM()).zzsK();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public int zzsL() {
        try {
            return ((IGamesService) zznM()).zzsL();
        } catch (RemoteException e) {
            zzb(e);
            return -1;
        }
    }

    public Intent zzsM() {
        try {
            return ((IGamesService) zznM()).zzsM();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public int zzsN() {
        try {
            return ((IGamesService) zznM()).zzsN();
        } catch (RemoteException e) {
            zzb(e);
            return -1;
        }
    }

    public int zzsO() {
        try {
            return ((IGamesService) zznM()).zzsO();
        } catch (RemoteException e) {
            zzb(e);
            return -1;
        }
    }

    public int zzsP() {
        try {
            return ((IGamesService) zznM()).zzsP();
        } catch (RemoteException e) {
            zzb(e);
            return -1;
        }
    }

    public int zzsQ() {
        try {
            return ((IGamesService) zznM()).zzsQ();
        } catch (RemoteException e) {
            zzb(e);
            return -1;
        }
    }

    public void zzsR() {
        if (isConnected()) {
            try {
                ((IGamesService) zznM()).zzsR();
            } catch (RemoteException e) {
                zzb(e);
            }
        }
    }

    public void zzsu() {
        try {
            ((IGamesService) zznM()).zza(new PopupLocationInfoBinderCallbacks(this.zzaoU), this.zzaoX);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public String zzsv() {
        try {
            return ((IGamesService) zznM()).zzsv();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public String zzsw() {
        if (this.zzaoS != null) {
            return this.zzaoS.getPlayerId();
        }
        try {
            return ((IGamesService) zznM()).zzsw();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public Player zzsx() {
        zznL();
        synchronized (this) {
            if (this.zzaoS == null) {
                PlayerBuffer playerBuffer;
                try {
                    playerBuffer = new PlayerBuffer(((IGamesService) zznM()).zzsT());
                    if (playerBuffer.getCount() > 0) {
                        this.zzaoS = (PlayerEntity) playerBuffer.get(0).freeze();
                    }
                    playerBuffer.release();
                } catch (RemoteException e) {
                    zzb(e);
                } catch (Throwable th) {
                    playerBuffer.release();
                }
            }
        }
        return this.zzaoS;
    }

    public Game zzsy() {
        zznL();
        synchronized (this) {
            if (this.zzaoT == null) {
                GameBuffer gameBuffer;
                try {
                    gameBuffer = new GameBuffer(((IGamesService) zznM()).zzsV());
                    if (gameBuffer.getCount() > 0) {
                        this.zzaoT = (GameEntity) gameBuffer.get(0).freeze();
                    }
                    gameBuffer.release();
                } catch (RemoteException e) {
                    zzb(e);
                } catch (Throwable th) {
                    gameBuffer.release();
                }
            }
        }
        return this.zzaoT;
    }

    public Intent zzsz() {
        try {
            return ((IGamesService) zznM()).zzsz();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }
}
