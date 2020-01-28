package com.autoparts.parts.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "parts")
public class PartEntity extends BaseEntity {

    @Column(name = "part_name",nullable = false, length = 50)
    private String partName;

    @Column(nullable = false, length = 25)
    private String condition;   //show this detail was used or new

    @Column(nullable = false, columnDefinition = "DECIMAL(5,2) DEFAULT 0")
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;
}
