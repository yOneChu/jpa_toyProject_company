package org.hyosung.controller;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ImproveForm {

    private Long id;
    private String gubun; // 구분
    private String typename; // 유형
    private String category; // 항목
    private String improveContent; // 개선필요 항목

    private String cause; // 원인
    private String detail; // 상세내용
    private String memo; // 비고
}
