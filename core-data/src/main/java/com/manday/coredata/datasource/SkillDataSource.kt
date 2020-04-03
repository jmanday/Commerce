package com.manday.coredata.datasource

import com.manday.coredata.entities.SkillEntity

interface SkillDataSource {

    fun getListSkill(): List<SkillEntity>?
}