package com.autoparts.parts.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {

    @Column(name = "first_name",nullable = false, length = 75)
    private String firstName;

    @Column(name = "last_name",nullable = false, length = 75)
    private String lastName;

    @Column(name = "telephone_number", length = 10)
    private Long telephoneNumber;

    @Column(nullable = false, unique = true , length = 150)
    private String email;

    @Column(unique = true, length = 40)
    private String login;


    private String password;
}
