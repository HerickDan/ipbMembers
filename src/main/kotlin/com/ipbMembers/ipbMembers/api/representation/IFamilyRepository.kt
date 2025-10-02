package com.ipbMembers.ipbMembers.api.representation

import com.ipbMembers.ipbMembers.api.entity.FamilyEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface IFamilyRepository: JpaRepository<FamilyEntity, Int>{
}