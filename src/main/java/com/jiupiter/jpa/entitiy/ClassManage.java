package com.jiupiter.jpa.entitiy;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

/**
 * @author: Lee Hyunseung
 * @date: 2023-09-15
 */
@Entity
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class ClassManage extends BaseEntity{

    @Id
    @GeneratedValue
    @Column
    private UUID uid;

    private String classType;
    private String className;
    private int fixedTerm;
    private int coupon;
    private double price;
    private boolean valid;



    @OneToMany(mappedBy = "classManageId")
    private List<UserClass> userClasses;
}
