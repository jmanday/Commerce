package com.sdos.commerce.repositories

import androidx.lifecycle.LiveData
import com.manday.management.data.entities.SkillEntity

interface SkillRepository {

    fun getListSkill(): LiveData<List<SkillEntity>>?
}