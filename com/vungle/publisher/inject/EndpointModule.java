package com.vungle.publisher.inject;

import dagger.Module;

@Module
/* compiled from: vungle */
public class EndpointModule {
    public String f2178a = "https://api.vungle.com/api/v4/";
    public String f2179b = "https://ingest.vungle.com/";

    public EndpointModule setVungleBaseUrl(String vungleBaseUrl) {
        this.f2178a = vungleBaseUrl;
        return this;
    }

    public EndpointModule setIngestBaseUrl(String ingestBaseUrl) {
        this.f2179b = ingestBaseUrl;
        return this;
    }
}
