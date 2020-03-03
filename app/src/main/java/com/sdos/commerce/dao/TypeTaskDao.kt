package com.sdos.commerce.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sdos.commerce.entities.TypeTask

@Dao
interface TypeTaskDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(typeTasks: List<TypeTask>)

    @Query("SELECT * FROM type_tasks ")
    fun getAllTypeTasks(): LiveData<List<TypeTask>>
}
