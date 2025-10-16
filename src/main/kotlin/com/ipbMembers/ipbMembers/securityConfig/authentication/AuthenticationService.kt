package com.ipbMembers.ipbMembers.securityConfig.authentication

import com.ipbMembers.ipbMembers.api.representation.request.AuthRequest
import com.ipbMembers.ipbMembers.api.representation.response.AuthResponse
import com.ipbMembers.ipbMembers.commons.dto.CreteMemberDto
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.userdetails.UserDetailsService

class AuthenticationService(
    private val authManager: AuthenticationManager,
    private val userDetailsService: UserDetailsService,
    private val tokenService: TokenService,
    private val refreshTokenRepository: RefreshTokenRepository
) {
    fun authentication(authRequest: AuthRequest): AuthResponse{
        authManager.authenticate(
            UsernamePasswordAuthenticationToken(
                authRequest.userName,
                authRequest.password
            )
        )
        val user = userDetailsService.loadUserByUsername(authRequest.userName)
    }


}