package org.hyosung.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
@Table(name = "improveBoard")
public class ImproveBoard {

    @Id
    @GeneratedValue
    @Column(name = "board_id")
    private Long id;

    private String gubun; // 구분
    private String typename; // 유형
    private String category; // 항목

    @Lob
    private String improveContent; // 개선필요 항목

    @Lob
    private String cause; // 원인

    @Lob
    private String detail; // 상세내용

    @Lob
    private String memo; // 비고

    private String admin; // 담당자

    private String processing; // 진척률

}
