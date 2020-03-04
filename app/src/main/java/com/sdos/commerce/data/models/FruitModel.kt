package com.sdos.commerce.data.models

import com.google.gson.annotations.SerializedName
import com.sdos.commerce.entities.Fruit

data class FruitModel(

    @SerializedName("farm_name")
    private var farmName: String,

    @SerializedName("category")
    private var category: String,

    @SerializedName("item")
    private var item: String,

    @SerializedName("farmer_id")
    private var farmerId: Int,

    @SerializedName("website")
    private var website: WebsiteModel,

    @SerializedName("zipcode")
    private var zipcode: String,

    @SerializedName("phone1")
    private var phone1: String,

    @SerializedName("business")
    private var business: String,

    @SerializedName("l")
    private var lNumber: Int,

    @SerializedName("location_1")
    private var locationL: LocationModel
)

fun FruitModel.toFruit() = Fruit().apply {
    this.farmName = farmName
    this.category = category
    this.item = item
    this.business = business
}