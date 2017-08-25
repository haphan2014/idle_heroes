package com.google.android.gms.games.quest;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;

public final class MilestoneEntity implements SafeParcelable, Milestone {
    public static final Creator<MilestoneEntity> CREATOR = new MilestoneEntityCreator();
    private final int mState;
    private final int zzCY;
    private final String zzaoK;
    private final String zzapR;
    private final long zzauS;
    private final long zzauT;
    private final byte[] zzauU;

    MilestoneEntity(int versionCode, String milestoneId, long currentProgress, long targetProgress, byte[] completionBlob, int state, String eventId) {
        this.zzCY = versionCode;
        this.zzapR = milestoneId;
        this.zzauS = currentProgress;
        this.zzauT = targetProgress;
        this.zzauU = completionBlob;
        this.mState = state;
        this.zzaoK = eventId;
    }

    public MilestoneEntity(Milestone milestone) {
        this.zzCY = 4;
        this.zzapR = milestone.getMilestoneId();
        this.zzauS = milestone.getCurrentProgress();
        this.zzauT = milestone.getTargetProgress();
        this.mState = milestone.getState();
        this.zzaoK = milestone.getEventId();
        Object completionRewardData = milestone.getCompletionRewardData();
        if (completionRewardData == null) {
            this.zzauU = null;
            return;
        }
        this.zzauU = new byte[completionRewardData.length];
        System.arraycopy(completionRewardData, 0, this.zzauU, 0, completionRewardData.length);
    }

    static int zza(Milestone milestone) {
        return zzt.hashCode(milestone.getMilestoneId(), Long.valueOf(milestone.getCurrentProgress()), Long.valueOf(milestone.getTargetProgress()), Integer.valueOf(milestone.getState()), milestone.getEventId());
    }

    static boolean zza(Milestone milestone, Object obj) {
        if (!(obj instanceof Milestone)) {
            return false;
        }
        if (milestone == obj) {
            return true;
        }
        Milestone milestone2 = (Milestone) obj;
        return zzt.equal(milestone2.getMilestoneId(), milestone.getMilestoneId()) && zzt.equal(Long.valueOf(milestone2.getCurrentProgress()), Long.valueOf(milestone.getCurrentProgress())) && zzt.equal(Long.valueOf(milestone2.getTargetProgress()), Long.valueOf(milestone.getTargetProgress())) && zzt.equal(Integer.valueOf(milestone2.getState()), Integer.valueOf(milestone.getState())) && zzt.equal(milestone2.getEventId(), milestone.getEventId());
    }

    static String zzb(Milestone milestone) {
        return zzt.zzt(milestone).zzg("MilestoneId", milestone.getMilestoneId()).zzg("CurrentProgress", Long.valueOf(milestone.getCurrentProgress())).zzg("TargetProgress", Long.valueOf(milestone.getTargetProgress())).zzg("State", Integer.valueOf(milestone.getState())).zzg("CompletionRewardData", milestone.getCompletionRewardData()).zzg("EventId", milestone.getEventId()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public Milestone freeze() {
        return this;
    }

    public byte[] getCompletionRewardData() {
        return this.zzauU;
    }

    public long getCurrentProgress() {
        return this.zzauS;
    }

    public String getEventId() {
        return this.zzaoK;
    }

    public String getMilestoneId() {
        return this.zzapR;
    }

    public int getState() {
        return this.mState;
    }

    public long getTargetProgress() {
        return this.zzauT;
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    public int hashCode() {
        return zza(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzb(this);
    }

    public void writeToParcel(Parcel out, int flags) {
        MilestoneEntityCreator.zza(this, out, flags);
    }
}
