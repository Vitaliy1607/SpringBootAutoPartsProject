package com.autoparts.parts.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.Email;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long id;

    @Column(name = "first_name",nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name",nullable = false, length = 50)
    private String lastName;

    @Column(name = "telephone_number", length = 10)
    private Long telephoneNumber;

    @Column(nullable = false, unique = true , length = 150)
    @Email
    private String email;

    @Column(nullable = false)
    private String sexType;

    private String password;
    private String passwordConfirm;
}
