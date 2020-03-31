package com.manday.coredata.datasource

import androidx.lifecycle.LiveData
import com.manday.coredata.entities.SkillEntity

interface SkillDatabaseDataSource {

    fun getSkillList(): LiveData<List<SkillEntity>>?
}