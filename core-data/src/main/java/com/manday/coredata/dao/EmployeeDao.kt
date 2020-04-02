package com.sdos.commerce.dao

import androidx.room.*
import com.manday.coredata.entities.EmployeeEntity

@Dao
interface EmployeeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(employees: List<EmployeeEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addEmployee(employee: EmployeeEntity)

    @Query("SELECT * FROM employees ")
    fun getAllEmployees(): List<EmployeeEntity>

    @Query("SELECT * FROM employees WHERE name = :mName AND pass = :mPass")
    fun getEmployee(mName: String, mPass: String): EmployeeEntity

}