package com.ipbMembers.ipbMembers.api.representation.request

import com.ipbMembers.ipbMembers.commons.dto.CreateFamilyDto

data class CreateFamilyRequest(
    val familyName: String
) {

    fun fromDto(): CreateFamilyDto =
        CreateFamilyDto(
            name = this.familyName
        )
}
