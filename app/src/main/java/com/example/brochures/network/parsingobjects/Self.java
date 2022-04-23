package com.example.brochures.network.parsingobjects;

import com.squareup.moshi.Json;

public class Self {

    @Json(name = "href")
    private String href;

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

}
