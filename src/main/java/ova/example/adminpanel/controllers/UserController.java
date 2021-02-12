package ova.example.adminpanel.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ova.example.adminpanel.models.User;
import ova.example.adminpanel.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping
    public List<User> getAllUser(){
        return userRepository.findAllUsers();
    }

    @GetMapping("/{id}")
    public Object getUserById(@PathVariable long id){
        return userRepository.findById(id);
    }
}
