package com.norway.norway.model;

import com.norway.norway.dto.PopupRegistrationForm;
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
public class Popup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long popupId;

    private String image;
    private String url;
    private String createdDate;
    private String modifiedDate;

    /** 생성 메소드 param = popupRegistrationForm **/
    public Popup createPopup(PopupRegistrationForm popupRegistrationForm){
        this.image = popupRegistrationForm.getImage();
        this.url = popupRegistrationForm.getUrl();
        return null;
    }
}
