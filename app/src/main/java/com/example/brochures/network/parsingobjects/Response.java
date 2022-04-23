package com.example.brochures.network.parsingobjects;


import com.squareup.moshi.Json;

public class Response {

    @Json(name = "_embedded")
    private Embedded embedded;
    @Json(name = "_links")
    private Links links;
    @Json(name = "page")
    private Page page;

    public Embedded getEmbedded() {
        return embedded;
    }

    public void setEmbedded(Embedded embedded) {
        this.embedded = embedded;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

}
