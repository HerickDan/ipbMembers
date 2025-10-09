package com.ipbMembers.ipbMembers.api.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.ZonedDateTime
import java.util.UUID

@Entity
@Table(name= "family_members")
data class FamilyMembersEntity (
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    val id: Int? = null,
    val appId: String = UUID.randomUUID().toString(),
    val mother: Int,
    val father: Int
)