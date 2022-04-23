package com.example.brochures.network.parsingobjects

import com.squareup.moshi.Json

class Thumbnail {
    @Json(name = "dimensions")
    var dimensions: AdditionalDimensions? = null

    @Json(name = "url")
    var url: String? = null
}