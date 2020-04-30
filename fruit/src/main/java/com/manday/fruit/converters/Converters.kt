package com.manday.fruit.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.manday.fruit.entities.LocationEntity
import com.manday.fruit.entities.WebsiteEntity

class Converters {

    private val gson = Gson()

    @TypeConverter
    fun stringToWebsite(value: String?): WebsiteEntity? {
        return value?.let {
            gson.fromJson(value, WebsiteEntity::class.java)
        }
    }

    @TypeConverter
    fun websiteToString(value: WebsiteEntity?): String? {
        return gson.toJson(value)
    }

    @TypeConverter
    fun stringToLocation(value: String?): LocationEntity? {
        return value?.let {
            gson.fromJson(value, LocationEntity::class.java)
        }
    }

    @TypeConverter
    fun locationToString(value: LocationEntity?): String? {
        return gson.toJson(value)
    }
}