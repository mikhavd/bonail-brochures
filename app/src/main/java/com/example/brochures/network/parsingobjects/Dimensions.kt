package com.example.brochures.network.parsingobjects

import com.squareup.moshi.Json

class Dimensions {
    @Json(name = "height")
    var height: Int? = null

    @Json(name = "width")
    var width: Int? = null
}