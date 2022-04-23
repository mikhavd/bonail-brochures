package com.example.brochures.network.parsingobjects

import com.squareup.moshi.Json
import com.example.brochures.network.parsingobjects.LinkOut
import com.example.brochures.network.parsingobjects.Thumbnail

class Content__2 {
    @Json(name = "id")
    var id: String? = null

    @Json(name = "publisherId")
    var publisherId: String? = null

    @Json(name = "publishedFrom")
    var publishedFrom: String? = null

    @Json(name = "publishedUntil")
    var publishedUntil: String? = null

    @Json(name = "linkOut")
    var linkOut: LinkOut? = null

    @Json(name = "video")
    var video: Video? = null

    @Json(name = "thumbnail")
    var thumbnail: Thumbnail? = null

    @Json(name = "type")
    var type: String? = null
}