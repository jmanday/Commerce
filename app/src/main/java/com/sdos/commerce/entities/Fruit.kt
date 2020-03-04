package com.sdos.commerce.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "fruits")
data class Fruit(

    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,

    @ColumnInfo(name = "farmName")
    var farmName: String = String(),

    @ColumnInfo(name = "category")
    var category: String = String(),

    @ColumnInfo(name = "item")
    var item: String = String(),

    @ColumnInfo(name = "business")
    var business: String = String()
)