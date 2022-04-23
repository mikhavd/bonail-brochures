package com.example.brochures.network.parsingobjects;

public class Thumbnail {

    @com.squareup.moshi.Json(name = "dimensions")
    private Dimensions__1 dimensions;
    @com.squareup.moshi.Json(name = "url")
    private String url;

    public Dimensions__1 getDimensions() {
        return dimensions;
    }

    public void setDimensions(Dimensions__1 dimensions) {
        this.dimensions = dimensions;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
