package com.norway.norway.controller;

import com.norway.norway.dto.MemberDto;
import com.norway.norway.dto.MemberRegistrationForm;
import com.norway.norway.service.MemberService;
import com.norway.norway.util.ApiUtils;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberController {

    private final MemberService memberService;

    @Operation(summary = "GET MEMBERS / RETURNS A ALL MEMBER")
    @GetMapping("/all")
    public ResponseEntity<ApiUtils.ApiResult<List<MemberDto>>> getMembers(){
        return ResponseEntity.ok(ApiUtils.success(memberService.getMembers()));
    }

    @Operation(summary = "GET MEMBER BY ID / RETURNS A SINGLE MEMBER")
    @GetMapping("/{memberId}")
    public ResponseEntity<ApiUtils.ApiResult<MemberDto>> getMemberDetail(@PathVariable Long memberId){
        return ResponseEntity.ok(ApiUtils.success(memberService.getMemberDetail(memberId)));
    }

    @Operation(summary = "DELETE MEMBER BY ID")
    @DeleteMapping("/{memberId}")
    public ResponseEntity<ApiUtils.ApiResult<Boolean>> deleteMember(@PathVariable Long memberId){
        return ResponseEntity.ok(ApiUtils.success(memberService.deleteMember(memberId)));
    }

    @Operation(summary = "SAVE ONE MEMBER")
    @PostMapping("/{memberId}")
    public ResponseEntity<ApiUtils.ApiResult<Boolean>> saveMember(@RequestBody MemberRegistrationForm memberRegistrationForm){
        return ResponseEntity.ok(ApiUtils.success(memberService.saveMember(memberRegistrationForm)));
    }
}
