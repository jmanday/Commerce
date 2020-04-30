package com.manday.fruit.controllers

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.manday.fruit.converters.Converters
import com.manday.fruit.dao.FruitDao
import com.manday.fruit.entities.FruitEntity
import com.manday.fruit.entities.LocationEntity
import com.manday.fruit.entities.WebsiteEntity

@Database(
    entities = arrayOf(FruitEntity::class, WebsiteEntity::class, LocationEntity::class),
    version = 2
)
@TypeConverters(Converters::class)
abstract class FruitRoomController : RoomDatabase() {

    abstract fun fruitDao(): FruitDao


    companion object {
        private const val DATABASE_NAME = "commerce_database_22"

        @Volatile
        private var instance: FruitRoomController? = null

        fun initialize(context: Context) {
            if (instance == null) {
                synchronized(FruitRoomController::class) {
                    instance = Room.databaseBuilder(
                        context.getApplicationContext(),
                        FruitRoomController::class.java, DATABASE_NAME
                    )
                        .build()
                }
            }
        }

        fun getInstance() = instance

        fun destroyDataBase() {
            instance = null
        }
    }

}