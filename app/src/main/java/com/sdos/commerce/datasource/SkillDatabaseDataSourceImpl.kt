package com.manday.coredata.datasource

import androidx.lifecycle.LiveData
import com.manday.management.data.controllers.RoomController
import com.manday.management.data.dao.SkillDao
import com.manday.management.data.entities.SkillEntity


class SkillDatabaseDataSourceImpl: SkillDatabaseDataSource {

    private var skillDao: SkillDao? = null

    init {
        skillDao = RoomController.getInstance()?.skillDao()
    }

    override fun getListSkill(): LiveData<List<SkillEntity>>? {
        return skillDao?.getAllSkills()
    }
}