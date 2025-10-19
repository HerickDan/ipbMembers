package com.ipbMembers.ipbMembers.securityConfig

import com.ipbMembers.ipbMembers.api.representation.repository.IMemberRepository
import com.ipbMembers.ipbMembers.api.representation.repository.IRoleRepository
import com.ipbMembers.ipbMembers.commons.enum.ErrorMessage
import com.ipbMembers.ipbMembers.exceptions.handledExceptions.NotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService


class CustomUserDetails (
    private val memberRepository: IMemberRepository,
    private val roleRepository: IRoleRepository
): UserDetailsService {
 override fun loadUserByUsername(memberId: String): UserDetails {
        val member = memberRepository.findByUserName(memberId) ?: throw NotFoundException(
            ErrorMessage.MEMBER_NOT_FOUND
        )
        val role = roleRepository.findByIdOrNull(member.roleId!!)
        return User.builder()
            .username(member.firstName)
            .password(member.password)
            .roles(role!!.roleName).build()
    }
}