package org.hyosung.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Setter @Getter
@Table(name = "hmember")
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String sabun;
    private String name;
    private LocalDateTime regdate;
}
