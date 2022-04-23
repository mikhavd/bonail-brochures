package com.example.brochures.network.parsingobjects

import com.squareup.moshi.Json

class LinkOut {
    @Json(name = "label")
    var label: String? = null

    @Json(name = "mobileUrl")
    var mobileUrl: String? = null

    @Json(name = "webUrl")
    var webUrl: Any? = null

    @Json(name = "bgColor")
    var bgColor: String? = null

    @Json(name = "textColor")
    var textColor: String? = null
}