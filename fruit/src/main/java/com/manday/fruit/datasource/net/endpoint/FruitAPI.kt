package com.manday.fruit.datasource.net.endpoint

import com.manday.fruit.entities.FruitEntity
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap


interface FruitAPI {

    @GET("hma6-9xbg.json/")
    fun getAllFruits(@QueryMap params: Map<String, String>): Call<List<FruitEntity>>
}