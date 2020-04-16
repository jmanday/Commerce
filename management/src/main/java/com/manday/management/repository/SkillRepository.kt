package com.manday.management.repository

import androidx.lifecycle.LiveData
import com.manday.management.data.entities.SkillEntity

interface SkillRepository {

    fun getListSkill(): LiveData<List<SkillEntity>>?
}