package com.ipbMembers.ipbMembers.api.controllers

import com.ipbMembers.ipbMembers.api.entity.MemberEntity
import com.ipbMembers.ipbMembers.api.representation.CreateMemberRequest
import com.ipbMembers.ipbMembers.commons.dto.ViewMemberDto
import com.ipbMembers.ipbMembers.services.MemberService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/member")
class MemberController(
    private val memberService: MemberService,
) {
    @PostMapping()
    fun createMember(
        @RequestBody req: CreateMemberRequest
    ) {
        memberService.createMember(req.toDto())
    }

    @GetMapping("/{memberId}")
    fun getMember(@PathVariable memberId: String): ViewMemberDto {
        return memberService.getMember(memberId)
    }
}