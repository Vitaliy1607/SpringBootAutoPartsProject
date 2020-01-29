package com.autoparts.parts.service.impl;

import com.autoparts.parts.domain.UserDTO;
import com.autoparts.parts.entity.UserEntity;
import com.autoparts.parts.repository.UserRepository;
import com.autoparts.parts.service.UserService;
import com.autoparts.parts.utils.ObjectMapperUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ObjectMapperUtils modelMapper;

    @Override
    public void addUser(UserDTO user) {
        UserEntity userEntity = modelMapper.map(user, UserEntity.class);
            userRepository.save(userEntity);
    }

    @Override
    public List<UserDTO> findAllUsers() {
       return modelMapper.mapAll(userRepository.findAll(),UserDTO.class);
    }

    @Override
    public UserDTO findUserById(Long id) {
        boolean existById = userRepository.existsById(id);
        if (existById){
            UserEntity userEntity = userRepository.findById(id).get();

            UserDTO userDTO = new UserDTO();
            userDTO.setFirstName(userEntity.getFirstName()); // Convert Entity to DTO
            return userDTO;
        } else {
        return null;
        }
    }

    @Override
    public void updateUser(UserDTO userToUpdate) {
        boolean existByEmail = userRepository.existsByEmail(userToUpdate.getEmail());
        if (existByEmail){

            userRepository.save(DTOToEntityMapper(userToUpdate));

//            UserEntity userFromDB = userRepository.findById(id).get(;
//            userFromDB.setFirstName(userToUpdate.getFirstName());              // EXAMPLE WITHOUT MODELMAPPER
//            userFromDB.setLastName(userToUpdate.getLastName());
//            userFromDB.setEmail(userToUpdate.getEmail());
//            userRepository.save(userFromDB);
        }
    }

    @Override
    public UserEntity DTOToEntityMapper(UserDTO userDTO) {
        return modelMapper.map(userDTO, UserEntity.class);
    }
}
