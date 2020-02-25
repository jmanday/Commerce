package com.sdos.commerce.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sdos.commerce.entities.Skill

@Dao
interface SkillDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(employees: List<Skill>)

    @Query("SELECT * FROM skills ")
    fun getAllSkills(): LiveData<List<Skill>>
}