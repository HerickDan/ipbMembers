package com.ipbMembers.ipbMembers.api.representation.request

import com.ipbMembers.ipbMembers.commons.dto.AddMemberDto
import com.ipbMembers.ipbMembers.commons.enum.HierarchLevel

data class AddMemberRequest(
    val memberId: String,
    val familyId: String
) {
    fun toDto(): AddMemberDto {
        return AddMemberDto(
            memberId = this.memberId,
            familyId = this.familyId
        )
    }
}