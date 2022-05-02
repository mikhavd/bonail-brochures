package com.example.brochures.brochuresfragment

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.brochures.network.BrochuresApi
import com.example.brochures.network.robopojo.ContentItem
import kotlinx.coroutines.launch
import java.lang.Exception

/**
 * TODO
 * @author Mikhail Avdeev (mvavdeev@sberbank.ru)
 */
class BrochuresViewModel : ViewModel() {

    private val _status = MutableLiveData<List<BrochureItem>>()
    val status: MutableLiveData<List<BrochureItem>> = _status

    init {
        loadBrochures()
    }

    fun getBrochures(): LiveData<List<BrochureItem>> = status

    private fun loadBrochures() {
        viewModelScope.launch {
            _status.value = getBrochuresList()
        }
    }

    private suspend fun testList() = listOf(
        BrochureItem(getTestAnswer() ?: "", null, additionalDescription = ""),
        BrochureItem("name", image = null, "retailer_name")
    )

    private suspend fun getBrochuresList(): List<BrochureItem> {
        val brochureList = arrayListOf<BrochureItem>()
        val brochuresContent = arrayListOf<ContentItem>()
        val retrofit = BrochuresApi.retrofitService
        try {
            retrofit.getResponse().embedded?.contents?.filter { contentsItem ->
                BROCHURES_CONTENT_TYPE.contains(contentsItem?.contentType)
            }?.forEach { brochure ->
                brochure?.content?.firstOrNull { it?.retailer?.name != null }?.let { brochuresContent += it }
            }
        } catch (e: Exception) {
            "Failure: ${e.message}"
            Log.d("brochures", "e: $e")
        } finally {
        }
        brochuresContent.forEachIndexed { index, element ->
            val brochureItem = BrochureItem(
                name = element.retailer?.name ?: "",
                //todo retrofit.getImage(element.brochureImage),
                additionalDescription = (index.toString() + 1))
            brochureList += brochureItem //todo !it.brochureImage) }}

        }
        return brochureList.takeIf(ArrayList<BrochureItem>::isNotEmpty) ?: testList()
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