package com.ipbMembers.ipbMembers.services

import com.ipbMembers.ipbMembers.api.MemberRepository
import com.ipbMembers.ipbMembers.api.entity.MemberEntity
import com.ipbMembers.ipbMembers.commons.dto.CreteMemberDto
import com.ipbMembers.ipbMembers.commons.dto.ViewMemberDto
import org.springframework.stereotype.Service

@Service
class MemberService(
    private val memberRepository: MemberRepository
) {
    fun createMember(dto: CreteMemberDto){
        val entity = MemberEntity(
            firstName = dto.firstName,
            lastName = dto.lastName,
            age = dto.age
        )
        memberRepository.save(entity)
    }

   fun getMember(memberId: String): ViewMemberDto{
       val member = memberRepository.findByUserApiId(memberId)
       return ViewMemberDto(
           userId = member.userApiId!!,
           firstName = member.firstName,
           lastName = member.lastName,
           age = member.age
       )
   }
}