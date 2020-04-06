package com.manday.coredata.entities

import com.google.gson.annotations.SerializedName

data class LocationModel(

    @SerializedName("latitude")
    private var latitude: String,

    @SerializedName("longitude")
    private var longitude: String,

    @SerializedName("human_address")
    private var human_address: String
)