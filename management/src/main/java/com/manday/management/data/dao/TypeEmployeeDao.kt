package com.manday.management.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.manday.management.data.entities.TypeEmployeeEntity

@Dao
interface TypeEmployeeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(typeEmployees: List<TypeEmployeeEntity>)
}