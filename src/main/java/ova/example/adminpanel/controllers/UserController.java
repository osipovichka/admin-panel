package ova.example.adminpanel.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ova.example.adminpanel.models.Role;
import ova.example.adminpanel.models.User;
import ova.example.adminpanel.repository.RoleRepository;
import ova.example.adminpanel.repository.UserRepository;

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
    public List<User> getAllUser(){
        return userRepository.findAll();
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
        roles.add(roleRepository.findById((long)1).orElseThrow());
        user.setRoles(roles);
        userRepository.saveAndFlush(user);
    }

    /**
     * Изменить пользователя в БД
     * @return User
     */
    // TODO: 31.03.2021 проверить наличие id у usera, протестить без перечисления полей
    @PutMapping
    public User updateUser(@RequestBody User userDetails){
//        User user = userRepository.findById(userDetails.getId()).orElseThrow();
//
//        user.setFirstName(userDetails.getFirstName());
//        user.setLastName(userDetails.getLastName());
//        user.setPatronymic(userDetails.getPatronymic());
//        user.setBirthDate(userDetails.getBirthDate());
//        user.setEmail(userDetails.getEmail());
//        user.setPhone(userDetails.getPhone());
//        user.setPassword(userDetails.getPassword());
//        user.setCityId(user.getCityId());

        User updateUser = userRepository.saveAndFlush(userDetails);

        return updateUser;
    }

    /**
     * Удаление пользователя из БД
     */
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable long id){
        userRepository.deleteById(id);
    }
}
