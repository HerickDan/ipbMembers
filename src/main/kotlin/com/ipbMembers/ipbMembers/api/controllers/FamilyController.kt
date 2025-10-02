package com.ipbMembers.ipbMembers.api.controllers

import com.ipbMembers.ipbMembers.api.entity.FamilyEntity
import com.ipbMembers.ipbMembers.api.representation.CreateFamilyRequest
import com.ipbMembers.ipbMembers.services.FamilyService
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/family")
class FamilyController(
    private val familyService: FamilyService
) {

    @PostMapping()
    fun createFamily(
        @RequestBody req: CreateFamilyRequest
    ){
        familyService.createFamily(req.fromDto())
    }
}