package com.example.brochures.network.parsingobjects

import com.squareup.moshi.Json

class Links {
    @Json(name = "self")
    var self: Self? = null
}