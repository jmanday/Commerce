package com.sdos.commerce.data.datasource.net

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sdos.commerce.data.datasource.FruitDataSource
import com.sdos.commerce.data.endpoints.FruitAPI
import com.sdos.commerce.data.models.Fruit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NetController: FruitDataSource {

    override fun getFruits(category: String, item: String): LiveData<List<Fruit>> {
        val data = MutableLiveData<List<Fruit>>()
        val service = RetrofitController.createRequest(FruitAPI::class.java)

        val call = service.getAllFruits(hashMapOf(
            "category" to category,
            "item" to item
        ))

        call.enqueue(object : Callback<List<Fruit>> {
            override fun onFailure(call: Call<List<Fruit>>, t: Throwable) {
                Log.d("Retrofit Error", t.message)
            }

            override fun onResponse(call: Call<List<Fruit>>, response: Response<List<Fruit>>) {
                data.value = response.body()
            }
        })

        return data
    }
}