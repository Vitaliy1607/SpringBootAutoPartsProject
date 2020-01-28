package com.autoparts.parts.controller;

import com.autoparts.parts.entity.UserEntity;
import com.autoparts.parts.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserEntity user){
        System.out.println("User " + user.getFirstName() + " " +
                user.getLastName() + " " +
                user.getEmail() + " was created");

        userService.addUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserEntity>> getAllUsers(){
        List<UserEntity> userList = userService.findAllUsers();

        return new ResponseEntity<>(userList, HttpStatus.OK);
     }

     @PutMapping("{userId}")
     public ResponseEntity<?> updateUser(
             @PathVariable("userId") Long id,
             @RequestBody UserEntity userToUpdate){
         UserEntity userEntity = userService.updateUser(id, userToUpdate);
        if (userToUpdate == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
            return new ResponseEntity<>(userEntity, HttpStatus.OK);

     }

}
