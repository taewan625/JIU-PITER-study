package com.jiupiter.jpa.entitiy;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

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
public class UserGrade extends BaseEntity{

    @Id
    @GeneratedValue
    @Column
    private UUID uid;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "userId")
    private User userId;

    @ManyToOne(targetEntity = Code.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "code", nullable = false)
    private Code code;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(columnDefinition = "DATE", nullable = false)
    private String levelUpDate;
}
