package com.sdos.commerce.domain.interactors

import com.manday.coredata.entities.SkillEntity

class GetListSkillInteractor(private val skillRepository: SkillRepository): () -> List<SkillEntity>? {

    override fun invoke(): List<SkillEntity>? {
        return skillRepository.getListSkill()
    }
}

