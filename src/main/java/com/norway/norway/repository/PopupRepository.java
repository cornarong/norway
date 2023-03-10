package com.norway.norway.repository;

import com.norway.norway.model.Popup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PopupRepository extends JpaRepository<Popup, Long> {

    /** 팝업 전체조회 **/
    List<Popup> findAll();

    /** 팝업 단건조회 **/
    Optional<Popup> findById(Long popupId);
}
