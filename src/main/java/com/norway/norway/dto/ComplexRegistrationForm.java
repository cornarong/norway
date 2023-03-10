package com.norway.norway.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComplexRegistrationForm {

    private Long complexId;
    private String name;
    private String url; // 해당 단지 분양 페이지 URL
    private String status; // UPCOMING : 분양예정 / ONGOING : 분양중 / BUILD : 공사중 / COMPLETED : 분양완료
    private int rate; // 계산식 : (납부금액)x(할인율/연체율)÷365x(일수)
    private String mainImage; // 사용자 프로젝트 목록에 노출할 대표 이미지 등록(1개) ,jpg, png
    private String illustImage; // 사용자 프로젝트 상세의 상단에 노출할 일러스트 등록 (1개) 확장자: ,jpg, png 사이즈: 1920*428
    private String visitAbleDate; // 관리자 - 사전방문등록 페이지에서 insert (초기값 null)
    private String moveInAbleDate; // 관리자 - 입주예약등록 페이지에서 insert (초기값 null)
    private String successionAbleDate; // 관리자 - 권리의무승계예약등록 페이지에서 insert (초기값 null)
    private String paymentInterestCondition;
    private String paymentFinancialCompany;
    private String paymentInterestRate;
    private String settlementDate;
    private String createdDate;
    private String modifiedDate;

}
