package com.example.brochures.network.parsingobjects;

import java.util.List;
import com.squareup.moshi.Json;

public class Embedded {

    @Json(name = "contents")
    private List<Content> contents = null;

    public List<Content> getContents() {
        return contents;
    }

    public void setContents(List<Content> contents) {
        this.contents = contents;
    }

}
