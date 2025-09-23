package com.ipbMembers.ipbMembers.api.representation

import com.ipbMembers.ipbMembers.commons.dto.CreteMemberDto

data class CreateMemberRequest(
    val firstName: String,
    val lastName: String,
) {
    fun toDto(): CreteMemberDto =
        CreteMemberDto(
            firstName = this.firstName,
            lastName = this.lastName
        )
}