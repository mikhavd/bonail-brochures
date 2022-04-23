package com.example.brochures.network.parsingobjects;

import com.squareup.moshi.Json;

public class Page {

    @Json(name = "size")
    private Integer size;
    @Json(name = "totalElements")
    private Integer totalElements;
    @Json(name = "totalPages")
    private Integer totalPages;
    @Json(name = "number")
    private Integer number;

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(Integer totalElements) {
        this.totalElements = totalElements;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

}
