package com.sdos.commerce.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sdos.commerce.entities.Fruit
import com.sdos.commerce.entities.Skill

@Dao
interface FruitDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(fruits: List<Fruit>)

    @Query("SELECT * FROM fruits")
    fun getAllFruitss(): LiveData<List<Fruit>>
}