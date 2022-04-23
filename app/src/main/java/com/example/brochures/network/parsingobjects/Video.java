package com.example.brochures.network.parsingobjects;

import com.squareup.moshi.Json;

import java.util.List;

public class Video {

    @Json(name = "sizes")
    private List<Size> sizes = null;

    public List<Size> getSizes() {
        return sizes;
    }

    public void setSizes(List<Size> sizes) {
        this.sizes = sizes;
    }

}
