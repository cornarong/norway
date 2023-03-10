package com.norway.norway.errors;

import com.norway.norway.util.ApiUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static com.norway.norway.util.ApiUtils.error;

@ControllerAdvice
public class GeneralExceptionHandler {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private ResponseEntity<ApiUtils.ApiResult<?>> newResponse(Throwable throwable, HttpStatus status) {
        ErrorCode errCode = ErrorCode.FAILED;
        return newResponse(throwable, status, errCode);
    }

    private ResponseEntity<ApiUtils.ApiResult<?>> newResponse(ErrorCode errCode, HttpStatus status) {
        return newResponse(errCode.getCode(), errCode.getErrorMsg(), status.value());
    }

    private ResponseEntity<ApiUtils.ApiResult<?>> newResponse(String errCode, String errMessage, int status) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        return new ResponseEntity<>(error(errCode, errMessage), headers, status);
    }

    private ResponseEntity<ApiUtils.ApiResult<?>> newResponse(Throwable throwable, HttpStatus status, ErrorCode errCode) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        return new ResponseEntity<>(error(errCode.getCode(), errCode.getErrorMsg()), headers, status);
    }

    @ExceptionHandler(value = CommonException.class)
    protected ResponseEntity<?> commonExceptionHandler(CommonException ce) {
        ErrorCode errorCode = ce.getErrorCode();
        log.error("Common exception occurred: [{}]", ce.getErrorDetailMsg());
        return newResponse(errorCode, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = { Exception.class, RuntimeException.class })
    protected  ResponseEntity<?> unexpectedExceptionHandler(Exception e) {
        log.error("Unexpected exception occurred: [{}]", e.getMessage(), e);
        return newResponse(e, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<?> validationExceptionHandler(MethodArgumentNotValidException ex){
        return newResponse(ex, HttpStatus.BAD_REQUEST);
    }

}