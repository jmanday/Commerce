package com.sdos.commerce.data.datasource

import androidx.lifecycle.LiveData
import com.sdos.commerce.entities.Skill

interface SkillDatabaseDataSource {

    fun getSkillList(): LiveData<List<Skill>>?
}