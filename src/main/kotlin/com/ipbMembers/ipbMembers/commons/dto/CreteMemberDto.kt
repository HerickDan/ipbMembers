package com.ipbMembers.ipbMembers.commons.dto

import com.ipbMembers.ipbMembers.commons.enum.HierarchLevel

data class CreteMemberDto(
    val firstName: String,
    val lastName: String,
    val age: Int,
    val email: String,
    val password: String,
    val userName: String,
    val hierarchLevel: HierarchLevel?
)