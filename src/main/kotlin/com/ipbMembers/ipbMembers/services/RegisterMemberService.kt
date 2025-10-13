package com.ipbMembers.ipbMembers.services

import com.ipbMembers.ipbMembers.api.entity.MemberEntity
import com.ipbMembers.ipbMembers.api.representation.repository.IMemberRepository
import com.ipbMembers.ipbMembers.commons.dto.CreteMemberDto
import com.ipbMembers.ipbMembers.securityConfig.SecurityConfig
import org.springframework.stereotype.Service

@Service
class RegisterMemberService(
    private val IMemberRepository: IMemberRepository,
    private val securityConfig: SecurityConfig
) {
    fun createMember(dto: CreteMemberDto) {
        val passwordEncoder = securityConfig.passwordEncoder()
        IMemberRepository.save(MemberEntity.fromDto(CreteMemberDto(
            firstName = dto.firstName,
            lastName = dto.lastName,
            age = dto.age,
            email = dto.email,
            password = passwordEncoder.encode(dto.password),
            hierarchLevel = dto.hierarchLevel
        )))
    }
}