package com.ipbMembers.ipbMembers.commons.dto

import com.ipbMembers.ipbMembers.commons.enum.HierarchLevel

data class CreteMemberDto(
    val firstName: String,
    val lastName: String,
    val age: Int,
    val hierarchLevel: HierarchLevel?
)