package com.example.brochures.brochuresfragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.brochures.network.BrochuresApi
import kotlinx.coroutines.launch
import java.lang.Exception

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
        return MutableLiveData<List<BrochureItem>>().apply {
            viewModelScope.launch {
                var answer: String? = null
                try {
                    answer = BrochuresApi.retrofitService.getResponse().toString() //todo .toBrochuresList()
                } catch (e: Exception) {
                    answer = "Failure: ${e.message}"
                } finally {
                    value = listOf(BrochureItem(answer ?: "", null, retailerName = "", ""))
                }
            }

        }
    }
}