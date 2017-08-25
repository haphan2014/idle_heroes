package com.google.android.gms.wearable.internal;

import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.ParcelFileDescriptor.AutoCloseOutputStream;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.CapabilityApi.AddLocalCapabilityResult;
import com.google.android.gms.wearable.CapabilityApi.GetAllCapabilitiesResult;
import com.google.android.gms.wearable.CapabilityApi.GetCapabilityResult;
import com.google.android.gms.wearable.CapabilityApi.RemoveLocalCapabilityResult;
import com.google.android.gms.wearable.CapabilityInfo;
import com.google.android.gms.wearable.Channel.GetInputStreamResult;
import com.google.android.gms.wearable.Channel.GetOutputStreamResult;
import com.google.android.gms.wearable.ChannelApi.OpenChannelResult;
import com.google.android.gms.wearable.DataApi.DataItemResult;
import com.google.android.gms.wearable.DataApi.DeleteDataItemsResult;
import com.google.android.gms.wearable.DataApi.GetFdForAssetResult;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.MessageApi.SendMessageResult;
import com.google.android.gms.wearable.NodeApi.GetConnectedNodesResult;
import com.google.android.gms.wearable.NodeApi.GetLocalNodeResult;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.FutureTask;

final class zzbj {

    static abstract class zzb<T> extends zza {
        private com.google.android.gms.common.api.zza.zzb<T> zzNO;

        public zzb(com.google.android.gms.common.api.zza.zzb<T> com_google_android_gms_common_api_zza_zzb_T) {
            this.zzNO = com_google_android_gms_common_api_zza_zzb_T;
        }

        public void zzP(T t) {
            com.google.android.gms.common.api.zza.zzb com_google_android_gms_common_api_zza_zzb = this.zzNO;
            if (com_google_android_gms_common_api_zza_zzb != null) {
                com_google_android_gms_common_api_zza_zzb.zzm(t);
                this.zzNO = null;
            }
        }
    }

    static final class zza extends zzb<AddLocalCapabilityResult> {
        public zza(com.google.android.gms.common.api.zza.zzb<AddLocalCapabilityResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_wearable_CapabilityApi_AddLocalCapabilityResult) {
            super(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_wearable_CapabilityApi_AddLocalCapabilityResult);
        }

        public void zza(AddLocalCapabilityResponse addLocalCapabilityResponse) {
            zzP(new com.google.android.gms.wearable.internal.zzg.zzb(zzbg.zzfn(addLocalCapabilityResponse.statusCode)));
        }
    }

    static final class zzc extends zzb<Status> {
        public zzc(com.google.android.gms.common.api.zza.zzb<Status> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status) {
            super(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status);
        }

        public void zza(CloseChannelResponse closeChannelResponse) {
            zzP(new Status(closeChannelResponse.statusCode));
        }
    }

    static final class zzd extends zzb<Status> {
        public zzd(com.google.android.gms.common.api.zza.zzb<Status> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status) {
            super(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status);
        }

        public void zzb(CloseChannelResponse closeChannelResponse) {
            zzP(new Status(closeChannelResponse.statusCode));
        }
    }

    static final class zze extends zzb<DeleteDataItemsResult> {
        public zze(com.google.android.gms.common.api.zza.zzb<DeleteDataItemsResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_wearable_DataApi_DeleteDataItemsResult) {
            super(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_wearable_DataApi_DeleteDataItemsResult);
        }

        public void zza(DeleteDataItemsResponse deleteDataItemsResponse) {
            zzP(new com.google.android.gms.wearable.internal.zzu.zzc(zzbg.zzfn(deleteDataItemsResponse.statusCode), deleteDataItemsResponse.zzaUp));
        }
    }

    static final class zzf extends zzb<GetAllCapabilitiesResult> {
        public zzf(com.google.android.gms.common.api.zza.zzb<GetAllCapabilitiesResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_wearable_CapabilityApi_GetAllCapabilitiesResult) {
            super(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_wearable_CapabilityApi_GetAllCapabilitiesResult);
        }

        public void zza(GetAllCapabilitiesResponse getAllCapabilitiesResponse) {
            zzP(new com.google.android.gms.wearable.internal.zzg.zzd(zzbg.zzfn(getAllCapabilitiesResponse.statusCode), zzbj.zzv(getAllCapabilitiesResponse.zzaUq)));
        }
    }

    static final class zzg extends zzb<GetCapabilityResult> {
        public zzg(com.google.android.gms.common.api.zza.zzb<GetCapabilityResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_wearable_CapabilityApi_GetCapabilityResult) {
            super(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_wearable_CapabilityApi_GetCapabilityResult);
        }

        public void zza(GetCapabilityResponse getCapabilityResponse) {
            zzP(new com.google.android.gms.wearable.internal.zzg.zze(zzbg.zzfn(getCapabilityResponse.statusCode), new com.google.android.gms.wearable.internal.zzg.zzc(getCapabilityResponse.zzaUr)));
        }
    }

    static final class zzh extends zzb<GetInputStreamResult> {
        private final zzq zzaUQ;

        public zzh(com.google.android.gms.common.api.zza.zzb<GetInputStreamResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_wearable_Channel_GetInputStreamResult, zzq com_google_android_gms_wearable_internal_zzq) {
            super(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_wearable_Channel_GetInputStreamResult);
            this.zzaUQ = (zzq) com.google.android.gms.common.internal.zzu.zzu(com_google_android_gms_wearable_internal_zzq);
        }

        public void zza(GetChannelInputStreamResponse getChannelInputStreamResponse) {
            InputStream inputStream = null;
            if (getChannelInputStreamResponse.zzaUs != null) {
                inputStream = new zzm(new AutoCloseInputStream(getChannelInputStreamResponse.zzaUs));
                this.zzaUQ.zza(inputStream.zzBb());
            }
            zzP(new zza(new Status(getChannelInputStreamResponse.statusCode), inputStream));
        }
    }

    static final class zzi extends zzb<GetOutputStreamResult> {
        private final zzq zzaUQ;

        public zzi(com.google.android.gms.common.api.zza.zzb<GetOutputStreamResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_wearable_Channel_GetOutputStreamResult, zzq com_google_android_gms_wearable_internal_zzq) {
            super(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_wearable_Channel_GetOutputStreamResult);
            this.zzaUQ = (zzq) com.google.android.gms.common.internal.zzu.zzu(com_google_android_gms_wearable_internal_zzq);
        }

        public void zza(GetChannelOutputStreamResponse getChannelOutputStreamResponse) {
            OutputStream outputStream = null;
            if (getChannelOutputStreamResponse.zzaUs != null) {
                outputStream = new zzn(new AutoCloseOutputStream(getChannelOutputStreamResponse.zzaUs));
                this.zzaUQ.zza(outputStream.zzBb());
            }
            zzP(new zzb(new Status(getChannelOutputStreamResponse.statusCode), outputStream));
        }
    }

    static final class zzj extends zzb<GetConnectedNodesResult> {
        public zzj(com.google.android.gms.common.api.zza.zzb<GetConnectedNodesResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_wearable_NodeApi_GetConnectedNodesResult) {
            super(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_wearable_NodeApi_GetConnectedNodesResult);
        }

        public void zza(GetConnectedNodesResponse getConnectedNodesResponse) {
            List arrayList = new ArrayList();
            arrayList.addAll(getConnectedNodesResponse.zzaUw);
            zzP(new com.google.android.gms.wearable.internal.zzax.zzb(zzbg.zzfn(getConnectedNodesResponse.statusCode), arrayList));
        }
    }

    static final class zzk extends zzb<DataItemResult> {
        public zzk(com.google.android.gms.common.api.zza.zzb<DataItemResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_wearable_DataApi_DataItemResult) {
            super(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_wearable_DataApi_DataItemResult);
        }

        public void zza(GetDataItemResponse getDataItemResponse) {
            zzP(new com.google.android.gms.wearable.internal.zzu.zzb(zzbg.zzfn(getDataItemResponse.statusCode), getDataItemResponse.zzaUx));
        }
    }

    static final class zzl extends zzb<DataItemBuffer> {
        public zzl(com.google.android.gms.common.api.zza.zzb<DataItemBuffer> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_wearable_DataItemBuffer) {
            super(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_wearable_DataItemBuffer);
        }

        public void zzad(DataHolder dataHolder) {
            zzP(new DataItemBuffer(dataHolder));
        }
    }

    static final class zzm extends zzb<GetFdForAssetResult> {
        public zzm(com.google.android.gms.common.api.zza.zzb<GetFdForAssetResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_wearable_DataApi_GetFdForAssetResult) {
            super(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_wearable_DataApi_GetFdForAssetResult);
        }

        public void zza(GetFdForAssetResponse getFdForAssetResponse) {
            zzP(new com.google.android.gms.wearable.internal.zzu.zzd(zzbg.zzfn(getFdForAssetResponse.statusCode), getFdForAssetResponse.zzaUy));
        }
    }

    static final class zzn extends zzb<GetLocalNodeResult> {
        public zzn(com.google.android.gms.common.api.zza.zzb<GetLocalNodeResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_wearable_NodeApi_GetLocalNodeResult) {
            super(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_wearable_NodeApi_GetLocalNodeResult);
        }

        public void zza(GetLocalNodeResponse getLocalNodeResponse) {
            zzP(new com.google.android.gms.wearable.internal.zzax.zzc(zzbg.zzfn(getLocalNodeResponse.statusCode), getLocalNodeResponse.zzaUz));
        }
    }

    static final class zzo extends zza {
        zzo() {
        }

        public void zza(Status status) {
        }
    }

    static final class zzp extends zzb<OpenChannelResult> {
        public zzp(com.google.android.gms.common.api.zza.zzb<OpenChannelResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_wearable_ChannelApi_OpenChannelResult) {
            super(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_wearable_ChannelApi_OpenChannelResult);
        }

        public void zza(OpenChannelResponse openChannelResponse) {
            zzP(new zzb(zzbg.zzfn(openChannelResponse.statusCode), openChannelResponse.zzaTP));
        }
    }

    static final class zzq extends zzb<DataItemResult> {
        private final List<FutureTask<Boolean>> zzwE;

        zzq(com.google.android.gms.common.api.zza.zzb<DataItemResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_wearable_DataApi_DataItemResult, List<FutureTask<Boolean>> list) {
            super(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_wearable_DataApi_DataItemResult);
            this.zzwE = list;
        }

        public void zza(PutDataResponse putDataResponse) {
            zzP(new com.google.android.gms.wearable.internal.zzu.zzb(zzbg.zzfn(putDataResponse.statusCode), putDataResponse.zzaUx));
            if (putDataResponse.statusCode != 0) {
                for (FutureTask cancel : this.zzwE) {
                    cancel.cancel(true);
                }
            }
        }
    }

    static final class zzr extends zzb<Status> {
        public zzr(com.google.android.gms.common.api.zza.zzb<Status> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status) {
            super(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status);
        }

        public void zza(ChannelSendFileResponse channelSendFileResponse) {
            zzP(new Status(channelSendFileResponse.statusCode));
        }
    }

    static final class zzs extends zzb<RemoveLocalCapabilityResult> {
        public zzs(com.google.android.gms.common.api.zza.zzb<RemoveLocalCapabilityResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_wearable_CapabilityApi_RemoveLocalCapabilityResult) {
            super(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_wearable_CapabilityApi_RemoveLocalCapabilityResult);
        }

        public void zza(RemoveLocalCapabilityResponse removeLocalCapabilityResponse) {
            zzP(new com.google.android.gms.wearable.internal.zzg.zzb(zzbg.zzfn(removeLocalCapabilityResponse.statusCode)));
        }
    }

    static final class zzt extends zzb<SendMessageResult> {
        public zzt(com.google.android.gms.common.api.zza.zzb<SendMessageResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_wearable_MessageApi_SendMessageResult) {
            super(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_wearable_MessageApi_SendMessageResult);
        }

        public void zza(SendMessageResponse sendMessageResponse) {
            zzP(new com.google.android.gms.wearable.internal.zzav.zzb(zzbg.zzfn(sendMessageResponse.statusCode), sendMessageResponse.zzaxg));
        }
    }

    static final class zzu extends zzb<Status> {
        public zzu(com.google.android.gms.common.api.zza.zzb<Status> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status) {
            super(com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status);
        }

        public void zza(ChannelReceiveFileResponse channelReceiveFileResponse) {
            zzP(new Status(channelReceiveFileResponse.statusCode));
        }
    }

    private static Map<String, CapabilityInfo> zzv(List<CapabilityInfoParcelable> list) {
        Map hashMap = new HashMap(list.size() * 2);
        for (CapabilityInfoParcelable capabilityInfoParcelable : list) {
            hashMap.put(capabilityInfoParcelable.getName(), new com.google.android.gms.wearable.internal.zzg.zzc(capabilityInfoParcelable));
        }
        return hashMap;
    }
}
