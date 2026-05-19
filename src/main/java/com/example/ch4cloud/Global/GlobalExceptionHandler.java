package com.example.ch4cloud.Global;

import com.example.ch4cloud.Member.Dto.Response.CommonResponse;
import com.example.ch4cloud.exception.ServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<CommonResponse<Void>> handleServiceException(ServiceException ex) {
        return CommonResponse.fail(ex.getStatus(), ex.getMessage()).toResponseEntity();
    }
}
