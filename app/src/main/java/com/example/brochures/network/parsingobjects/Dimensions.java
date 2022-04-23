package com.example.brochures.network.parsingobjects;

public class Dimensions {

    @com.squareup.moshi.Json(name = "height")
    private Integer height;
    @com.squareup.moshi.Json(name = "width")
    private Integer width;

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

}
