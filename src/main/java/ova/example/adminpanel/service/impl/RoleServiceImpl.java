package ova.example.adminpanel.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ova.example.adminpanel.models.Role;
import ova.example.adminpanel.models.User;
import ova.example.adminpanel.repository.RoleRepository;
import ova.example.adminpanel.repository.UserRepository;
import ova.example.adminpanel.service.RoleService;
import ova.example.adminpanel.exception.RoleException;
import ova.example.adminpanel.utils.RolesEnum;

import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    @Override
    public void addUserRole(long userId, long roleId) {
        Optional<Role> opRole = roleRepository.findById(roleId);
        if (opRole.isEmpty()){
            log.info("Роль с id - {} не найдены в БД", roleId);
        }
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()){
            log.info("Пользователь с id - {} не найдены в БД", userId);
        }
        User user = optionalUser.get();
        Set<Role> role = user.getRoles();
        role.add(opRole.get());
        user.setRoles(role);
        userRepository.saveAndFlush(user);
    }

    @Override
    public void deleteUserRole(long userId, long roleId) {
        Optional<User> opUser = userRepository.findById(userId);
        if(opUser.isEmpty()){
            log.info("Пользователь с id - {} не найдены в БД", userId);
        }
        User user = opUser.get();

        Optional<Role> opRole = roleRepository.findById(roleId);
        if(opRole.isEmpty()){
            log.info("Роль с id - {} не найдены в БД", roleId);
        }
        Role role = opRole.get();

        Set<Role> roles = user.getRoles();
        if(!roles.remove(role)){
            log.info("Роль с id - {} у пользователя не найдена", roleId);
        }
        user.setRoles(roles);
        userRepository.saveAndFlush(user);
    }
}
