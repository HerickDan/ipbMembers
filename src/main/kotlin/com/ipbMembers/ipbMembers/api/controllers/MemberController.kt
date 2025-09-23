package com.ipbMembers.ipbMembers.api.controllers

import com.ipbMembers.ipbMembers.api.representation.CreateMemberRequest
import com.ipbMembers.ipbMembers.services.MemberService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/member")
class MemberController(
    private val memberService: MemberService
) {
    @PostMapping()
    fun createMember(
        @RequestBody req: CreateMemberRequest
    ){
        memberService.createMember(req.toDto())
    }
}