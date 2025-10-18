package com.ipbMembers.ipbMembers.api.representation.response

data class AuthResponse(
    val accessToken:String ? = null,
    val refreshToken: String
)
