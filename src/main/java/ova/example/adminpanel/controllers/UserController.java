package ova.example.adminpanel.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ova.example.adminpanel.DTO.UserDTO;
import ova.example.adminpanel.models.User;
import ova.example.adminpanel.service.impl.UserServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userServiceImpl;

    @GetMapping
    public List<UserDTO> getAllUser(){

        return userServiceImpl.getAllUser();
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable long id){
        return userServiceImpl.getUserById(id);
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody User user){
        return ResponseEntity.ok(userServiceImpl.createUser(user));
    }

    @PutMapping
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDetails){
        if(userDetails.getId() == 0){
            ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(userServiceImpl.updateUser(userDetails));
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable long id){
        userServiceImpl.deleteUser(id);
    }

    @PostMapping("/AddUser_Role/{userId}/{roleId}")
    public void addUserRole(@PathVariable long userId, @PathVariable long roleId){
        userServiceImpl.addUserRole(userId, roleId);
    }
}
