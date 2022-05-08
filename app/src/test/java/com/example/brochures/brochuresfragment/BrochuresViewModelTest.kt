package com.example.brochures.brochuresfragment

import androidx.lifecycle.Observer
import com.example.brochures.network.robopojo.ContentItem
import org.junit.Test
import io.mockk.mockk

import org.junit.Assert.*
import org.junit.Before

/**
 * TODO
 * @author Mikhail Avdeev (avdeev.m92@gmail.com)
 */
class BrochuresViewModelTest {

    private val statusObserver: Observer<BrochuresApiStatus> = mockk(relaxed = true)
    private val brochuresObserver: Observer<List<ContentItem>> = mockk(relaxed = true)
    private lateinit var viewModel: BrochuresViewModel

    @Before
    fun setUp(){
        viewModel = BrochuresViewModel()
        viewModel.brochures.observeForever(brochuresObserver)
        viewModel.status.observeForever(statusObserver)
    }

    @Test
    fun getStatus() {
    }

    @Test
    fun getBrochures() {
    }
}