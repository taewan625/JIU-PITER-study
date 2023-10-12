package com.jiupiter.jpa.entitiy;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

/**
 * @author: Lee Hyunseung
 * @date: 2023-09-15
 */
@Entity
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class AttendanceEvent extends BaseEntity {

    @Id
    @GeneratedValue
    @Column
    private UUID uid;

    private String eventDate;
    private String endDate;
    private int attendanceDays;
    private String eventName;
    private String eventDesc;
}
