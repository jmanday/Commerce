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

class FruitNetDataSourceImpl:
    FruitNetDataSource {

    override fun getFruits(category: String, item: String): LiveData<List<FruitEntity>?> {
        val data = MutableLiveData<List<FruitEntity>?>()
        val service = RetrofitController.createRequest<FruitAPI>()

        val call = service.getAllFruits(hashMapOf(
            "category" to category,
            "item" to item
        ))

        call.enqueue(object : Callback<List<FruitEntity>> {
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

}