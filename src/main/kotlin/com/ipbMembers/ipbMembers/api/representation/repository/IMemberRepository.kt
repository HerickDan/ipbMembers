package com.ipbMembers.ipbMembers.api.representation.repository

import com.ipbMembers.ipbMembers.api.entity.MemberEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import java.lang.reflect.Member

interface IMemberRepository: JpaRepository<MemberEntity, Long> {
    fun findByApiId(memberId: String): MemberEntity?
    fun findByEmail(email: String): MemberEntity?
    override fun findAll(page: Pageable): Page<MemberEntity>
}