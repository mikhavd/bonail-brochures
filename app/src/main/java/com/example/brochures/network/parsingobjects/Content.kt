package com.example.brochures.network.parsingobjects

import com.example.brochures.network.SingleToArray
import com.squareup.moshi.Json

class Content {
    @Json(name = "placement")
    var placement: String? = null

    @Json(name = "adFormat")
    var adFormat: String? = null

    @Json(name = "contentFormatSource")
    var contentFormatSource: String? = null

    @Json(name = "contentType")
    var contentType: String? = null

    @Json(name = "externalTracking")
    var externalTracking: ExternalTracking? = null

    @Json(name = "content")
    //todo @SingleToArray
    val innerContentWrapper: InnerContentWrapper? = null //List<InnerContent>? = null //todo  List<Content__1>? = null
}