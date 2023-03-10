package com.norway.norway.service;

import com.norway.norway.dto.PopupDto;
import com.norway.norway.dto.PopupRegistrationForm;
import com.norway.norway.model.Popup;
import com.norway.norway.repository.PopupRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PopupService {
    
    private final PopupRepository popupRepository;

    /** 팝업 전체조회 **/
    public List<PopupDto> getPopupList(){
        return new PopupDto().createPopupDtoList(popupRepository.findAll());

    }

    /** 팝업 단건조회 **/
    public PopupDto getPopupDetail(Long popupId){
        return new PopupDto().createPopupDto(popupRepository.findById(popupId));
    }

    /** 팝업 삭제 **/
    @Transactional(readOnly = false)
    public Boolean deletePopup(Long popupId) {
        popupRepository.deleteById(popupId);
        return true;
    }

    /** 팝업 등록 **/
    @Transactional(readOnly = false)
    public Boolean savePopup(PopupRegistrationForm popupRegistrationForm){
        popupRepository.save(new Popup().createPopup(popupRegistrationForm));
        return true;
    }
}
