package com.example.brochures.network.parsingobjects;

import com.squareup.moshi.Json;
public class Links {

    @Json(name = "self")
    private Self self;

    public Self getSelf() {
        return self;
    }

    public void setSelf(Self self) {
        this.self = self;
    }

}
