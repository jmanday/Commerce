package com.sdos.commerce.data.room

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.sdos.commerce.dao.*
import com.sdos.commerce.entities.*
import com.sdos.commerce.generator.Generator
import com.sdos.commerce.util.ListConverter
import java.util.concurrent.Executors

@Database(entities = arrayOf(Employee::class, Task::class, Skill::class, TypeEmployee::class, TypeTask::class, Fruit::class), version = 1)
@TypeConverters(ListConverter::class)
abstract class CommerceDatabase: RoomDatabase() {

    abstract fun employeeDao(): EmployeeDao

    abstract fun taskDao(): TaskDao

    abstract fun skillDao(): SkillDao

    abstract fun typeEmployeeDao(): TypeEmployeeDao

    abstract fun typeTaskDao(): TypeTaskDao

    companion object {
        private const val DATABASE_NAME = "commerce_database"
        @Volatile
        private var instance: CommerceDatabase? = null

        fun initialize(context: Context, callback: () -> Unit): CommerceDatabase? {
            if (instance == null) {
                synchronized(CommerceDatabase::class) {
                    instance = Room.databaseBuilder(context.getApplicationContext(),
                        CommerceDatabase::class.java, "weather1_7_6_659.db")
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