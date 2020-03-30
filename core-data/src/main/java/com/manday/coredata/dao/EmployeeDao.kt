package com.sdos.commerce.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.manday.coredata.entities.EmployeeEntity

@Dao
interface EmployeeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(employees: List<EmployeeEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addEmployee(employee: EmployeeEntity)

    @Query("SELECT * FROM employees ")
    fun getAllEmployees(): LiveData<List<EmployeeEntity>>

    @Query("SELECT * FROM employees WHERE name = :mName AND pass = :mPass AND typeEmployee = :type")
    fun getEmployee(mName: String, mPass: String, type: Int): LiveData<EmployeeEntity>
/*
    @Query("UPDATE employees SET listTask=:listNewTask WHERE id = :idEmployee")
    fun assignTaskToEmploye(idEmployee: Int, listNewTask: List<Int>)



    @Update
    suspend fun updateUsers(employee: Employee)

    @Delete
    suspend fun deleteUsers(employee: Employee)

     */
}