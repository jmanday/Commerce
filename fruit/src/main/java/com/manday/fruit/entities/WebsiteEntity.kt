package com.manday.fruit.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "website")
data class WebsiteEntity (

    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,

    @SerializedName("url")
    @ColumnInfo(name = "url")
    var url: String
)