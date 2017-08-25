package com.heyzap.common.vast.model;

import com.facebook.internal.ServerProtocol;

public enum VASTDocElement {
    vastVersion("2.0"),
    vasts("VASTS"),
    vastAdTagURI("VASTAdTagURI"),
    vastVersionAttribute(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION);
    
    private String value;

    private VASTDocElement(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
