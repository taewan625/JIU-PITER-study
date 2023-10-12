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
public class UserClassState extends BaseEntity {

    @Id
    @GeneratedValue
    @Column
    private UUID uid;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "userId")
    private User userId;

    @OneToOne(targetEntity = UserClass.class)
    @JoinColumn(name = "userClassId")
    private UserClass userClassId;


    private String holdDate;
    private String endDate;
    private String reason;
    private String terminationDate;
    private boolean valid;

}
