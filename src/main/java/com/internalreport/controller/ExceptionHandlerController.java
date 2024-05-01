package com.internalreport.controller;

import com.internalreport.model.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<BaseResponse<String>> constraintViolation(RuntimeException exception) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                BaseResponse.<String>builder().error(exception.getMessage()).status(HttpStatus.INTERNAL_SERVER_ERROR.value()).build()
        );
    }
}
