package com.sdos.commerce.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.manday.coredata.entities.SkillEntity

@Dao
interface SkillDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(skills: List<SkillEntity>)

    @Query("SELECT * FROM skills")
    fun getAllSkills(): LiveData<List<SkillEntity>>
}