package com.google.android.gms.plus.internal.model.moments;

import android.os.Parcel;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.plus.PlusShare;
import com.google.android.gms.plus.model.moments.ItemScope;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class ItemScopeEntity extends FastSafeParcelableJsonResponse implements ItemScope {
    public static final zza CREATOR = new zza();
    private static final HashMap<String, Field<?, ?>> zzaHP = new HashMap();
    String mName;
    final int zzCY;
    String zzEl;
    String zzF;
    String zzKI;
    final Set<Integer> zzaHQ;
    ItemScopeEntity zzaHR;
    List<String> zzaHS;
    ItemScopeEntity zzaHT;
    String zzaHU;
    String zzaHV;
    String zzaHW;
    List<ItemScopeEntity> zzaHX;
    int zzaHY;
    List<ItemScopeEntity> zzaHZ;
    String zzaIA;
    String zzaIB;
    ItemScopeEntity zzaIC;
    String zzaID;
    String zzaIE;
    String zzaIF;
    ItemScopeEntity zzaIG;
    String zzaIH;
    String zzaII;
    String zzaIJ;
    String zzaIK;
    ItemScopeEntity zzaIa;
    List<ItemScopeEntity> zzaIb;
    String zzaIc;
    String zzaId;
    ItemScopeEntity zzaIe;
    String zzaIf;
    String zzaIg;
    List<ItemScopeEntity> zzaIh;
    String zzaIi;
    String zzaIj;
    String zzaIk;
    String zzaIl;
    String zzaIm;
    String zzaIn;
    String zzaIo;
    String zzaIp;
    ItemScopeEntity zzaIq;
    String zzaIr;
    String zzaIs;
    String zzaIt;
    ItemScopeEntity zzaIu;
    ItemScopeEntity zzaIv;
    ItemScopeEntity zzaIw;
    List<ItemScopeEntity> zzaIx;
    String zzaIy;
    String zzaIz;
    String zzakM;
    double zzaxB;
    double zzaxC;
    String zzsB;

    static {
        zzaHP.put("about", Field.zza("about", 2, ItemScopeEntity.class));
        zzaHP.put("additionalName", Field.zzm("additionalName", 3));
        zzaHP.put("address", Field.zza("address", 4, ItemScopeEntity.class));
        zzaHP.put("addressCountry", Field.zzl("addressCountry", 5));
        zzaHP.put("addressLocality", Field.zzl("addressLocality", 6));
        zzaHP.put("addressRegion", Field.zzl("addressRegion", 7));
        zzaHP.put("associated_media", Field.zzb("associated_media", 8, ItemScopeEntity.class));
        zzaHP.put("attendeeCount", Field.zzi("attendeeCount", 9));
        zzaHP.put("attendees", Field.zzb("attendees", 10, ItemScopeEntity.class));
        zzaHP.put("audio", Field.zza("audio", 11, ItemScopeEntity.class));
        zzaHP.put("author", Field.zzb("author", 12, ItemScopeEntity.class));
        zzaHP.put("bestRating", Field.zzl("bestRating", 13));
        zzaHP.put("birthDate", Field.zzl("birthDate", 14));
        zzaHP.put("byArtist", Field.zza("byArtist", 15, ItemScopeEntity.class));
        zzaHP.put("caption", Field.zzl("caption", 16));
        zzaHP.put("contentSize", Field.zzl("contentSize", 17));
        zzaHP.put("contentUrl", Field.zzl("contentUrl", 18));
        zzaHP.put("contributor", Field.zzb("contributor", 19, ItemScopeEntity.class));
        zzaHP.put("dateCreated", Field.zzl("dateCreated", 20));
        zzaHP.put("dateModified", Field.zzl("dateModified", 21));
        zzaHP.put("datePublished", Field.zzl("datePublished", 22));
        zzaHP.put("description", Field.zzl("description", 23));
        zzaHP.put("duration", Field.zzl("duration", 24));
        zzaHP.put("embedUrl", Field.zzl("embedUrl", 25));
        zzaHP.put("endDate", Field.zzl("endDate", 26));
        zzaHP.put("familyName", Field.zzl("familyName", 27));
        zzaHP.put("gender", Field.zzl("gender", 28));
        zzaHP.put("geo", Field.zza("geo", 29, ItemScopeEntity.class));
        zzaHP.put("givenName", Field.zzl("givenName", 30));
        zzaHP.put("height", Field.zzl("height", 31));
        zzaHP.put("id", Field.zzl("id", 32));
        zzaHP.put("image", Field.zzl("image", 33));
        zzaHP.put("inAlbum", Field.zza("inAlbum", 34, ItemScopeEntity.class));
        zzaHP.put("latitude", Field.zzj("latitude", 36));
        zzaHP.put("location", Field.zza("location", 37, ItemScopeEntity.class));
        zzaHP.put("longitude", Field.zzj("longitude", 38));
        zzaHP.put("name", Field.zzl("name", 39));
        zzaHP.put("partOfTVSeries", Field.zza("partOfTVSeries", 40, ItemScopeEntity.class));
        zzaHP.put("performers", Field.zzb("performers", 41, ItemScopeEntity.class));
        zzaHP.put("playerType", Field.zzl("playerType", 42));
        zzaHP.put("postOfficeBoxNumber", Field.zzl("postOfficeBoxNumber", 43));
        zzaHP.put("postalCode", Field.zzl("postalCode", 44));
        zzaHP.put("ratingValue", Field.zzl("ratingValue", 45));
        zzaHP.put("reviewRating", Field.zza("reviewRating", 46, ItemScopeEntity.class));
        zzaHP.put("startDate", Field.zzl("startDate", 47));
        zzaHP.put("streetAddress", Field.zzl("streetAddress", 48));
        zzaHP.put("text", Field.zzl("text", 49));
        zzaHP.put("thumbnail", Field.zza("thumbnail", 50, ItemScopeEntity.class));
        zzaHP.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_THUMBNAIL_URL, Field.zzl(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_THUMBNAIL_URL, 51));
        zzaHP.put("tickerSymbol", Field.zzl("tickerSymbol", 52));
        zzaHP.put("type", Field.zzl("type", 53));
        zzaHP.put("url", Field.zzl("url", 54));
        zzaHP.put("width", Field.zzl("width", 55));
        zzaHP.put("worstRating", Field.zzl("worstRating", 56));
    }

    public ItemScopeEntity() {
        this.zzCY = 1;
        this.zzaHQ = new HashSet();
    }

    ItemScopeEntity(Set<Integer> indicatorSet, int versionCode, ItemScopeEntity about, List<String> additionalName, ItemScopeEntity address, String addressCountry, String addressLocality, String addressRegion, List<ItemScopeEntity> associated_media, int attendeeCount, List<ItemScopeEntity> attendees, ItemScopeEntity audio, List<ItemScopeEntity> author, String bestRating, String birthDate, ItemScopeEntity byArtist, String caption, String contentSize, String contentUrl, List<ItemScopeEntity> contributor, String dateCreated, String dateModified, String datePublished, String description, String duration, String embedUrl, String endDate, String familyName, String gender, ItemScopeEntity geo, String givenName, String height, String id, String image, ItemScopeEntity inAlbum, double latitude, ItemScopeEntity location, double longitude, String name, ItemScopeEntity partOfTVSeries, List<ItemScopeEntity> performers, String playerType, String postOfficeBoxNumber, String postalCode, String ratingValue, ItemScopeEntity reviewRating, String startDate, String streetAddress, String text, ItemScopeEntity thumbnail, String thumbnailUrl, String tickerSymbol, String type, String url, String width, String worstRating) {
        this.zzaHQ = indicatorSet;
        this.zzCY = versionCode;
        this.zzaHR = about;
        this.zzaHS = additionalName;
        this.zzaHT = address;
        this.zzaHU = addressCountry;
        this.zzaHV = addressLocality;
        this.zzaHW = addressRegion;
        this.zzaHX = associated_media;
        this.zzaHY = attendeeCount;
        this.zzaHZ = attendees;
        this.zzaIa = audio;
        this.zzaIb = author;
        this.zzaIc = bestRating;
        this.zzaId = birthDate;
        this.zzaIe = byArtist;
        this.zzaIf = caption;
        this.zzaIg = contentSize;
        this.zzsB = contentUrl;
        this.zzaIh = contributor;
        this.zzaIi = dateCreated;
        this.zzaIj = dateModified;
        this.zzaIk = datePublished;
        this.zzakM = description;
        this.zzaIl = duration;
        this.zzaIm = embedUrl;
        this.zzaIn = endDate;
        this.zzaIo = familyName;
        this.zzaIp = gender;
        this.zzaIq = geo;
        this.zzaIr = givenName;
        this.zzaIs = height;
        this.zzKI = id;
        this.zzaIt = image;
        this.zzaIu = inAlbum;
        this.zzaxB = latitude;
        this.zzaIv = location;
        this.zzaxC = longitude;
        this.mName = name;
        this.zzaIw = partOfTVSeries;
        this.zzaIx = performers;
        this.zzaIy = playerType;
        this.zzaIz = postOfficeBoxNumber;
        this.zzaIA = postalCode;
        this.zzaIB = ratingValue;
        this.zzaIC = reviewRating;
        this.zzaID = startDate;
        this.zzaIE = streetAddress;
        this.zzaIF = text;
        this.zzaIG = thumbnail;
        this.zzaIH = thumbnailUrl;
        this.zzaII = tickerSymbol;
        this.zzEl = type;
        this.zzF = url;
        this.zzaIJ = width;
        this.zzaIK = worstRating;
    }

    public ItemScopeEntity(Set<Integer> indicatorSet, ItemScopeEntity about, List<String> additionalName, ItemScopeEntity address, String addressCountry, String addressLocality, String addressRegion, List<ItemScopeEntity> associated_media, int attendeeCount, List<ItemScopeEntity> attendees, ItemScopeEntity audio, List<ItemScopeEntity> author, String bestRating, String birthDate, ItemScopeEntity byArtist, String caption, String contentSize, String contentUrl, List<ItemScopeEntity> contributor, String dateCreated, String dateModified, String datePublished, String description, String duration, String embedUrl, String endDate, String familyName, String gender, ItemScopeEntity geo, String givenName, String height, String id, String image, ItemScopeEntity inAlbum, double latitude, ItemScopeEntity location, double longitude, String name, ItemScopeEntity partOfTVSeries, List<ItemScopeEntity> performers, String playerType, String postOfficeBoxNumber, String postalCode, String ratingValue, ItemScopeEntity reviewRating, String startDate, String streetAddress, String text, ItemScopeEntity thumbnail, String thumbnailUrl, String tickerSymbol, String type, String url, String width, String worstRating) {
        this.zzaHQ = indicatorSet;
        this.zzCY = 1;
        this.zzaHR = about;
        this.zzaHS = additionalName;
        this.zzaHT = address;
        this.zzaHU = addressCountry;
        this.zzaHV = addressLocality;
        this.zzaHW = addressRegion;
        this.zzaHX = associated_media;
        this.zzaHY = attendeeCount;
        this.zzaHZ = attendees;
        this.zzaIa = audio;
        this.zzaIb = author;
        this.zzaIc = bestRating;
        this.zzaId = birthDate;
        this.zzaIe = byArtist;
        this.zzaIf = caption;
        this.zzaIg = contentSize;
        this.zzsB = contentUrl;
        this.zzaIh = contributor;
        this.zzaIi = dateCreated;
        this.zzaIj = dateModified;
        this.zzaIk = datePublished;
        this.zzakM = description;
        this.zzaIl = duration;
        this.zzaIm = embedUrl;
        this.zzaIn = endDate;
        this.zzaIo = familyName;
        this.zzaIp = gender;
        this.zzaIq = geo;
        this.zzaIr = givenName;
        this.zzaIs = height;
        this.zzKI = id;
        this.zzaIt = image;
        this.zzaIu = inAlbum;
        this.zzaxB = latitude;
        this.zzaIv = location;
        this.zzaxC = longitude;
        this.mName = name;
        this.zzaIw = partOfTVSeries;
        this.zzaIx = performers;
        this.zzaIy = playerType;
        this.zzaIz = postOfficeBoxNumber;
        this.zzaIA = postalCode;
        this.zzaIB = ratingValue;
        this.zzaIC = reviewRating;
        this.zzaID = startDate;
        this.zzaIE = streetAddress;
        this.zzaIF = text;
        this.zzaIG = thumbnail;
        this.zzaIH = thumbnailUrl;
        this.zzaII = tickerSymbol;
        this.zzEl = type;
        this.zzF = url;
        this.zzaIJ = width;
        this.zzaIK = worstRating;
    }

    public int describeContents() {
        zza com_google_android_gms_plus_internal_model_moments_zza = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ItemScopeEntity)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        ItemScopeEntity itemScopeEntity = (ItemScopeEntity) obj;
        for (Field field : zzaHP.values()) {
            if (zza(field)) {
                if (!itemScopeEntity.zza(field)) {
                    return false;
                }
                if (!zzb(field).equals(itemScopeEntity.zzb(field))) {
                    return false;
                }
            } else if (itemScopeEntity.zza(field)) {
                return false;
            }
        }
        return true;
    }

    public /* synthetic */ Object freeze() {
        return zzxG();
    }

    public ItemScope getAbout() {
        return this.zzaHR;
    }

    public List<String> getAdditionalName() {
        return this.zzaHS;
    }

    public ItemScope getAddress() {
        return this.zzaHT;
    }

    public String getAddressCountry() {
        return this.zzaHU;
    }

    public String getAddressLocality() {
        return this.zzaHV;
    }

    public String getAddressRegion() {
        return this.zzaHW;
    }

    public List<ItemScope> getAssociated_media() {
        return (ArrayList) this.zzaHX;
    }

    public int getAttendeeCount() {
        return this.zzaHY;
    }

    public List<ItemScope> getAttendees() {
        return (ArrayList) this.zzaHZ;
    }

    public ItemScope getAudio() {
        return this.zzaIa;
    }

    public List<ItemScope> getAuthor() {
        return (ArrayList) this.zzaIb;
    }

    public String getBestRating() {
        return this.zzaIc;
    }

    public String getBirthDate() {
        return this.zzaId;
    }

    public ItemScope getByArtist() {
        return this.zzaIe;
    }

    public String getCaption() {
        return this.zzaIf;
    }

    public String getContentSize() {
        return this.zzaIg;
    }

    public String getContentUrl() {
        return this.zzsB;
    }

    public List<ItemScope> getContributor() {
        return (ArrayList) this.zzaIh;
    }

    public String getDateCreated() {
        return this.zzaIi;
    }

    public String getDateModified() {
        return this.zzaIj;
    }

    public String getDatePublished() {
        return this.zzaIk;
    }

    public String getDescription() {
        return this.zzakM;
    }

    public String getDuration() {
        return this.zzaIl;
    }

    public String getEmbedUrl() {
        return this.zzaIm;
    }

    public String getEndDate() {
        return this.zzaIn;
    }

    public String getFamilyName() {
        return this.zzaIo;
    }

    public String getGender() {
        return this.zzaIp;
    }

    public ItemScope getGeo() {
        return this.zzaIq;
    }

    public String getGivenName() {
        return this.zzaIr;
    }

    public String getHeight() {
        return this.zzaIs;
    }

    public String getId() {
        return this.zzKI;
    }

    public String getImage() {
        return this.zzaIt;
    }

    public ItemScope getInAlbum() {
        return this.zzaIu;
    }

    public double getLatitude() {
        return this.zzaxB;
    }

    public ItemScope getLocation() {
        return this.zzaIv;
    }

    public double getLongitude() {
        return this.zzaxC;
    }

    public String getName() {
        return this.mName;
    }

    public ItemScope getPartOfTVSeries() {
        return this.zzaIw;
    }

    public List<ItemScope> getPerformers() {
        return (ArrayList) this.zzaIx;
    }

    public String getPlayerType() {
        return this.zzaIy;
    }

    public String getPostOfficeBoxNumber() {
        return this.zzaIz;
    }

    public String getPostalCode() {
        return this.zzaIA;
    }

    public String getRatingValue() {
        return this.zzaIB;
    }

    public ItemScope getReviewRating() {
        return this.zzaIC;
    }

    public String getStartDate() {
        return this.zzaID;
    }

    public String getStreetAddress() {
        return this.zzaIE;
    }

    public String getText() {
        return this.zzaIF;
    }

    public ItemScope getThumbnail() {
        return this.zzaIG;
    }

    public String getThumbnailUrl() {
        return this.zzaIH;
    }

    public String getTickerSymbol() {
        return this.zzaII;
    }

    public String getType() {
        return this.zzEl;
    }

    public String getUrl() {
        return this.zzF;
    }

    public String getWidth() {
        return this.zzaIJ;
    }

    public String getWorstRating() {
        return this.zzaIK;
    }

    public boolean hasAbout() {
        return this.zzaHQ.contains(Integer.valueOf(2));
    }

    public boolean hasAdditionalName() {
        return this.zzaHQ.contains(Integer.valueOf(3));
    }

    public boolean hasAddress() {
        return this.zzaHQ.contains(Integer.valueOf(4));
    }

    public boolean hasAddressCountry() {
        return this.zzaHQ.contains(Integer.valueOf(5));
    }

    public boolean hasAddressLocality() {
        return this.zzaHQ.contains(Integer.valueOf(6));
    }

    public boolean hasAddressRegion() {
        return this.zzaHQ.contains(Integer.valueOf(7));
    }

    public boolean hasAssociated_media() {
        return this.zzaHQ.contains(Integer.valueOf(8));
    }

    public boolean hasAttendeeCount() {
        return this.zzaHQ.contains(Integer.valueOf(9));
    }

    public boolean hasAttendees() {
        return this.zzaHQ.contains(Integer.valueOf(10));
    }

    public boolean hasAudio() {
        return this.zzaHQ.contains(Integer.valueOf(11));
    }

    public boolean hasAuthor() {
        return this.zzaHQ.contains(Integer.valueOf(12));
    }

    public boolean hasBestRating() {
        return this.zzaHQ.contains(Integer.valueOf(13));
    }

    public boolean hasBirthDate() {
        return this.zzaHQ.contains(Integer.valueOf(14));
    }

    public boolean hasByArtist() {
        return this.zzaHQ.contains(Integer.valueOf(15));
    }

    public boolean hasCaption() {
        return this.zzaHQ.contains(Integer.valueOf(16));
    }

    public boolean hasContentSize() {
        return this.zzaHQ.contains(Integer.valueOf(17));
    }

    public boolean hasContentUrl() {
        return this.zzaHQ.contains(Integer.valueOf(18));
    }

    public boolean hasContributor() {
        return this.zzaHQ.contains(Integer.valueOf(19));
    }

    public boolean hasDateCreated() {
        return this.zzaHQ.contains(Integer.valueOf(20));
    }

    public boolean hasDateModified() {
        return this.zzaHQ.contains(Integer.valueOf(21));
    }

    public boolean hasDatePublished() {
        return this.zzaHQ.contains(Integer.valueOf(22));
    }

    public boolean hasDescription() {
        return this.zzaHQ.contains(Integer.valueOf(23));
    }

    public boolean hasDuration() {
        return this.zzaHQ.contains(Integer.valueOf(24));
    }

    public boolean hasEmbedUrl() {
        return this.zzaHQ.contains(Integer.valueOf(25));
    }

    public boolean hasEndDate() {
        return this.zzaHQ.contains(Integer.valueOf(26));
    }

    public boolean hasFamilyName() {
        return this.zzaHQ.contains(Integer.valueOf(27));
    }

    public boolean hasGender() {
        return this.zzaHQ.contains(Integer.valueOf(28));
    }

    public boolean hasGeo() {
        return this.zzaHQ.contains(Integer.valueOf(29));
    }

    public boolean hasGivenName() {
        return this.zzaHQ.contains(Integer.valueOf(30));
    }

    public boolean hasHeight() {
        return this.zzaHQ.contains(Integer.valueOf(31));
    }

    public boolean hasId() {
        return this.zzaHQ.contains(Integer.valueOf(32));
    }

    public boolean hasImage() {
        return this.zzaHQ.contains(Integer.valueOf(33));
    }

    public boolean hasInAlbum() {
        return this.zzaHQ.contains(Integer.valueOf(34));
    }

    public boolean hasLatitude() {
        return this.zzaHQ.contains(Integer.valueOf(36));
    }

    public boolean hasLocation() {
        return this.zzaHQ.contains(Integer.valueOf(37));
    }

    public boolean hasLongitude() {
        return this.zzaHQ.contains(Integer.valueOf(38));
    }

    public boolean hasName() {
        return this.zzaHQ.contains(Integer.valueOf(39));
    }

    public boolean hasPartOfTVSeries() {
        return this.zzaHQ.contains(Integer.valueOf(40));
    }

    public boolean hasPerformers() {
        return this.zzaHQ.contains(Integer.valueOf(41));
    }

    public boolean hasPlayerType() {
        return this.zzaHQ.contains(Integer.valueOf(42));
    }

    public boolean hasPostOfficeBoxNumber() {
        return this.zzaHQ.contains(Integer.valueOf(43));
    }

    public boolean hasPostalCode() {
        return this.zzaHQ.contains(Integer.valueOf(44));
    }

    public boolean hasRatingValue() {
        return this.zzaHQ.contains(Integer.valueOf(45));
    }

    public boolean hasReviewRating() {
        return this.zzaHQ.contains(Integer.valueOf(46));
    }

    public boolean hasStartDate() {
        return this.zzaHQ.contains(Integer.valueOf(47));
    }

    public boolean hasStreetAddress() {
        return this.zzaHQ.contains(Integer.valueOf(48));
    }

    public boolean hasText() {
        return this.zzaHQ.contains(Integer.valueOf(49));
    }

    public boolean hasThumbnail() {
        return this.zzaHQ.contains(Integer.valueOf(50));
    }

    public boolean hasThumbnailUrl() {
        return this.zzaHQ.contains(Integer.valueOf(51));
    }

    public boolean hasTickerSymbol() {
        return this.zzaHQ.contains(Integer.valueOf(52));
    }

    public boolean hasType() {
        return this.zzaHQ.contains(Integer.valueOf(53));
    }

    public boolean hasUrl() {
        return this.zzaHQ.contains(Integer.valueOf(54));
    }

    public boolean hasWidth() {
        return this.zzaHQ.contains(Integer.valueOf(55));
    }

    public boolean hasWorstRating() {
        return this.zzaHQ.contains(Integer.valueOf(56));
    }

    public int hashCode() {
        int i = 0;
        for (Field field : zzaHP.values()) {
            int hashCode;
            if (zza(field)) {
                hashCode = zzb(field).hashCode() + (i + field.zzot());
            } else {
                hashCode = i;
            }
            i = hashCode;
        }
        return i;
    }

    public boolean isDataValid() {
        return true;
    }

    public void writeToParcel(Parcel out, int flags) {
        zza com_google_android_gms_plus_internal_model_moments_zza = CREATOR;
        zza.zza(this, out, flags);
    }

    protected boolean zza(Field field) {
        return this.zzaHQ.contains(Integer.valueOf(field.zzot()));
    }

    protected Object zzb(Field field) {
        switch (field.zzot()) {
            case 2:
                return this.zzaHR;
            case 3:
                return this.zzaHS;
            case 4:
                return this.zzaHT;
            case 5:
                return this.zzaHU;
            case 6:
                return this.zzaHV;
            case 7:
                return this.zzaHW;
            case 8:
                return this.zzaHX;
            case 9:
                return Integer.valueOf(this.zzaHY);
            case 10:
                return this.zzaHZ;
            case 11:
                return this.zzaIa;
            case 12:
                return this.zzaIb;
            case 13:
                return this.zzaIc;
            case 14:
                return this.zzaId;
            case 15:
                return this.zzaIe;
            case 16:
                return this.zzaIf;
            case 17:
                return this.zzaIg;
            case 18:
                return this.zzsB;
            case 19:
                return this.zzaIh;
            case Place.TYPE_CAR_WASH /*20*/:
                return this.zzaIi;
            case Place.TYPE_CASINO /*21*/:
                return this.zzaIj;
            case Place.TYPE_CEMETERY /*22*/:
                return this.zzaIk;
            case Place.TYPE_CHURCH /*23*/:
                return this.zzakM;
            case Place.TYPE_CITY_HALL /*24*/:
                return this.zzaIl;
            case Place.TYPE_CLOTHING_STORE /*25*/:
                return this.zzaIm;
            case Place.TYPE_CONVENIENCE_STORE /*26*/:
                return this.zzaIn;
            case Place.TYPE_COURTHOUSE /*27*/:
                return this.zzaIo;
            case Place.TYPE_DENTIST /*28*/:
                return this.zzaIp;
            case Place.TYPE_DEPARTMENT_STORE /*29*/:
                return this.zzaIq;
            case 30:
                return this.zzaIr;
            case 31:
                return this.zzaIs;
            case 32:
                return this.zzKI;
            case Place.TYPE_EMBASSY /*33*/:
                return this.zzaIt;
            case Place.TYPE_ESTABLISHMENT /*34*/:
                return this.zzaIu;
            case Place.TYPE_FIRE_STATION /*36*/:
                return Double.valueOf(this.zzaxB);
            case Place.TYPE_FLORIST /*37*/:
                return this.zzaIv;
            case Place.TYPE_FOOD /*38*/:
                return Double.valueOf(this.zzaxC);
            case Place.TYPE_FUNERAL_HOME /*39*/:
                return this.mName;
            case 40:
                return this.zzaIw;
            case Place.TYPE_GAS_STATION /*41*/:
                return this.zzaIx;
            case Place.TYPE_GENERAL_CONTRACTOR /*42*/:
                return this.zzaIy;
            case Place.TYPE_GROCERY_OR_SUPERMARKET /*43*/:
                return this.zzaIz;
            case Place.TYPE_GYM /*44*/:
                return this.zzaIA;
            case Place.TYPE_HAIR_CARE /*45*/:
                return this.zzaIB;
            case Place.TYPE_HARDWARE_STORE /*46*/:
                return this.zzaIC;
            case Place.TYPE_HEALTH /*47*/:
                return this.zzaID;
            case Place.TYPE_HINDU_TEMPLE /*48*/:
                return this.zzaIE;
            case Place.TYPE_HOME_GOODS_STORE /*49*/:
                return this.zzaIF;
            case 50:
                return this.zzaIG;
            case Place.TYPE_INSURANCE_AGENCY /*51*/:
                return this.zzaIH;
            case Place.TYPE_JEWELRY_STORE /*52*/:
                return this.zzaII;
            case Place.TYPE_LAUNDRY /*53*/:
                return this.zzEl;
            case Place.TYPE_LAWYER /*54*/:
                return this.zzF;
            case Place.TYPE_LIBRARY /*55*/:
                return this.zzaIJ;
            case Place.TYPE_LIQUOR_STORE /*56*/:
                return this.zzaIK;
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + field.zzot());
        }
    }

    public /* synthetic */ Map zzom() {
        return zzxF();
    }

    public HashMap<String, Field<?, ?>> zzxF() {
        return zzaHP;
    }

    public ItemScopeEntity zzxG() {
        return this;
    }
}
