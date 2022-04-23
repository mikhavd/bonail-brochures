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

    //todo private val brochures: MutableLiveData<List<BrochureItem>> by lazy(::loadBrochures)
    // The internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData<List<BrochureItem>>()

    val status: MutableLiveData<List<BrochureItem>> = _status

    init {
        loadBrochures()
    }

    fun getBrochures(): LiveData<List<BrochureItem>> = status

    private fun loadBrochures() {
        viewModelScope.launch {
            _status.value = getBrochuresList() //todo testList()
        }
    }

    private suspend fun testList() = listOf(
        BrochureItem(getTestAnswer() ?: "", null, retailerName = ""),
        BrochureItem("name", image = null, "retailer_name")
    )

    private suspend fun getBrochuresList(): List<BrochureItem> {
        val brochureList = arrayListOf<BrochureItem>()
        try {
            BrochuresApi.retrofitService.getResponse().embedded?.contents?.filter { content ->
                BROCHURES_CONTENT_TYPE.contains(content.contentType?.lowercase())
            }?.mapNotNull { content ->
                content.innerContentWrapper?.innerContent?.forEach { innerContent ->
                    innerContent.publisher?.name?.let { publisherName ->
                        brochureList += BrochureItem(publisherName, null, publisherName)
                    }
                }
            }
        } catch (e: Exception) {
            "Failure: ${e.message}"
        } finally {
        }
        return brochureList.takeIf { it.isNotEmpty() } ?: testList()
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
        private val BROCHURES_CONTENT_TYPE: Set<String> = setOf("brochure".lowercase(), "brochurePremium".lowercase())
    }
}