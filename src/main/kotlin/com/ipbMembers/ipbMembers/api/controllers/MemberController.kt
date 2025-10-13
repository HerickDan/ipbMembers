package com.ipbMembers.ipbMembers.api.controllers

import com.ipbMembers.ipbMembers.api.representation.request.CreateMemberRequest
import com.ipbMembers.ipbMembers.commons.dto.UpdateMember
import com.ipbMembers.ipbMembers.commons.dto.ViewMemberDto
import com.ipbMembers.ipbMembers.services.MemberService
import com.ipbMembers.ipbMembers.services.RegisterMemberService
import org.springdoc.core.annotations.ParameterObject
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController



@RestController
@RequestMapping("/member")
class MemberController(
    private val memberService: MemberService,
    private val registerMemberService: RegisterMemberService
) {
    @PostMapping()
    fun createMember(
        @RequestBody req: CreateMemberRequest
    ) {
        registerMemberService.createMember(req.toDto())
    }

    @GetMapping
    fun getAllmembers(
        @ParameterObject page: Pageable
    ): Page<ViewMemberDto> {
        return memberService.getAllMembers(page)
    }

    @GetMapping("/{memberId}")
    fun getMember(@PathVariable memberId: String): ViewMemberDto {
        return memberService.getMember(memberId)
    }

    @PatchMapping("/{memberId}")
    fun updateMember(
        @PathVariable memberId: String,
        @RequestBody req: UpdateMember
    ) {
        memberService.updateMember(memberId, req)
    }

    @DeleteMapping("/{memberId}")
    fun deleteMember(
        @PathVariable memberId: String
    ) {
        memberService.delete(memberId)
    }
}