package com.ipbMembers.ipbMembers.securityConfig.authentication

import com.ipbMembers.ipbMembers.api.representation.request.AuthRequest
import com.ipbMembers.ipbMembers.api.representation.response.AuthResponse
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.AuthenticationServiceException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import java.util.Date

@Service
class AuthenticationService(
    private val authManager: AuthenticationManager,
    private val userDetailsService: UserDetailsService,
    private val tokenService: TokenService,
    private val refreshTokenRepository: RefreshTokenRepository
) {
    fun authentication(authRequest: AuthRequest): AuthResponse {
        authManager.authenticate(
            UsernamePasswordAuthenticationToken(
                authRequest.userName,
                authRequest.password
            )
        )
        val user = userDetailsService.loadUserByUsername(authRequest.userName)

        val accessToken = createAccessToken(user)
        val refreshToken = createRefreshToken(user)

        return AuthResponse(
            accessToken,
            refreshToken
        )
    }

    fun refreshAccessToken(refreshToken: String): String {
        val userName = tokenService.extractUsername(refreshToken)
        return userName.let { user ->
            val currentUserDetails = userDetailsService.loadUserByUsername(user)
            val refreshTokenUserDetails = refreshTokenRepository.findUserDetailsByToken(refreshToken)

            if (currentUserDetails.username == refreshTokenUserDetails?.username) {
                createAccessToken(currentUserDetails)
            } else {
                throw AuthenticationServiceException("Invalid refresh token")
            }
        }
    }

    private fun createAccessToken(user: UserDetails): String {
        return tokenService.generateToken(
            subject = user.username,
            expiration = Date(System.currentTimeMillis() + 15 * 60 * 1000),
            user = user
        )
    }

    private fun createRefreshToken(user: UserDetails): String {
       return  tokenService.generateToken(
            subject = user.username,
            expiration = Date(System.currentTimeMillis() + 15 * 60 * 1000),
            user = user
        )
    }

}