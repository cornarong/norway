package com.norway.norway.dto;

import com.norway.norway.model.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDto {

    private Long memberId;
    private String id;
    private String password;
    private String name;
    private String birth;
    private String email;
    private String phone1;
    private String phone2;
    private String address1;
    private String address2;
    private String corporateName;
    private String corporateNumber;
    private String role;
    private String createdDate;
    private String modifiedDate;

    /** 생성 메소드 param = Member **/
    public MemberDto createMemberDto(Optional<Member> member){
        Member defaultMember = new Member();
        this.memberId = member.orElseGet(() -> defaultMember).getMemberId();
        this.id = member.orElseGet(() -> defaultMember).getId();
        this.password = member.orElseGet(() -> defaultMember).getPassword();
        this.name = member.orElseGet(() -> defaultMember).getName();
        this.birth = member.orElseGet(() -> defaultMember).getBirth();
        this.email = member.orElseGet(() -> defaultMember).getEmail();
        this.phone1 = member.orElseGet(() -> defaultMember).getPhone1();
        this.phone2 = member.orElseGet(() -> defaultMember).getPhone2();
        this.address1 = member.orElseGet(() -> defaultMember).getAddress1();
        this.address2 = member.orElseGet(() -> defaultMember).getAddress2();
        this.corporateName = member.orElseGet(() -> defaultMember).getCorporateName();
        this.corporateNumber = member.orElseGet(() -> defaultMember).getCorporateNumber();
        this.role = member.orElseGet(() -> defaultMember).getRole();
        this.createdDate = member.orElseGet(() -> defaultMember).getCreatedDate();
        this.modifiedDate = member.orElseGet(() -> defaultMember).getModifiedDate();
        return this;
    }

    /** 생성 메소드 param = List<MemberDto> **/
    public List<MemberDto> createMemberDtoList(List<Member> memberList){
        List<MemberDto> memberDtoList = new ArrayList<>();
        for(Member member : memberList){
            MemberDto memberDto = new MemberDto();
            memberDto.setMemberId(member.getMemberId());
            memberDto.setId(member.getId());
            memberDto.setPassword(member.getPassword());
            memberDto.setName(member.getName());
            memberDto.setBirth(member.getBirth());
            memberDto.setEmail(member.getEmail());
            memberDto.setPhone1(member.getPhone1());
            memberDto.setPhone2(member.getPhone2());
            memberDto.setAddress1(member.getAddress1());
            memberDto.setAddress2(member.getAddress2());
            memberDto.setCorporateName(member.getCorporateName());
            memberDto.setCorporateNumber(member.getCorporateNumber());
            memberDto.setRole(member.getRole());
            memberDto.setCreatedDate(member.getCreatedDate());
            memberDto.setModifiedDate(member.getModifiedDate());
            memberDtoList.add(memberDto);
        }
        return memberDtoList;
    }
}
