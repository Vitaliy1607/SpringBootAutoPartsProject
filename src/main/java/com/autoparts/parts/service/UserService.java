package com.autoparts.parts.service;

import com.autoparts.parts.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    void addUser(UserEntity user);

    List<UserEntity> findAllUsers();

    UserEntity findUserById(Long id);

    UserEntity updateUser(Long id, UserEntity userBeforeUpdate);
}
