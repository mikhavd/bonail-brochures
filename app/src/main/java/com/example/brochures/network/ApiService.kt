package com.example.brochures.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

/**
 * TODO
 * @author Mikhail Avdeev (mvavdeev@sberbank.ru)
 */

private const val BASE_URL =
    "https://test-mobile-configuration-files.s3.eu-central-1.amazonaws.com/stories-test\n" +
        "/"
val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    //todo .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
    .build()

interface BrochuresApiService {

    @GET("shelf.json") //todo  @GET("photos")
    suspend fun getResponse(): String //ShelfResponse
}

object BrochuresApi {
    val retrofitService: BrochuresApiService by lazy {
        retrofit.create(BrochuresApiService::class.java)
    }
}