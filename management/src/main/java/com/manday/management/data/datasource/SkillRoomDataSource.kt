package com.manday.coredata.datasource

import androidx.lifecycle.LiveData
import com.manday.management.data.datasource.ManagementRoomDataSource
import com.manday.management.data.entities.SkillEntity


class SkillRoomDataSource : SkillDatabaseDataSource, ManagementRoomDataSource() {

    override fun getListSkill(): LiveData<List<SkillEntity>>? {
        return skillDao?.getAllSkills()
    }
}