package com.manday.coredata.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "fruits")
data class FruitEntity(

    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,

    @ColumnInfo(name = "farmName")
    var farmName: String? = String(),

    @ColumnInfo(name = "category")
    var category: String? = String(),

    @ColumnInfo(name = "item")
    var item: String? = String(),

    @ColumnInfo(name = "business")
    var business: String? = String()
): Serializable