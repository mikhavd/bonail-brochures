package com.example.brochures.network.parsingobjects

import com.squareup.moshi.Json

class Response {
    @Json(name = "_embedded")
    var embedded: Embedded? = null

    @Json(name = "_links")
    var links: Links? = null

    @Json(name = "page")
    var page: Page? = null
}