package com.sdos.commerce.data

import androidx.lifecycle.LiveData
import com.sdos.commerce.data.datasource.SkillDatabaseDataSource
import com.sdos.commerce.domain.SkillRepository
import com.sdos.commerce.entities.Skill

class SkillRepositoryImpl(private val dataSource: SkillDatabaseDataSource): SkillRepository {

    override fun getListSkill(): LiveData<List<Skill>>? {
        return dataSource.getSkillList()
    }
}