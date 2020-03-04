package com.sdos.commerce.data.models

import com.google.gson.annotations.SerializedName

data class Fruit(

    @SerializedName("farm_name")
    private var farmName: String,

    @SerializedName("category")
    private var category: String,

    @SerializedName("item")
    private var item: String,

    @SerializedName("farmer_id")
    private var farmerId: Int,

    @SerializedName("website")
    private var website: Website,

    @SerializedName("zipcode")
    private var zipcode: String,

    @SerializedName("phone1")
    private var phone1: String,

    @SerializedName("business")
    private var business: String,

    @SerializedName("l")
    private var lNumber: Int,

    @SerializedName("location_1")
    private var locationL: Location
)