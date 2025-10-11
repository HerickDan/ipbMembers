package com.ipbMembers.ipbMembers.api.controllers

import com.ipbMembers.ipbMembers.api.representation.request.AddMemberRequest
import com.ipbMembers.ipbMembers.api.representation.request.CreateFamilyRequest
import com.ipbMembers.ipbMembers.commons.dto.AddMemberDto
import com.ipbMembers.ipbMembers.services.FamilyService
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
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

    @PatchMapping
    fun addMembers(
        @RequestBody req: AddMemberRequest
    ){
        familyService.addMembers(req.toDto())
    }
}