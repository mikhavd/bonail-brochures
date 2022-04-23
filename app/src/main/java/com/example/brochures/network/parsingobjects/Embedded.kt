package com.example.brochures.network.parsingobjects

import com.example.brochures.network.SingleToArray
import com.squareup.moshi.Json

class Embedded {
    @Json(name = "contents")
    @SingleToArray
    var contents: List<Content>? = null
}