package com.example.brochures.network

import com.example.brochures.network.robopojo.ShelfResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import rx.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import rx.Observable

/**
 * Services for API [https://test-mobile-configuration-files.s3.eu-central-1.amazonaws.com/stories-test/"]
 * @author Mikhail Avdeev (avdeev.m92@gmail.com)
 */

private const val BASE_URL = """https://test-mobile-configuration-files.s3.eu-central-1.amazonaws.com/stories-test/"""

var rxAdapter: RxJavaCallAdapterFactory = RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io())

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .add(SingleToArray.Adapter.FACTORY)
    .build()

val retrofit: Retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .addCallAdapterFactory(rxAdapter)
    .build()

/**
 * Interface for obtaining [ShelfResponse] from
 * [https://test-mobile-configuration-files.s3.eu-central-1.amazonaws.com/stories-test/shelf.json]
 */
interface BrochuresApiService {

    @GET("shelf.json")
    fun getShelfResponse(): Observable<ShelfResponse>
}

object BrochuresApi {
    val brochuresApiService: BrochuresApiService by lazy { retrofit.create(BrochuresApiService::class.java) }
}