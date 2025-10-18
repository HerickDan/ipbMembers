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
import jakarta.persistence.JoinColumn
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "members")
data class MemberEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Column(name="first_name")
    val firstName: String,
    @Column(name="last_name")
    val lastName: String,
    @Column(name="age")
    val age: Int,
    @Column(name="hierarchical_level")
    @Enumerated(EnumType.STRING)
    val hierarchicalLevel: HierarchLevel ? = HierarchLevel.COMMON_MEMBER,
    @Column(name="api_id")
    val apiId: String? = UUID.randomUUID().toString(),
    @Column(name="email")
    val email: String,
    @Column(name="password")
    val password: String,
    @JoinColumn(name="id")
    @Column(name="role_id")
    val roleId: Int ? = null,
    @Column(name="user_name")
    val userName: String
) {
    companion object {
        fun fromDto(dto: CreteMemberDto): MemberEntity =
            MemberEntity(
                firstName = dto.firstName,
                lastName = dto.lastName,
                age = dto.age,
                hierarchicalLevel = dto.hierarchLevel,
                email = dto.email,
                password = dto.password,
                userName = dto.userName
            )
    }
}