package com.manday.management.data.controllers

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteDatabase
import com.manday.management.data.converters.ListConverter
import com.manday.management.data.dao.*
import com.manday.management.data.entities.*
import com.manday.management.data.generator.Generator
import java.util.concurrent.Executors

@Database(entities = arrayOf(EmployeeEntity::class, TaskEntity::class, SkillEntity::class, TypeEmployeeEntity::class, TypeTaskEntity::class), version = 1)
@TypeConverters(ListConverter::class)
abstract class RoomController: RoomDatabase() {

    abstract fun employeeDao(): EmployeeDao

    abstract fun taskDao(): TaskDao

    abstract fun skillDao(): SkillDao

    abstract fun typeEmployeeDao(): TypeEmployeeDao

    abstract fun typeTaskDao(): TypeTaskDao

    companion object {
        private const val DATABASE_NAME = "commerce_database_11"
        @Volatile
        private var instance: RoomController? = null

        fun initialize(context: Context, callback: () -> Unit): RoomController? {
            if (instance == null) {
                synchronized(RoomController::class) {
                    instance = Room.databaseBuilder(context.getApplicationContext(),
                        RoomController::class.java, DATABASE_NAME)
                        .addCallback(object : Callback() {
                            override fun onCreate(db: SupportSQLiteDatabase) {
                                super.onCreate(db)
                                Executors.newSingleThreadExecutor().execute {
                                    instance?.let {
                                        it.employeeDao().insert(Generator.getEmployees())
                                        it.taskDao().insert(Generator.getTasks())
                                        it.skillDao().insert(Generator.getSkills())
                                        it.typeEmployeeDao().insert(Generator.getTypeEmployee())
                                        it.typeTaskDao().insert(Generator.getTypeTask())
                                    }
                                }
                            }
                        })
                        .build()
                }
            }

            instance?.beginTransaction()
            instance?.endTransaction()
            instance?.let {
                if (it.mDatabase.isWriteAheadLoggingEnabled)
                    callback.invoke()
            }

            return instance
        }

        fun getInstance() = instance

        fun destroyDataBase(){
            instance = null
        }
    }

}