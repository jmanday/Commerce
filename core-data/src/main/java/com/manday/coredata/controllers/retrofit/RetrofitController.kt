package com.manday.coredata.controllers.retrofit

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitController {

    val connections = mutableMapOf<String, Retrofit>()

    fun createConnection(baseUrl: String) {
        connections[baseUrl] = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    inline fun <reified T : Any> createRequest(baseUrl: String): T? =
        connections.get(baseUrl)?.create(T::class.java)

    inline fun <T, U> Response<T>.unwrapResponse(f: T.() -> List<U>) =
        body()?.f()
}