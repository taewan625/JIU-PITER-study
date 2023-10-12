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
public class UserClass extends BaseEntity{

    @Id
    @GeneratedValue
    @Column
    private UUID uid;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "userId")
    private User userId;

    @ManyToOne(targetEntity = ClassManage.class)
    @JoinColumn(name = "classManageId")
    private ClassManage classManageId;


    private String startDate;
    private String endDate;

    @OneToOne(mappedBy = "userClassId")
    private UserClassState userClassId;

    @OneToMany(mappedBy = "userClassId")
    private List<UserAttendance> userAttendances;

    @OneToMany(mappedBy = "userClassId")
    private List<ClassExtension> classExtensions;
}
