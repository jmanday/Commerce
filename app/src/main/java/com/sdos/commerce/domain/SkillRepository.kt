package com.sdos.commerce.domain

import androidx.lifecycle.LiveData
import com.sdos.commerce.entities.Skill

interface SkillRepository {

    fun getListSkill(): LiveData<List<Skill>>?
}