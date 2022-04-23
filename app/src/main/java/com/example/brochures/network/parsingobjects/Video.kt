package com.example.brochures.network.parsingobjects

import com.squareup.moshi.Json

class Video {
    @Json(name = "sizes")
    var sizes: List<Size>? = null
}