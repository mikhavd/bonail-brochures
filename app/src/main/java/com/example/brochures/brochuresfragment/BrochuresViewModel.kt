package com.example.brochures.brochuresfragment

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.brochures.main.SchedulerProvider
import com.example.brochures.network.BrochuresApiService
import com.example.brochures.network.robopojo.ContentItem
import com.example.brochures.network.robopojo.ShelfResponse
import rx.Subscriber

enum class BrochuresApiStatus { LOADING, ERROR, DONE }

/**
 * ViewModel that provides:
 * * a list of brochures, loaded via network ([brochures])
 * * a status of brochures' loading process ([status])
 *
 * @param brochuresApiService Interface for obtaining [ShelfResponse] with brochures to display
 * @param schedulerProvider Provider of schedulers for RxJava
 * @author Mikhail Avdeev (avdeev.m92@gmail.com)
 */
class BrochuresViewModel(
    private val brochuresApiService: BrochuresApiService,
    private val schedulerProvider: SchedulerProvider,
) : ViewModel() {

    // The internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData(BrochuresApiStatus.LOADING)

    // The external immutable LiveData for the request status
    val status: LiveData<BrochuresApiStatus> = _status

    //The internal obtained list for brochures to display
    private val _brochures = MutableLiveData<List<ContentItem>>()

    // The external immutable LiveData for brochures to display
    val brochures: LiveData<List<ContentItem>> = _brochures

    init {
        loadBrochures()
    }

    private fun loadBrochures() {
        brochuresApiService.getShelfResponse()
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())
            .doOnSubscribe { _status.postValue(BrochuresApiStatus.LOADING) }
            .subscribe(
                this::parseShelfResponse,
                this::onFailure)
    }

    private fun parseShelfResponse(response: ShelfResponse?) {
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

    private fun onFailure(throwable: Throwable) {
        try {
            _status.postValue(BrochuresApiStatus.ERROR)
            _brochures.postValue(emptyList())
            Log.d(TAG, "throwable = " + throwable.message)
        } catch (e: Throwable) {
            Log.d(TAG, "throwable = " + e.message)
        }
    }

    private fun updateLiveDataOnSuccess(contentItems: ArrayList<ContentItem>) {
        _status.postValue(BrochuresApiStatus.DONE)
        _brochures.postValue(contentItems)
    }

    companion object {
        private val BROCHURES_CONTENT_TYPE: Set<String> =
            setOf("brochure".lowercase(), "brochurePremium".lowercase())

        private const val TAG = "Brochures"
    }

    @Suppress("UNCHECKED_CAST")
    class BrochuresViewModelFactory(
        private val brochuresApiService: BrochuresApiService,
        private val schedulerProvider: SchedulerProvider,
    ) : ViewModelProvider.Factory {

        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return BrochuresViewModel(brochuresApiService, schedulerProvider) as T
        }
    }
}