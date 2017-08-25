package com.google.android.gms.drive.internal;

import android.content.IntentSender;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.drive.RealtimeDocumentSyncRequest;
import com.google.android.gms.location.places.Place;

public interface zzak extends IInterface {

    public static abstract class zza extends Binder implements zzak {

        private static class zza implements zzak {
            private IBinder zznF;

            zza(IBinder iBinder) {
                this.zznF = iBinder;
            }

            public IBinder asBinder() {
                return this.zznF;
            }

            public IntentSender zza(CreateFileIntentSenderRequest createFileIntentSenderRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (createFileIntentSenderRequest != null) {
                        obtain.writeInt(1);
                        createFileIntentSenderRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznF.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    IntentSender intentSender = obtain2.readInt() != 0 ? (IntentSender) IntentSender.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return intentSender;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IntentSender zza(OpenFileIntentSenderRequest openFileIntentSenderRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (openFileIntentSenderRequest != null) {
                        obtain.writeInt(1);
                        openFileIntentSenderRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznF.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    IntentSender intentSender = obtain2.readInt() != 0 ? (IntentSender) IntentSender.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return intentSender;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public DriveServiceResponse zza(OpenContentsRequest openContentsRequest, zzal com_google_android_gms_drive_internal_zzal) throws RemoteException {
                DriveServiceResponse driveServiceResponse = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (openContentsRequest != null) {
                        obtain.writeInt(1);
                        openContentsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzal != null ? com_google_android_gms_drive_internal_zzal.asBinder() : null);
                    this.zznF.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        driveServiceResponse = (DriveServiceResponse) DriveServiceResponse.CREATOR.createFromParcel(obtain2);
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return driveServiceResponse;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(RealtimeDocumentSyncRequest realtimeDocumentSyncRequest, zzal com_google_android_gms_drive_internal_zzal) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (realtimeDocumentSyncRequest != null) {
                        obtain.writeInt(1);
                        realtimeDocumentSyncRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzal != null ? com_google_android_gms_drive_internal_zzal.asBinder() : null);
                    this.zznF.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(AddEventListenerRequest addEventListenerRequest, zzam com_google_android_gms_drive_internal_zzam, String str, zzal com_google_android_gms_drive_internal_zzal) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (addEventListenerRequest != null) {
                        obtain.writeInt(1);
                        addEventListenerRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzam != null ? com_google_android_gms_drive_internal_zzam.asBinder() : null);
                    obtain.writeString(str);
                    if (com_google_android_gms_drive_internal_zzal != null) {
                        iBinder = com_google_android_gms_drive_internal_zzal.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zznF.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(AddPermissionRequest addPermissionRequest, zzal com_google_android_gms_drive_internal_zzal) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (addPermissionRequest != null) {
                        obtain.writeInt(1);
                        addPermissionRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzal != null ? com_google_android_gms_drive_internal_zzal.asBinder() : null);
                    this.zznF.transact(48, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(AuthorizeAccessRequest authorizeAccessRequest, zzal com_google_android_gms_drive_internal_zzal) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (authorizeAccessRequest != null) {
                        obtain.writeInt(1);
                        authorizeAccessRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzal != null ? com_google_android_gms_drive_internal_zzal.asBinder() : null);
                    this.zznF.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(CancelPendingActionsRequest cancelPendingActionsRequest, zzal com_google_android_gms_drive_internal_zzal) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (cancelPendingActionsRequest != null) {
                        obtain.writeInt(1);
                        cancelPendingActionsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzal != null ? com_google_android_gms_drive_internal_zzal.asBinder() : null);
                    this.zznF.transact(37, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(CheckResourceIdsExistRequest checkResourceIdsExistRequest, zzal com_google_android_gms_drive_internal_zzal) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (checkResourceIdsExistRequest != null) {
                        obtain.writeInt(1);
                        checkResourceIdsExistRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzal != null ? com_google_android_gms_drive_internal_zzal.asBinder() : null);
                    this.zznF.transact(30, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(CloseContentsAndUpdateMetadataRequest closeContentsAndUpdateMetadataRequest, zzal com_google_android_gms_drive_internal_zzal) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (closeContentsAndUpdateMetadataRequest != null) {
                        obtain.writeInt(1);
                        closeContentsAndUpdateMetadataRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzal != null ? com_google_android_gms_drive_internal_zzal.asBinder() : null);
                    this.zznF.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(CloseContentsRequest closeContentsRequest, zzal com_google_android_gms_drive_internal_zzal) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (closeContentsRequest != null) {
                        obtain.writeInt(1);
                        closeContentsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzal != null ? com_google_android_gms_drive_internal_zzal.asBinder() : null);
                    this.zznF.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(CreateContentsRequest createContentsRequest, zzal com_google_android_gms_drive_internal_zzal) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (createContentsRequest != null) {
                        obtain.writeInt(1);
                        createContentsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzal != null ? com_google_android_gms_drive_internal_zzal.asBinder() : null);
                    this.zznF.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(CreateFileRequest createFileRequest, zzal com_google_android_gms_drive_internal_zzal) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (createFileRequest != null) {
                        obtain.writeInt(1);
                        createFileRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzal != null ? com_google_android_gms_drive_internal_zzal.asBinder() : null);
                    this.zznF.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(CreateFolderRequest createFolderRequest, zzal com_google_android_gms_drive_internal_zzal) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (createFolderRequest != null) {
                        obtain.writeInt(1);
                        createFolderRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzal != null ? com_google_android_gms_drive_internal_zzal.asBinder() : null);
                    this.zznF.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(DeleteResourceRequest deleteResourceRequest, zzal com_google_android_gms_drive_internal_zzal) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (deleteResourceRequest != null) {
                        obtain.writeInt(1);
                        deleteResourceRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzal != null ? com_google_android_gms_drive_internal_zzal.asBinder() : null);
                    this.zznF.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(DisconnectRequest disconnectRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (disconnectRequest != null) {
                        obtain.writeInt(1);
                        disconnectRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznF.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(FetchThumbnailRequest fetchThumbnailRequest, zzal com_google_android_gms_drive_internal_zzal) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (fetchThumbnailRequest != null) {
                        obtain.writeInt(1);
                        fetchThumbnailRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzal != null ? com_google_android_gms_drive_internal_zzal.asBinder() : null);
                    this.zznF.transact(42, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(GetChangesRequest getChangesRequest, zzal com_google_android_gms_drive_internal_zzal) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (getChangesRequest != null) {
                        obtain.writeInt(1);
                        getChangesRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzal != null ? com_google_android_gms_drive_internal_zzal.asBinder() : null);
                    this.zznF.transact(44, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(GetDriveIdFromUniqueIdentifierRequest getDriveIdFromUniqueIdentifierRequest, zzal com_google_android_gms_drive_internal_zzal) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (getDriveIdFromUniqueIdentifierRequest != null) {
                        obtain.writeInt(1);
                        getDriveIdFromUniqueIdentifierRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzal != null ? com_google_android_gms_drive_internal_zzal.asBinder() : null);
                    this.zznF.transact(29, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(GetMetadataRequest getMetadataRequest, zzal com_google_android_gms_drive_internal_zzal) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (getMetadataRequest != null) {
                        obtain.writeInt(1);
                        getMetadataRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzal != null ? com_google_android_gms_drive_internal_zzal.asBinder() : null);
                    this.zznF.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(GetPermissionsRequest getPermissionsRequest, zzal com_google_android_gms_drive_internal_zzal) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (getPermissionsRequest != null) {
                        obtain.writeInt(1);
                        getPermissionsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzal != null ? com_google_android_gms_drive_internal_zzal.asBinder() : null);
                    this.zznF.transact(47, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(ListParentsRequest listParentsRequest, zzal com_google_android_gms_drive_internal_zzal) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (listParentsRequest != null) {
                        obtain.writeInt(1);
                        listParentsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzal != null ? com_google_android_gms_drive_internal_zzal.asBinder() : null);
                    this.zznF.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(LoadRealtimeRequest loadRealtimeRequest, zzal com_google_android_gms_drive_internal_zzal) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (loadRealtimeRequest != null) {
                        obtain.writeInt(1);
                        loadRealtimeRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzal != null ? com_google_android_gms_drive_internal_zzal.asBinder() : null);
                    this.zznF.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(QueryRequest queryRequest, zzal com_google_android_gms_drive_internal_zzal) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (queryRequest != null) {
                        obtain.writeInt(1);
                        queryRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzal != null ? com_google_android_gms_drive_internal_zzal.asBinder() : null);
                    this.zznF.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(QueryRequest queryRequest, zzam com_google_android_gms_drive_internal_zzam, zzal com_google_android_gms_drive_internal_zzal) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (queryRequest != null) {
                        obtain.writeInt(1);
                        queryRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzam != null ? com_google_android_gms_drive_internal_zzam.asBinder() : null);
                    if (com_google_android_gms_drive_internal_zzal != null) {
                        iBinder = com_google_android_gms_drive_internal_zzal.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zznF.transact(51, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(RemoveEventListenerRequest removeEventListenerRequest, zzam com_google_android_gms_drive_internal_zzam, String str, zzal com_google_android_gms_drive_internal_zzal) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (removeEventListenerRequest != null) {
                        obtain.writeInt(1);
                        removeEventListenerRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzam != null ? com_google_android_gms_drive_internal_zzam.asBinder() : null);
                    obtain.writeString(str);
                    if (com_google_android_gms_drive_internal_zzal != null) {
                        iBinder = com_google_android_gms_drive_internal_zzal.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zznF.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(RemovePermissionRequest removePermissionRequest, zzal com_google_android_gms_drive_internal_zzal) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (removePermissionRequest != null) {
                        obtain.writeInt(1);
                        removePermissionRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzal != null ? com_google_android_gms_drive_internal_zzal.asBinder() : null);
                    this.zznF.transact(50, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(SetDrivePreferencesRequest setDrivePreferencesRequest, zzal com_google_android_gms_drive_internal_zzal) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (setDrivePreferencesRequest != null) {
                        obtain.writeInt(1);
                        setDrivePreferencesRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzal != null ? com_google_android_gms_drive_internal_zzal.asBinder() : null);
                    this.zznF.transact(33, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(SetFileUploadPreferencesRequest setFileUploadPreferencesRequest, zzal com_google_android_gms_drive_internal_zzal) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (setFileUploadPreferencesRequest != null) {
                        obtain.writeInt(1);
                        setFileUploadPreferencesRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzal != null ? com_google_android_gms_drive_internal_zzal.asBinder() : null);
                    this.zznF.transact(36, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(SetResourceParentsRequest setResourceParentsRequest, zzal com_google_android_gms_drive_internal_zzal) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (setResourceParentsRequest != null) {
                        obtain.writeInt(1);
                        setResourceParentsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzal != null ? com_google_android_gms_drive_internal_zzal.asBinder() : null);
                    this.zznF.transact(28, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(TrashResourceRequest trashResourceRequest, zzal com_google_android_gms_drive_internal_zzal) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (trashResourceRequest != null) {
                        obtain.writeInt(1);
                        trashResourceRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzal != null ? com_google_android_gms_drive_internal_zzal.asBinder() : null);
                    this.zznF.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(UnsubscribeResourceRequest unsubscribeResourceRequest, zzal com_google_android_gms_drive_internal_zzal) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (unsubscribeResourceRequest != null) {
                        obtain.writeInt(1);
                        unsubscribeResourceRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzal != null ? com_google_android_gms_drive_internal_zzal.asBinder() : null);
                    this.zznF.transact(46, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(UntrashResourceRequest untrashResourceRequest, zzal com_google_android_gms_drive_internal_zzal) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (untrashResourceRequest != null) {
                        obtain.writeInt(1);
                        untrashResourceRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzal != null ? com_google_android_gms_drive_internal_zzal.asBinder() : null);
                    this.zznF.transact(38, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(UpdateMetadataRequest updateMetadataRequest, zzal com_google_android_gms_drive_internal_zzal) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (updateMetadataRequest != null) {
                        obtain.writeInt(1);
                        updateMetadataRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzal != null ? com_google_android_gms_drive_internal_zzal.asBinder() : null);
                    this.zznF.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(UpdatePermissionRequest updatePermissionRequest, zzal com_google_android_gms_drive_internal_zzal) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (updatePermissionRequest != null) {
                        obtain.writeInt(1);
                        updatePermissionRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzal != null ? com_google_android_gms_drive_internal_zzal.asBinder() : null);
                    this.zznF.transact(49, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzal com_google_android_gms_drive_internal_zzal) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzal != null ? com_google_android_gms_drive_internal_zzal.asBinder() : null);
                    this.zznF.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzam com_google_android_gms_drive_internal_zzam, zzal com_google_android_gms_drive_internal_zzal) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzam != null ? com_google_android_gms_drive_internal_zzam.asBinder() : null);
                    if (com_google_android_gms_drive_internal_zzal != null) {
                        iBinder = com_google_android_gms_drive_internal_zzal.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zznF.transact(52, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(QueryRequest queryRequest, zzal com_google_android_gms_drive_internal_zzal) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (queryRequest != null) {
                        obtain.writeInt(1);
                        queryRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzal != null ? com_google_android_gms_drive_internal_zzal.asBinder() : null);
                    this.zznF.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzal com_google_android_gms_drive_internal_zzal) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzal != null ? com_google_android_gms_drive_internal_zzal.asBinder() : null);
                    this.zznF.transact(31, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(zzal com_google_android_gms_drive_internal_zzal) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzal != null ? com_google_android_gms_drive_internal_zzal.asBinder() : null);
                    this.zznF.transact(32, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzd(zzal com_google_android_gms_drive_internal_zzal) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzal != null ? com_google_android_gms_drive_internal_zzal.asBinder() : null);
                    this.zznF.transact(35, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zze(zzal com_google_android_gms_drive_internal_zzal) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzal != null ? com_google_android_gms_drive_internal_zzal.asBinder() : null);
                    this.zznF.transact(41, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzf(zzal com_google_android_gms_drive_internal_zzal) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    obtain.writeStrongBinder(com_google_android_gms_drive_internal_zzal != null ? com_google_android_gms_drive_internal_zzal.asBinder() : null);
                    this.zznF.transact(43, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzak zzaO(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.drive.internal.IDriveService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzak)) ? new zza(iBinder) : (zzak) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            QueryRequest queryRequest = null;
            IntentSender zza;
            switch (code) {
                case 1:
                    GetMetadataRequest getMetadataRequest;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        getMetadataRequest = (GetMetadataRequest) GetMetadataRequest.CREATOR.createFromParcel(data);
                    }
                    zza(getMetadataRequest, com.google.android.gms.drive.internal.zzal.zza.zzaP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        queryRequest = (QueryRequest) QueryRequest.CREATOR.createFromParcel(data);
                    }
                    zza(queryRequest, com.google.android.gms.drive.internal.zzal.zza.zzaP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 3:
                    UpdateMetadataRequest updateMetadataRequest;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        updateMetadataRequest = (UpdateMetadataRequest) UpdateMetadataRequest.CREATOR.createFromParcel(data);
                    }
                    zza(updateMetadataRequest, com.google.android.gms.drive.internal.zzal.zza.zzaP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 4:
                    CreateContentsRequest createContentsRequest;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        createContentsRequest = (CreateContentsRequest) CreateContentsRequest.CREATOR.createFromParcel(data);
                    }
                    zza(createContentsRequest, com.google.android.gms.drive.internal.zzal.zza.zzaP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 5:
                    CreateFileRequest createFileRequest;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        createFileRequest = (CreateFileRequest) CreateFileRequest.CREATOR.createFromParcel(data);
                    }
                    zza(createFileRequest, com.google.android.gms.drive.internal.zzal.zza.zzaP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 6:
                    CreateFolderRequest createFolderRequest;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        createFolderRequest = (CreateFolderRequest) CreateFolderRequest.CREATOR.createFromParcel(data);
                    }
                    zza(createFolderRequest, com.google.android.gms.drive.internal.zzal.zza.zzaP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 7:
                    OpenContentsRequest openContentsRequest;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        openContentsRequest = (OpenContentsRequest) OpenContentsRequest.CREATOR.createFromParcel(data);
                    }
                    DriveServiceResponse zza2 = zza(openContentsRequest, com.google.android.gms.drive.internal.zzal.zza.zzaP(data.readStrongBinder()));
                    reply.writeNoException();
                    if (zza2 != null) {
                        reply.writeInt(1);
                        zza2.writeToParcel(reply, 1);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                case 8:
                    CloseContentsRequest closeContentsRequest;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        closeContentsRequest = (CloseContentsRequest) CloseContentsRequest.CREATOR.createFromParcel(data);
                    }
                    zza(closeContentsRequest, com.google.android.gms.drive.internal.zzal.zza.zzaP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 9:
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zza(com.google.android.gms.drive.internal.zzal.zza.zzaP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 10:
                    OpenFileIntentSenderRequest openFileIntentSenderRequest;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        openFileIntentSenderRequest = (OpenFileIntentSenderRequest) OpenFileIntentSenderRequest.CREATOR.createFromParcel(data);
                    }
                    zza = zza(openFileIntentSenderRequest);
                    reply.writeNoException();
                    if (zza != null) {
                        reply.writeInt(1);
                        zza.writeToParcel(reply, 1);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                case 11:
                    CreateFileIntentSenderRequest createFileIntentSenderRequest;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        createFileIntentSenderRequest = (CreateFileIntentSenderRequest) CreateFileIntentSenderRequest.CREATOR.createFromParcel(data);
                    }
                    zza = zza(createFileIntentSenderRequest);
                    reply.writeNoException();
                    if (zza != null) {
                        reply.writeInt(1);
                        zza.writeToParcel(reply, 1);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                case 12:
                    AuthorizeAccessRequest authorizeAccessRequest;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        authorizeAccessRequest = (AuthorizeAccessRequest) AuthorizeAccessRequest.CREATOR.createFromParcel(data);
                    }
                    zza(authorizeAccessRequest, com.google.android.gms.drive.internal.zzal.zza.zzaP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 13:
                    ListParentsRequest listParentsRequest;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        listParentsRequest = (ListParentsRequest) ListParentsRequest.CREATOR.createFromParcel(data);
                    }
                    zza(listParentsRequest, com.google.android.gms.drive.internal.zzal.zza.zzaP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 14:
                    AddEventListenerRequest addEventListenerRequest;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        addEventListenerRequest = (AddEventListenerRequest) AddEventListenerRequest.CREATOR.createFromParcel(data);
                    }
                    zza(addEventListenerRequest, com.google.android.gms.drive.internal.zzam.zza.zzaQ(data.readStrongBinder()), data.readString(), com.google.android.gms.drive.internal.zzal.zza.zzaP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 15:
                    RemoveEventListenerRequest removeEventListenerRequest;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        removeEventListenerRequest = (RemoveEventListenerRequest) RemoveEventListenerRequest.CREATOR.createFromParcel(data);
                    }
                    zza(removeEventListenerRequest, com.google.android.gms.drive.internal.zzam.zza.zzaQ(data.readStrongBinder()), data.readString(), com.google.android.gms.drive.internal.zzal.zza.zzaP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 16:
                    DisconnectRequest disconnectRequest;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        disconnectRequest = (DisconnectRequest) DisconnectRequest.CREATOR.createFromParcel(data);
                    }
                    zza(disconnectRequest);
                    reply.writeNoException();
                    return true;
                case 17:
                    TrashResourceRequest trashResourceRequest;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        trashResourceRequest = (TrashResourceRequest) TrashResourceRequest.CREATOR.createFromParcel(data);
                    }
                    zza(trashResourceRequest, com.google.android.gms.drive.internal.zzal.zza.zzaP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 18:
                    CloseContentsAndUpdateMetadataRequest closeContentsAndUpdateMetadataRequest;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        closeContentsAndUpdateMetadataRequest = (CloseContentsAndUpdateMetadataRequest) CloseContentsAndUpdateMetadataRequest.CREATOR.createFromParcel(data);
                    }
                    zza(closeContentsAndUpdateMetadataRequest, com.google.android.gms.drive.internal.zzal.zza.zzaP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 19:
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        queryRequest = (QueryRequest) QueryRequest.CREATOR.createFromParcel(data);
                    }
                    zzb(queryRequest, com.google.android.gms.drive.internal.zzal.zza.zzaP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Place.TYPE_CITY_HALL /*24*/:
                    DeleteResourceRequest deleteResourceRequest;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        deleteResourceRequest = (DeleteResourceRequest) DeleteResourceRequest.CREATOR.createFromParcel(data);
                    }
                    zza(deleteResourceRequest, com.google.android.gms.drive.internal.zzal.zza.zzaP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Place.TYPE_COURTHOUSE /*27*/:
                    LoadRealtimeRequest loadRealtimeRequest;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        loadRealtimeRequest = (LoadRealtimeRequest) LoadRealtimeRequest.CREATOR.createFromParcel(data);
                    }
                    zza(loadRealtimeRequest, com.google.android.gms.drive.internal.zzal.zza.zzaP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Place.TYPE_DENTIST /*28*/:
                    SetResourceParentsRequest setResourceParentsRequest;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        setResourceParentsRequest = (SetResourceParentsRequest) SetResourceParentsRequest.CREATOR.createFromParcel(data);
                    }
                    zza(setResourceParentsRequest, com.google.android.gms.drive.internal.zzal.zza.zzaP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Place.TYPE_DEPARTMENT_STORE /*29*/:
                    GetDriveIdFromUniqueIdentifierRequest getDriveIdFromUniqueIdentifierRequest;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        getDriveIdFromUniqueIdentifierRequest = (GetDriveIdFromUniqueIdentifierRequest) GetDriveIdFromUniqueIdentifierRequest.CREATOR.createFromParcel(data);
                    }
                    zza(getDriveIdFromUniqueIdentifierRequest, com.google.android.gms.drive.internal.zzal.zza.zzaP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 30:
                    CheckResourceIdsExistRequest checkResourceIdsExistRequest;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        checkResourceIdsExistRequest = (CheckResourceIdsExistRequest) CheckResourceIdsExistRequest.CREATOR.createFromParcel(data);
                    }
                    zza(checkResourceIdsExistRequest, com.google.android.gms.drive.internal.zzal.zza.zzaP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 31:
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zzb(com.google.android.gms.drive.internal.zzal.zza.zzaP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 32:
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zzc(com.google.android.gms.drive.internal.zzal.zza.zzaP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Place.TYPE_EMBASSY /*33*/:
                    SetDrivePreferencesRequest setDrivePreferencesRequest;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        setDrivePreferencesRequest = (SetDrivePreferencesRequest) SetDrivePreferencesRequest.CREATOR.createFromParcel(data);
                    }
                    zza(setDrivePreferencesRequest, com.google.android.gms.drive.internal.zzal.zza.zzaP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Place.TYPE_ESTABLISHMENT /*34*/:
                    RealtimeDocumentSyncRequest realtimeDocumentSyncRequest;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        realtimeDocumentSyncRequest = (RealtimeDocumentSyncRequest) RealtimeDocumentSyncRequest.CREATOR.createFromParcel(data);
                    }
                    zza(realtimeDocumentSyncRequest, com.google.android.gms.drive.internal.zzal.zza.zzaP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Place.TYPE_FINANCE /*35*/:
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zzd(com.google.android.gms.drive.internal.zzal.zza.zzaP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Place.TYPE_FIRE_STATION /*36*/:
                    SetFileUploadPreferencesRequest setFileUploadPreferencesRequest;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        setFileUploadPreferencesRequest = (SetFileUploadPreferencesRequest) SetFileUploadPreferencesRequest.CREATOR.createFromParcel(data);
                    }
                    zza(setFileUploadPreferencesRequest, com.google.android.gms.drive.internal.zzal.zza.zzaP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Place.TYPE_FLORIST /*37*/:
                    CancelPendingActionsRequest cancelPendingActionsRequest;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        cancelPendingActionsRequest = (CancelPendingActionsRequest) CancelPendingActionsRequest.CREATOR.createFromParcel(data);
                    }
                    zza(cancelPendingActionsRequest, com.google.android.gms.drive.internal.zzal.zza.zzaP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Place.TYPE_FOOD /*38*/:
                    UntrashResourceRequest untrashResourceRequest;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        untrashResourceRequest = (UntrashResourceRequest) UntrashResourceRequest.CREATOR.createFromParcel(data);
                    }
                    zza(untrashResourceRequest, com.google.android.gms.drive.internal.zzal.zza.zzaP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Place.TYPE_GAS_STATION /*41*/:
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zze(com.google.android.gms.drive.internal.zzal.zza.zzaP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Place.TYPE_GENERAL_CONTRACTOR /*42*/:
                    FetchThumbnailRequest fetchThumbnailRequest;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        fetchThumbnailRequest = (FetchThumbnailRequest) FetchThumbnailRequest.CREATOR.createFromParcel(data);
                    }
                    zza(fetchThumbnailRequest, com.google.android.gms.drive.internal.zzal.zza.zzaP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Place.TYPE_GROCERY_OR_SUPERMARKET /*43*/:
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zzf(com.google.android.gms.drive.internal.zzal.zza.zzaP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Place.TYPE_GYM /*44*/:
                    GetChangesRequest getChangesRequest;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        getChangesRequest = (GetChangesRequest) GetChangesRequest.CREATOR.createFromParcel(data);
                    }
                    zza(getChangesRequest, com.google.android.gms.drive.internal.zzal.zza.zzaP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Place.TYPE_HARDWARE_STORE /*46*/:
                    UnsubscribeResourceRequest unsubscribeResourceRequest;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        unsubscribeResourceRequest = (UnsubscribeResourceRequest) UnsubscribeResourceRequest.CREATOR.createFromParcel(data);
                    }
                    zza(unsubscribeResourceRequest, com.google.android.gms.drive.internal.zzal.zza.zzaP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Place.TYPE_HEALTH /*47*/:
                    GetPermissionsRequest getPermissionsRequest;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        getPermissionsRequest = (GetPermissionsRequest) GetPermissionsRequest.CREATOR.createFromParcel(data);
                    }
                    zza(getPermissionsRequest, com.google.android.gms.drive.internal.zzal.zza.zzaP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Place.TYPE_HINDU_TEMPLE /*48*/:
                    AddPermissionRequest addPermissionRequest;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        addPermissionRequest = (AddPermissionRequest) AddPermissionRequest.CREATOR.createFromParcel(data);
                    }
                    zza(addPermissionRequest, com.google.android.gms.drive.internal.zzal.zza.zzaP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Place.TYPE_HOME_GOODS_STORE /*49*/:
                    UpdatePermissionRequest updatePermissionRequest;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        updatePermissionRequest = (UpdatePermissionRequest) UpdatePermissionRequest.CREATOR.createFromParcel(data);
                    }
                    zza(updatePermissionRequest, com.google.android.gms.drive.internal.zzal.zza.zzaP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 50:
                    RemovePermissionRequest removePermissionRequest;
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        removePermissionRequest = (RemovePermissionRequest) RemovePermissionRequest.CREATOR.createFromParcel(data);
                    }
                    zza(removePermissionRequest, com.google.android.gms.drive.internal.zzal.zza.zzaP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Place.TYPE_INSURANCE_AGENCY /*51*/:
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (data.readInt() != 0) {
                        queryRequest = (QueryRequest) QueryRequest.CREATOR.createFromParcel(data);
                    }
                    zza(queryRequest, com.google.android.gms.drive.internal.zzam.zza.zzaQ(data.readStrongBinder()), com.google.android.gms.drive.internal.zzal.zza.zzaP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Place.TYPE_JEWELRY_STORE /*52*/:
                    data.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zza(com.google.android.gms.drive.internal.zzam.zza.zzaQ(data.readStrongBinder()), com.google.android.gms.drive.internal.zzal.zza.zzaP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.drive.internal.IDriveService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    IntentSender zza(CreateFileIntentSenderRequest createFileIntentSenderRequest) throws RemoteException;

    IntentSender zza(OpenFileIntentSenderRequest openFileIntentSenderRequest) throws RemoteException;

    DriveServiceResponse zza(OpenContentsRequest openContentsRequest, zzal com_google_android_gms_drive_internal_zzal) throws RemoteException;

    void zza(RealtimeDocumentSyncRequest realtimeDocumentSyncRequest, zzal com_google_android_gms_drive_internal_zzal) throws RemoteException;

    void zza(AddEventListenerRequest addEventListenerRequest, zzam com_google_android_gms_drive_internal_zzam, String str, zzal com_google_android_gms_drive_internal_zzal) throws RemoteException;

    void zza(AddPermissionRequest addPermissionRequest, zzal com_google_android_gms_drive_internal_zzal) throws RemoteException;

    void zza(AuthorizeAccessRequest authorizeAccessRequest, zzal com_google_android_gms_drive_internal_zzal) throws RemoteException;

    void zza(CancelPendingActionsRequest cancelPendingActionsRequest, zzal com_google_android_gms_drive_internal_zzal) throws RemoteException;

    void zza(CheckResourceIdsExistRequest checkResourceIdsExistRequest, zzal com_google_android_gms_drive_internal_zzal) throws RemoteException;

    void zza(CloseContentsAndUpdateMetadataRequest closeContentsAndUpdateMetadataRequest, zzal com_google_android_gms_drive_internal_zzal) throws RemoteException;

    void zza(CloseContentsRequest closeContentsRequest, zzal com_google_android_gms_drive_internal_zzal) throws RemoteException;

    void zza(CreateContentsRequest createContentsRequest, zzal com_google_android_gms_drive_internal_zzal) throws RemoteException;

    void zza(CreateFileRequest createFileRequest, zzal com_google_android_gms_drive_internal_zzal) throws RemoteException;

    void zza(CreateFolderRequest createFolderRequest, zzal com_google_android_gms_drive_internal_zzal) throws RemoteException;

    void zza(DeleteResourceRequest deleteResourceRequest, zzal com_google_android_gms_drive_internal_zzal) throws RemoteException;

    void zza(DisconnectRequest disconnectRequest) throws RemoteException;

    void zza(FetchThumbnailRequest fetchThumbnailRequest, zzal com_google_android_gms_drive_internal_zzal) throws RemoteException;

    void zza(GetChangesRequest getChangesRequest, zzal com_google_android_gms_drive_internal_zzal) throws RemoteException;

    void zza(GetDriveIdFromUniqueIdentifierRequest getDriveIdFromUniqueIdentifierRequest, zzal com_google_android_gms_drive_internal_zzal) throws RemoteException;

    void zza(GetMetadataRequest getMetadataRequest, zzal com_google_android_gms_drive_internal_zzal) throws RemoteException;

    void zza(GetPermissionsRequest getPermissionsRequest, zzal com_google_android_gms_drive_internal_zzal) throws RemoteException;

    void zza(ListParentsRequest listParentsRequest, zzal com_google_android_gms_drive_internal_zzal) throws RemoteException;

    void zza(LoadRealtimeRequest loadRealtimeRequest, zzal com_google_android_gms_drive_internal_zzal) throws RemoteException;

    void zza(QueryRequest queryRequest, zzal com_google_android_gms_drive_internal_zzal) throws RemoteException;

    void zza(QueryRequest queryRequest, zzam com_google_android_gms_drive_internal_zzam, zzal com_google_android_gms_drive_internal_zzal) throws RemoteException;

    void zza(RemoveEventListenerRequest removeEventListenerRequest, zzam com_google_android_gms_drive_internal_zzam, String str, zzal com_google_android_gms_drive_internal_zzal) throws RemoteException;

    void zza(RemovePermissionRequest removePermissionRequest, zzal com_google_android_gms_drive_internal_zzal) throws RemoteException;

    void zza(SetDrivePreferencesRequest setDrivePreferencesRequest, zzal com_google_android_gms_drive_internal_zzal) throws RemoteException;

    void zza(SetFileUploadPreferencesRequest setFileUploadPreferencesRequest, zzal com_google_android_gms_drive_internal_zzal) throws RemoteException;

    void zza(SetResourceParentsRequest setResourceParentsRequest, zzal com_google_android_gms_drive_internal_zzal) throws RemoteException;

    void zza(TrashResourceRequest trashResourceRequest, zzal com_google_android_gms_drive_internal_zzal) throws RemoteException;

    void zza(UnsubscribeResourceRequest unsubscribeResourceRequest, zzal com_google_android_gms_drive_internal_zzal) throws RemoteException;

    void zza(UntrashResourceRequest untrashResourceRequest, zzal com_google_android_gms_drive_internal_zzal) throws RemoteException;

    void zza(UpdateMetadataRequest updateMetadataRequest, zzal com_google_android_gms_drive_internal_zzal) throws RemoteException;

    void zza(UpdatePermissionRequest updatePermissionRequest, zzal com_google_android_gms_drive_internal_zzal) throws RemoteException;

    void zza(zzal com_google_android_gms_drive_internal_zzal) throws RemoteException;

    void zza(zzam com_google_android_gms_drive_internal_zzam, zzal com_google_android_gms_drive_internal_zzal) throws RemoteException;

    void zzb(QueryRequest queryRequest, zzal com_google_android_gms_drive_internal_zzal) throws RemoteException;

    void zzb(zzal com_google_android_gms_drive_internal_zzal) throws RemoteException;

    void zzc(zzal com_google_android_gms_drive_internal_zzal) throws RemoteException;

    void zzd(zzal com_google_android_gms_drive_internal_zzal) throws RemoteException;

    void zze(zzal com_google_android_gms_drive_internal_zzal) throws RemoteException;

    void zzf(zzal com_google_android_gms_drive_internal_zzal) throws RemoteException;
}
