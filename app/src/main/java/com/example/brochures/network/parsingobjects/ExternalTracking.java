package com.example.brochures.network.parsingobjects;

import com.squareup.moshi.Json;

import java.util.List;
public class ExternalTracking {

    @Json(name = "impression")
    private List<Object> impression = null;
    @Json(name = "click")
    private List<String> click = null;

    public List<Object> getImpression() {
        return impression;
    }

    public void setImpression(List<Object> impression) {
        this.impression = impression;
    }

    public List<String> getClick() {
        return click;
    }

    public void setClick(List<String> click) {
        this.click = click;
    }

}
