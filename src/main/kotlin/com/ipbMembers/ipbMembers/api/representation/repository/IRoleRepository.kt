package com.ipbMembers.ipbMembers.api.representation.repository

import com.ipbMembers.ipbMembers.api.entity.RoleEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface IRoleRepository: JpaRepository<RoleEntity,Int> {
    override fun findById(id: Int): Optional<RoleEntity?>
    fun findByRoleName(roleName: String): RoleEntity?
}