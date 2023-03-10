package com.norway.norway.model;

import com.norway.norway.dto.MemberRegistrationForm;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    /** 생성 메소드 param = MemberRegistrationForm **/
    public Member createRegistrationMember(MemberRegistrationForm memberRegistrationForm) {
        this.id = memberRegistrationForm.getId();
        this.password = memberRegistrationForm.getPassword();
        this.name = memberRegistrationForm.getName();
        this.birth = memberRegistrationForm.getBirth();
        this.email = memberRegistrationForm.getEmail();
        this.phone1 = memberRegistrationForm.getPhone();
        this.corporateName = memberRegistrationForm.getCorporateName();
        this.corporateNumber = memberRegistrationForm.getCorporateNumber();
        return this;
    }
}
