package com.applovin.sdk;

import android.location.Location;

public interface AppLovinTargetingData {
    public static final char GENDER_FEMALE = 'f';
    public static final char GENDER_MALE = 'm';

    void clearData();

    void putExtra(String str, String str2);

    void setBirthYear(int i);

    @Deprecated
    void setCarrier(String str);

    @Deprecated
    void setCountry(String str);

    void setGender(char c);

    void setInterests(String... strArr);

    void setKeywords(String... strArr);

    void setLanguage(String str);

    @Deprecated
    void setLocation(Location location);
}
