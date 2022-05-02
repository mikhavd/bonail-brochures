package com.example.brochures.network

import com.example.brochures.network.parsingobjects.Response
import com.example.brochures.network.robopojo.RoboResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

/**
 * TODO
 * @author Mikhail Avdeev (mvavdeev@sberbank.ru)
 */

private const val BASE_URL = """https://test-mobile-configuration-files.s3.eu-central-1.amazonaws.com/stories-test/"""


private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .add(SingleToArray.Adapter.FACTORY)
    .build()


val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface BrochuresApiService {

    @GET("shelf.json")
    suspend fun getResponse(): RoboResponse
}

object BrochuresApi {
    val retrofitService: BrochuresApiService by lazy {
        retrofit.create(BrochuresApiService::class.java)
    }
}