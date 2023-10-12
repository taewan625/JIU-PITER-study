package com.jiupiter.jpa.entitiy;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.List;
import java.util.UUID;

/**
 * @author: Lee Hyunseung
 * @date: 2023-09-14
 */

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class User {

    @Id
    @GeneratedValue
    @Column
    private UUID uid;

    @Column(columnDefinition = "VARCHAR(50)", length = 50, nullable = false, unique = true)
    private String userId;

    @Column(columnDefinition = "VARCHAR(200)", length = 200)
    private String password;

    @ManyToOne(targetEntity = Code.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "userType", nullable = false)
    private Code userType;


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(columnDefinition = "DATE", nullable = false)
    private String birthday;

    @Column(columnDefinition = "VARCHAR(15)")
    private String phone;

    @Column(columnDefinition = "VARCHAR(4)", nullable = false, unique = true)
    private String attendNum;

    @Column(columnDefinition = "CHAR", nullable = false)
    private char gender;

    @Column(columnDefinition = "CHAR DEFAULT 'Y'", nullable = false)
    private char status;

    @CreationTimestamp
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(columnDefinition = "DATE", nullable = false)
    private String joinDate;

    @Column
    private UUID updUser;

    @UpdateTimestamp
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(columnDefinition = "DATETIME")
    private String updDtm;


    @OneToMany(mappedBy = "userId")
    private List<UserGrade> userGrades;

    @OneToMany(mappedBy = "userId")
    private List<UserClassState> userClassStates;

    @OneToMany(mappedBy = "userId")
    private List<UserClass> userClasses;

    @OneToMany(mappedBy = "userId")
    private List<UserAttendance> userAttendances;

    @OneToMany(mappedBy = "userId")
    private List<ClassExtension> classExtensions;


}
