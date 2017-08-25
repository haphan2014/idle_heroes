package com.heyzap.common.vast.model;

import com.facebook.AppEventsConstants;
import java.io.Serializable;
import java.math.BigInteger;

public class VASTMediaFile implements Serializable {
    private static final long serialVersionUID = -707854068457983406L;
    private String apiFramework;
    private BigInteger bitrate;
    private String delivery;
    private BigInteger height = new BigInteger(AppEventsConstants.EVENT_PARAM_VALUE_YES);
    private String id;
    private Boolean maintainAspectRatio;
    private Boolean scalable;
    private String type;
    private String value;
    private BigInteger width = new BigInteger(AppEventsConstants.EVENT_PARAM_VALUE_YES);

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String value) {
        this.id = value;
    }

    public String getDelivery() {
        return this.delivery;
    }

    public void setDelivery(String value) {
        this.delivery = value;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String value) {
        this.type = value;
    }

    public BigInteger getBitrate() {
        return this.bitrate;
    }

    public void setBitrate(BigInteger value) {
        this.bitrate = value;
    }

    public BigInteger getWidth() {
        return this.width;
    }

    public void setWidth(BigInteger value) {
        if (value != null) {
            this.width = value;
        }
    }

    public BigInteger getHeight() {
        return this.height;
    }

    public void setHeight(BigInteger value) {
        if (value != null) {
            this.height = value;
        }
    }

    public Boolean isScalable() {
        return this.scalable;
    }

    public void setScalable(Boolean value) {
        this.scalable = value;
    }

    public Boolean isMaintainAspectRatio() {
        return this.maintainAspectRatio;
    }

    public void setMaintainAspectRatio(Boolean value) {
        this.maintainAspectRatio = value;
    }

    public String getApiFramework() {
        return this.apiFramework;
    }

    public void setApiFramework(String value) {
        this.apiFramework = value;
    }

    public String toString() {
        return "MediaFile [value=" + this.value + ", id=" + this.id + ", delivery=" + this.delivery + ", type=" + this.type + ", bitrate=" + this.bitrate + ", width=" + this.width + ", height=" + this.height + ", scalable=" + this.scalable + ", maintainAspectRatio=" + this.maintainAspectRatio + ", apiFramework=" + this.apiFramework + "]";
    }
}
