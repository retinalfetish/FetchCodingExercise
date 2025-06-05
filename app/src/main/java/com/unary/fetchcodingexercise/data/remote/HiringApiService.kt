package com.unary.fetchcodingexercise.data.remote

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.unary.fetchcodingexercise.domain.model.Person
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

/**
 * An interface for the Fetch hiring API.
 */
interface HiringApiService {
    @GET("hiring.json")
    suspend fun getList(): List<Person>
}

/**
 * Retrofit service for the Fetch hiring API.
 */
object HiringApi {
    private val baseUrl = "https://hiring.fetch.com/"

    private val moshi: Moshi by lazy {
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    val apiService: HiringApiService by lazy { retrofit.create(HiringApiService::class.java) }
}