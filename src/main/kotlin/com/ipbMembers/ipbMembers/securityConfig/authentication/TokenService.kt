package com.ipbMembers.ipbMembers.securityConfig.authentication

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.Jwts.*
import org.springframework.stereotype.Service
import java.util.Base64
import java.util.Date
import javax.crypto.spec.SecretKeySpec

@Service
class TokenService(
    private val secretToken: String = "tokenSecret",
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
        additionalClaims: Map<String, Any>? = emptyMap()
    ): String {
        return builder()
            .claims()
            .add(additionalClaims).subject(subject)
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