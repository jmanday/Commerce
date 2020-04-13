package com.manday.coredata.datasource

import androidx.lifecycle.LiveData
import com.manday.coredata.entities.SkillEntity
import com.sdos.commerce.dao.SkillDao
import com.sdos.commerce.data.room.RoomController

class SkillDatabaseDataSourceImpl: SkillDatabaseDataSource {

    private var skillDao: SkillDao? = null

    init {
        skillDao = RoomController.getSkillDao()
    }

    override fun getListSkill(): LiveData<List<SkillEntity>>? {
        return skillDao?.getAllSkills()
    }
}