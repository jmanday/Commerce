package com.sdos.commerce.repositories

import androidx.lifecycle.LiveData
import com.manday.coredata.entities.SkillEntity

interface SkillRepository {

    fun getListSkill(): LiveData<List<SkillEntity>>?
}