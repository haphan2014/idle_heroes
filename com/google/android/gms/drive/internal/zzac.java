package com.google.android.gms.drive.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Pair;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.ChangeListener;
import com.google.android.gms.drive.events.ChangesAvailableEvent;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.events.CompletionListener;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.events.ProgressEvent;
import com.google.android.gms.drive.events.QueryResultEventParcelable;
import com.google.android.gms.drive.events.zzc;
import com.google.android.gms.drive.events.zzf;
import com.google.android.gms.drive.events.zzi;
import com.google.android.gms.drive.events.zzj;
import com.google.android.gms.drive.events.zzl;
import java.util.ArrayList;
import java.util.List;

public class zzac extends com.google.android.gms.drive.internal.zzam.zza {
    private final int zzaca;
    private final zzf zzafC;
    private final zza zzafD;
    private final List<Integer> zzafE = new ArrayList();

    private static class zza extends Handler {
        private final Context mContext;

        private zza(Looper looper, Context context) {
            super(looper);
            this.mContext = context;
        }

        private static void zza(zzl com_google_android_gms_drive_events_zzl, QueryResultEventParcelable queryResultEventParcelable) {
            DataHolder zzpx = queryResultEventParcelable.zzpx();
            if (zzpx != null) {
                final MetadataBuffer metadataBuffer = new MetadataBuffer(zzpx);
                com_google_android_gms_drive_events_zzl.zza(new zzj() {
                });
            }
            if (queryResultEventParcelable.zzpy()) {
                com_google_android_gms_drive_events_zzl.zzck(queryResultEventParcelable.zzpz());
            }
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    Pair pair = (Pair) msg.obj;
                    zzf com_google_android_gms_drive_events_zzf = (zzf) pair.first;
                    DriveEvent driveEvent = (DriveEvent) pair.second;
                    switch (driveEvent.getType()) {
                        case 1:
                            ((ChangeListener) com_google_android_gms_drive_events_zzf).onChange((ChangeEvent) driveEvent);
                            return;
                        case 2:
                            ((CompletionListener) com_google_android_gms_drive_events_zzf).onCompletion((CompletionEvent) driveEvent);
                            return;
                        case 3:
                            zza((zzl) com_google_android_gms_drive_events_zzf, (QueryResultEventParcelable) driveEvent);
                            return;
                        case 4:
                            ((zzc) com_google_android_gms_drive_events_zzf).zza((ChangesAvailableEvent) driveEvent);
                            return;
                        case 5:
                        case 6:
                            ((zzi) com_google_android_gms_drive_events_zzf).zza((ProgressEvent) driveEvent);
                            return;
                        default:
                            zzx.zzu("EventCallback", "Unexpected event: " + driveEvent);
                            return;
                    }
                default:
                    zzx.zze(this.mContext, "EventCallback", "Don't know how to handle this event");
                    return;
            }
        }

        public void zza(zzf com_google_android_gms_drive_events_zzf, DriveEvent driveEvent) {
            sendMessage(obtainMessage(1, new Pair(com_google_android_gms_drive_events_zzf, driveEvent)));
        }
    }

    public zzac(Looper looper, Context context, int i, zzf com_google_android_gms_drive_events_zzf) {
        this.zzaca = i;
        this.zzafC = com_google_android_gms_drive_events_zzf;
        this.zzafD = new zza(looper, context);
    }

    public void zzc(OnEventResponse onEventResponse) throws RemoteException {
        DriveEvent zzpO = onEventResponse.zzpO();
        zzu.zzU(this.zzaca == zzpO.getType());
        zzu.zzU(this.zzafE.contains(Integer.valueOf(zzpO.getType())));
        this.zzafD.zza(this.zzafC, zzpO);
    }

    public void zzcA(int i) {
        this.zzafE.add(Integer.valueOf(i));
    }

    public boolean zzcB(int i) {
        return this.zzafE.contains(Integer.valueOf(i));
    }
}
