package com.example.brochures.network.parsingobjects

import com.squareup.moshi.Json

class Retailer {
    @Json(name = "id")
    var id: Int? = null

    @Json(name = "name")
    var name: String? = null
}