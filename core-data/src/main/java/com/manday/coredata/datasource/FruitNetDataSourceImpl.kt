package com.manday.coredata.datasource

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.manday.coredata.controllers.retrofit.RetrofitController
import com.manday.coredata.endpoints.FruitAPI
import com.manday.coredata.entities.FruitEntity
import com.manday.coredata.entities.FruitModel
import com.manday.coredata.entities.toFruit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FruitNetDataSourceImpl: FruitNetDataSource {

    override fun getFruits(category: String, item: String): LiveData<List<FruitEntity>> {
        val data = MutableLiveData<List<FruitEntity>>()
        val service = RetrofitController.createRequest<FruitAPI>()

        val call = service.getAllFruits(hashMapOf(
            "category" to category,
            "item" to item
        ))

        call.enqueue(object : Callback<List<FruitModel>> {
            override fun onFailure(call: Call<List<FruitModel>>, t: Throwable) {
                Log.d("Retrofit Error", t.message)
            }

            override fun onResponse(call: Call<List<FruitModel>>, response: Response<List<FruitModel>>) {
                data.value = response.unwrapResponse {
                    this.map { it.toFruit() }
                }
            }
        })

        return data
    }

    private inline fun <T, U> Response<T>.unwrapResponse(f: T.() -> List<U>) =
        body()?.f()
}