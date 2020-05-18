package com.manday.management.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.manday.management.data.entities.EmployeeEntity

@Dao
interface EmployeeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(employees: List<EmployeeEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addEmployee(employee: EmployeeEntity): Long?

    @Query("SELECT * FROM employees WHERE typeEmployee = 1")
    fun getAllEmployees(): LiveData<List<EmployeeEntity>?>

    @Query("SELECT * FROM employees WHERE name = :mName AND pass = :mPass")
    fun getEmployee(mName: String, mPass: String): LiveData<EmployeeEntity?>

}