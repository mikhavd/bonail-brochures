package com.example.brochures.network

import com.example.brochures.brochuresfragment.BrochureItem

class ShelfResponse {

    private val TEST_IMAGE_URL: String =
        "https://content-media.bonial.biz/64aa6e5e-7a36-40a8-9e65-c90efe0df3f5/4f8f7ba7-72a5-47cb-82e7-62335db48c81.png"

    //todo this is a stub
    private val testArrayList = arrayListOf(BrochureItem("name", image = null, TEST_IMAGE_URL))

    fun toBrochuresList(): ArrayList<BrochureItem> {
        return testArrayList
    }
}
