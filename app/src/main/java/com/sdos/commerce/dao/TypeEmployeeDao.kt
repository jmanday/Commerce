package com.sdos.commerce.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.sdos.commerce.entities.TypeEmployee

@Dao
interface TypeEmployeeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(typeEmployees: List<TypeEmployee>)
}