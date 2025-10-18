package com.ipbMembers.ipbMembers.services

import com.ipbMembers.ipbMembers.api.representation.repository.IMemberRepository
import com.ipbMembers.ipbMembers.api.entity.MemberEntity
import com.ipbMembers.ipbMembers.commons.dto.CreteMemberDto
import com.ipbMembers.ipbMembers.commons.dto.UpdateMember
import com.ipbMembers.ipbMembers.commons.dto.ViewMemberDto
import com.ipbMembers.ipbMembers.commons.enum.ErrorMessage
import com.ipbMembers.ipbMembers.exceptions.handledExceptions.NotFoundException
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class MemberService(
    private val IMemberRepository: IMemberRepository,
) {


    fun getMember(memberId: String): ViewMemberDto {
        val member = IMemberRepository.findByApiId(memberId) ?: throw NotFoundException(
            ErrorMessage.FAMILY_NOT_FOUND
        )
        return ViewMemberDto(
            userId = member.apiId!!,
            firstName = member.firstName,
            lastName = member.lastName,
            age = member.age,
            userName = member.userName
        )
    }

    fun updateMember(memberId: String, dto: UpdateMember) {
        val member = IMemberRepository.findByApiId(memberId) ?: throw NotFoundException(
            ErrorMessage.FAMILY_NOT_FOUND
        )
        val updatedMember = member.copy(
            firstName = dto.firstName ?: member.firstName,
            lastName = dto.lastName ?: member.lastName,
            age = dto.age ?: member.age
        )
        IMemberRepository.save(updatedMember)
    }

    fun delete(memberId: String) {
        val member = IMemberRepository.findByApiId(memberId) ?: throw NotFoundException(
            ErrorMessage.FAMILY_NOT_FOUND
        )
        IMemberRepository.delete(member)
    }

    fun getAllMembers(page: Pageable): Page<ViewMemberDto> {
        val members = IMemberRepository.findAll(page)
        return members.map { member ->
            ViewMemberDto(
                userId = member.apiId!!,
                firstName = member.firstName,
                lastName = member.lastName,
                age = member.age,
                userName = member.userName
            )
        }
    }
}