package ova.example.adminpanel.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ova.example.adminpanel.DTO.UserDTO;
import ova.example.adminpanel.models.Role;
import ova.example.adminpanel.models.User;
import ova.example.adminpanel.repository.RoleRepository;
import ova.example.adminpanel.repository.UserRepository;
import ova.example.adminpanel.service.UserService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public List<UserDTO> getAllUser() {
        List<UserDTO> lUserDto = new ArrayList<>();
        for (User us: userRepository.findAll()) {
            lUserDto.add(UserDTO.fromModel(us));
        }
        return lUserDto;
    }

    @Override
    public UserDTO getUserById(Long id) {
        return UserDTO.fromModel(userRepository.findById(id).orElseThrow());
    }

    @Override
    public UserDTO createUser(User user) {
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findById(1L).orElseThrow());
        user.setRoles(roles);
        return UserDTO.fromModel(userRepository.saveAndFlush(user));
    }

    @Override
    public UserDTO updateUser(User userDetails) {
        if(userDetails.getId() == 0){
            ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }

        Set<Role> roles = new HashSet<>();
        for (Role r: userRepository.findById(userDetails.getId()).orElseThrow().getRoles()) {
            roles.add(r);
            userDetails.setRoles(roles);
        }
        userRepository.saveAndFlush(userDetails);
        return UserDTO.fromModel(userDetails);
    }

    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }
}
