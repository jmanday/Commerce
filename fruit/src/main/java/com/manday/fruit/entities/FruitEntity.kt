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
    var farmName: String? = null,

    @SerializedName("category")
    @ColumnInfo(name = "category")
    var category: String? = null,

    @SerializedName("item")
    @ColumnInfo(name = "item")
    var item: String? = null,

    @SerializedName("farmer_id")
    @ColumnInfo(name = "farmerId")
    var farmerId: Int? = null,

    @SerializedName("website")
    @ColumnInfo(name = "website")
    var website: WebsiteEntity? = null,

    @SerializedName("zipcode")
    @ColumnInfo(name = "zipcode")
    var zipcode: String? = null,

    @SerializedName("phone1")
    @ColumnInfo(name = "phone1")
    var phone1: String? = null,

    @SerializedName("business")
    @ColumnInfo(name = "business")
    var business: String? = null,

    @SerializedName("l")
    @ColumnInfo(name = "lNumber")
    var lNumber: Int? = null,

    @SerializedName("location_1")
    @ColumnInfo(name = "location")
    var locationL: LocationEntity? = null
) {

    fun isEnabled() = (!this.farmName.isNullOrEmpty() && !this.category.isNullOrEmpty() &&
            !this.item.isNullOrEmpty() && !this.business.isNullOrEmpty() && !this.locationL?.latitude.isNullOrEmpty()
            && !this.locationL?.longitude.isNullOrEmpty())
}

fun FruitEntity.mapToFruitModel() =
    FruitModel(
        this.farmName, this.category, this.item, this.business,
        this.locationL?.latitude, this.locationL?.longitude
    )
