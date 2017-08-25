package com.vungle.publisher;

import android.database.Cursor;
import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.tagmanager.DataLayer;
import com.vungle.publisher.eo.C1749a;
import java.util.HashMap;
import java.util.Map;

/* compiled from: vungle */
public abstract class jw extends eo {

    /* compiled from: vungle */
    static abstract class C1766b<R extends adq> extends C1749a<jw, aec, R> {
        C1766b() {
        }

        final /* synthetic */ Map mo4468a(String str, aeb com_vungle_publisher_aeb) {
            aec com_vungle_publisher_aec = (aec) com_vungle_publisher_aeb;
            if (com_vungle_publisher_aec == null) {
                return null;
            }
            Map hashMap = new HashMap();
            m1632a(str, hashMap, C1798a.error, com_vungle_publisher_aec.m1126g());
            m1632a(str, hashMap, C1798a.mute, com_vungle_publisher_aec.m1127h());
            abp[] j = com_vungle_publisher_aec.m1129j();
            if (j != null && j.length > 0) {
                for (abp com_vungle_publisher_abp : j) {
                    Float f = com_vungle_publisher_abp.f947a;
                    if (f != null) {
                        jt jtVar;
                        float floatValue = f.floatValue();
                        if (floatValue == 0.0f) {
                            jtVar = C1798a.play_percentage_0;
                        } else if (((double) floatValue) == 0.25d) {
                            jtVar = C1798a.play_percentage_25;
                        } else if (((double) floatValue) == 0.5d) {
                            jtVar = C1798a.play_percentage_50;
                        } else if (((double) floatValue) == 0.75d) {
                            jtVar = C1798a.play_percentage_75;
                        } else if (floatValue == TextTrackStyle.DEFAULT_FONT_SCALE) {
                            jtVar = C1798a.play_percentage_100;
                        } else {
                            so.m2470a(5, "VungleDatabase", "invalid play percent: " + floatValue, null);
                            jtVar = null;
                        }
                        if (jtVar != null) {
                            m1632a(str, hashMap, jtVar, com_vungle_publisher_abp.f948b);
                        }
                    }
                }
            }
            m1632a(str, hashMap, C1798a.postroll_click, com_vungle_publisher_aec.m1123c());
            m1632a(str, hashMap, C1798a.postroll_view, com_vungle_publisher_aec.m1130k());
            m1632a(str, hashMap, C1798a.video_click, com_vungle_publisher_aec.m1124e());
            m1632a(str, hashMap, C1798a.video_close, com_vungle_publisher_aec.m1125f());
            m1632a(str, hashMap, C1798a.video_pause, com_vungle_publisher_aec.m1128i());
            m1632a(str, hashMap, C1798a.video_resume, com_vungle_publisher_aec.m1131l());
            m1632a(str, hashMap, C1798a.unmute, com_vungle_publisher_aec.m1132m());
            return hashMap;
        }

        private jw m1779a(jw jwVar, Cursor cursor, boolean z) {
            super.mo4467a(jwVar, cursor, z);
            jwVar.c = (jt) cm.m1254a(cursor, DataLayer.EVENT_KEY, C1798a.class);
            return jwVar;
        }

        protected final /* bridge */ /* synthetic */ dw[] mo4396a(int i) {
            return new jw[i];
        }
    }

    /* compiled from: vungle */
    public enum C1798a implements jt {
        error,
        mute,
        play_percentage_0((String) 0.0f),
        play_percentage_25((String) 0.25f),
        play_percentage_50((String) 0.5f),
        play_percentage_75((String) 0.75f),
        play_percentage_80((String) 0.8f),
        play_percentage_100((String) 0.99f),
        postroll_click((String) (byte) 0),
        postroll_view,
        unmute,
        video_click((String) (byte) 0),
        video_close,
        video_pause,
        video_resume;
        
        public final float f2307p;
        private final boolean f2308q;

        private C1798a(float f) {
            this(r2, r3, f, false);
        }

        private C1798a(byte b) {
            this(r3, r4, GroundOverlayOptions.NO_DIMENSION, true);
        }

        private C1798a(float f, boolean z) {
            this.f2307p = f;
            this.f2308q = z;
        }

        public final boolean mo4482a() {
            return this.f2308q;
        }
    }

    protected jw() {
    }
}
