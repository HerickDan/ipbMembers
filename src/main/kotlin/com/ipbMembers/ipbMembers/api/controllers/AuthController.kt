package com.ipbMembers.ipbMembers.api.controllers

import com.ipbMembers.ipbMembers.api.representation.request.AuthRequest
import com.ipbMembers.ipbMembers.api.representation.request.RefreshTokenRequest
import com.ipbMembers.ipbMembers.api.representation.response.AuthResponse
import com.ipbMembers.ipbMembers.securityConfig.authentication.AuthenticationService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/auth")
class AuthController(
    private val authService: AuthenticationService
) {
    @PostMapping
    fun authenticate(
        @RequestBody authRequest: AuthRequest
    ): AuthResponse = authService.authentication(authRequest)

    @PostMapping("/refresh")
    fun refreshAccessToken(
        @RequestBody req: RefreshTokenRequest
    ): AuthResponse = AuthResponse(
        refreshToken = authService.refreshAccessToken(req.refreshToken)
    )
}