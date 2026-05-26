package com.example.ch4cloud.exception;

import org.springframework.http.HttpStatus;

public class FileUploadFailException extends ServiceException {
    public FileUploadFailException() {
        super(HttpStatus.INTERNAL_SERVER_ERROR, "파일 업로드에 실패했습니다");
    }
}
