package com.example.brochures.network.parsingobjects

import com.squareup.moshi.Json

class Size {
    @Json(name = "dimensions")
    var dimensions: Dimensions? = null

    @Json(name = "url")
    var url: String? = null
}