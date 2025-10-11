package com.ipbMembers.ipbMembers.api.representation.request

import com.ipbMembers.ipbMembers.commons.dto.CreteMemberDto
import com.ipbMembers.ipbMembers.commons.enum.HierarchLevel

data class CreateMemberRequest(
    val firstName: String,
    val lastName: String,
    val age: Int,
    val hierarchLevel: HierarchLevel ? = HierarchLevel.COMMON_MEMBER
) {
    fun toDto(): CreteMemberDto =
        CreteMemberDto(
            firstName = this.firstName,
            lastName = this.lastName,
            age = this.age,
            hierarchLevel = this.hierarchLevel
        )
}