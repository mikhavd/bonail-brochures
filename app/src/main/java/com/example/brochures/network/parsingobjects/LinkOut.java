package com.example.brochures.network.parsingobjects;

public class LinkOut {

    @com.squareup.moshi.Json(name = "label")
    private String label;
    @com.squareup.moshi.Json(name = "mobileUrl")
    private String mobileUrl;
    @com.squareup.moshi.Json(name = "webUrl")
    private Object webUrl;
    @com.squareup.moshi.Json(name = "bgColor")
    private String bgColor;
    @com.squareup.moshi.Json(name = "textColor")
    private String textColor;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getMobileUrl() {
        return mobileUrl;
    }

    public void setMobileUrl(String mobileUrl) {
        this.mobileUrl = mobileUrl;
    }

    public Object getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(Object webUrl) {
        this.webUrl = webUrl;
    }

    public String getBgColor() {
        return bgColor;
    }

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }

    public String getTextColor() {
        return textColor;
    }

    public void setTextColor(String textColor) {
        this.textColor = textColor;
    }

}
