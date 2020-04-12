package com.manday.fruit.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.manday.fruit.models.FruitModel

@Entity(tableName = "fruits")
data class FruitEntity (

    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,

    @SerializedName("farm_name")
    @ColumnInfo(name = "farmName")
    var farmName: String,

    @SerializedName("category")
    @ColumnInfo(name = "category")
    var category: String,

    @SerializedName("item")
    @ColumnInfo(name = "item")
    var item: String,

    @SerializedName("farmer_id")
    @ColumnInfo(name = "farmerId")
    var farmerId: Int,

    @SerializedName("website")
    @ColumnInfo(name = "website")
    var website: WebsiteEntity,

    @SerializedName("zipcode")
    @ColumnInfo(name = "zipcode")
    var zipcode: String,

    @SerializedName("phone1")
    @ColumnInfo(name = "phone1")
    var phone1: String,

    @SerializedName("business")
    @ColumnInfo(name = "business")
    var business: String,

    @SerializedName("l")
    @ColumnInfo(name = "lNumber")
    var lNumber: Int,

    @SerializedName("location_1")
    @ColumnInfo(name = "location")
    var locationL: LocationEntity
) {
    fun mapToFruitModel() =
        FruitModel(farmName, category, item, business, locationL.latitude, locationL.longitude)
}