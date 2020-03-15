package com.sdos.commerce.data.datasource.net

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitController {

    private const val BASE_URL = "https://data.ct.gov/resource/"
    var retrofit: Retrofit

    init {
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    inline fun<reified T: Any> createRequest(): T = retrofit.create(T::class.java)
}