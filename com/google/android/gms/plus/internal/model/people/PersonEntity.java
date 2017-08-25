package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.server.converter.StringToIntConverter;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse;
import com.google.android.gms.fitness.FitnessActivities;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.plus.PlusShare;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.Person.AgeRange;
import com.google.android.gms.plus.model.people.Person.Cover;
import com.google.android.gms.plus.model.people.Person.Cover.CoverInfo;
import com.google.android.gms.plus.model.people.Person.Cover.CoverPhoto;
import com.google.android.gms.plus.model.people.Person.Image;
import com.google.android.gms.plus.model.people.Person.Name;
import com.google.android.gms.plus.model.people.Person.Organizations;
import com.google.android.gms.plus.model.people.Person.PlacesLived;
import com.google.android.gms.plus.model.people.Person.Urls;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class PersonEntity extends FastSafeParcelableJsonResponse implements Person {
    public static final zza CREATOR = new zza();
    private static final HashMap<String, Field<?, ?>> zzaHP = new HashMap();
    final int zzCY;
    String zzF;
    String zzKI;
    String zzRA;
    final Set<Integer> zzaHQ;
    String zzaIO;
    AgeRangeEntity zzaIP;
    String zzaIQ;
    String zzaIR;
    int zzaIS;
    CoverEntity zzaIT;
    String zzaIU;
    ImageEntity zzaIV;
    boolean zzaIW;
    NameEntity zzaIX;
    String zzaIY;
    int zzaIZ;
    List<OrganizationsEntity> zzaJa;
    List<PlacesLivedEntity> zzaJb;
    int zzaJc;
    int zzaJd;
    String zzaJe;
    List<UrlsEntity> zzaJf;
    boolean zzaJg;
    String zzadI;
    int zzsC;

    public static final class AgeRangeEntity extends FastSafeParcelableJsonResponse implements AgeRange {
        public static final zzb CREATOR = new zzb();
        private static final HashMap<String, Field<?, ?>> zzaHP = new HashMap();
        final int zzCY;
        final Set<Integer> zzaHQ;
        int zzaJh;
        int zzaJi;

        static {
            zzaHP.put("max", Field.zzi("max", 2));
            zzaHP.put("min", Field.zzi("min", 3));
        }

        public AgeRangeEntity() {
            this.zzCY = 1;
            this.zzaHQ = new HashSet();
        }

        AgeRangeEntity(Set<Integer> indicatorSet, int versionCode, int max, int min) {
            this.zzaHQ = indicatorSet;
            this.zzCY = versionCode;
            this.zzaJh = max;
            this.zzaJi = min;
        }

        public int describeContents() {
            zzb com_google_android_gms_plus_internal_model_people_zzb = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof AgeRangeEntity)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            AgeRangeEntity ageRangeEntity = (AgeRangeEntity) obj;
            for (Field field : zzaHP.values()) {
                if (zza(field)) {
                    if (!ageRangeEntity.zza(field)) {
                        return false;
                    }
                    if (!zzb(field).equals(ageRangeEntity.zzb(field))) {
                        return false;
                    }
                } else if (ageRangeEntity.zza(field)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return zzxK();
        }

        public int getMax() {
            return this.zzaJh;
        }

        public int getMin() {
            return this.zzaJi;
        }

        public boolean hasMax() {
            return this.zzaHQ.contains(Integer.valueOf(2));
        }

        public boolean hasMin() {
            return this.zzaHQ.contains(Integer.valueOf(3));
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
            zzb com_google_android_gms_plus_internal_model_people_zzb = CREATOR;
            zzb.zza(this, out, flags);
        }

        protected boolean zza(Field field) {
            return this.zzaHQ.contains(Integer.valueOf(field.zzot()));
        }

        protected Object zzb(Field field) {
            switch (field.zzot()) {
                case 2:
                    return Integer.valueOf(this.zzaJh);
                case 3:
                    return Integer.valueOf(this.zzaJi);
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

        public AgeRangeEntity zzxK() {
            return this;
        }
    }

    public static final class CoverEntity extends FastSafeParcelableJsonResponse implements Cover {
        public static final zzc CREATOR = new zzc();
        private static final HashMap<String, Field<?, ?>> zzaHP = new HashMap();
        final int zzCY;
        final Set<Integer> zzaHQ;
        CoverInfoEntity zzaJj;
        CoverPhotoEntity zzaJk;
        int zzaJl;

        public static final class CoverInfoEntity extends FastSafeParcelableJsonResponse implements CoverInfo {
            public static final zzd CREATOR = new zzd();
            private static final HashMap<String, Field<?, ?>> zzaHP = new HashMap();
            final int zzCY;
            final Set<Integer> zzaHQ;
            int zzaJm;
            int zzaJn;

            static {
                zzaHP.put("leftImageOffset", Field.zzi("leftImageOffset", 2));
                zzaHP.put("topImageOffset", Field.zzi("topImageOffset", 3));
            }

            public CoverInfoEntity() {
                this.zzCY = 1;
                this.zzaHQ = new HashSet();
            }

            CoverInfoEntity(Set<Integer> indicatorSet, int versionCode, int leftImageOffset, int topImageOffset) {
                this.zzaHQ = indicatorSet;
                this.zzCY = versionCode;
                this.zzaJm = leftImageOffset;
                this.zzaJn = topImageOffset;
            }

            public int describeContents() {
                zzd com_google_android_gms_plus_internal_model_people_zzd = CREATOR;
                return 0;
            }

            public boolean equals(Object obj) {
                if (!(obj instanceof CoverInfoEntity)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                CoverInfoEntity coverInfoEntity = (CoverInfoEntity) obj;
                for (Field field : zzaHP.values()) {
                    if (zza(field)) {
                        if (!coverInfoEntity.zza(field)) {
                            return false;
                        }
                        if (!zzb(field).equals(coverInfoEntity.zzb(field))) {
                            return false;
                        }
                    } else if (coverInfoEntity.zza(field)) {
                        return false;
                    }
                }
                return true;
            }

            public /* synthetic */ Object freeze() {
                return zzxM();
            }

            public int getLeftImageOffset() {
                return this.zzaJm;
            }

            public int getTopImageOffset() {
                return this.zzaJn;
            }

            public boolean hasLeftImageOffset() {
                return this.zzaHQ.contains(Integer.valueOf(2));
            }

            public boolean hasTopImageOffset() {
                return this.zzaHQ.contains(Integer.valueOf(3));
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
                zzd com_google_android_gms_plus_internal_model_people_zzd = CREATOR;
                zzd.zza(this, out, flags);
            }

            protected boolean zza(Field field) {
                return this.zzaHQ.contains(Integer.valueOf(field.zzot()));
            }

            protected Object zzb(Field field) {
                switch (field.zzot()) {
                    case 2:
                        return Integer.valueOf(this.zzaJm);
                    case 3:
                        return Integer.valueOf(this.zzaJn);
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

            public CoverInfoEntity zzxM() {
                return this;
            }
        }

        public static final class CoverPhotoEntity extends FastSafeParcelableJsonResponse implements CoverPhoto {
            public static final zze CREATOR = new zze();
            private static final HashMap<String, Field<?, ?>> zzaHP = new HashMap();
            final int zzCY;
            String zzF;
            final Set<Integer> zzaHQ;
            int zznM;
            int zznN;

            static {
                zzaHP.put("height", Field.zzi("height", 2));
                zzaHP.put("url", Field.zzl("url", 3));
                zzaHP.put("width", Field.zzi("width", 4));
            }

            public CoverPhotoEntity() {
                this.zzCY = 1;
                this.zzaHQ = new HashSet();
            }

            CoverPhotoEntity(Set<Integer> indicatorSet, int versionCode, int height, String url, int width) {
                this.zzaHQ = indicatorSet;
                this.zzCY = versionCode;
                this.zznN = height;
                this.zzF = url;
                this.zznM = width;
            }

            public int describeContents() {
                zze com_google_android_gms_plus_internal_model_people_zze = CREATOR;
                return 0;
            }

            public boolean equals(Object obj) {
                if (!(obj instanceof CoverPhotoEntity)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                CoverPhotoEntity coverPhotoEntity = (CoverPhotoEntity) obj;
                for (Field field : zzaHP.values()) {
                    if (zza(field)) {
                        if (!coverPhotoEntity.zza(field)) {
                            return false;
                        }
                        if (!zzb(field).equals(coverPhotoEntity.zzb(field))) {
                            return false;
                        }
                    } else if (coverPhotoEntity.zza(field)) {
                        return false;
                    }
                }
                return true;
            }

            public /* synthetic */ Object freeze() {
                return zzxN();
            }

            public int getHeight() {
                return this.zznN;
            }

            public String getUrl() {
                return this.zzF;
            }

            public int getWidth() {
                return this.zznM;
            }

            public boolean hasHeight() {
                return this.zzaHQ.contains(Integer.valueOf(2));
            }

            public boolean hasUrl() {
                return this.zzaHQ.contains(Integer.valueOf(3));
            }

            public boolean hasWidth() {
                return this.zzaHQ.contains(Integer.valueOf(4));
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
                zze com_google_android_gms_plus_internal_model_people_zze = CREATOR;
                zze.zza(this, out, flags);
            }

            protected boolean zza(Field field) {
                return this.zzaHQ.contains(Integer.valueOf(field.zzot()));
            }

            protected Object zzb(Field field) {
                switch (field.zzot()) {
                    case 2:
                        return Integer.valueOf(this.zznN);
                    case 3:
                        return this.zzF;
                    case 4:
                        return Integer.valueOf(this.zznM);
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

            public CoverPhotoEntity zzxN() {
                return this;
            }
        }

        static {
            zzaHP.put("coverInfo", Field.zza("coverInfo", 2, CoverInfoEntity.class));
            zzaHP.put("coverPhoto", Field.zza("coverPhoto", 3, CoverPhotoEntity.class));
            zzaHP.put("layout", Field.zza("layout", 4, new StringToIntConverter().zzh("banner", 0), false));
        }

        public CoverEntity() {
            this.zzCY = 1;
            this.zzaHQ = new HashSet();
        }

        CoverEntity(Set<Integer> indicatorSet, int versionCode, CoverInfoEntity coverInfo, CoverPhotoEntity coverPhoto, int layout) {
            this.zzaHQ = indicatorSet;
            this.zzCY = versionCode;
            this.zzaJj = coverInfo;
            this.zzaJk = coverPhoto;
            this.zzaJl = layout;
        }

        public int describeContents() {
            zzc com_google_android_gms_plus_internal_model_people_zzc = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof CoverEntity)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            CoverEntity coverEntity = (CoverEntity) obj;
            for (Field field : zzaHP.values()) {
                if (zza(field)) {
                    if (!coverEntity.zza(field)) {
                        return false;
                    }
                    if (!zzb(field).equals(coverEntity.zzb(field))) {
                        return false;
                    }
                } else if (coverEntity.zza(field)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return zzxL();
        }

        public CoverInfo getCoverInfo() {
            return this.zzaJj;
        }

        public CoverPhoto getCoverPhoto() {
            return this.zzaJk;
        }

        public int getLayout() {
            return this.zzaJl;
        }

        public boolean hasCoverInfo() {
            return this.zzaHQ.contains(Integer.valueOf(2));
        }

        public boolean hasCoverPhoto() {
            return this.zzaHQ.contains(Integer.valueOf(3));
        }

        public boolean hasLayout() {
            return this.zzaHQ.contains(Integer.valueOf(4));
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
            zzc com_google_android_gms_plus_internal_model_people_zzc = CREATOR;
            zzc.zza(this, out, flags);
        }

        protected boolean zza(Field field) {
            return this.zzaHQ.contains(Integer.valueOf(field.zzot()));
        }

        protected Object zzb(Field field) {
            switch (field.zzot()) {
                case 2:
                    return this.zzaJj;
                case 3:
                    return this.zzaJk;
                case 4:
                    return Integer.valueOf(this.zzaJl);
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

        public CoverEntity zzxL() {
            return this;
        }
    }

    public static final class ImageEntity extends FastSafeParcelableJsonResponse implements Image {
        public static final zzf CREATOR = new zzf();
        private static final HashMap<String, Field<?, ?>> zzaHP = new HashMap();
        final int zzCY;
        String zzF;
        final Set<Integer> zzaHQ;

        static {
            zzaHP.put("url", Field.zzl("url", 2));
        }

        public ImageEntity() {
            this.zzCY = 1;
            this.zzaHQ = new HashSet();
        }

        public ImageEntity(String url) {
            this.zzaHQ = new HashSet();
            this.zzCY = 1;
            this.zzF = url;
            this.zzaHQ.add(Integer.valueOf(2));
        }

        ImageEntity(Set<Integer> indicatorSet, int versionCode, String url) {
            this.zzaHQ = indicatorSet;
            this.zzCY = versionCode;
            this.zzF = url;
        }

        public int describeContents() {
            zzf com_google_android_gms_plus_internal_model_people_zzf = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ImageEntity)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            ImageEntity imageEntity = (ImageEntity) obj;
            for (Field field : zzaHP.values()) {
                if (zza(field)) {
                    if (!imageEntity.zza(field)) {
                        return false;
                    }
                    if (!zzb(field).equals(imageEntity.zzb(field))) {
                        return false;
                    }
                } else if (imageEntity.zza(field)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return zzxO();
        }

        public String getUrl() {
            return this.zzF;
        }

        public boolean hasUrl() {
            return this.zzaHQ.contains(Integer.valueOf(2));
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
            zzf com_google_android_gms_plus_internal_model_people_zzf = CREATOR;
            zzf.zza(this, out, flags);
        }

        protected boolean zza(Field field) {
            return this.zzaHQ.contains(Integer.valueOf(field.zzot()));
        }

        protected Object zzb(Field field) {
            switch (field.zzot()) {
                case 2:
                    return this.zzF;
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

        public ImageEntity zzxO() {
            return this;
        }
    }

    public static final class NameEntity extends FastSafeParcelableJsonResponse implements Name {
        public static final zzg CREATOR = new zzg();
        private static final HashMap<String, Field<?, ?>> zzaHP = new HashMap();
        final int zzCY;
        final Set<Integer> zzaHQ;
        String zzaIo;
        String zzaIr;
        String zzaJo;
        String zzaJp;
        String zzaJq;
        String zzaJr;

        static {
            zzaHP.put("familyName", Field.zzl("familyName", 2));
            zzaHP.put("formatted", Field.zzl("formatted", 3));
            zzaHP.put("givenName", Field.zzl("givenName", 4));
            zzaHP.put("honorificPrefix", Field.zzl("honorificPrefix", 5));
            zzaHP.put("honorificSuffix", Field.zzl("honorificSuffix", 6));
            zzaHP.put("middleName", Field.zzl("middleName", 7));
        }

        public NameEntity() {
            this.zzCY = 1;
            this.zzaHQ = new HashSet();
        }

        NameEntity(Set<Integer> indicatorSet, int versionCode, String familyName, String formatted, String givenName, String honorificPrefix, String honorificSuffix, String middleName) {
            this.zzaHQ = indicatorSet;
            this.zzCY = versionCode;
            this.zzaIo = familyName;
            this.zzaJo = formatted;
            this.zzaIr = givenName;
            this.zzaJp = honorificPrefix;
            this.zzaJq = honorificSuffix;
            this.zzaJr = middleName;
        }

        public int describeContents() {
            zzg com_google_android_gms_plus_internal_model_people_zzg = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof NameEntity)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            NameEntity nameEntity = (NameEntity) obj;
            for (Field field : zzaHP.values()) {
                if (zza(field)) {
                    if (!nameEntity.zza(field)) {
                        return false;
                    }
                    if (!zzb(field).equals(nameEntity.zzb(field))) {
                        return false;
                    }
                } else if (nameEntity.zza(field)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return zzxP();
        }

        public String getFamilyName() {
            return this.zzaIo;
        }

        public String getFormatted() {
            return this.zzaJo;
        }

        public String getGivenName() {
            return this.zzaIr;
        }

        public String getHonorificPrefix() {
            return this.zzaJp;
        }

        public String getHonorificSuffix() {
            return this.zzaJq;
        }

        public String getMiddleName() {
            return this.zzaJr;
        }

        public boolean hasFamilyName() {
            return this.zzaHQ.contains(Integer.valueOf(2));
        }

        public boolean hasFormatted() {
            return this.zzaHQ.contains(Integer.valueOf(3));
        }

        public boolean hasGivenName() {
            return this.zzaHQ.contains(Integer.valueOf(4));
        }

        public boolean hasHonorificPrefix() {
            return this.zzaHQ.contains(Integer.valueOf(5));
        }

        public boolean hasHonorificSuffix() {
            return this.zzaHQ.contains(Integer.valueOf(6));
        }

        public boolean hasMiddleName() {
            return this.zzaHQ.contains(Integer.valueOf(7));
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
            zzg com_google_android_gms_plus_internal_model_people_zzg = CREATOR;
            zzg.zza(this, out, flags);
        }

        protected boolean zza(Field field) {
            return this.zzaHQ.contains(Integer.valueOf(field.zzot()));
        }

        protected Object zzb(Field field) {
            switch (field.zzot()) {
                case 2:
                    return this.zzaIo;
                case 3:
                    return this.zzaJo;
                case 4:
                    return this.zzaIr;
                case 5:
                    return this.zzaJp;
                case 6:
                    return this.zzaJq;
                case 7:
                    return this.zzaJr;
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

        public NameEntity zzxP() {
            return this;
        }
    }

    public static final class OrganizationsEntity extends FastSafeParcelableJsonResponse implements Organizations {
        public static final zzh CREATOR = new zzh();
        private static final HashMap<String, Field<?, ?>> zzaHP = new HashMap();
        String mName;
        final int zzCY;
        int zzSq;
        final Set<Integer> zzaHQ;
        String zzaID;
        String zzaIn;
        String zzaJs;
        String zzaJt;
        boolean zzaJu;
        String zzadv;
        String zzakM;

        static {
            zzaHP.put("department", Field.zzl("department", 2));
            zzaHP.put("description", Field.zzl("description", 3));
            zzaHP.put("endDate", Field.zzl("endDate", 4));
            zzaHP.put("location", Field.zzl("location", 5));
            zzaHP.put("name", Field.zzl("name", 6));
            zzaHP.put("primary", Field.zzk("primary", 7));
            zzaHP.put("startDate", Field.zzl("startDate", 8));
            zzaHP.put("title", Field.zzl("title", 9));
            zzaHP.put("type", Field.zza("type", 10, new StringToIntConverter().zzh("work", 0).zzh("school", 1), false));
        }

        public OrganizationsEntity() {
            this.zzCY = 1;
            this.zzaHQ = new HashSet();
        }

        OrganizationsEntity(Set<Integer> indicatorSet, int versionCode, String department, String description, String endDate, String location, String name, boolean primary, String startDate, String title, int type) {
            this.zzaHQ = indicatorSet;
            this.zzCY = versionCode;
            this.zzaJs = department;
            this.zzakM = description;
            this.zzaIn = endDate;
            this.zzaJt = location;
            this.mName = name;
            this.zzaJu = primary;
            this.zzaID = startDate;
            this.zzadv = title;
            this.zzSq = type;
        }

        public int describeContents() {
            zzh com_google_android_gms_plus_internal_model_people_zzh = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof OrganizationsEntity)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            OrganizationsEntity organizationsEntity = (OrganizationsEntity) obj;
            for (Field field : zzaHP.values()) {
                if (zza(field)) {
                    if (!organizationsEntity.zza(field)) {
                        return false;
                    }
                    if (!zzb(field).equals(organizationsEntity.zzb(field))) {
                        return false;
                    }
                } else if (organizationsEntity.zza(field)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return zzxQ();
        }

        public String getDepartment() {
            return this.zzaJs;
        }

        public String getDescription() {
            return this.zzakM;
        }

        public String getEndDate() {
            return this.zzaIn;
        }

        public String getLocation() {
            return this.zzaJt;
        }

        public String getName() {
            return this.mName;
        }

        public String getStartDate() {
            return this.zzaID;
        }

        public String getTitle() {
            return this.zzadv;
        }

        public int getType() {
            return this.zzSq;
        }

        public boolean hasDepartment() {
            return this.zzaHQ.contains(Integer.valueOf(2));
        }

        public boolean hasDescription() {
            return this.zzaHQ.contains(Integer.valueOf(3));
        }

        public boolean hasEndDate() {
            return this.zzaHQ.contains(Integer.valueOf(4));
        }

        public boolean hasLocation() {
            return this.zzaHQ.contains(Integer.valueOf(5));
        }

        public boolean hasName() {
            return this.zzaHQ.contains(Integer.valueOf(6));
        }

        public boolean hasPrimary() {
            return this.zzaHQ.contains(Integer.valueOf(7));
        }

        public boolean hasStartDate() {
            return this.zzaHQ.contains(Integer.valueOf(8));
        }

        public boolean hasTitle() {
            return this.zzaHQ.contains(Integer.valueOf(9));
        }

        public boolean hasType() {
            return this.zzaHQ.contains(Integer.valueOf(10));
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

        public boolean isPrimary() {
            return this.zzaJu;
        }

        public void writeToParcel(Parcel out, int flags) {
            zzh com_google_android_gms_plus_internal_model_people_zzh = CREATOR;
            zzh.zza(this, out, flags);
        }

        protected boolean zza(Field field) {
            return this.zzaHQ.contains(Integer.valueOf(field.zzot()));
        }

        protected Object zzb(Field field) {
            switch (field.zzot()) {
                case 2:
                    return this.zzaJs;
                case 3:
                    return this.zzakM;
                case 4:
                    return this.zzaIn;
                case 5:
                    return this.zzaJt;
                case 6:
                    return this.mName;
                case 7:
                    return Boolean.valueOf(this.zzaJu);
                case 8:
                    return this.zzaID;
                case 9:
                    return this.zzadv;
                case 10:
                    return Integer.valueOf(this.zzSq);
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

        public OrganizationsEntity zzxQ() {
            return this;
        }
    }

    public static final class PlacesLivedEntity extends FastSafeParcelableJsonResponse implements PlacesLived {
        public static final zzi CREATOR = new zzi();
        private static final HashMap<String, Field<?, ?>> zzaHP = new HashMap();
        String mValue;
        final int zzCY;
        final Set<Integer> zzaHQ;
        boolean zzaJu;

        static {
            zzaHP.put("primary", Field.zzk("primary", 2));
            zzaHP.put("value", Field.zzl("value", 3));
        }

        public PlacesLivedEntity() {
            this.zzCY = 1;
            this.zzaHQ = new HashSet();
        }

        PlacesLivedEntity(Set<Integer> indicatorSet, int versionCode, boolean primary, String value) {
            this.zzaHQ = indicatorSet;
            this.zzCY = versionCode;
            this.zzaJu = primary;
            this.mValue = value;
        }

        public int describeContents() {
            zzi com_google_android_gms_plus_internal_model_people_zzi = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof PlacesLivedEntity)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            PlacesLivedEntity placesLivedEntity = (PlacesLivedEntity) obj;
            for (Field field : zzaHP.values()) {
                if (zza(field)) {
                    if (!placesLivedEntity.zza(field)) {
                        return false;
                    }
                    if (!zzb(field).equals(placesLivedEntity.zzb(field))) {
                        return false;
                    }
                } else if (placesLivedEntity.zza(field)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return zzxR();
        }

        public String getValue() {
            return this.mValue;
        }

        public boolean hasPrimary() {
            return this.zzaHQ.contains(Integer.valueOf(2));
        }

        public boolean hasValue() {
            return this.zzaHQ.contains(Integer.valueOf(3));
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

        public boolean isPrimary() {
            return this.zzaJu;
        }

        public void writeToParcel(Parcel out, int flags) {
            zzi com_google_android_gms_plus_internal_model_people_zzi = CREATOR;
            zzi.zza(this, out, flags);
        }

        protected boolean zza(Field field) {
            return this.zzaHQ.contains(Integer.valueOf(field.zzot()));
        }

        protected Object zzb(Field field) {
            switch (field.zzot()) {
                case 2:
                    return Boolean.valueOf(this.zzaJu);
                case 3:
                    return this.mValue;
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

        public PlacesLivedEntity zzxR() {
            return this;
        }
    }

    public static final class UrlsEntity extends FastSafeParcelableJsonResponse implements Urls {
        public static final zzj CREATOR = new zzj();
        private static final HashMap<String, Field<?, ?>> zzaHP = new HashMap();
        String mValue;
        final int zzCY;
        int zzSq;
        String zzaEH;
        final Set<Integer> zzaHQ;
        private final int zzaJv;

        static {
            zzaHP.put(PlusShare.KEY_CALL_TO_ACTION_LABEL, Field.zzl(PlusShare.KEY_CALL_TO_ACTION_LABEL, 5));
            zzaHP.put("type", Field.zza("type", 6, new StringToIntConverter().zzh("home", 0).zzh("work", 1).zzh("blog", 2).zzh(Scopes.PROFILE, 3).zzh(FitnessActivities.OTHER, 4).zzh("otherProfile", 5).zzh("contributor", 6).zzh("website", 7), false));
            zzaHP.put("value", Field.zzl("value", 4));
        }

        public UrlsEntity() {
            this.zzaJv = 4;
            this.zzCY = 1;
            this.zzaHQ = new HashSet();
        }

        UrlsEntity(Set<Integer> indicatorSet, int versionCode, String label, int type, String value, int type_DEPRECATED_FENACHO) {
            this.zzaJv = 4;
            this.zzaHQ = indicatorSet;
            this.zzCY = versionCode;
            this.zzaEH = label;
            this.zzSq = type;
            this.mValue = value;
        }

        public int describeContents() {
            zzj com_google_android_gms_plus_internal_model_people_zzj = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof UrlsEntity)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            UrlsEntity urlsEntity = (UrlsEntity) obj;
            for (Field field : zzaHP.values()) {
                if (zza(field)) {
                    if (!urlsEntity.zza(field)) {
                        return false;
                    }
                    if (!zzb(field).equals(urlsEntity.zzb(field))) {
                        return false;
                    }
                } else if (urlsEntity.zza(field)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return zzxT();
        }

        public String getLabel() {
            return this.zzaEH;
        }

        public int getType() {
            return this.zzSq;
        }

        public String getValue() {
            return this.mValue;
        }

        public boolean hasLabel() {
            return this.zzaHQ.contains(Integer.valueOf(5));
        }

        public boolean hasType() {
            return this.zzaHQ.contains(Integer.valueOf(6));
        }

        public boolean hasValue() {
            return this.zzaHQ.contains(Integer.valueOf(4));
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
            zzj com_google_android_gms_plus_internal_model_people_zzj = CREATOR;
            zzj.zza(this, out, flags);
        }

        protected boolean zza(Field field) {
            return this.zzaHQ.contains(Integer.valueOf(field.zzot()));
        }

        protected Object zzb(Field field) {
            switch (field.zzot()) {
                case 4:
                    return this.mValue;
                case 5:
                    return this.zzaEH;
                case 6:
                    return Integer.valueOf(this.zzSq);
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

        @Deprecated
        public int zzxS() {
            return 4;
        }

        public UrlsEntity zzxT() {
            return this;
        }
    }

    public static class zza {
        public static int zzdY(String str) {
            if (str.equals("person")) {
                return 0;
            }
            if (str.equals("page")) {
                return 1;
            }
            throw new IllegalArgumentException("Unknown objectType string: " + str);
        }
    }

    static {
        zzaHP.put("aboutMe", Field.zzl("aboutMe", 2));
        zzaHP.put("ageRange", Field.zza("ageRange", 3, AgeRangeEntity.class));
        zzaHP.put("birthday", Field.zzl("birthday", 4));
        zzaHP.put("braggingRights", Field.zzl("braggingRights", 5));
        zzaHP.put("circledByCount", Field.zzi("circledByCount", 6));
        zzaHP.put("cover", Field.zza("cover", 7, CoverEntity.class));
        zzaHP.put("currentLocation", Field.zzl("currentLocation", 8));
        zzaHP.put("displayName", Field.zzl("displayName", 9));
        zzaHP.put("gender", Field.zza("gender", 12, new StringToIntConverter().zzh("male", 0).zzh("female", 1).zzh(FitnessActivities.OTHER, 2), false));
        zzaHP.put("id", Field.zzl("id", 14));
        zzaHP.put("image", Field.zza("image", 15, ImageEntity.class));
        zzaHP.put("isPlusUser", Field.zzk("isPlusUser", 16));
        zzaHP.put("language", Field.zzl("language", 18));
        zzaHP.put("name", Field.zza("name", 19, NameEntity.class));
        zzaHP.put("nickname", Field.zzl("nickname", 20));
        zzaHP.put("objectType", Field.zza("objectType", 21, new StringToIntConverter().zzh("person", 0).zzh("page", 1), false));
        zzaHP.put("organizations", Field.zzb("organizations", 22, OrganizationsEntity.class));
        zzaHP.put("placesLived", Field.zzb("placesLived", 23, PlacesLivedEntity.class));
        zzaHP.put("plusOneCount", Field.zzi("plusOneCount", 24));
        zzaHP.put("relationshipStatus", Field.zza("relationshipStatus", 25, new StringToIntConverter().zzh("single", 0).zzh("in_a_relationship", 1).zzh("engaged", 2).zzh("married", 3).zzh("its_complicated", 4).zzh("open_relationship", 5).zzh("widowed", 6).zzh("in_domestic_partnership", 7).zzh("in_civil_union", 8), false));
        zzaHP.put("tagline", Field.zzl("tagline", 26));
        zzaHP.put("url", Field.zzl("url", 27));
        zzaHP.put("urls", Field.zzb("urls", 28, UrlsEntity.class));
        zzaHP.put("verified", Field.zzk("verified", 29));
    }

    public PersonEntity() {
        this.zzCY = 1;
        this.zzaHQ = new HashSet();
    }

    public PersonEntity(String displayName, String id, ImageEntity image, int objectType, String url) {
        this.zzCY = 1;
        this.zzaHQ = new HashSet();
        this.zzadI = displayName;
        this.zzaHQ.add(Integer.valueOf(9));
        this.zzKI = id;
        this.zzaHQ.add(Integer.valueOf(14));
        this.zzaIV = image;
        this.zzaHQ.add(Integer.valueOf(15));
        this.zzaIZ = objectType;
        this.zzaHQ.add(Integer.valueOf(21));
        this.zzF = url;
        this.zzaHQ.add(Integer.valueOf(27));
    }

    PersonEntity(Set<Integer> indicatorSet, int versionCode, String aboutMe, AgeRangeEntity ageRange, String birthday, String braggingRights, int circledByCount, CoverEntity cover, String currentLocation, String displayName, int gender, String id, ImageEntity image, boolean isPlusUser, String language, NameEntity name, String nickname, int objectType, List<OrganizationsEntity> organizations, List<PlacesLivedEntity> placesLived, int plusOneCount, int relationshipStatus, String tagline, String url, List<UrlsEntity> urls, boolean verified) {
        this.zzaHQ = indicatorSet;
        this.zzCY = versionCode;
        this.zzaIO = aboutMe;
        this.zzaIP = ageRange;
        this.zzaIQ = birthday;
        this.zzaIR = braggingRights;
        this.zzaIS = circledByCount;
        this.zzaIT = cover;
        this.zzaIU = currentLocation;
        this.zzadI = displayName;
        this.zzsC = gender;
        this.zzKI = id;
        this.zzaIV = image;
        this.zzaIW = isPlusUser;
        this.zzRA = language;
        this.zzaIX = name;
        this.zzaIY = nickname;
        this.zzaIZ = objectType;
        this.zzaJa = organizations;
        this.zzaJb = placesLived;
        this.zzaJc = plusOneCount;
        this.zzaJd = relationshipStatus;
        this.zzaJe = tagline;
        this.zzF = url;
        this.zzaJf = urls;
        this.zzaJg = verified;
    }

    public static PersonEntity zzp(byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        PersonEntity zzfM = CREATOR.zzfM(obtain);
        obtain.recycle();
        return zzfM;
    }

    public int describeContents() {
        zza com_google_android_gms_plus_internal_model_people_zza = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PersonEntity)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        PersonEntity personEntity = (PersonEntity) obj;
        for (Field field : zzaHP.values()) {
            if (zza(field)) {
                if (!personEntity.zza(field)) {
                    return false;
                }
                if (!zzb(field).equals(personEntity.zzb(field))) {
                    return false;
                }
            } else if (personEntity.zza(field)) {
                return false;
            }
        }
        return true;
    }

    public /* synthetic */ Object freeze() {
        return zzxJ();
    }

    public String getAboutMe() {
        return this.zzaIO;
    }

    public AgeRange getAgeRange() {
        return this.zzaIP;
    }

    public String getBirthday() {
        return this.zzaIQ;
    }

    public String getBraggingRights() {
        return this.zzaIR;
    }

    public int getCircledByCount() {
        return this.zzaIS;
    }

    public Cover getCover() {
        return this.zzaIT;
    }

    public String getCurrentLocation() {
        return this.zzaIU;
    }

    public String getDisplayName() {
        return this.zzadI;
    }

    public int getGender() {
        return this.zzsC;
    }

    public String getId() {
        return this.zzKI;
    }

    public Image getImage() {
        return this.zzaIV;
    }

    public String getLanguage() {
        return this.zzRA;
    }

    public Name getName() {
        return this.zzaIX;
    }

    public String getNickname() {
        return this.zzaIY;
    }

    public int getObjectType() {
        return this.zzaIZ;
    }

    public List<Organizations> getOrganizations() {
        return (ArrayList) this.zzaJa;
    }

    public List<PlacesLived> getPlacesLived() {
        return (ArrayList) this.zzaJb;
    }

    public int getPlusOneCount() {
        return this.zzaJc;
    }

    public int getRelationshipStatus() {
        return this.zzaJd;
    }

    public String getTagline() {
        return this.zzaJe;
    }

    public String getUrl() {
        return this.zzF;
    }

    public List<Urls> getUrls() {
        return (ArrayList) this.zzaJf;
    }

    public boolean hasAboutMe() {
        return this.zzaHQ.contains(Integer.valueOf(2));
    }

    public boolean hasAgeRange() {
        return this.zzaHQ.contains(Integer.valueOf(3));
    }

    public boolean hasBirthday() {
        return this.zzaHQ.contains(Integer.valueOf(4));
    }

    public boolean hasBraggingRights() {
        return this.zzaHQ.contains(Integer.valueOf(5));
    }

    public boolean hasCircledByCount() {
        return this.zzaHQ.contains(Integer.valueOf(6));
    }

    public boolean hasCover() {
        return this.zzaHQ.contains(Integer.valueOf(7));
    }

    public boolean hasCurrentLocation() {
        return this.zzaHQ.contains(Integer.valueOf(8));
    }

    public boolean hasDisplayName() {
        return this.zzaHQ.contains(Integer.valueOf(9));
    }

    public boolean hasGender() {
        return this.zzaHQ.contains(Integer.valueOf(12));
    }

    public boolean hasId() {
        return this.zzaHQ.contains(Integer.valueOf(14));
    }

    public boolean hasImage() {
        return this.zzaHQ.contains(Integer.valueOf(15));
    }

    public boolean hasIsPlusUser() {
        return this.zzaHQ.contains(Integer.valueOf(16));
    }

    public boolean hasLanguage() {
        return this.zzaHQ.contains(Integer.valueOf(18));
    }

    public boolean hasName() {
        return this.zzaHQ.contains(Integer.valueOf(19));
    }

    public boolean hasNickname() {
        return this.zzaHQ.contains(Integer.valueOf(20));
    }

    public boolean hasObjectType() {
        return this.zzaHQ.contains(Integer.valueOf(21));
    }

    public boolean hasOrganizations() {
        return this.zzaHQ.contains(Integer.valueOf(22));
    }

    public boolean hasPlacesLived() {
        return this.zzaHQ.contains(Integer.valueOf(23));
    }

    public boolean hasPlusOneCount() {
        return this.zzaHQ.contains(Integer.valueOf(24));
    }

    public boolean hasRelationshipStatus() {
        return this.zzaHQ.contains(Integer.valueOf(25));
    }

    public boolean hasTagline() {
        return this.zzaHQ.contains(Integer.valueOf(26));
    }

    public boolean hasUrl() {
        return this.zzaHQ.contains(Integer.valueOf(27));
    }

    public boolean hasUrls() {
        return this.zzaHQ.contains(Integer.valueOf(28));
    }

    public boolean hasVerified() {
        return this.zzaHQ.contains(Integer.valueOf(29));
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

    public boolean isPlusUser() {
        return this.zzaIW;
    }

    public boolean isVerified() {
        return this.zzaJg;
    }

    public void writeToParcel(Parcel out, int flags) {
        zza com_google_android_gms_plus_internal_model_people_zza = CREATOR;
        zza.zza(this, out, flags);
    }

    protected boolean zza(Field field) {
        return this.zzaHQ.contains(Integer.valueOf(field.zzot()));
    }

    protected Object zzb(Field field) {
        switch (field.zzot()) {
            case 2:
                return this.zzaIO;
            case 3:
                return this.zzaIP;
            case 4:
                return this.zzaIQ;
            case 5:
                return this.zzaIR;
            case 6:
                return Integer.valueOf(this.zzaIS);
            case 7:
                return this.zzaIT;
            case 8:
                return this.zzaIU;
            case 9:
                return this.zzadI;
            case 12:
                return Integer.valueOf(this.zzsC);
            case 14:
                return this.zzKI;
            case 15:
                return this.zzaIV;
            case 16:
                return Boolean.valueOf(this.zzaIW);
            case 18:
                return this.zzRA;
            case 19:
                return this.zzaIX;
            case Place.TYPE_CAR_WASH /*20*/:
                return this.zzaIY;
            case Place.TYPE_CASINO /*21*/:
                return Integer.valueOf(this.zzaIZ);
            case Place.TYPE_CEMETERY /*22*/:
                return this.zzaJa;
            case Place.TYPE_CHURCH /*23*/:
                return this.zzaJb;
            case Place.TYPE_CITY_HALL /*24*/:
                return Integer.valueOf(this.zzaJc);
            case Place.TYPE_CLOTHING_STORE /*25*/:
                return Integer.valueOf(this.zzaJd);
            case Place.TYPE_CONVENIENCE_STORE /*26*/:
                return this.zzaJe;
            case Place.TYPE_COURTHOUSE /*27*/:
                return this.zzF;
            case Place.TYPE_DENTIST /*28*/:
                return this.zzaJf;
            case Place.TYPE_DEPARTMENT_STORE /*29*/:
                return Boolean.valueOf(this.zzaJg);
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

    public PersonEntity zzxJ() {
        return this;
    }
}
