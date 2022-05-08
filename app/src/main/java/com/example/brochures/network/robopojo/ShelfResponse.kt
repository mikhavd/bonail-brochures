package com.example.brochures.network.robopojo

import com.example.brochures.network.SingleToArray
import com.squareup.moshi.Json

data class ShelfResponse(

	@Json(name = "_embedded")
	val embedded: Embedded? = null,

	@Json(name = "_links")
	val links: Links? = null,

	@Json(name = "page")
	val page: Page? = null,
)

data class ExternalTracking(

	@Json(name = "impression")
	val impression: List<Any?>? = null,

	@Json(name = "click")
	val click: List<Any?>? = null,
)

data class Thumbnail(

	@Json(name = "url")
	val url: String? = null,

	@Json(name = "dimensions")
	val dimensions: Dimensions? = null,
)

data class Video(

	@Json(name = "sizes")
	val sizes: List<SizesItem?>? = null,
)

data class Self(

	@Json(name = "href")
	val href: String? = null,
)

data class Links(

	@Json(name = "self")
	val self: Self? = null,
)

data class Dimensions(

	@Json(name = "width")
	val width: Int? = null,

	@Json(name = "height")
	val height: Int? = null,
)

data class LinkOut(

	@Json(name = "bgColor")
	val bgColor: String? = null,

	@Json(name = "webUrl")
	val webUrl: Any? = null,

	@Json(name = "label")
	val label: String? = null,

	@Json(name = "mobileUrl")
	val mobileUrl: String? = null,

	@Json(name = "textColor")
	val textColor: String? = null,
)

data class Publisher(

	@Json(name = "name")
	val name: String? = null,

	@Json(name = "id")
	val id: Int? = null,

	@Json(name = "type")
	val type: String? = null,
)

data class SizesItem(

	@Json(name = "url")
	val url: String? = null,

	@Json(name = "dimensions")
	val dimensions: Dimensions? = null,
)

data class ContentItem(

	@Json(name = "externalTracking")
	val externalTracking: ExternalTracking? = null,

	@Json(name = "content")
	val content: Content? = null,

	@Json(name = "publisherId")
	val publisherId: String? = null,

	@Json(name = "title")
	val title: String? = null,

	@Json(name = "publisherImage")
	val publisherImage: String? = null,

	@Json(name = "items")
	val items: List<ItemsItem?>? = null,

	@Json(name = "imgURL")
	val imgURL: String? = null,

	@Json(name = "teaserText")
	val teaserText: String? = null,

	@Json(name = "link")
	val link: String? = null,

	@Json(name = "campaign_item_id")
	val campaignItemId: String? = null,

	@Json(name = "id")
	val id: Int? = null,

	@Json(name = "savingsValueStatement")
	val savingsValueStatement: String? = null,

	@Json(name = "remoteOfferId")
	val remoteOfferId: String? = null,

	@Json(name = "displayName")
	val displayName: String? = null,

	@Json(name = "imageUrl")
	val imageUrl: String? = null,

	@Json(name = "landingPageUrl")
	val landingPageUrl: String? = null,

	@Json(name = "pageCount")
	val pageCount: Int? = null,

	@Json(name = "isEcommerce")
	val isEcommerce: Boolean? = null,

	@Json(name = "distance")
	val distance: Double? = null,

	@Json(name = "retailer")
	val retailer: Retailer? = null,

	@Json(name = "publishedUntil")
	val publishedUntil: String? = null,

	@Json(name = "validFrom")
	val validFrom: String? = null,

	@Json(name = "type")
	val type: String? = null,

	@Json(name = "publishedFrom")
	val publishedFrom: String? = null,

	@Json(name = "badges")
	val badges: List<Any?>? = null,

	@Json(name = "brochureImage")
	val brochureImage: String? = null,

	@Json(name = "hideValidityDate")
	val hideValidityDate: Boolean? = null,

	@Json(name = "validUntil")
	val validUntil: String? = null,

	@Json(name = "publisher")
	val publisher: Publisher? = null,

	@Json(name = "clickUrl")
	val clickUrl: String? = null,

	@Json(name = "thumbnail")
	val thumbnail: Thumbnail? = null,

	@Json(name = "linkOut")
	val linkOut: LinkOut? = null,

	@Json(name = "video")
	val video: Video? = null,
)

data class ContentsItem(

	@Json(name = "placement")
	val placement: String? = null,

	@Json(name = "adFormat")
	val adFormat: Any? = null,

	@Json(name = "externalTracking")
	val externalTracking: ExternalTracking? = null,

	@Json(name = "contentType")
	val contentType: String? = null,

	@Json(name = "contentFormatSource")
	val contentFormatSource: String? = null,

	@Json(name = "content")
	@SingleToArray
	val content: List<ContentItem?>? = null,
)

data class Page(

	@Json(name = "number")
	val number: Int? = null,

	@Json(name = "size")
	val size: Int? = null,

	@Json(name = "totalPages")
	val totalPages: Int? = null,

	@Json(name = "totalElements")
	val totalElements: Int? = null,
)

data class Embedded(

	@Json(name = "contents")
	@SingleToArray
	val contents: List<ContentsItem?>? = null,
)

data class Content(

	@Json(name = "pageCount")
	val pageCount: Int? = null,

	@Json(name = "isEcommerce")
	val isEcommerce: Boolean? = null,

	@Json(name = "distance")
	val distance: Double? = null,

	@Json(name = "retailer")
	val retailer: Retailer? = null,

	@Json(name = "publishedUntil")
	val publishedUntil: String? = null,

	@Json(name = "validFrom")
	val validFrom: String? = null,

	@Json(name = "title")
	val title: String? = null,

	@Json(name = "type")
	val type: String? = null,

	@Json(name = "publishedFrom")
	val publishedFrom: String? = null,

	@Json(name = "badges")
	val badges: List<Any?>? = null,

	@Json(name = "brochureImage")
	val brochureImage: String? = null,

	@Json(name = "hideValidityDate")
	val hideValidityDate: Boolean? = null,

	@Json(name = "validUntil")
	val validUntil: String? = null,

	@Json(name = "publisher")
	val publisher: Publisher? = null,

	@Json(name = "id")
	val id: String? = null,

	@Json(name = "imageUrl")
	val imageUrl: String? = null,

	@Json(name = "link")
	val link: String? = null,

	@Json(name = "clickUrl")
	val clickUrl: String? = null,

	@Json(name = "publisherId")
	val publisherId: Int? = null,

	@Json(name = "thumbnail")
	val thumbnail: Thumbnail? = null,

	@Json(name = "linkOut")
	val linkOut: LinkOut? = null,

	@Json(name = "video")
	val video: Video? = null,
)

data class ItemsItem(

	@Json(name = "externalTracking")
	val externalTracking: ExternalTracking? = null,

	@Json(name = "content")
	val content: Content? = null,
)

data class Retailer(

	@Json(name = "name")
	val name: String? = null,

	@Json(name = "id")
	val id: Int? = null,
)
