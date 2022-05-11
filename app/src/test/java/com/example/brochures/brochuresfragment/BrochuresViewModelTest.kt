package com.example.brochures.brochuresfragment

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
    private val fullShelfResponse =
        Files.lines(Paths.get(loader.getResource(FULL_SHELF_FILE_PATH).toURI()))
            .parallel()
            .collect(Collectors.joining()).run { adapter.fromJson(this) }
    private val testSingleBrochure =
        Files.lines(Paths.get(loader.getResource(SINGLE_BROCHURE_FILE_PATH).toURI()))
            .parallel()
            .collect(Collectors.joining()).run { adapter.fromJson(this) }

    @Before
    fun setupTest() {
    }

    @Test
    fun getLoadingStatusForNonObtainedResponse() {
        viewModel = BrochuresViewModel(brochuresApiService, testSchedulerProvider)
        viewModel.status.observeForever(statusObserver)
        verify { statusObserver.onChanged(BrochuresApiStatus.LOADING) }
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
        every { brochuresApiService.getShelfResponse() } returns Observable.just(fullShelfResponse)
        viewModel = BrochuresViewModel(brochuresApiService, testSchedulerProvider)
        viewModel.status.observeForever(statusObserver)
        viewModel.brochures.observeForever(brochuresObserver)
        verify { statusObserver.onChanged(BrochuresApiStatus.DONE) }
        viewModel.brochures.value?.let { list ->
            assertFalse(list.isEmpty())
        } ?: fail("Should not have thrown any exception")
    }

    @Test
    fun parseSingleBrochure() {
        every { brochuresApiService.getShelfResponse() } returns Observable.just(testSingleBrochure)
        viewModel = BrochuresViewModel(brochuresApiService, testSchedulerProvider)
        viewModel.status.observeForever(statusObserver)
        viewModel.brochures.observeForever(brochuresObserver)
        verify { statusObserver.onChanged(BrochuresApiStatus.DONE) }
        viewModel.brochures.value?.let { list ->
            val expected = ContentItem(
                retailer = Retailer(name = "XXXLutz Möbelhäuser", id = 34906914),
                brochureImage = "https://content-media.bonial.biz/8c0766ca-825a-41e8-a708-c57c775dad61/preview.jpg")
            val actual = list[0]
            assertEquals(expected.retailer, actual.retailer)
            assertEquals(expected.brochureImage, actual.brochureImage)
        } ?: fail("Should not have thrown any exception")
    }

    companion object {
        private const val FULL_SHELF_FILE_PATH = "test_shelf_response.json"
        private const val SINGLE_BROCHURE_FILE_PATH = "test_single_brochure_response.json"
    }
}