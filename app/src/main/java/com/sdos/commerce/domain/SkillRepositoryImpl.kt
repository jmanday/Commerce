package com.sdos.commerce.domain

import androidx.lifecycle.LiveData
import com.manday.coredata.datasource.SkillDatabaseDataSource
import com.manday.coredata.entities.SkillEntity

class SkillRepositoryImpl(private val dataSource: SkillDatabaseDataSource): SkillRepository {

    override fun getListSkill(): LiveData<List<SkillEntity>>? {
        return dataSource.getListSkill()
    }
}