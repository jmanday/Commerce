package com.sdos.commerce.domain.interactors

import com.manday.coredata.entities.SkillEntity

interface SkillRepository {

    fun getListSkill(): List<SkillEntity>?
}