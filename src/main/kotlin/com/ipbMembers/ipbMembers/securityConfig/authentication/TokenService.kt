package com.ipbMembers.ipbMembers.securityConfig.authentication

import com.ipbMembers.ipbMembers.securityConfig.CustomUserDetails
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.Jwts.*
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import java.util.Base64
import java.util.Date
import javax.crypto.spec.SecretKeySpec

@Service
class TokenService(
    private val secretToken: String = "0yF0e1o6s4Rl4s0p3M5tX4v1B2d1W3pZx6G9s3T0u2H1K8aZ4J6V5x8d9y3L2q1",
) {
    private val signingKey: SecretKeySpec
        get() {
            val keyBytes: ByteArray = Base64.getDecoder().decode(secretToken)
            return SecretKeySpec(
                keyBytes,
                0,
                keyBytes.size,
                "HmacSHA256"
            )
        }

    fun generateToken(
        subject: String,
        expiration: Date,
        additionalClaims: Map<String, Any>? = emptyMap(),
        user: UserDetails
    ): String {
        val roles = user.authorities.map { it.authority }
        return builder()
            .claims()
            .add("role", roles).subject(subject)
            .issuedAt(
                 Date(System.currentTimeMillis())
            ).and()
            .expiration(expiration)
            .signWith(signingKey).compact()
    }

    fun extractAllClaims(token: String): Claims {
        return Jwts.parser().build().parseSignedClaims(token).payload
    }

    fun extractUsername(token: String): String {
        return extractAllClaims(token).subject
    }


}