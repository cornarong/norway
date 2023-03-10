package com.norway.norway.dto;

import com.norway.norway.model.Complex;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComplexDto {

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


    /** 생성 메소드 param = List<Complex> **/
    public List<ComplexDto> createComplexDtoList(List<Complex> complexList){
        List<ComplexDto> complexDtoList = new ArrayList<>();
        for(Complex complex : complexList){
            ComplexDto complexDto = new ComplexDto();
            complexDto.setComplexId(complex.getComplexId());
            complexDto.setName(complex.getName());
            complexDto.setUrl(complex.getUrl());
            complexDto.setStatus(complex.getStatus());
            complexDto.setRate(complex.getRate());
            complexDto.setMainImage(complex.getMainImage());
            complexDto.setIllustImage(complex.getIllustImage());
            complexDto.setVisitAbleDate(complex.getVisitAbleDate());
            complexDto.setMoveInAbleDate(complex.getMoveInAbleDate());
            complexDto.setSuccessionAbleDate(complex.getSuccessionAbleDate());
            complexDto.setPaymentInterestCondition(complex.getPaymentInterestCondition());
            complexDto.setPaymentFinancialCompany(complex.getPaymentFinancialCompany());
            complexDto.setPaymentInterestRate(complex.getPaymentInterestRate());
            complexDto.setSettlementDate(complex.getSettlementDate());
            complexDto.setCreatedDate(complex.getCreatedDate());
            complexDto.setModifiedDate(complex.getModifiedDate());
            complexDtoList.add(complexDto);
        }
        return complexDtoList;
    }

    /** 생성 메소드 param = complex **/
    public ComplexDto createComplexDto(Optional<Complex> complex){
        Complex defaultComplex = new Complex();
        this.complexId = complex.orElseGet(() -> defaultComplex).getComplexId();
        this.name = complex.orElseGet(() -> defaultComplex).getName();
        this.url = complex.orElseGet(() -> defaultComplex).getUrl();
        this.status = complex.orElseGet(() -> defaultComplex).getStatus();
        this.rate = complex.orElseGet(() -> defaultComplex).getRate();
        this.mainImage = complex.orElseGet(() -> defaultComplex).getMainImage();
        this.illustImage = complex.orElseGet(() -> defaultComplex).getIllustImage();
        this.visitAbleDate = complex.orElseGet(() -> defaultComplex).getVisitAbleDate();
        this.moveInAbleDate = complex.orElseGet(() -> defaultComplex).getMoveInAbleDate();
        this.successionAbleDate = complex.orElseGet(() -> defaultComplex).getSuccessionAbleDate();
        this.paymentInterestCondition = complex.orElseGet(() -> defaultComplex).getPaymentInterestCondition();
        this.paymentFinancialCompany = complex.orElseGet(() -> defaultComplex).getPaymentFinancialCompany();
        this.paymentInterestRate = complex.orElseGet(() -> defaultComplex).getPaymentInterestRate();
        this.settlementDate = complex.orElseGet(() -> defaultComplex).getSettlementDate();
        this.createdDate = complex.orElseGet(() -> defaultComplex).getCreatedDate();
        this.modifiedDate = complex.orElseGet(() -> defaultComplex).getModifiedDate();
        return this;
    }
}
