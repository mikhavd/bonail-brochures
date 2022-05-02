package com.example.brochures.brochuresfragment

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.brochures.network.BrochuresApi
import com.example.brochures.network.BrochuresApiService
import com.example.brochures.network.robopojo.ContentItem
import com.example.brochures.recycler.DisplayableBrochureItem
import kotlinx.coroutines.launch
import java.lang.Exception

/**
 * TODO
 * @author Mikhail Avdeev (mvavdeev@sberbank.ru)
 */
class BrochuresViewModel : ViewModel() {

    //todo private val _status = MutableLiveData<List<DisplayableBrochureItem>>()
    // todo val status: MutableLiveData<List<DisplayableBrochureItem>> = _status

    private val _brochures = MutableLiveData<List<ContentItem>>()
    val brochures: LiveData<List<ContentItem>> = _brochures

    init {
        loadBrochures()
    }

    private fun loadBrochures() {
        viewModelScope.launch {
            _brochures.value = BrochuresApi.retrofitService.getBrochuresContent()
        }
    }

    private suspend fun testList() = listOf(
        DisplayableBrochureItem(getTestAnswer() ?: "", null, additionalDescription = ""),
        DisplayableBrochureItem("name", image = null, "retailer_name")
    )

    private suspend fun getDisplayableBrochuresList(): List<DisplayableBrochureItem> {
        val brochureList = arrayListOf<DisplayableBrochureItem>()

        val retrofitService = BrochuresApi.retrofitService
        val brochuresContent = retrofitService.getBrochuresContent()
        _brochures.value = brochuresContent
        brochuresContent.forEachIndexed { index, element ->
            val brochureItem = DisplayableBrochureItem(
                name = element.retailer?.name ?: "",
                additionalDescription = (index.toString() + 1))
            brochureList += brochureItem
        }
        return brochureList.takeIf(ArrayList<DisplayableBrochureItem>::isNotEmpty) ?: testList()
    }

    private suspend fun BrochuresApiService.getBrochuresContent(): ArrayList<ContentItem> {
        val brochureList = arrayListOf<ContentItem>()
        try {
            getResponse().embedded?.contents?.filter { contentsItem ->
                BROCHURES_CONTENT_TYPE.contains(contentsItem?.contentType)
            }?.forEach { brochure ->
                brochure?.content?.firstOrNull { content ->
                    content?.retailer?.name != null
                }?.let { brochureList.plusAssign(it) }
            }
        } catch (e: Exception) {
            "Failure: ${e.message}"
            Log.d("brochures", "e: $e")
        } finally {
        }
        return brochureList
    }

    private suspend fun getTestAnswer(): String? {
        val testAnswer: String? = try {
            BrochuresApi.retrofitService.getResponse().links?.self?.href ?: "moshi didn't convert"
        } catch (e: Exception) {
            "Failure: ${e.message}"
        } finally {
        }
        return testAnswer
    }

    companion object {
        private val BROCHURES_CONTENT_TYPE: Set<String> =
            setOf("brochure".lowercase(), "brochurePremium".lowercase())
    }
}