package com.sdos.commerce.util

import android.app.Application
import android.content.Context
import android.content.res.AssetManager
import android.view.ContextThemeWrapper
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.InputStream
import java.io.InputStreamReader
import java.io.Reader

class Converter<T> {

    fun convertToList(context: Context, nameFile: String): List<T> {
        val assetManager = context.assets
        val ims = assetManager.open(nameFile)
        val reader = InputStreamReader(ims)
        return Gson().fromJson<List<T>>(reader, object: TypeToken<List<T>>(){}.type)
    }

    /*
    companion object{
        private lateinit var assetManager: AssetManager
        private lateinit var ims: InputStream
        private lateinit var reader: Reader

        fun configure(context: Context) {
            assetManager = context.assets

        }

        fun<T> convert() = Gson().fromJson<T>(reader, object: TypeToken<T>(){}.type)


        fun convertToList(nameFile: String): List<T> {
            ims = assetManager.open(nameFile)
            reader = InputStreamReader(ims)

            return Gson().fromJson<List<T>>(reader, object: TypeToken<List<T>>(){}.type)
        }
    }

     */
}