package com.jiupiter.jpa.entitiy;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.UUID;

/**
 * @author: Lee Hyunseung
 * @date: 2023-09-14
 */

@Getter
@Setter
@MappedSuperclass
public class BaseEntity {

    @Column
    private UUID regUser;

    @CreationTimestamp
    @Column(columnDefinition = "DATETIME")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String regDtm;

    @Column
    private UUID updUser;

    @UpdateTimestamp
    @Column(columnDefinition = "DATETIME")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String updDtm;
}
