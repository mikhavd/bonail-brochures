package com.example.brochures.network.parsingobjects;

public class Item {

    @com.squareup.moshi.Json(name = "content")
    private Content__2 content;
    @com.squareup.moshi.Json(name = "externalTracking")
    private ExternalTracking externalTracking;

    public Content__2 getContent() {
        return content;
    }

    public void setContent(Content__2 content) {
        this.content = content;
    }

    public ExternalTracking getExternalTracking() {
        return externalTracking;
    }

    public void setExternalTracking(ExternalTracking externalTracking) {
        this.externalTracking = externalTracking;
    }

}
