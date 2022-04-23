package com.example.brochures.network.parsingobjects;

public class Content__2 {

    @com.squareup.moshi.Json(name = "id")
    private String id;
    @com.squareup.moshi.Json(name = "publisherId")
    private String publisherId;
    @com.squareup.moshi.Json(name = "publishedFrom")
    private String publishedFrom;
    @com.squareup.moshi.Json(name = "publishedUntil")
    private String publishedUntil;
    @com.squareup.moshi.Json(name = "linkOut")
    private LinkOut linkOut;
    @com.squareup.moshi.Json(name = "video")
    private Video video;
    @com.squareup.moshi.Json(name = "thumbnail")
    private Thumbnail thumbnail;
    @com.squareup.moshi.Json(name = "type")
    private String type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(String publisherId) {
        this.publisherId = publisherId;
    }

    public String getPublishedFrom() {
        return publishedFrom;
    }

    public void setPublishedFrom(String publishedFrom) {
        this.publishedFrom = publishedFrom;
    }

    public String getPublishedUntil() {
        return publishedUntil;
    }

    public void setPublishedUntil(String publishedUntil) {
        this.publishedUntil = publishedUntil;
    }

    public LinkOut getLinkOut() {
        return linkOut;
    }

    public void setLinkOut(LinkOut linkOut) {
        this.linkOut = linkOut;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}

