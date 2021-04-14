package org.hyosung.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "err_board")
public class ErrBoard {

    @Id
    @GeneratedValue
    @Column(name = "board_id")
    private Long id;

    @Enumerated
    private GubunStatus gubunStatus; ////구분

    private String targetsw; //대상sw

    private String type; // 유형

    @Lob
    private String reqContent; // 요청내용

    private String requestor; // 요청자
    private String duty; //담당 (메카, 시스템)
    private String reqDept; //소속팀
    private LocalDateTime reqDate; //요청일

    private LocalDateTime comDate; //완료일
    private String administrator; //담당자

    @Lob
    private String cause; //원인

    @Lob
    private String comContent; //처리내역

}
