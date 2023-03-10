package com.norway.norway.dto;

import com.norway.norway.model.Popup;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PopupDto {

    private Long popupId;
    private String image;
    private String url;
    private String createdDate;
    private String modifiedDate;

    /** 생성 메소드 param = popup **/
    public PopupDto createPopupDto(Optional<Popup> popup){
        Popup defaultPopup = new Popup();
        this.popupId = popup.orElseGet(() -> defaultPopup).getPopupId();
        this.image = popup.orElseGet(() -> defaultPopup).getImage();
        this.url = popup.orElseGet(() -> defaultPopup).getUrl();
        this.createdDate = popup.orElseGet(() -> defaultPopup).getCreatedDate();
        this.modifiedDate = popup.orElseGet(() -> defaultPopup).getModifiedDate();
        return this;
    }

    /** 생성 메소드 param = popupList **/
    public List<PopupDto> createPopupDtoList(List<Popup> popupList){
        List<PopupDto> popupDtoList = new ArrayList<>();
        for(Popup popup : popupList){
            PopupDto popupDto = new PopupDto();
            popupDto.setPopupId(popup.getPopupId());
            popupDto.setImage(popupDto.getImage());
            popupDto.setUrl(popupDto.getUrl());
            popupDto.setCreatedDate(popup.getCreatedDate());
            popupDto.setModifiedDate(popup.getModifiedDate());
            popupDtoList.add(popupDto);
        }
        return popupDtoList;
    }

}
