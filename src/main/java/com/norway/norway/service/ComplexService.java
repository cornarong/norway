package com.norway.norway.service;

import com.norway.norway.dto.ComplexDto;
import com.norway.norway.dto.ComplexRegistrationForm;
import com.norway.norway.model.Complex;
import com.norway.norway.repository.ComplexRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ComplexService {

    private final ComplexRepository complexRepository;

    /** 단지 전체조회 **/
    public List<ComplexDto> getComplexes(){
        return new ComplexDto().createComplexDtoList(complexRepository.findAll());

    }

    /** 단지 단건조회 **/
    public ComplexDto getComplexDetail(Long complexId){
        return new ComplexDto().createComplexDto(complexRepository.findById(complexId));
    }

    /** 단지 삭제 **/
    @Transactional(readOnly = false)
    public Boolean deleteComplex(Long complexId) {
        complexRepository.deleteById(complexId);
        return true;
    }

    /** 단지 등록 **/
    @Transactional(readOnly = false)
    public Boolean saveComplex(ComplexRegistrationForm complexRegistrationForm){
        complexRepository.save(new Complex().createRegistrationComplex(complexRegistrationForm));
        return true;
    }
}
