package com.norway.norway.controller;

import com.norway.norway.dto.PopupDto;
import com.norway.norway.dto.PopupRegistrationForm;
import com.norway.norway.service.PopupService;
import com.norway.norway.util.ApiUtils;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/popup")
public class PopupController {

    private final PopupService popupService;

    @Operation(summary = "GET POPUP / RETURNS A ALL POPUP")
    @GetMapping("/all")
    public ResponseEntity<ApiUtils.ApiResult<List<PopupDto>>> getPopupList(){
        return ResponseEntity.ok(ApiUtils.success(popupService.getPopupList()));
    }

    @Operation(summary = "GET POPUP BY ID / RETURNS A SINGLE POPUP")
    @GetMapping("/{popupId}")
    public ResponseEntity<ApiUtils.ApiResult<PopupDto>> getPopupDetail(@PathVariable Long popupId){
        return ResponseEntity.ok(ApiUtils.success(popupService.getPopupDetail(popupId)));
    }

    @Operation(summary = "DELETE POPUP BY ID")
    @DeleteMapping("/{popupId}")
    public ResponseEntity<ApiUtils.ApiResult<Boolean>> deletePopup(@PathVariable Long popupId){
        return ResponseEntity.ok(ApiUtils.success(popupService.deletePopup(popupId)));
    }

    @Operation(summary = "SAVE ONE POPUP")
    @PostMapping("/{popupId}")
    public ResponseEntity<ApiUtils.ApiResult<Boolean>> savePopup(@RequestBody PopupRegistrationForm popupRegistrationForm){
        return ResponseEntity.ok(ApiUtils.success(popupService.savePopup(popupRegistrationForm)));
    }
}
