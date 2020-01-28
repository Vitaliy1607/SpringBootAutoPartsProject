package com.autoparts.parts.service.impl;

import com.autoparts.parts.entity.UserEntity;
import com.autoparts.parts.repository.UserRepository;
import com.autoparts.parts.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void addUser(UserEntity user) {
            userRepository.save(user);
    }

    @Override
    public List<UserEntity> findAllUsers() {
        List<UserEntity> users = userRepository.findAll();
        return users;
    }

    @Override
    public UserEntity findUserById(Long id) {
        boolean existById = userRepository.existsById(id);
        if (existById){
            UserEntity user = userRepository.findById(id).get();
            return user;
        } else {
        return null;
        }
    }

    @Override
    public UserEntity updateUser(Long id, UserEntity userToUpdate) {
        boolean existById = userRepository.existsById(id);
        if (existById){
            UserEntity userFromDB = userRepository.findById(id).get();
            userFromDB.setFirstName(userToUpdate.getFirstName());
            userFromDB.setLastName(userToUpdate.getLastName());
            userFromDB.setEmail(userToUpdate.getEmail());
            userRepository.save(userFromDB);
        }
        return null;
    }
}
