package com.norway.norway.service;

import com.norway.norway.dto.MemberDto;
import com.norway.norway.dto.MemberRegistrationForm;
import com.norway.norway.model.Member;
import com.norway.norway.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    /** 회원 전체조회 **/
    public List<MemberDto> getMembers(){
        return new MemberDto().createMemberDtoList(memberRepository.findAll());

    }

    /** 회원 단건조회 **/
    public MemberDto getMemberDetail(Long memberId){
        return new MemberDto().createMemberDto(memberRepository.findById(memberId));
    }

    /** 회원 삭제 **/
    @Transactional(readOnly = false)
    public Boolean deleteMember(Long memberId) {
        memberRepository.deleteById(memberId);
        return true;
    }

    /** 회원 등록 **/
    @Transactional(readOnly = false)
    public Boolean saveMember(MemberRegistrationForm memberRegistrationForm){
        memberRepository.save(new Member().createRegistrationMember(memberRegistrationForm));
        return true;
    }
}
