package com.ipbMembers.ipbMembers.api.entity

import com.ipbMembers.ipbMembers.commons.dto.CreteMemberDto
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "members")
data class MemberEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val userApiId: String? = UUID.randomUUID().toString(),
    val firstName: String,
    val lastName: String,
    val age: Int
) {
    fun fromDto(dto: CreteMemberDto): CreteMemberDto =
        CreteMemberDto(
            firstName = this.firstName,
            lastName = this.lastName,
            age = this.age
        )
}