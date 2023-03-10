package com.norway.norway.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberRegistrationForm {

    private String id;
    private String password;
    private String name;
    private String birth;
    private String email;
    private String phone;
    private String corporateName;
    private String corporateNumber;
    private String term1;
    private String term2;
    private String term3;

}
