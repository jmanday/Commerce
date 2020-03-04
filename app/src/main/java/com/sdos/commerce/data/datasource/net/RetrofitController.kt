package com.sdos.commerce.data.datasource.net

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitController {

    private const val BASE_URL = "https://data.ct.gov/resource/hma6-9xbg.json/"
    private var retrofit: Retrofit

    init {
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun<T> createRequest(service: Class<T>) {
        retrofit.create(service::class.java)
    }
}