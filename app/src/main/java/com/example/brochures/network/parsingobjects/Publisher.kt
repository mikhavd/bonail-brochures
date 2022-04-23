package com.example.brochures.network.parsingobjects

import com.squareup.moshi.Json

class Publisher {
    @Json(name = "id")
    var id: Int? = null

    @Json(name = "name")
    var name: String? = null

    @Json(name = "type")
    var type: String? = null
}