package com.manday.fruit.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "location")
data class LocationEntity (

    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,

    @SerializedName("latitude")
    @ColumnInfo(name = "latitude")
    var latitude: String,

    @SerializedName("longitude")
    @ColumnInfo(name = "longitude")
    var longitude: String,

    @SerializedName("human_address")
    @ColumnInfo(name = "humanAddress")
    var human_address: String
)