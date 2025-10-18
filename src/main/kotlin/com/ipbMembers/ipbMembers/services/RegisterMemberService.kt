package com.ipbMembers.ipbMembers.services

import com.ipbMembers.ipbMembers.api.entity.MemberEntity
import com.ipbMembers.ipbMembers.api.representation.repository.IMemberRepository
import com.ipbMembers.ipbMembers.api.representation.repository.IRoleRepository
import com.ipbMembers.ipbMembers.commons.dto.CreteMemberDto
import com.ipbMembers.ipbMembers.commons.enum.ErrorMessage
import com.ipbMembers.ipbMembers.exceptions.handledExceptions.AlreadyCreatedException
import com.ipbMembers.ipbMembers.securityConfig.SecurityConfig
import org.springframework.stereotype.Service

@Service
class RegisterMemberService(
    private val memberRepository: IMemberRepository,
    private val securityConfig: SecurityConfig,
    private val roleRepository: IRoleRepository
) {
    fun createMember(dto: CreteMemberDto) {
        val passwordEncoder = securityConfig.passwordEncoder()
        val existsMember = memberRepository.findByEmail(dto.email)?.email!!.isNotEmpty()

        if (existsMember) throw AlreadyCreatedException(ErrorMessage.ENTITY_ALREADY_CREATED)

        memberRepository.save(
            MemberEntity.fromDto(
                CreteMemberDto(
                    firstName = dto.firstName,
                    lastName = dto.lastName,
                    age = dto.age,
                    email = dto.email,
                    password = passwordEncoder.encode(dto.password),
                    hierarchLevel = dto.hierarchLevel,
                    userName = dto.userName
                )
            )
        )
    }
}