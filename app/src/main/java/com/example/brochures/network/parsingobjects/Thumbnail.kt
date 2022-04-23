package com.example.brochures.network.parsingobjects

import com.squareup.moshi.Json

class Thumbnail {
    @Json(name = "dimensions")
    var dimensions: Dimensions__1? = null

    @Json(name = "url")
    var url: String? = null
}