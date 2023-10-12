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
@EqualsAndHashCode
public class UserAttendance {

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

    private String attendanceDate;
}
