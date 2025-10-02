package com.ipbMembers.ipbMembers.api.entity

import com.ipbMembers.ipbMembers.commons.dto.CreteMemberDto
import com.ipbMembers.ipbMembers.commons.enum.HierarchLevel
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
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
    val firstName: String,
    val lastName: String,
    val age: Int,
    @Column(name="hierarchical_level")
    @Enumerated(EnumType.STRING)
    val hierarchicalLevel: HierarchLevel,
    val userApiId: String? = UUID.randomUUID().toString(),
) {
    companion object {
        fun fromDto(dto: CreteMemberDto): MemberEntity =
            MemberEntity(
                firstName = dto.firstName,
                lastName = dto.lastName,
                age = dto.age,
                hierarchicalLevel = dto.hierarchLevel,
            )
    }
}