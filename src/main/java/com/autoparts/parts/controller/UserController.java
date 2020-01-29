package com.autoparts.parts.controller;

import com.autoparts.parts.domain.UserDTO;
import com.autoparts.parts.entity.UserEntity;
import com.autoparts.parts.service.UserService;
import com.autoparts.parts.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> createUser(@Valid @RequestBody UserDTO user){
        System.out.println("User " + user.getFirstName() + " " +
                user.getLastName() + " " +
                user.getEmail() + " was created");

        userService.addUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers(){

        return new ResponseEntity<>(userService.findAllUsers(), HttpStatus.OK);
     }

     @GetMapping("{userId}")
     public ResponseEntity<?> getUserById(@PathVariable("userId") Long id){
        UserDTO userDTO = userService.findUserById(id);

        if (userDTO == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
     }

     @PutMapping("{email}")
     public ResponseEntity<?> updateUser(
             @PathVariable("email") String email,
             @RequestBody UserDTO userToUpdate){
         userService.updateUser(userToUpdate);

        if (userToUpdate == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
            return new ResponseEntity<>(HttpStatus.OK);

     }

}
