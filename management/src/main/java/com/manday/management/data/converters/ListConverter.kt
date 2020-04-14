package com.manday.coredata.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class ListConverter {

    private val gson = Gson()

    @TypeConverter
    fun stringToTaskList(data: String): List<Int> {
        val listType = object : TypeToken<List<Int>?>() {}.type
        return gson.fromJson(data, listType)
    }


    @TypeConverter
    fun taskListToString(list: List<Int>): String? {
        return gson.toJson(list)
    }
}