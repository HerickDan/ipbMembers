package com.ipbMembers.ipbMembers.api.representation.repository

import com.ipbMembers.ipbMembers.api.entity.FamilyEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface IFamilyRepository: JpaRepository<FamilyEntity, Int>{
    fun findByApiId(apiId: String): FamilyEntity
}