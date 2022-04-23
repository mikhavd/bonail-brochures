package com.example.brochures.brochuresfragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * TODO
 * @author Mikhail Avdeev (mvavdeev@sberbank.ru)
 */
class BrochuresViewModel : ViewModel() {

    private val brochures: MutableLiveData<List<BrochureItem>> by lazy(::loadBrochures)

    fun getBrochures(): LiveData<List<BrochureItem>> {
        return brochures
    }

    private fun loadBrochures(): MutableLiveData<List<BrochureItem>> {
        //todo this is a stub
        return MutableLiveData<List<BrochureItem>>().apply {
            value = (arrayListOf(BrochureItem("name", null, "retailer_name")))
        }
    }
}