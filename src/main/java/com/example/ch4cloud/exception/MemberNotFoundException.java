package com.example.ch4cloud.exception;

import org.springframework.http.HttpStatus;

public class MemberNotFoundException extends ServiceException{
    public MemberNotFoundException() { super(HttpStatus.NOT_FOUND, "멤버를 찾을 수 없습니다"); }
}
