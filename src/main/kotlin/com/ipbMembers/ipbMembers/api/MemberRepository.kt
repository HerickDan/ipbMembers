package com.ipbMembers.ipbMembers.api

import com.ipbMembers.ipbMembers.api.entity.MemberEntity
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository: JpaRepository<MemberEntity, Long> {
    fun findByUserApiId(memberId: String): MemberEntity
}
