package com.manday.coredata.datasource

import androidx.lifecycle.LiveData
import com.manday.management.data.entities.SkillEntity

interface SkillDatabaseDataSource {

    fun getListSkill(): LiveData<List<SkillEntity>?>?
}