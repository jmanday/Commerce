package com.manday.management.repository

import androidx.lifecycle.LiveData
import com.manday.coredata.datasource.SkillDatabaseDataSource
import com.manday.management.data.entities.SkillEntity

class SkillRepositoryImpl(private val dataSource: SkillDatabaseDataSource): SkillRepository {

    override fun getListSkill(): LiveData<List<SkillEntity>>? {
        return dataSource.getListSkill()
    }
}