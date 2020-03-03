package com.sdos.commerce.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.sdos.commerce.entities.TypeTask

@Dao
interface TypeTaskDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(typeTasks: List<TypeTask>)
}
