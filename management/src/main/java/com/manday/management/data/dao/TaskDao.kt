package com.manday.management.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.manday.management.data.entities.TaskEntity

@Dao
interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(tasks: List<TaskEntity>)

    @Query("SELECT * FROM tasks ")
    fun getAllTasks(): LiveData<List<TaskEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addTask(task: TaskEntity): Long?
/*
    @Query("SELECT * FROM employees WHERE name = :mName AND pass = :mPass")
    fun getEmployee(mName: String, mPass: String): LiveData<Employee>

    @Query("UPDATE employees SET listTask=:listNewTask WHERE id = :idEmployee")
    fun assignTaskToEmploye(idEmployee: Int, listNewTask: List<Int>)



    @Update
    suspend fun updateUsers(employee: Employee)

    @Delete
    suspend fun deleteUsers(employee: Employee)

     */
}