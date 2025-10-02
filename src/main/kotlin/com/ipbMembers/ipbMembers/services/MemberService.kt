package com.ipbMembers.ipbMembers.services

import com.ipbMembers.ipbMembers.api.MemberRepository
import com.ipbMembers.ipbMembers.api.entity.MemberEntity
import com.ipbMembers.ipbMembers.commons.dto.CreteMemberDto
import com.ipbMembers.ipbMembers.commons.dto.UpdateMember
import com.ipbMembers.ipbMembers.commons.dto.ViewMemberDto
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class MemberService(
    private val memberRepository: MemberRepository,
) {
    fun createMember(dto: CreteMemberDto) {
        memberRepository.save(MemberEntity.fromDto(dto))
    }

    fun getMember(memberId: String): ViewMemberDto {
        val member = memberRepository.findByUserApiId(memberId)
        return ViewMemberDto(
            userId = member.userApiId!!,
            firstName = member.firstName,
            lastName = member.lastName,
            age = member.age
        )
    }

    fun updateMember(memberId: String, dto: UpdateMember) {
        val member = memberRepository.findByUserApiId(memberId)
        val updatedMember = member.copy(
            firstName = dto.firstName ?: member.firstName,
            lastName = dto.lastName ?: member.lastName,
            age = dto.age ?: member.age
        )
        memberRepository.save(updatedMember)
    }

    fun delete(memberId: String) {
        val member = memberRepository.findByUserApiId(memberId)
        memberRepository.delete(member)
    }

    fun getAllMembers(page: Pageable): Page<ViewMemberDto> {
        val members = memberRepository.findAll(page)
        return members.map { member ->
            ViewMemberDto(
                userId = member.userApiId!!,
                firstName = member.firstName,
                lastName = member.lastName,
                age = member.age
            )
        }
    }
}