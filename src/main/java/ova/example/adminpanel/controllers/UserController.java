package ova.example.adminpanel.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ova.example.adminpanel.DTO.UserDTO;
import ova.example.adminpanel.DTO.UserWithRolesDTO;
import ova.example.adminpanel.service.impl.UserServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userServiceImpl;

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUser(){

        return ResponseEntity.ok(userServiceImpl.getAllUser());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable long id){
        return ResponseEntity.ok(userServiceImpl.getUserById(id));
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO user){
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
    public ResponseEntity deleteUser(@PathVariable long id){
        userServiceImpl.deleteUser(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/AddUser_Role/{userId}/{roleId}")
    public ResponseEntity addUserRole(@PathVariable long userId, @PathVariable long roleId){
        userServiceImpl.addUserRole(userId, roleId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/User_Roles/{id}")
    public ResponseEntity<UserWithRolesDTO> getUserWithRoles(@PathVariable long id){
        if(id == 0){
            ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(userServiceImpl.getUserWithRoles(id));
    }
}
