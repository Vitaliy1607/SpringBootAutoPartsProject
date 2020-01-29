package com.autoparts.parts.service;

import com.autoparts.parts.domain.UserDTO;
import com.autoparts.parts.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    void addUser(UserDTO user);

    List<UserDTO> findAllUsers();

    UserDTO findUserById(Long id);

    void updateUser(UserDTO userBeforeUpdate);

    UserEntity DTOToEntityMapper(UserDTO userDTO);
}
