package com.sdos.commerce.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.manday.management.data.entities.FruitEntity

@Dao
interface FruitDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(fruits: List<FruitEntity>)

    @Query("SELECT * FROM fruits")
    fun getAllFruitss(): LiveData<List<FruitEntity>>
}