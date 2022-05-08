package com.example.brochures.brochuresfragment

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.brochures.network.BrochuresApi
import com.example.brochures.network.robopojo.ContentItem
import com.example.brochures.network.robopojo.ShelfResponse
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

enum class BrochuresApiStatus { LOADING, ERROR, DONE }

/**
 * TODO
 * @author Mikhail Avdeev (mvavdeev@sberbank.ru)
 */
class BrochuresViewModel : ViewModel() {

    // The internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData(BrochuresApiStatus.LOADING)

    // The external immutable LiveData for the request status
    val status: LiveData<BrochuresApiStatus> = _status

    private val _brochures = MutableLiveData<List<ContentItem>>()
    val brochures: LiveData<List<ContentItem>> = _brochures

    init {
        loadBrochures()
    }

    private fun loadBrochures() {
        BrochuresApi.retrofitService.getShelfResponse()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { _status.value = BrochuresApiStatus.LOADING }
            .subscribe(this::parseOnSuccess, this::onFailure)
    }

    private fun parseOnSuccess(response: ShelfResponse?) {
        arrayListOf<ContentItem>().apply {
            response?.embedded?.contents?.filter { contentsItem ->
                BROCHURES_CONTENT_TYPE.contains(contentsItem?.contentType)
            }?.forEach { brochure ->
                brochure?.content?.firstOrNull { it?.retailer?.name != null }?.let { contentItem ->
                    this.plusAssign(contentItem)
                }
            }
        }.also(::updateLiveDataOnSuccess)
    }

    private fun updateLiveDataOnSuccess(contentItems: ArrayList<ContentItem>) {
        _status.value = BrochuresApiStatus.DONE
        _brochures.value = contentItems
    }

    private fun onFailure(throwable: Throwable) {
        _status.value = BrochuresApiStatus.ERROR
        _brochures.value = listOf()
        Log.d("Brochures", "throwable = " + throwable.message)
    }

    companion object {
        private val BROCHURES_CONTENT_TYPE: Set<String> =
            setOf("brochure".lowercase(), "brochurePremium".lowercase())
    }
}