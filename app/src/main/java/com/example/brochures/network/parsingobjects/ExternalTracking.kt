package com.example.brochures.network.parsingobjects

import com.squareup.moshi.Json

class ExternalTracking {
    @Json(name = "impression")
    var impression: List<Any>? = null

    @Json(name = "click")
    var click: List<String>? = null
}