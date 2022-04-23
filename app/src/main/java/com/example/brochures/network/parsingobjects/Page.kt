package com.example.brochures.network.parsingobjects

import com.squareup.moshi.Json

class Page {
    @Json(name = "size")
    var size: Int? = null

    @Json(name = "totalElements")
    var totalElements: Int? = null

    @Json(name = "totalPages")
    var totalPages: Int? = null

    @Json(name = "number")
    var number: Int? = null
}