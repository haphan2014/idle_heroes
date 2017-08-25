package com.google.android.gms.games.event;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.zzlc;

public final class EventEntity implements SafeParcelable, Event {
    public static final EventEntityCreator CREATOR = new EventEntityCreator();
    private final String mName;
    private final int zzCY;
    private final String zzakM;
    private final Uri zzanf;
    private final String zzanq;
    private final String zzaoK;
    private final long zzaoL;
    private final String zzaoM;
    private final boolean zzaoN;
    private final PlayerEntity zzaog;

    EventEntity(int versionCode, String eventId, String name, String description, Uri iconImageUri, String iconImageUrl, Player player, long value, String formattedValue, boolean isVisible) {
        this.zzCY = versionCode;
        this.zzaoK = eventId;
        this.mName = name;
        this.zzakM = description;
        this.zzanf = iconImageUri;
        this.zzanq = iconImageUrl;
        this.zzaog = new PlayerEntity(player);
        this.zzaoL = value;
        this.zzaoM = formattedValue;
        this.zzaoN = isVisible;
    }

    public EventEntity(Event event) {
        this.zzCY = 1;
        this.zzaoK = event.getEventId();
        this.mName = event.getName();
        this.zzakM = event.getDescription();
        this.zzanf = event.getIconImageUri();
        this.zzanq = event.getIconImageUrl();
        this.zzaog = (PlayerEntity) event.getPlayer().freeze();
        this.zzaoL = event.getValue();
        this.zzaoM = event.getFormattedValue();
        this.zzaoN = event.isVisible();
    }

    static int zza(Event event) {
        return zzt.hashCode(event.getEventId(), event.getName(), event.getDescription(), event.getIconImageUri(), event.getIconImageUrl(), event.getPlayer(), Long.valueOf(event.getValue()), event.getFormattedValue(), Boolean.valueOf(event.isVisible()));
    }

    static boolean zza(Event event, Object obj) {
        if (!(obj instanceof Event)) {
            return false;
        }
        if (event == obj) {
            return true;
        }
        Event event2 = (Event) obj;
        return zzt.equal(event2.getEventId(), event.getEventId()) && zzt.equal(event2.getName(), event.getName()) && zzt.equal(event2.getDescription(), event.getDescription()) && zzt.equal(event2.getIconImageUri(), event.getIconImageUri()) && zzt.equal(event2.getIconImageUrl(), event.getIconImageUrl()) && zzt.equal(event2.getPlayer(), event.getPlayer()) && zzt.equal(Long.valueOf(event2.getValue()), Long.valueOf(event.getValue())) && zzt.equal(event2.getFormattedValue(), event.getFormattedValue()) && zzt.equal(Boolean.valueOf(event2.isVisible()), Boolean.valueOf(event.isVisible()));
    }

    static String zzb(Event event) {
        return zzt.zzt(event).zzg("Id", event.getEventId()).zzg("Name", event.getName()).zzg("Description", event.getDescription()).zzg("IconImageUri", event.getIconImageUri()).zzg("IconImageUrl", event.getIconImageUrl()).zzg("Player", event.getPlayer()).zzg("Value", Long.valueOf(event.getValue())).zzg("FormattedValue", event.getFormattedValue()).zzg("isVisible", Boolean.valueOf(event.isVisible())).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public Event freeze() {
        return this;
    }

    public String getDescription() {
        return this.zzakM;
    }

    public void getDescription(CharArrayBuffer dataOut) {
        zzlc.zzb(this.zzakM, dataOut);
    }

    public String getEventId() {
        return this.zzaoK;
    }

    public String getFormattedValue() {
        return this.zzaoM;
    }

    public void getFormattedValue(CharArrayBuffer dataOut) {
        zzlc.zzb(this.zzaoM, dataOut);
    }

    public Uri getIconImageUri() {
        return this.zzanf;
    }

    public String getIconImageUrl() {
        return this.zzanq;
    }

    public String getName() {
        return this.mName;
    }

    public void getName(CharArrayBuffer dataOut) {
        zzlc.zzb(this.mName, dataOut);
    }

    public Player getPlayer() {
        return this.zzaog;
    }

    public long getValue() {
        return this.zzaoL;
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

    public boolean isVisible() {
        return this.zzaoN;
    }

    public String toString() {
        return zzb(this);
    }

    public void writeToParcel(Parcel out, int flags) {
        EventEntityCreator.zza(this, out, flags);
    }
}
