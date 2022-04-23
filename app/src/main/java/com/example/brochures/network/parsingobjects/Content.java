package com.example.brochures.network.parsingobjects;

import com.squareup.moshi.Json;

public class Content {

    @Json(name = "placement")
    private String placement;
    @Json(name = "adFormat")
    private String adFormat;
    @Json(name = "contentFormatSource")
    private String contentFormatSource;
    @Json(name = "contentType")
    private String contentType;
    @Json(name = "externalTracking")
    private ExternalTracking externalTracking;
    @Json(name = "content")
    private Content__1 content;

    public String getPlacement() {
        return placement;
    }

    public void setPlacement(String placement) {
        this.placement = placement;
    }

    public String getAdFormat() {
        return adFormat;
    }

    public void setAdFormat(String adFormat) {
        this.adFormat = adFormat;
    }

    public String getContentFormatSource() {
        return contentFormatSource;
    }

    public void setContentFormatSource(String contentFormatSource) {
        this.contentFormatSource = contentFormatSource;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public ExternalTracking getExternalTracking() {
        return externalTracking;
    }

    public void setExternalTracking(ExternalTracking externalTracking) {
        this.externalTracking = externalTracking;
    }

    public Content__1 getContent() {
        return content;
    }

    public void setContent(Content__1 content) {
        this.content = content;
    }

}
