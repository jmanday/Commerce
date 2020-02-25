package com.sdos.commerce.domain.interactors

import androidx.lifecycle.LiveData
import com.sdos.commerce.domain.SkillRepository
import com.sdos.commerce.entities.Skill

class GetListSkillInteractor(private val skillRepository: SkillRepository): () -> LiveData<List<Skill>>? {


    override fun invoke(): LiveData<List<Skill>>? {
        return skillRepository.getListSkill()
    }
}