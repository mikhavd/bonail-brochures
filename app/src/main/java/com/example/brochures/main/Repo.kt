package com.example.brochures.main

import com.example.brochures.network.BrochuresApi
import com.example.brochures.network.robopojo.ShelfResponse

interface ShelfRepository {
    fun getShelfResponse() : rx.Observable<ShelfResponse>
}
object Repo {
    //val shelfResponse : ShelfRepository by lazy { BrochuresApi.retrofitService.getShelfResponse() }
}