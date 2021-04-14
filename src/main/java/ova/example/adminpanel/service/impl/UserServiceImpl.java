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

import java.util.*;

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
        UserDTO userDTO = null;
        try {
            userDTO = UserDTO.fromModel(userRepository.findById(id).orElseThrow());
        }catch (NoSuchElementException e){
            log.error("Пользователь не найден в БД {}", e.getMessage(), e);
        }
        return userDTO;
    }

    @Override
    public UserDTO createUser(UserDTO userDto) {
        User user = new User(userDto);
        UserDTO userDTO = null;
        try {
            Set<Role> roles = new HashSet<>();
            roles.add(roleRepository.findById(RolesEnum.USER.getValue()).orElseThrow());
            user.setRoles(roles);
            userDTO = UserDTO.fromModel(userRepository.saveAndFlush(user));

        } catch (NoSuchElementException e){
            log.error("В БД нет данной роли {}", e.getMessage(), e);
        }catch (Exception e){
            log.error("Пользователь не записан в БД {}", e.getMessage(), e);
        }
        return userDTO;
    }

    @Override
    public UserDTO updateUser(UserDTO userDetails) {
        User user = null;
        try {
            user = userRepository.findById(userDetails.getId()).orElseThrow();
            user.setFirstName(userDetails.getFirstName());
            user.setLastName(userDetails.getLastName());
            user.setPatronymic(userDetails.getPatronymic());
            user.setBirthDate(userDetails.getBirthDate());
            user.setEmail(userDetails.getEmail());
            user.setPhone(userDetails.getPhone());
            user.setCityId(userDetails.getCityId());
            userRepository.saveAndFlush(user);
        } catch (NoSuchElementException e){
            log.error("Пользователь не найден в БД {}", e.getMessage(), e);
        } catch (Exception e){
            log.error("Пользователь не обновлен в БД {}", e.getMessage(), e);
        }
        return UserDTO.fromModel(user);
    }

    @Override
    public void deleteUser(long id) {
         try {
             userRepository.deleteById(id);
         }catch (Exception e){
             log.error("Невозможно удалить пользователя {}", e.getMessage(), e);
         }
    }

    @Override
    public void addUserRole(long userId, long roleId) {
        try {
            User user = userRepository.findById(userId).orElseThrow();
            Set<Role> role = user.getRoles();
            role.add(roleRepository.findById(roleId).orElseThrow());
            user.setRoles(role);
            userRepository.saveAndFlush(user);
        } catch (NoSuchElementException e){
            log.error("Пользователь или роль не найдены в БД {}", e.getMessage(), e);
        } catch (Exception e){
            log.error("Пользователь не обновлен в БД {}", e.getMessage(), e);
        }

    }

    @Override
    public UserWithRolesDTO getUserWithRoles(long id) {
        User user = null;
        try {
            user = userRepository.findById(id).orElseThrow();
        } catch (NoSuchElementException e){
            log.error("Пользователь не найден в БД {}", e.getMessage(), e);
        }
        return UserWithRolesDTO.fromModel(user);
    }
}
