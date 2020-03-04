package com.sdos.commerce.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.sdos.commerce.entities.Task

@Dao
interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(tasks: List<Task>)

    @Query("SELECT * FROM tasks ")
    fun getAllTasks(): LiveData<List<Task>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addTask(task: Task)
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