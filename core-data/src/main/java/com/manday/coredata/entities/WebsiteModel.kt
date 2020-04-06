package com.manday.coredata.entities

import com.google.gson.annotations.SerializedName

data class WebsiteModel(

    @SerializedName("url")
    private var url: String
)