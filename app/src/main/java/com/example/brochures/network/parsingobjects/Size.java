package com.example.brochures.network.parsingobjects;

public class Size {

    @com.squareup.moshi.Json(name = "dimensions")
    private Dimensions dimensions;
    @com.squareup.moshi.Json(name = "url")
    private String url;

    public Dimensions getDimensions() {
        return dimensions;
    }

    public void setDimensions(Dimensions dimensions) {
        this.dimensions = dimensions;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
