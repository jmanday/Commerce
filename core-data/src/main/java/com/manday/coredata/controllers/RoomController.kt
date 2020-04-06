package com.manday.coredata.controllers

import androidx.lifecycle.LiveData
import com.manday.coredata.datasource.EmployeeDatabaseDataSource
import com.manday.coredata.datasource.SkillDatabaseDataSource
import com.manday.coredata.datasource.TaskDatabaseDataSource
import com.manday.coredata.entities.EmployeeEntity
import com.manday.coredata.entities.SkillEntity
import com.manday.coredata.entities.TaskEntity
import com.manday.coredata.entities.TypeTaskEntity
import com.sdos.commerce.dao.*
import com.sdos.commerce.data.room.RoomController


class RoomController: SkillDatabaseDataSource {

    private var db: RoomController? = null
    private var skillDao: SkillDao? = null

    init {
        db = RoomController.getInstance()
        skillDao = db?.skillDao()
    }

    override fun getListSkill(): LiveData<List<SkillEntity>>? {
        return skillDao?.getAllSkills()
    }
}