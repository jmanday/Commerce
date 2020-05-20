package com.manday.management.repository

import androidx.lifecycle.LiveData
import com.manday.coredata.datasource.SkillDatabaseDataSource
import com.manday.management.data.entities.SkillEntity

class SkillRepositoryImpl(private val databseDataSource: SkillDatabaseDataSource) :
    SkillRepository {

    override fun getListSkill(): LiveData<List<SkillEntity>?>? {
        return databseDataSource.getListSkill()
    }
}