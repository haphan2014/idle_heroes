package com.heyzap.sdk.ads;

import android.location.Location;
import android.support.annotation.Nullable;
import com.heyzap.mediation.MediationManager;
import com.heyzap.mediation.config.ConfigLoader.MediationConfigListener;
import com.heyzap.mediation.config.MediationConfig;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DemographicInfo {
    private Location location;
    private Date userBirthDate;
    private EducationLevel userEducationLevel = EducationLevel.UNKNOWN;
    private Gender userGender = Gender.UNKNOWN;
    private Integer userHouseholdIncome;
    private List<String> userInterests;
    private MaritalStatus userMaritalStatus = MaritalStatus.UNKNOWN;
    private String userPostalCode;

    public enum EducationLevel {
        UNKNOWN("u"),
        GRADE_SCHOOL("gs"),
        HIGH_SCHOOL_UNFINISHED("hsu"),
        HIGH_SCHOOL_FINISHED("hsd"),
        COLLEGE_UNFINISHED("col"),
        ASSOCIATE_DEGREE("aa"),
        BACHELORS_DEGREE("ba"),
        GRADUATE_DEGREE("gd"),
        POST_GRADUATE_DEGREE("pgd");
        
        private String adcolony;
        public String code;

        static {
            UNKNOWN.adcolony = "";
            GRADE_SCHOOL.adcolony = "grade_school";
            HIGH_SCHOOL_UNFINISHED.adcolony = "some_high_school";
            HIGH_SCHOOL_FINISHED.adcolony = "high_school_diploma";
            COLLEGE_UNFINISHED.adcolony = "some_college";
            ASSOCIATE_DEGREE.adcolony = "associates_degree";
            BACHELORS_DEGREE.adcolony = "bachelors_degree";
            GRADUATE_DEGREE.adcolony = "graduate_degree";
            POST_GRADUATE_DEGREE.adcolony = "graduate_degree";
        }

        private EducationLevel(String code) {
            this.code = code;
        }

        public String getAdColonyString() {
            return this.adcolony;
        }
    }

    public enum Gender {
        UNKNOWN("u"),
        MALE("m"),
        FEMALE("f"),
        OTHER("o");
        
        private String adcolony;
        public final String code;

        static {
            UNKNOWN.adcolony = "";
            MALE.adcolony = "male";
            FEMALE.adcolony = "female";
            OTHER.adcolony = "";
        }

        private Gender(String code) {
            this.code = code;
        }

        public String getAdColonyString() {
            return this.adcolony;
        }
    }

    public enum MaritalStatus {
        UNKNOWN("u"),
        SINGLE("s"),
        MARRIED("m");
        
        private String adcolony;
        public final String code;

        static {
            UNKNOWN.adcolony = "";
            SINGLE.adcolony = "single";
            MARRIED.adcolony = "married";
        }

        private MaritalStatus(String code) {
            this.code = code;
        }

        public String getAdColonyString() {
            return this.adcolony;
        }
    }

    @Nullable
    public Location getLocation() {
        return this.location;
    }

    void setLocationWithoutProviderUpdate(Location location) {
        this.location = location;
    }

    public void setLocation(final Location location) {
        this.location = location;
        MediationManager.getInstance().getConfigLoader().get(new MediationConfigListener() {
            public void onConfigLoaded(MediationConfig config) {
                config.getLocationProvider().setLocation(location);
            }
        });
    }

    @Nullable
    public Date getUserBirthDate() {
        return this.userBirthDate;
    }

    public void setUserBirthDate(Date userBirthDate) {
        this.userBirthDate = userBirthDate;
    }

    @Nullable
    public List<String> getUserInterests() {
        return this.userInterests;
    }

    public void setUserInterests(List<String> userInterests) {
        this.userInterests = userInterests;
    }

    public Gender getUserGender() {
        return this.userGender;
    }

    public void setUserGender(Gender userGender) {
        if (userGender == null) {
            userGender = Gender.UNKNOWN;
        } else {
            this.userGender = userGender;
        }
    }

    @Nullable
    public String getUserPostalCode() {
        return this.userPostalCode;
    }

    public void setUserPostalCode(String userPostalCode) {
        this.userPostalCode = userPostalCode;
    }

    @Nullable
    public Integer getUserHouseholdIncome() {
        return this.userHouseholdIncome;
    }

    public void setUserHouseholdIncome(Integer userHouseholdIncome) {
        this.userHouseholdIncome = userHouseholdIncome;
    }

    public MaritalStatus getUserMaritalStatus() {
        return this.userMaritalStatus;
    }

    public void setUserMaritalStatus(MaritalStatus userMaritalStatus) {
        if (userMaritalStatus == null) {
            userMaritalStatus = MaritalStatus.UNKNOWN;
        } else {
            this.userMaritalStatus = userMaritalStatus;
        }
    }

    public EducationLevel getUserEducationLevel() {
        return this.userEducationLevel;
    }

    public void setUserEducationLevel(EducationLevel userEducationLevel) {
        if (userEducationLevel == null) {
            userEducationLevel = EducationLevel.UNKNOWN;
        } else {
            this.userEducationLevel = userEducationLevel;
        }
    }

    @Nullable
    public Integer getUserAgeFromBirthdate() {
        if (getUserBirthDate() == null) {
            return null;
        }
        Calendar birthdateCal = Calendar.getInstance();
        birthdateCal.setTime(getUserBirthDate());
        Calendar nowCal = Calendar.getInstance();
        int age = nowCal.get(1) - birthdateCal.get(1);
        if (birthdateCal.get(2) > nowCal.get(2) || (birthdateCal.get(2) == nowCal.get(2) && birthdateCal.get(5) > nowCal.get(5))) {
            age--;
        }
        return Integer.valueOf(age);
    }

    public String toString() {
        return "DemographicInfo{location=" + this.location + ", userBirthDate=" + this.userBirthDate + ", userInterests=" + this.userInterests + ", userGender=" + this.userGender + ", userPostalCode='" + this.userPostalCode + '\'' + ", userHouseholdIncome=" + this.userHouseholdIncome + ", userMaritalStatus=" + this.userMaritalStatus + ", userEducationLevel=" + this.userEducationLevel + '}';
    }
}
