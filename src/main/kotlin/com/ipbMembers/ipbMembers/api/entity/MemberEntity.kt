package com.ipbMembers.ipbMembers.api.entity

import com.ipbMembers.ipbMembers.commons.dto.CreteMemberDto
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "members")
data class MemberEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val firstName: String,
    val lastName: String
) {
    fun fromDto(dto: CreteMemberDto): CreteMemberDto =
        CreteMemberDto(
            firstName = this.firstName,
            lastName = this.lastName
        )
}