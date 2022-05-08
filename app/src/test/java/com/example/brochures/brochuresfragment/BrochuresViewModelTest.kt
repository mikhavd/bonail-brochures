package com.example.brochures.brochuresfragment

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.brochures.network.BrochuresApiService
import com.example.brochures.network.robopojo.ContentItem
import com.example.brochures.network.robopojo.ShelfResponse
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import io.reactivex.rxjava3.android.plugins.RxAndroidPlugins
import io.reactivex.rxjava3.schedulers.Schedulers
import org.junit.Before
import org.junit.ClassRule
import org.junit.Rule
import org.junit.Test
import rx.Observable

/**
 * Tests for [BrochuresViewModel]
 * @author Mikhail Avdeev (avdeev.m92@gmail.com)
 */
class BrochuresViewModelTest {

    private val statusObserver: Observer<BrochuresApiStatus> = mockk(relaxed = true)
    private val brochuresObserver: Observer<List<ContentItem>> = mockk(relaxed = true)
    private lateinit var viewModel: BrochuresViewModel
    private val brochuresApiService: BrochuresApiService = mockk(relaxed = true)

    companion object {
        @ClassRule
        @JvmField
        val schedulers = RxImmediateSchedulerRule()
    }

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    @Before
    fun setupTest() {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }
    }

    @Test
    fun getStatus() {
        viewModel = BrochuresViewModel(brochuresApiService)
        viewModel.status.observeForever(statusObserver)
        verify { statusObserver.onChanged(BrochuresApiStatus.DONE) }
    }

    @Test
    fun getBrochures() {
        //todo
    }

    @Test
    fun parseNoResponse() {
        every { brochuresApiService.getShelfResponse() } returns Observable.just(ShelfResponse(null, null, null))
        viewModel = BrochuresViewModel(brochuresApiService)
        viewModel.brochures.observeForever(brochuresObserver)
        viewModel.status.observeForever(statusObserver)
        verify { statusObserver.onChanged(BrochuresApiStatus.ERROR) }
        verify { brochuresObserver.onChanged(emptyList()) }
    }
}