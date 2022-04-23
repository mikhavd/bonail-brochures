package com.example.brochures.brochuresfragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * TODO
 * @author Mikhail Avdeev (mvavdeev@sberbank.ru)
 */
class BrochuresViewModel : ViewModel() {

    private val TEST_IMAGE_URL: String =
        "https://content-media.bonial.biz/64aa6e5e-7a36-40a8-9e65-c90efe0df3f5/4f8f7ba7-72a5-47cb-82e7-62335db48c81.png"
    private val brochures: MutableLiveData<List<BrochureItem>> by lazy(::loadBrochures)

    fun getBrochures(): LiveData<List<BrochureItem>> {
        return brochures
    }

    private fun loadBrochures(): MutableLiveData<List<BrochureItem>> {
        //todo this is a stub
        return MutableLiveData<List<BrochureItem>>().apply {
            value = (arrayListOf(BrochureItem("name", image = null, TEST_IMAGE_URL, "retailer_name")))
        }
    }
}