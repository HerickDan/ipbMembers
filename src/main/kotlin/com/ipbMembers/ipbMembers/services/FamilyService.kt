package com.ipbMembers.ipbMembers.services

import com.ipbMembers.ipbMembers.api.entity.FamilyEntity
import com.ipbMembers.ipbMembers.api.representation.repository.IFamilyRepository
import com.ipbMembers.ipbMembers.api.representation.repository.IMemberRepository
import com.ipbMembers.ipbMembers.commons.dto.AddMemberDto
import com.ipbMembers.ipbMembers.commons.dto.CreateFamilyDto
import com.ipbMembers.ipbMembers.commons.enum.ErrorMessage
import com.ipbMembers.ipbMembers.exceptions.handledExceptions.NotFoundException
import org.springframework.stereotype.Service


@Service
class FamilyService(
    private val familyRepository: IFamilyRepository,
    private val memberRepository: IMemberRepository
) {
    fun createFamily(dto: CreateFamilyDto) {
        familyRepository.save(FamilyEntity.fromDto(dto))
    }

    fun addMembers(req: AddMemberDto) {
        val family = familyRepository.findByApiId(req.familyId) ?: throw NotFoundException(
            ErrorMessage.FAMILY_NOT_FOUND
        )
        val member = memberRepository.findByApiId(req.memberId) ?: throw NotFoundException(
            ErrorMessage.MEMBER_NOT_FOUND
        )
    }
}