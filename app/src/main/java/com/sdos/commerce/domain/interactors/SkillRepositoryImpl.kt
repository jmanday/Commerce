package com.sdos.commerce.domain.interactors

import androidx.lifecycle.LiveData
import com.manday.coredata.datasource.SkillDataSource
import com.manday.coredata.entities.SkillEntity

class SkillRepositoryImpl(private val dataSource: SkillDataSource): SkillRepository {

    override fun getListSkill(): LiveData<List<SkillEntity>>? {
        return dataSource.getListSkill()
    }
}