package com.example.brochures.network.parsingobjects

import com.squareup.moshi.Json

class InnerContent {
    @Json(name = "id")
    var id: Int? = null

    @Json(name = "title")
    var title: String? = null

    @Json(name = "validFrom")
    var validFrom: String? = null

    @Json(name = "validUntil")
    var validUntil: String? = null

    @Json(name = "publishedFrom")
    var publishedFrom: String? = null

    @Json(name = "publishedUntil")
    var publishedUntil: String? = null

    @Json(name = "type")
    var type: String? = null

    @Json(name = "pageCount")
    var pageCount: Int? = null

    @Json(name = "publisher")
    var publisher: Publisher? = null

    @Json(name = "retailer")
    var retailer: Retailer? = null

    @Json(name = "brochureImage")
    var brochureImage: String? = null

    @Json(name = "badges")
    var badges: List<Any>? = null

    @Json(name = "isEcommerce")
    var isEcommerce: Boolean? = null

    @Json(name = "distance")
    var distance: Double? = null

    @Json(name = "hideValidityDate")
    var hideValidityDate: Boolean? = null

    @Json(name = "publisherId")
    var publisherId: String? = null

    @Json(name = "publisherImage")
    var publisherImage: String? = null

    @Json(name = "items")
    var items: List<Item>? = null

    @Json(name = "campaign_item_id")
    val compaign: String? = null

    @Json(name = "link")
    val link: String? = null

    @Json(name = "imgURL")
    val imgURL: String? = null

    @Json(name = "teaserText")
    val teaserText: String? = null

    @Json(name = "remoteOfferId")
    val remoteOfferId: String? = null

    @Json(name = "displayName")
    val displayName: String? = null

    @Json(name = "savingsValueStatement")
    val savingsValueStatement: String? = null

    @Json(name = "landingPageUrl")
    val landingPageUrl: String? = null

    @Json(name = "imageUrl")
    val imageUrl: String? = null

    @Json(name = "clickUrl")
    val clickUrl: String? = null
}