package com.sdos.commerce.data.models

import com.google.gson.annotations.SerializedName
import com.sdos.commerce.entities.Fruit

data class FruitModel(

    @SerializedName("farm_name")
    var farmName: String,

    @SerializedName("category")
    var category: String,

    @SerializedName("item")
    var item: String,

    @SerializedName("farmer_id")
    var farmerId: Int,

    @SerializedName("website")
    var website: WebsiteModel,

    @SerializedName("zipcode")
    var zipcode: String,

    @SerializedName("phone1")
    var phone1: String,

    @SerializedName("business")
    var business: String,

    @SerializedName("l")
    var lNumber: Int,

    @SerializedName("location_1")
    var locationL: LocationModel
)

fun FruitModel.toFruit(): Fruit {
    return Fruit(null, this.farmName, this.category, this.item, this.business)
}