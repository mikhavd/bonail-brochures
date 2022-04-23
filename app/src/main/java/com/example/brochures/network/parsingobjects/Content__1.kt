package com.example.brochures.network.parsingobjects

import com.squareup.moshi.Json

/**
 * TODO
 * @author Mikhail Avdeev (mvavdeev@sberbank.ru)
 */

class Content__1 {
    @Json(name = "title")
    var title: String? = null

    @Json(name = "publisherId")
    var publisherId: String? = null

    @Json(name = "publisherImage")
    var publisherImage: String? = null

    @Json(name = "items")
    var items: List<Item>? = null
}