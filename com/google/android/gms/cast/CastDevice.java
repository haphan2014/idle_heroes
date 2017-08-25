package com.google.android.gms.cast;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CastDevice implements SafeParcelable {
    public static final int CAPABILITY_AUDIO_IN = 8;
    public static final int CAPABILITY_AUDIO_OUT = 4;
    public static final int CAPABILITY_VIDEO_IN = 2;
    public static final int CAPABILITY_VIDEO_OUT = 1;
    public static final Creator<CastDevice> CREATOR = new zzb();
    private final int zzCY;
    private String zzQL;
    String zzQM;
    private Inet4Address zzQN;
    private String zzQO;
    private String zzQP;
    private String zzQQ;
    private int zzQR;
    private List<WebImage> zzQS;
    private int zzQT;
    private int zzwS;

    private CastDevice() {
        this(3, null, null, null, null, null, -1, new ArrayList(), 0, -1);
    }

    CastDevice(int versionCode, String deviceId, String hostAddress, String friendlyName, String modelName, String deviceVersion, int servicePort, List<WebImage> icons, int capabilities, int status) {
        this.zzCY = versionCode;
        this.zzQL = deviceId;
        this.zzQM = hostAddress;
        if (this.zzQM != null) {
            try {
                InetAddress byName = InetAddress.getByName(this.zzQM);
                if (byName instanceof Inet4Address) {
                    this.zzQN = (Inet4Address) byName;
                }
            } catch (UnknownHostException e) {
                this.zzQN = null;
            }
        }
        this.zzQO = friendlyName;
        this.zzQP = modelName;
        this.zzQQ = deviceVersion;
        this.zzQR = servicePort;
        this.zzQS = icons;
        this.zzQT = capabilities;
        this.zzwS = status;
    }

    public static CastDevice getFromBundle(Bundle extras) {
        if (extras == null) {
            return null;
        }
        extras.setClassLoader(CastDevice.class.getClassLoader());
        return (CastDevice) extras.getParcelable("com.google.android.gms.cast.EXTRA_CAST_DEVICE");
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CastDevice)) {
            return false;
        }
        CastDevice castDevice = (CastDevice) obj;
        return getDeviceId() == null ? castDevice.getDeviceId() == null : zzf.zza(this.zzQL, castDevice.zzQL) && zzf.zza(this.zzQN, castDevice.zzQN) && zzf.zza(this.zzQP, castDevice.zzQP) && zzf.zza(this.zzQO, castDevice.zzQO) && zzf.zza(this.zzQQ, castDevice.zzQQ) && this.zzQR == castDevice.zzQR && zzf.zza(this.zzQS, castDevice.zzQS) && this.zzQT == castDevice.zzQT && this.zzwS == castDevice.zzwS;
    }

    public int getCapabilities() {
        return this.zzQT;
    }

    public String getDeviceId() {
        return this.zzQL;
    }

    public String getDeviceVersion() {
        return this.zzQQ;
    }

    public String getFriendlyName() {
        return this.zzQO;
    }

    public WebImage getIcon(int preferredWidth, int preferredHeight) {
        WebImage webImage = null;
        if (this.zzQS.isEmpty()) {
            return null;
        }
        if (preferredWidth <= 0 || preferredHeight <= 0) {
            return (WebImage) this.zzQS.get(0);
        }
        WebImage webImage2 = null;
        for (WebImage webImage3 : this.zzQS) {
            WebImage webImage32;
            int width = webImage32.getWidth();
            int height = webImage32.getHeight();
            if (width < preferredWidth || height < preferredHeight) {
                if (width < preferredWidth && height < preferredHeight && (webImage == null || (webImage.getWidth() < width && webImage.getHeight() < height))) {
                    webImage = webImage2;
                }
                webImage32 = webImage;
                webImage = webImage2;
            } else {
                if (webImage2 == null || (webImage2.getWidth() > width && webImage2.getHeight() > height)) {
                    WebImage webImage4 = webImage;
                    webImage = webImage32;
                    webImage32 = webImage4;
                }
                webImage32 = webImage;
                webImage = webImage2;
            }
            webImage2 = webImage;
            webImage = webImage32;
        }
        if (webImage2 == null) {
            webImage2 = webImage != null ? webImage : (WebImage) this.zzQS.get(0);
        }
        return webImage2;
    }

    public List<WebImage> getIcons() {
        return Collections.unmodifiableList(this.zzQS);
    }

    public Inet4Address getIpAddress() {
        return this.zzQN;
    }

    public String getModelName() {
        return this.zzQP;
    }

    public int getServicePort() {
        return this.zzQR;
    }

    public int getStatus() {
        return this.zzwS;
    }

    int getVersionCode() {
        return this.zzCY;
    }

    public boolean hasCapabilities(int[] capabilities) {
        if (capabilities == null) {
            return false;
        }
        for (int hasCapability : capabilities) {
            if (!hasCapability(hasCapability)) {
                return false;
            }
        }
        return true;
    }

    public boolean hasCapability(int capability) {
        return (this.zzQT & capability) == capability;
    }

    public boolean hasIcons() {
        return !this.zzQS.isEmpty();
    }

    public int hashCode() {
        return this.zzQL == null ? 0 : this.zzQL.hashCode();
    }

    public boolean isOnLocalNetwork() {
        return !this.zzQL.startsWith("__cast_nearby__");
    }

    public boolean isSameDevice(CastDevice castDevice) {
        return castDevice == null ? false : getDeviceId() == null ? castDevice.getDeviceId() == null : zzf.zza(getDeviceId(), castDevice.getDeviceId());
    }

    public void putInBundle(Bundle bundle) {
        if (bundle != null) {
            bundle.putParcelable("com.google.android.gms.cast.EXTRA_CAST_DEVICE", this);
        }
    }

    public String toString() {
        return String.format("\"%s\" (%s)", new Object[]{this.zzQO, this.zzQL});
    }

    public void writeToParcel(Parcel out, int flags) {
        zzb.zza(this, out, flags);
    }
}
