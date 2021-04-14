package org.hyosung.controller;

import lombok.Getter;
import lombok.Setter;
import org.hyosung.domain.GubunStatus;

@Setter
@Getter
public class ErrBoardForm {

    private Long id;
    private GubunStatus gubunStatus; //구분
    private String targetsw; //대상sw
    private String reqContent; // 요청내용

    private String requestor; // 요청자
    private String administrator; //담당자

    private String cause; //원인
    private String comContent; //처리내역
}
