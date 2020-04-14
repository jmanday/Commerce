package com.sdos.commerce.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.manday.management.data.entities.TypeTaskEntity

@Dao
interface TypeTaskDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(typeTasks: List<TypeTaskEntity>)

    @Query("SELECT * FROM type_tasks ")
    fun getAllTypeTasks(): LiveData<List<TypeTaskEntity>>
}
