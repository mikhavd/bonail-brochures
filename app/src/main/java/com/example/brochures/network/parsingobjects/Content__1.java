package com.example.brochures.network.parsingobjects;


import java.util.List;

public class Content__1 {

    @com.squareup.moshi.Json(name = "title")
    private String title;
    @com.squareup.moshi.Json(name = "publisherId")
    private String publisherId;
    @com.squareup.moshi.Json(name = "publisherImage")
    private String publisherImage;
    @com.squareup.moshi.Json(name = "items")
    private List<Item> items = null;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(String publisherId) {
        this.publisherId = publisherId;
    }

    public String getPublisherImage() {
        return publisherImage;
    }

    public void setPublisherImage(String publisherImage) {
        this.publisherImage = publisherImage;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

}
