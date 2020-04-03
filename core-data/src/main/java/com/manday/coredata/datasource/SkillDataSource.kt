package com.manday.coredata.datasource

import androidx.lifecycle.LiveData
import com.manday.coredata.entities.SkillEntity

interface SkillDataSource {

    fun getListSkill(): LiveData<List<SkillEntity>>?
}