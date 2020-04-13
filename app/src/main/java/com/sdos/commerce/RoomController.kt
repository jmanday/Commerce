package com.sdos.commerce.data.room

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteDatabase
import com.manday.coredata.converters.ListConverter
import com.manday.coredata.entities.*
import com.manday.coredata.generator.Generator
import com.manday.employee.data.entities.EmployeeEntity
import com.sdos.commerce.dao.*
import java.util.concurrent.Executors

@Database(entities = arrayOf(EmployeeEntity::class, TaskEntity::class, SkillEntity::class, TypeEmployeeEntity::class, TypeTaskEntity::class, FruitEntity::class), version = 1)
@TypeConverters(ListConverter::class)
abstract class RoomController: RoomDatabase() {

    abstract fun employeeDao(): EmployeeDao

    abstract fun taskDao(): TaskDao

    abstract fun skillDao(): SkillDao

    abstract fun typeEmployeeDao(): TypeEmployeeDao

    abstract fun typeTaskDao(): TypeTaskDao

    abstract fun fruitDao(): FruitDao

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

        fun getEmployeeDao()= instance?.employeeDao()

        fun getTaskDao() = instance?.taskDao()

        fun getSkillDao() = instance?.skillDao()

        fun destroyDataBase(){
            instance = null
        }
    }

}