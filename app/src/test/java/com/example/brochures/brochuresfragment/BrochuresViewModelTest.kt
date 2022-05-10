package com.example.brochures.brochuresfragment

import android.util.Log
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.brochures.network.BrochuresApiService
import com.example.brochures.network.SingleToArray
import com.example.brochures.network.robopojo.ContentItem
import com.example.brochures.network.robopojo.Retailer
import com.example.brochures.network.robopojo.ShelfResponse
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertFalse
import junit.framework.Assert.fail
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import rx.Observable
import java.nio.file.Files
import java.nio.file.Paths
import java.util.stream.Collectors

/**
 * Tests for [BrochuresViewModel]
 * @author Mikhail Avdeev (avdeev.m92@gmail.com)
 */
class BrochuresViewModelTest {

    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val statusObserver = mockk<Observer<BrochuresApiStatus>>(relaxed = true)
    private val brochuresObserver = mockk<Observer<List<ContentItem>>>(relaxed = true)
    private lateinit var viewModel: BrochuresViewModel
    private val brochuresApiService: BrochuresApiService = mockk(relaxed = true)
    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .add(SingleToArray.Adapter.FACTORY)
        .build()
    private val adapter: JsonAdapter<ShelfResponse> = moshi.adapter(ShelfResponse::class.java)
    private var loader: ClassLoader = ClassLoader.getSystemClassLoader()
    private val testSchedulerProvider = TestSchedulerProvider()

    /*companion object {
        @ClassRule
        @JvmField
        val schedulers = RxImmediateSchedulerRule()

        /**
         * path to full shelf test JSON
         */
        private const val FULL_SHELF_FILE_PATH = "test_shelf_response.json"
        private const val SINGLE_BROCHURE_FILE_PATH = "test_single_brochure_response.json"
    }

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()
    */

    @Before
    fun setupTest() {
        //todo RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }
    }

    @Test
    fun retrofitTestSingleBrochure() {
        val testSingleBrochure =
            Files.lines(Paths.get(loader.getResource(SINGLE_BROCHURE_FILE_PATH).toURI()))
                .parallel()
                .collect(Collectors.joining()).run { adapter.fromJson(this) }
        every { brochuresApiService.getShelfResponse() } returns Observable.just(testSingleBrochure)
        val retrofitAnswer = brochuresApiService.getShelfResponse()
        retrofitAnswer
            .subscribeOn(testSchedulerProvider.io())
            .observeOn(testSchedulerProvider.ui())
            //todo .doOnSubscribe { _status.value = BrochuresApiStatus.LOADING }
            .subscribe(
                this::parseShelfResponse,
                this::onFailure)
    }

    private fun parseShelfResponse(response: ShelfResponse?) {
        Log.d("Brochures", "shelfResponse: $response")
        arrayListOf<ContentItem>().apply {
            response?.embedded?.contents?.//.filter { contentsItem ->
                //BrochuresViewModel.BROCHURES_CONTENT_TYPE.contains(contentsItem?.contentType)
                //}?//
            forEach { brochure ->
                brochure?.content?.firstOrNull { it?.retailer?.name != null }?.let { contentItem ->
                    this.plusAssign(contentItem)
                }
            }
        }.also {
            val expected = ContentItem(
                retailer = Retailer(name = "XXXLutz Möbelhäuser", id = 34906914),
                brochureImage = "https://content-media.bonial.biz/8c0766ca-825a-41e8-a708-c57c775dad61/preview.jpg")
            val actual = it[0]
            assertEquals(expected.retailer, actual.retailer)
            assertEquals(expected.brochureImage, actual.brochureImage)
        }
    }

    private fun onFailure(throwable: Throwable) {
        try {
            //_status.value = BrochuresApiStatus.ERROR
            //_brochures.value = listOf()
            Log.d("Brochures", "throwable = " + throwable.message)
        } catch (e: Throwable) {
            Log.d("Brochures", "throwable = " + e.message)
        }
    }

    @Test
    fun getLoadingStatusForNonObtainedResponse() {
        viewModel = BrochuresViewModel(brochuresApiService, testSchedulerProvider)
        //todo viewModel.status.observeForever(statusObserver)
        //todo verify { statusObserver.onChanged(BrochuresApiStatus.LOADING) }
    }

    @Test
    fun parseEmptyResponse() {
        every { brochuresApiService.getShelfResponse() } returns Observable.just(ShelfResponse())
        viewModel = BrochuresViewModel(brochuresApiService, testSchedulerProvider)
        viewModel.status.observeForever(statusObserver)
        viewModel.brochures.observeForever(brochuresObserver)
        verify { statusObserver.onChanged(BrochuresApiStatus.DONE) }
        verify { brochuresObserver.onChanged(emptyList()) }
    }

    @Test
    fun parseFullTestResponse() {
        val fullShelfResponse =
            Files.lines(Paths.get(loader.getResource(FULL_SHELF_FILE_PATH).toURI()))
                .parallel()
                .collect(Collectors.joining()).run { adapter.fromJson(this) }

        every { brochuresApiService.getShelfResponse() } returns Observable.just(fullShelfResponse)
        viewModel = BrochuresViewModel(brochuresApiService, testSchedulerProvider)
        //todo viewModel.brochures.observeForever(brochuresObserver)
        //todo viewModel.status.observeForever(statusObserver)
        viewModel.brochures.value?.let { list ->
            assertFalse(list.isEmpty())
        } ?: fail("Should not have thrown any exception")
        //todo assertEquals(BrochuresApiStatus.DONE, viewModel.status.value)
    }

    @Test
    fun parseSingleBrochure() {
        val testSingleBrochure =
            Files.lines(Paths.get(loader.getResource(SINGLE_BROCHURE_FILE_PATH).toURI()))
                .parallel()
                .collect(Collectors.joining()).run { adapter.fromJson(this) }
        every { brochuresApiService.getShelfResponse() } returns Observable.just(testSingleBrochure)
        viewModel = BrochuresViewModel(brochuresApiService, testSchedulerProvider)
        //todo  brochures.observeForever(brochuresObserver)
        //todo  status.observeForever(statusObserver)
        //todo  }

        //todo verify { statusObserver.onChanged(BrochuresApiStatus.LOADING) }
        //todo verify { statusObserver.onChanged(BrochuresApiStatus.DONE) }
        viewModel.brochures.value?.let { list ->
            val expected = ContentItem(
                retailer = Retailer(name = "XXXLutz Möbelhäuser", id = 34906914),
                brochureImage = "https://content-media.bonial.biz/8c0766ca-825a-41e8-a708-c57c775dad61/preview.jpg")
            val actual = list[0]
            assertEquals(expected.retailer, actual.retailer)
            assertEquals(expected.brochureImage, actual.brochureImage)
        } ?: fail("Should not have thrown any exception")
        //todo assertEquals(BrochuresApiStatus.DONE, viewModel.status.value,)
    }

    companion object {
        private const val FULL_SHELF_FILE_PATH = "test_shelf_response.json"
        private const val SINGLE_BROCHURE_FILE_PATH = "test_single_brochure_response.json"
    }
}