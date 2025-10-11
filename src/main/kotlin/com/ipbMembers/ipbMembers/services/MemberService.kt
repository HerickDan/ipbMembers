package com.ipbMembers.ipbMembers.services

import com.ipbMembers.ipbMembers.api.representation.repository.IMemberRepository
import com.ipbMembers.ipbMembers.api.entity.MemberEntity
import com.ipbMembers.ipbMembers.commons.dto.CreteMemberDto
import com.ipbMembers.ipbMembers.commons.dto.UpdateMember
import com.ipbMembers.ipbMembers.commons.dto.ViewMemberDto
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class MemberService(
    private val IMemberRepository: IMemberRepository,
) {
    fun createMember(dto: CreteMemberDto) {
        IMemberRepository.save(MemberEntity.fromDto(dto))
    }

    fun getMember(memberId: String): ViewMemberDto {
        val member = IMemberRepository.findByApiId(memberId)
        return ViewMemberDto(
            userId = member.apiId!!,
            firstName = member.firstName,
            lastName = member.lastName,
            age = member.age
        )
    }

    fun updateMember(memberId: String, dto: UpdateMember) {
        val member = IMemberRepository.findByApiId(memberId)
        val updatedMember = member.copy(
            firstName = dto.firstName ?: member.firstName,
            lastName = dto.lastName ?: member.lastName,
            age = dto.age ?: member.age
        )
        IMemberRepository.save(updatedMember)
    }

    fun delete(memberId: String) {
        val member = IMemberRepository.findByApiId(memberId)
        IMemberRepository.delete(member)
    }

    fun getAllMembers(page: Pageable): Page<ViewMemberDto> {
        val members = IMemberRepository.findAll(page)
        return members.map { member ->
            ViewMemberDto(
                userId = member.apiId!!,
                firstName = member.firstName,
                lastName = member.lastName,
                age = member.age
            )
        }
    }
}