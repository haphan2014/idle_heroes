package com.google.android.gms.plus.model.moments;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.plus.internal.model.moments.ItemScopeEntity;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface ItemScope extends Freezable<ItemScope> {

    public static class Builder {
        private String mName;
        private String zzEl;
        private String zzF;
        private String zzKI;
        private final Set<Integer> zzaHQ = new HashSet();
        private ItemScopeEntity zzaHR;
        private List<String> zzaHS;
        private ItemScopeEntity zzaHT;
        private String zzaHU;
        private String zzaHV;
        private String zzaHW;
        private List<ItemScopeEntity> zzaHX;
        private int zzaHY;
        private List<ItemScopeEntity> zzaHZ;
        private String zzaIA;
        private String zzaIB;
        private ItemScopeEntity zzaIC;
        private String zzaID;
        private String zzaIE;
        private String zzaIF;
        private ItemScopeEntity zzaIG;
        private String zzaIH;
        private String zzaII;
        private String zzaIJ;
        private String zzaIK;
        private ItemScopeEntity zzaIa;
        private List<ItemScopeEntity> zzaIb;
        private String zzaIc;
        private String zzaId;
        private ItemScopeEntity zzaIe;
        private String zzaIf;
        private String zzaIg;
        private List<ItemScopeEntity> zzaIh;
        private String zzaIi;
        private String zzaIj;
        private String zzaIk;
        private String zzaIl;
        private String zzaIm;
        private String zzaIn;
        private String zzaIo;
        private String zzaIp;
        private ItemScopeEntity zzaIq;
        private String zzaIr;
        private String zzaIs;
        private String zzaIt;
        private ItemScopeEntity zzaIu;
        private ItemScopeEntity zzaIv;
        private ItemScopeEntity zzaIw;
        private List<ItemScopeEntity> zzaIx;
        private String zzaIy;
        private String zzaIz;
        private String zzakM;
        private double zzaxB;
        private double zzaxC;
        private String zzsB;

        public ItemScope build() {
            return new ItemScopeEntity(this.zzaHQ, this.zzaHR, this.zzaHS, this.zzaHT, this.zzaHU, this.zzaHV, this.zzaHW, this.zzaHX, this.zzaHY, this.zzaHZ, this.zzaIa, this.zzaIb, this.zzaIc, this.zzaId, this.zzaIe, this.zzaIf, this.zzaIg, this.zzsB, this.zzaIh, this.zzaIi, this.zzaIj, this.zzaIk, this.zzakM, this.zzaIl, this.zzaIm, this.zzaIn, this.zzaIo, this.zzaIp, this.zzaIq, this.zzaIr, this.zzaIs, this.zzKI, this.zzaIt, this.zzaIu, this.zzaxB, this.zzaIv, this.zzaxC, this.mName, this.zzaIw, this.zzaIx, this.zzaIy, this.zzaIz, this.zzaIA, this.zzaIB, this.zzaIC, this.zzaID, this.zzaIE, this.zzaIF, this.zzaIG, this.zzaIH, this.zzaII, this.zzEl, this.zzF, this.zzaIJ, this.zzaIK);
        }

        public Builder setAbout(ItemScope about) {
            this.zzaHR = (ItemScopeEntity) about;
            this.zzaHQ.add(Integer.valueOf(2));
            return this;
        }

        public Builder setAdditionalName(List<String> additionalName) {
            this.zzaHS = additionalName;
            this.zzaHQ.add(Integer.valueOf(3));
            return this;
        }

        public Builder setAddress(ItemScope address) {
            this.zzaHT = (ItemScopeEntity) address;
            this.zzaHQ.add(Integer.valueOf(4));
            return this;
        }

        public Builder setAddressCountry(String addressCountry) {
            this.zzaHU = addressCountry;
            this.zzaHQ.add(Integer.valueOf(5));
            return this;
        }

        public Builder setAddressLocality(String addressLocality) {
            this.zzaHV = addressLocality;
            this.zzaHQ.add(Integer.valueOf(6));
            return this;
        }

        public Builder setAddressRegion(String addressRegion) {
            this.zzaHW = addressRegion;
            this.zzaHQ.add(Integer.valueOf(7));
            return this;
        }

        public Builder setAssociated_media(List<ItemScope> associated_media) {
            this.zzaHX = associated_media;
            this.zzaHQ.add(Integer.valueOf(8));
            return this;
        }

        public Builder setAttendeeCount(int attendeeCount) {
            this.zzaHY = attendeeCount;
            this.zzaHQ.add(Integer.valueOf(9));
            return this;
        }

        public Builder setAttendees(List<ItemScope> attendees) {
            this.zzaHZ = attendees;
            this.zzaHQ.add(Integer.valueOf(10));
            return this;
        }

        public Builder setAudio(ItemScope audio) {
            this.zzaIa = (ItemScopeEntity) audio;
            this.zzaHQ.add(Integer.valueOf(11));
            return this;
        }

        public Builder setAuthor(List<ItemScope> author) {
            this.zzaIb = author;
            this.zzaHQ.add(Integer.valueOf(12));
            return this;
        }

        public Builder setBestRating(String bestRating) {
            this.zzaIc = bestRating;
            this.zzaHQ.add(Integer.valueOf(13));
            return this;
        }

        public Builder setBirthDate(String birthDate) {
            this.zzaId = birthDate;
            this.zzaHQ.add(Integer.valueOf(14));
            return this;
        }

        public Builder setByArtist(ItemScope byArtist) {
            this.zzaIe = (ItemScopeEntity) byArtist;
            this.zzaHQ.add(Integer.valueOf(15));
            return this;
        }

        public Builder setCaption(String caption) {
            this.zzaIf = caption;
            this.zzaHQ.add(Integer.valueOf(16));
            return this;
        }

        public Builder setContentSize(String contentSize) {
            this.zzaIg = contentSize;
            this.zzaHQ.add(Integer.valueOf(17));
            return this;
        }

        public Builder setContentUrl(String contentUrl) {
            this.zzsB = contentUrl;
            this.zzaHQ.add(Integer.valueOf(18));
            return this;
        }

        public Builder setContributor(List<ItemScope> contributor) {
            this.zzaIh = contributor;
            this.zzaHQ.add(Integer.valueOf(19));
            return this;
        }

        public Builder setDateCreated(String dateCreated) {
            this.zzaIi = dateCreated;
            this.zzaHQ.add(Integer.valueOf(20));
            return this;
        }

        public Builder setDateModified(String dateModified) {
            this.zzaIj = dateModified;
            this.zzaHQ.add(Integer.valueOf(21));
            return this;
        }

        public Builder setDatePublished(String datePublished) {
            this.zzaIk = datePublished;
            this.zzaHQ.add(Integer.valueOf(22));
            return this;
        }

        public Builder setDescription(String description) {
            this.zzakM = description;
            this.zzaHQ.add(Integer.valueOf(23));
            return this;
        }

        public Builder setDuration(String duration) {
            this.zzaIl = duration;
            this.zzaHQ.add(Integer.valueOf(24));
            return this;
        }

        public Builder setEmbedUrl(String embedUrl) {
            this.zzaIm = embedUrl;
            this.zzaHQ.add(Integer.valueOf(25));
            return this;
        }

        public Builder setEndDate(String endDate) {
            this.zzaIn = endDate;
            this.zzaHQ.add(Integer.valueOf(26));
            return this;
        }

        public Builder setFamilyName(String familyName) {
            this.zzaIo = familyName;
            this.zzaHQ.add(Integer.valueOf(27));
            return this;
        }

        public Builder setGender(String gender) {
            this.zzaIp = gender;
            this.zzaHQ.add(Integer.valueOf(28));
            return this;
        }

        public Builder setGeo(ItemScope geo) {
            this.zzaIq = (ItemScopeEntity) geo;
            this.zzaHQ.add(Integer.valueOf(29));
            return this;
        }

        public Builder setGivenName(String givenName) {
            this.zzaIr = givenName;
            this.zzaHQ.add(Integer.valueOf(30));
            return this;
        }

        public Builder setHeight(String height) {
            this.zzaIs = height;
            this.zzaHQ.add(Integer.valueOf(31));
            return this;
        }

        public Builder setId(String id) {
            this.zzKI = id;
            this.zzaHQ.add(Integer.valueOf(32));
            return this;
        }

        public Builder setImage(String image) {
            this.zzaIt = image;
            this.zzaHQ.add(Integer.valueOf(33));
            return this;
        }

        public Builder setInAlbum(ItemScope inAlbum) {
            this.zzaIu = (ItemScopeEntity) inAlbum;
            this.zzaHQ.add(Integer.valueOf(34));
            return this;
        }

        public Builder setLatitude(double latitude) {
            this.zzaxB = latitude;
            this.zzaHQ.add(Integer.valueOf(36));
            return this;
        }

        public Builder setLocation(ItemScope location) {
            this.zzaIv = (ItemScopeEntity) location;
            this.zzaHQ.add(Integer.valueOf(37));
            return this;
        }

        public Builder setLongitude(double longitude) {
            this.zzaxC = longitude;
            this.zzaHQ.add(Integer.valueOf(38));
            return this;
        }

        public Builder setName(String name) {
            this.mName = name;
            this.zzaHQ.add(Integer.valueOf(39));
            return this;
        }

        public Builder setPartOfTVSeries(ItemScope partOfTVSeries) {
            this.zzaIw = (ItemScopeEntity) partOfTVSeries;
            this.zzaHQ.add(Integer.valueOf(40));
            return this;
        }

        public Builder setPerformers(List<ItemScope> performers) {
            this.zzaIx = performers;
            this.zzaHQ.add(Integer.valueOf(41));
            return this;
        }

        public Builder setPlayerType(String playerType) {
            this.zzaIy = playerType;
            this.zzaHQ.add(Integer.valueOf(42));
            return this;
        }

        public Builder setPostOfficeBoxNumber(String postOfficeBoxNumber) {
            this.zzaIz = postOfficeBoxNumber;
            this.zzaHQ.add(Integer.valueOf(43));
            return this;
        }

        public Builder setPostalCode(String postalCode) {
            this.zzaIA = postalCode;
            this.zzaHQ.add(Integer.valueOf(44));
            return this;
        }

        public Builder setRatingValue(String ratingValue) {
            this.zzaIB = ratingValue;
            this.zzaHQ.add(Integer.valueOf(45));
            return this;
        }

        public Builder setReviewRating(ItemScope reviewRating) {
            this.zzaIC = (ItemScopeEntity) reviewRating;
            this.zzaHQ.add(Integer.valueOf(46));
            return this;
        }

        public Builder setStartDate(String startDate) {
            this.zzaID = startDate;
            this.zzaHQ.add(Integer.valueOf(47));
            return this;
        }

        public Builder setStreetAddress(String streetAddress) {
            this.zzaIE = streetAddress;
            this.zzaHQ.add(Integer.valueOf(48));
            return this;
        }

        public Builder setText(String text) {
            this.zzaIF = text;
            this.zzaHQ.add(Integer.valueOf(49));
            return this;
        }

        public Builder setThumbnail(ItemScope thumbnail) {
            this.zzaIG = (ItemScopeEntity) thumbnail;
            this.zzaHQ.add(Integer.valueOf(50));
            return this;
        }

        public Builder setThumbnailUrl(String thumbnailUrl) {
            this.zzaIH = thumbnailUrl;
            this.zzaHQ.add(Integer.valueOf(51));
            return this;
        }

        public Builder setTickerSymbol(String tickerSymbol) {
            this.zzaII = tickerSymbol;
            this.zzaHQ.add(Integer.valueOf(52));
            return this;
        }

        public Builder setType(String type) {
            this.zzEl = type;
            this.zzaHQ.add(Integer.valueOf(53));
            return this;
        }

        public Builder setUrl(String url) {
            this.zzF = url;
            this.zzaHQ.add(Integer.valueOf(54));
            return this;
        }

        public Builder setWidth(String width) {
            this.zzaIJ = width;
            this.zzaHQ.add(Integer.valueOf(55));
            return this;
        }

        public Builder setWorstRating(String worstRating) {
            this.zzaIK = worstRating;
            this.zzaHQ.add(Integer.valueOf(56));
            return this;
        }
    }

    ItemScope getAbout();

    List<String> getAdditionalName();

    ItemScope getAddress();

    String getAddressCountry();

    String getAddressLocality();

    String getAddressRegion();

    List<ItemScope> getAssociated_media();

    int getAttendeeCount();

    List<ItemScope> getAttendees();

    ItemScope getAudio();

    List<ItemScope> getAuthor();

    String getBestRating();

    String getBirthDate();

    ItemScope getByArtist();

    String getCaption();

    String getContentSize();

    String getContentUrl();

    List<ItemScope> getContributor();

    String getDateCreated();

    String getDateModified();

    String getDatePublished();

    String getDescription();

    String getDuration();

    String getEmbedUrl();

    String getEndDate();

    String getFamilyName();

    String getGender();

    ItemScope getGeo();

    String getGivenName();

    String getHeight();

    String getId();

    String getImage();

    ItemScope getInAlbum();

    double getLatitude();

    ItemScope getLocation();

    double getLongitude();

    String getName();

    ItemScope getPartOfTVSeries();

    List<ItemScope> getPerformers();

    String getPlayerType();

    String getPostOfficeBoxNumber();

    String getPostalCode();

    String getRatingValue();

    ItemScope getReviewRating();

    String getStartDate();

    String getStreetAddress();

    String getText();

    ItemScope getThumbnail();

    String getThumbnailUrl();

    String getTickerSymbol();

    String getType();

    String getUrl();

    String getWidth();

    String getWorstRating();

    boolean hasAbout();

    boolean hasAdditionalName();

    boolean hasAddress();

    boolean hasAddressCountry();

    boolean hasAddressLocality();

    boolean hasAddressRegion();

    boolean hasAssociated_media();

    boolean hasAttendeeCount();

    boolean hasAttendees();

    boolean hasAudio();

    boolean hasAuthor();

    boolean hasBestRating();

    boolean hasBirthDate();

    boolean hasByArtist();

    boolean hasCaption();

    boolean hasContentSize();

    boolean hasContentUrl();

    boolean hasContributor();

    boolean hasDateCreated();

    boolean hasDateModified();

    boolean hasDatePublished();

    boolean hasDescription();

    boolean hasDuration();

    boolean hasEmbedUrl();

    boolean hasEndDate();

    boolean hasFamilyName();

    boolean hasGender();

    boolean hasGeo();

    boolean hasGivenName();

    boolean hasHeight();

    boolean hasId();

    boolean hasImage();

    boolean hasInAlbum();

    boolean hasLatitude();

    boolean hasLocation();

    boolean hasLongitude();

    boolean hasName();

    boolean hasPartOfTVSeries();

    boolean hasPerformers();

    boolean hasPlayerType();

    boolean hasPostOfficeBoxNumber();

    boolean hasPostalCode();

    boolean hasRatingValue();

    boolean hasReviewRating();

    boolean hasStartDate();

    boolean hasStreetAddress();

    boolean hasText();

    boolean hasThumbnail();

    boolean hasThumbnailUrl();

    boolean hasTickerSymbol();

    boolean hasType();

    boolean hasUrl();

    boolean hasWidth();

    boolean hasWorstRating();
}
