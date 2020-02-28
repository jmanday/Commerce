package com.sdos.commerce.data.room

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.sdos.commerce.dao.EmployeeDao
import com.sdos.commerce.dao.SkillDao
import com.sdos.commerce.dao.TaskDao
import com.sdos.commerce.entities.*
import com.sdos.commerce.generator.Generator
import com.sdos.commerce.util.ListConverter
import java.util.concurrent.Executors

@Database(entities = arrayOf(Employee::class, Task::class, Skill::class, TypeEmployee::class, TypeTask::class), version = 1)
@TypeConverters(ListConverter::class)
abstract class CommerceDatabase: RoomDatabase() {

    abstract fun employeeDao(): EmployeeDao

    abstract fun taskDao(): TaskDao

    abstract fun skillDao(): SkillDao

    companion object {
        private const val DATABASE_NAME = "commerce_database"
        @Volatile
        private var instance: CommerceDatabase? = null

        fun getInstance(context: Context): CommerceDatabase? {
            if (instance == null) {
                synchronized(CommerceDatabase::class) {
                    instance = Room.databaseBuilder(context.getApplicationContext(),
                        CommerceDatabase::class.java, "weather1_7_6_58.db")
                        .addCallback(object : Callback() {
                            override fun onCreate(db: SupportSQLiteDatabase) {
                                super.onCreate(db)
                                Executors.newSingleThreadExecutor().execute {
                                    instance?.let {
                                        it.employeeDao().insert(Generator.getEmployees())
                                        it.taskDao().insert(Generator.getTasks())
                                        it.skillDao().insert(Generator.getSkills())
                                    }


                                    Log.d("COMMERCE", "Database created")
                                }
                            }
                        })
                        .build()
                }
            }
            return instance
        }

        fun destroyDataBase(){
            instance = null
        }
    }

}