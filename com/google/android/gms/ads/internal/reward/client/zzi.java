package com.google.android.gms.ads.internal.reward.client;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.internal.client.zzg;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

public class zzi implements RewardedVideoAd {
    private final Context mContext;
    private String zzEO;
    private RewardedVideoAdListener zzES;
    private final zzb zzET;
    private final Object zzqt = new Object();

    public zzi(Context context, zzb com_google_android_gms_ads_internal_reward_client_zzb) {
        this.zzET = com_google_android_gms_ads_internal_reward_client_zzb;
        this.mContext = context;
    }

    public void destroy() {
        synchronized (this.zzqt) {
            if (this.zzET == null) {
                return;
            }
            try {
                this.zzET.destroy();
            } catch (Throwable e) {
                zzb.zzd("Could not forward destroy to RewardedVideoAd", e);
            }
        }
    }

    public RewardedVideoAdListener getRewardedVideoAdListener() {
        RewardedVideoAdListener rewardedVideoAdListener;
        synchronized (this.zzqt) {
            rewardedVideoAdListener = this.zzES;
        }
        return rewardedVideoAdListener;
    }

    public String getUserId() {
        String str;
        synchronized (this.zzqt) {
            str = this.zzEO;
        }
        return str;
    }

    public boolean isLoaded() {
        boolean z = false;
        synchronized (this.zzqt) {
            if (this.zzET == null) {
            } else {
                try {
                    z = this.zzET.isLoaded();
                } catch (Throwable e) {
                    zzb.zzd("Could not forward isLoaded to RewardedVideoAd", e);
                }
            }
        }
        return z;
    }

    public void loadAd(String adUnitId, AdRequest adRequest) {
        synchronized (this.zzqt) {
            if (this.zzET == null) {
                return;
            }
            try {
                this.zzET.zza(zzg.zzcw().zza(this.mContext, adRequest.zzaF(), adUnitId));
            } catch (Throwable e) {
                zzb.zzd("Could not forward loadAd to RewardedVideoAd", e);
            }
        }
    }

    public void pause() {
        synchronized (this.zzqt) {
            if (this.zzET == null) {
                return;
            }
            try {
                this.zzET.pause();
            } catch (Throwable e) {
                zzb.zzd("Could not forward pause to RewardedVideoAd", e);
            }
        }
    }

    public void resume() {
        synchronized (this.zzqt) {
            if (this.zzET == null) {
                return;
            }
            try {
                this.zzET.resume();
            } catch (Throwable e) {
                zzb.zzd("Could not forward resume to RewardedVideoAd", e);
            }
        }
    }

    public void setRewardedVideoAdListener(RewardedVideoAdListener listener) {
        synchronized (this.zzqt) {
            if (this.zzES != null) {
                zzb.zzaC("A RewardedVideoAdListener has already been set, ignoring.");
                return;
            }
            this.zzES = listener;
            if (this.zzET != null) {
                try {
                    this.zzET.zza(new zzg(listener));
                } catch (Throwable e) {
                    zzb.zzd("Could not forward setRewardedVideoAdListener to RewardedVideoAd", e);
                }
            }
        }
    }

    public void setUserId(String userId) {
        synchronized (this.zzqt) {
            if (TextUtils.isEmpty(this.zzEO)) {
                this.zzEO = userId;
                if (this.zzET != null) {
                    try {
                        this.zzET.setUserId(userId);
                    } catch (Throwable e) {
                        zzb.zzd("Could not forward setUserId to RewardedVideoAd", e);
                    }
                }
                return;
            }
            zzb.zzaC("A user id has already been set, ignoring.");
        }
    }

    public void show() {
        synchronized (this.zzqt) {
            if (this.zzET == null) {
                return;
            }
            try {
                this.zzET.show();
            } catch (Throwable e) {
                zzb.zzd("Could not forward show to RewardedVideoAd", e);
            }
        }
    }
}
