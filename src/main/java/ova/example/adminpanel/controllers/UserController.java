package ova.example.adminpanel.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ova.example.adminpanel.DTO.UserDTO;
import ova.example.adminpanel.models.Role;
import ova.example.adminpanel.models.User;
import ova.example.adminpanel.repository.RoleRepository;
import ova.example.adminpanel.repository.UserRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    /**
     * Возвращает список всех пользователей
     * @return List<User>
     */
    @GetMapping
    public List<UserDTO> getAllUser(){
        List<UserDTO> lUserDto = new ArrayList<>();
        for (User us: userRepository.findAll()) {
            lUserDto.add(UserDTO.fromModel(us));
        }
        return lUserDto;
    }

    /**
     * Возвращает пользователя по id
     * @return User
     */
    @GetMapping("/{id}")
    public User getUserById(@PathVariable long id){
        return userRepository.findById(id).orElseThrow();
    }

    /**
     * Записывает пользователя в БД
     */
    @PostMapping
    public void createUser(@RequestBody User user){
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findById(1L).orElseThrow());
        user.setRoles(roles);
        userRepository.saveAndFlush(user);
    }

    /**
     * Изменить пользователя в БД
     * @return User
     */
    @PutMapping
    public ResponseEntity<UserDTO> updateUser(@RequestBody User userDetails){
        if(userDetails.getId() == 0){
            ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }

        Set<Role> roles = new HashSet<>();
        for (Role r: userRepository.findById(userDetails.getId()).orElseThrow().getRoles()) {
            roles.add(r);
            userDetails.setRoles(roles);
        }
        userRepository.saveAndFlush(userDetails);
        return ResponseEntity.ok(UserDTO.fromModel(userDetails));
    }

    /**
     * Удаление пользователя из БД
     */
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable long id){
        userRepository.deleteById(id);
    }
}
