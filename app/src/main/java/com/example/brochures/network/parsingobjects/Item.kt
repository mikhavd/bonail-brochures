package com.example.brochures.network.parsingobjects

import com.squareup.moshi.Json

class Item {
    @Json(name = "content")
    var content: Content__2? = null

    @Json(name = "externalTracking")
    var externalTracking: ExternalTracking? = null
}