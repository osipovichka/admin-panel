package ova.example.adminpanel.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ova.example.adminpanel.DTO.UserDTO;
import ova.example.adminpanel.DTO.UserWithRolesDTO;
import ova.example.adminpanel.models.Role;
import ova.example.adminpanel.models.User;
import ova.example.adminpanel.repository.RoleRepository;
import ova.example.adminpanel.repository.UserRepository;
import ova.example.adminpanel.service.UserService;
import ova.example.adminpanel.utils.RolesEnum;

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
    public UserDTO createUser(UserDTO userDto) {
        User user = new User(userDto);
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findById(RolesEnum.USER.getValue()).orElseThrow());
        user.setRoles(roles);
        return UserDTO.fromModel(userRepository.saveAndFlush(user));
    }

    @Override
    public UserDTO updateUser(UserDTO userDetails) {
        User user = userRepository.findById(userDetails.getId()).orElseThrow();
        user.setFirstName(userDetails.getFirstName());
        user.setLastName(userDetails.getLastName());
        user.setPatronymic(userDetails.getPatronymic());
        user.setBirthDate(userDetails.getBirthDate());
        user.setEmail(userDetails.getEmail());
        user.setPhone(userDetails.getPhone());
        user.setCityId(userDetails.getCityId());
        userRepository.saveAndFlush(user);

        return UserDTO.fromModel(user);
    }

    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void addUserRole(long userId, long roleId) {
        User user = userRepository.findById(userId).orElseThrow();
        Set<Role> role = user.getRoles();
        role.add(roleRepository.findById(roleId).orElseThrow());
        user.setRoles(role);
        userRepository.saveAndFlush(user);
    }

    @Override
    public UserWithRolesDTO getUserWithRoles(long id) {
        User user = userRepository.findById(id).orElseThrow();
        return UserWithRolesDTO.fromModel(user);
    }
}
