package com.jiupiter.jpa.entitiy;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.UUID;

/**
 * @author: Lee Hyunseung
 * @date: 2023-09-15
 */

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class ClassExtension {

    @Id
    @GeneratedValue
    @Column
    private UUID uid;


    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "userId")
    private User userId;

    @ManyToOne(targetEntity = UserClass.class)
    @JoinColumn(name = "userClassId")
    private UserClass userClassId;

    private int extensionDays;

    @Column
    private UUID regUser;

    @CreationTimestamp
    @Column(columnDefinition = "DATETIME")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String regDtm;
}
