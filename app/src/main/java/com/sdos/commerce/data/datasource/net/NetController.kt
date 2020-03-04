package com.sdos.commerce.data.datasource.net

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sdos.commerce.data.datasource.FruitDataSource
import com.sdos.commerce.data.endpoints.FruitAPI
import com.sdos.commerce.data.models.FruitModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NetController: FruitDataSource {

    override fun getFruits(category: String, item: String): LiveData<List<FruitModel>> {
        val data = MutableLiveData<List<FruitModel>>()
        val service = RetrofitController.createRequest(FruitAPI::class.java)

        val call = service.getAllFruits(hashMapOf(
            "category" to category,
            "item" to item
        ))

        call.enqueue(object : Callback<List<FruitModel>> {
            override fun onFailure(call: Call<List<FruitModel>>, t: Throwable) {
                Log.d("Retrofit Error", t.message)
            }

            override fun onResponse(call: Call<List<FruitModel>>, response: Response<List<FruitModel>>) {
                data.value = response.body()
            }
        })

        return data
    }
}