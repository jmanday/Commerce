package com.manday.fruit.datasource.net

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.manday.coredata.controllers.retrofit.RetrofitController
import com.manday.fruit.datasource.net.endpoint.FruitAPI
import com.manday.fruit.entities.FruitEntity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FruitRetrofitDataSource :
    FruitNetDataSource {

    private var services: FruitAPI?

    init {
        RetrofitController.createConnection(BASE_URL)
        services = RetrofitController.createRequest(BASE_URL)
    }

    override fun getFruits(category: String, item: String): LiveData<List<FruitEntity>?> {
        val data = MutableLiveData<List<FruitEntity>?>()

        val call = services?.getAllFruits(
            hashMapOf(
            "category" to category,
            "item" to item
        ))

        call?.enqueue(object : Callback<List<FruitEntity>> {
            override fun onFailure(call: Call<List<FruitEntity>>, t: Throwable) {
                Log.d("Retrofit Error", t.message)
                data.value = null
            }

            override fun onResponse(call: Call<List<FruitEntity>>, response: Response<List<FruitEntity>>) {
                if (response.errorBody() == null) {
                    data.value = response.body()
                }
            }
        })

        return data
    }

    companion object {
        private const val BASE_URL = "https://data.ct.gov/resource/"

    }
}