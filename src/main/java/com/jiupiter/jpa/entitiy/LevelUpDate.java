package com.jiupiter.jpa.entitiy;

import jakarta.persistence.*;
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
public class LevelUpDate extends BaseEntity {

    @Id
    @GeneratedValue
    @Column
    private UUID uid;

    @ManyToOne(targetEntity = Code.class)
    @JoinColumn(name = "beltType")
    private Code beltType;

    private boolean adult;
    private int goalDays;
}
