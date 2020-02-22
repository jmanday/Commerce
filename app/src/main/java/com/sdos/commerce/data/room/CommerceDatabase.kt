package com.sdos.commerce.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sdos.commerce.dao.EmployeeDao
import com.sdos.commerce.entities.*

@Database(entities = [Employee::class, Task::class, Skill::class, TypeEmployee::class, TypeTask::class], version = 1)
abstract class CommerceDatabase: RoomDatabase() {

    abstract fun noteDao(): EmployeeDao

    private var instance: CommerceDatabase? = null

    fun getInstance(context: Context): CommerceDatabase? {
        if (instance == null) {
            synchronized(CommerceDatabase::class) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    CommerceDatabase::class.java, "commerce_database"
                )
                    .fallbackToDestructiveMigration()
                    ///.addCallback()
                    .build()
            }
        }
        return instance
    }
}