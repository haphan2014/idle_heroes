package com.google.android.gms.fitness;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.result.DailyTotalResult;
import com.google.android.gms.fitness.result.DataReadResult;
import java.util.concurrent.TimeUnit;

public interface HistoryApi {

    public static class ViewIntentBuilder {
        private final Context mContext;
        private long zzKT;
        private final DataType zzajF;
        private DataSource zzajG;
        private long zzajH;
        private String zzajI;

        public ViewIntentBuilder(Context context, DataType dataType) {
            this.mContext = context;
            this.zzajF = dataType;
        }

        private Intent zzj(Intent intent) {
            if (this.zzajI == null) {
                return intent;
            }
            Intent intent2 = new Intent(intent).setPackage(this.zzajI);
            ResolveInfo resolveActivity = this.mContext.getPackageManager().resolveActivity(intent2, 0);
            if (resolveActivity == null) {
                return intent;
            }
            intent2.setComponent(new ComponentName(this.zzajI, resolveActivity.activityInfo.name));
            return intent2;
        }

        public Intent build() {
            boolean z = true;
            zzu.zza(this.zzKT > 0, (Object) "Start time must be set");
            if (this.zzajH <= this.zzKT) {
                z = false;
            }
            zzu.zza(z, (Object) "End time must be set and after start time");
            Intent intent = new Intent(Fitness.ACTION_VIEW);
            intent.setType(DataType.getMimeType(this.zzajG.getDataType()));
            intent.putExtra(Fitness.EXTRA_START_TIME, this.zzKT);
            intent.putExtra(Fitness.EXTRA_END_TIME, this.zzajH);
            zzc.zza(this.zzajG, intent, DataSource.EXTRA_DATA_SOURCE);
            return zzj(intent);
        }

        public ViewIntentBuilder setDataSource(DataSource dataSource) {
            zzu.zzb(dataSource.getDataType().equals(this.zzajF), "Data source %s is not for the data type %s", dataSource, this.zzajF);
            this.zzajG = dataSource;
            return this;
        }

        public ViewIntentBuilder setPreferredApplication(String packageName) {
            this.zzajI = packageName;
            return this;
        }

        public ViewIntentBuilder setTimeInterval(long start, long end, TimeUnit timeUnit) {
            this.zzKT = timeUnit.toMillis(start);
            this.zzajH = timeUnit.toMillis(end);
            return this;
        }
    }

    PendingResult<Status> deleteData(GoogleApiClient googleApiClient, DataDeleteRequest dataDeleteRequest);

    PendingResult<Status> insertData(GoogleApiClient googleApiClient, DataSet dataSet);

    PendingResult<DailyTotalResult> readDailyTotal(GoogleApiClient googleApiClient, DataType dataType);

    PendingResult<DataReadResult> readData(GoogleApiClient googleApiClient, DataReadRequest dataReadRequest);
}
