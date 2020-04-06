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

    @Query("SELECT * FROM employees WHERE typeEmployee = 1")
    fun getAllEmployees(): LiveData<List<EmployeeEntity>>

    @Query("SELECT * FROM employees WHERE name = :mName AND pass = :mPass")
    fun getEmployee(mName: String, mPass: String): EmployeeEntity

}