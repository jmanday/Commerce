package com.sdos.commerce.data.endpoints

import com.sdos.commerce.data.models.FruitModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap


interface FruitAPI {

    @GET("hma6-9xbg.json/")
    fun getAllFruits(@QueryMap params: Map<String, String>): Call<List<FruitModel>>
}