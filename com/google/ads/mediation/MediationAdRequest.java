package com.google.ads.mediation;

import android.location.Location;
import com.google.ads.AdRequest.Gender;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

@Deprecated
public class MediationAdRequest {
    private final Date zzaQ;
    private final Gender zzaR;
    private final Set<String> zzaS;
    private final boolean zzaT;
    private final Location zzaU;

    public MediationAdRequest(Date birthday, Gender gender, Set<String> keywords, boolean isTesting, Location location) {
        this.zzaQ = birthday;
        this.zzaR = gender;
        this.zzaS = keywords;
        this.zzaT = isTesting;
        this.zzaU = location;
    }

    public Integer getAgeInYears() {
        if (this.zzaQ == null) {
            return null;
        }
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        instance.setTime(this.zzaQ);
        Integer valueOf = Integer.valueOf(instance2.get(1) - instance.get(1));
        return (instance2.get(2) < instance.get(2) || (instance2.get(2) == instance.get(2) && instance2.get(5) < instance.get(5))) ? Integer.valueOf(valueOf.intValue() - 1) : valueOf;
    }

    public Date getBirthday() {
        return this.zzaQ;
    }

    public Gender getGender() {
        return this.zzaR;
    }

    public Set<String> getKeywords() {
        return this.zzaS;
    }

    public Location getLocation() {
        return this.zzaU;
    }

    public boolean isTesting() {
        return this.zzaT;
    }
}
