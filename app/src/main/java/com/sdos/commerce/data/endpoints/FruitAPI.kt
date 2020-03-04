package com.sdos.commerce.data.endpoints

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap


interface FruitAPI {

    @GET()
    fun getAllFruits(@QueryMap params: Map<String, String>): Call<List<FruitAPI>>
}