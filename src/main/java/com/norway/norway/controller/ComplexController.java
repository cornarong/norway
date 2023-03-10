package com.norway.norway.controller;

import com.norway.norway.dto.ComplexDto;
import com.norway.norway.dto.ComplexRegistrationForm;
import com.norway.norway.service.ComplexService;
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
@RequestMapping("/api/complex")
public class ComplexController {

    private final ComplexService complexService;

    @Operation(summary = "GET COMPLEX / RETURNS A ALL COMPLEX")
    @GetMapping("/all")
    public ResponseEntity<ApiUtils.ApiResult<List<ComplexDto>>> getComplexes(){
        return ResponseEntity.ok(ApiUtils.success(complexService.getComplexes()));
    }

    @Operation(summary = "GET COMPLEX BY ID / RETURNS A SINGLE COMPLEX")
    @GetMapping("/{complexId}")
    public ResponseEntity<ApiUtils.ApiResult<ComplexDto>> getComplexDetail(@PathVariable Long complexId){
        return ResponseEntity.ok(ApiUtils.success(complexService.getComplexDetail(complexId)));
    }

    @Operation(summary = "DELETE COMPLEX BY ID")
    @DeleteMapping("/{complexId}")
    public ResponseEntity<ApiUtils.ApiResult<Boolean>> deleteComplex(@PathVariable Long complexId){
        return ResponseEntity.ok(ApiUtils.success(complexService.deleteComplex(complexId)));
    }

    @Operation(summary = "SAVE ONE COMPLEX")
    @PostMapping("/{complexId}")
    public ResponseEntity<ApiUtils.ApiResult<Boolean>> saveComplex(@RequestBody ComplexRegistrationForm complexRegistrationForm){
        return ResponseEntity.ok(ApiUtils.success(complexService.saveComplex(complexRegistrationForm)));
    }
}
