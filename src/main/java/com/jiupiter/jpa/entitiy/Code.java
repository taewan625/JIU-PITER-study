package com.jiupiter.jpa.entitiy;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author: Lee Hyunseung
 * @date: 2023-09-14
 */

@Entity
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class Code extends BaseEntity{

    @Id
    @Column(columnDefinition = "VARCHAR(20)", length = 20, nullable = false)
    private String code;

    @Column(columnDefinition = "VARCHAR(50)", length = 50, nullable = false)
    private String codeName;

    @Column(columnDefinition = "VARCHAR(50)", length = 50, nullable = false)
    private String codeType;

    @Column(columnDefinition = "INT DEFAULT 1")
    private int codeLevel;

    @Column(columnDefinition = "INT DEFAULT 1")
    private String codeOrder;

    @Column(columnDefinition = "VARCHAR(200)", length=200)
    private String codeDesc;

    @Column(columnDefinition = "BOOLEAN DEFAULT true")
    private boolean valid;


    @OneToMany(mappedBy = "userType")
    private List<User> user;

    @OneToMany(mappedBy = "code")
    private List<UserGrade> userGrades;

    @OneToMany(mappedBy = "beltType")
    private List<LevelUpDate> levelUpDates;
}
