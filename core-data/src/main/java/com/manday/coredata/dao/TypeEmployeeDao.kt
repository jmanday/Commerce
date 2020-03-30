package com.sdos.commerce.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.manday.coredata.entities.TypeEmployeeEntity

@Dao
interface TypeEmployeeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(typeEmployees: List<TypeEmployeeEntity>)
}