package com.ipbMembers.ipbMembers.api.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.ZonedDateTime
import java.util.UUID


@Entity
@Table(name = "roles")
data class RoleEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,
    val apiId: String? = UUID.randomUUID().toString(),
    val createdAt: ZonedDateTime = ZonedDateTime.now()
)
