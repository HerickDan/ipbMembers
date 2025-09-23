package com.ipbMembers.ipbMembers.services

import com.ipbMembers.ipbMembers.api.MemberRepository
import com.ipbMembers.ipbMembers.api.entity.MemberEntity
import com.ipbMembers.ipbMembers.commons.dto.CreteMemberDto
import org.springframework.stereotype.Service

@Service
class MemberService(
    private val memberRepository: MemberRepository
) {
    fun createMember(dto: CreteMemberDto){
        val entity = MemberEntity(
            firstName = dto.firstName,
            lastName = dto.lastName
        )
        memberRepository.save(entity)
    }
}