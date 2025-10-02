package com.ipbMembers.ipbMembers.api.entity

import com.ipbMembers.ipbMembers.commons.dto.CreateFamilyDto
import com.ipbMembers.ipbMembers.commons.dto.CreteMemberDto
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.ZonedDateTime
import java.util.UUID


@Entity
@Table(name = "family")
data class FamilyEntity(
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    val id: Int? = null,
    val apiId: String = UUID.randomUUID().toString(),
    val createdAt: ZonedDateTime? = ZonedDateTime.now(),
    val updatedAt: ZonedDateTime? = null,
    val familyName: String
){
    companion object{
        fun fromDto(dto: CreateFamilyDto): FamilyEntity{
            return FamilyEntity(
                familyName = dto.name
            )
        }
    }
}
