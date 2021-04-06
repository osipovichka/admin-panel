package ova.example.adminpanel.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import ova.example.adminpanel.DTO.UserDTO;
import ova.example.adminpanel.DTO.UserWithRolesDTO;
import ova.example.adminpanel.models.User;

import java.util.List;

public interface UserService {

    /**
     * Получить список всех пользователей.
     *
     * @return List<UserDTO>
     */
    List<UserDTO> getAllUser();

    /**
     * Получить пользователя по id.
     *
     * @param id пользователя.
     *
     * @return пользователь.
     */
    UserDTO getUserById(Long id);

    /**
     * Записать пользователя в БД.
     *
     * @param userDto пользователь.
     *
     * @return пользователь.
     */
    UserDTO createUser(UserDTO userDto);

    /**
     * Записать пользователя в БД.
     *
     * @param userDetails пользователь с изменениями.
     *
     * @return пользователь.
     */
    UserDTO updateUser(UserDTO userDetails);

    /**
     * Удаление пользователя из БД
     */
    void deleteUser(long id);

    /**
     * Добавить пользователю роль.
     *
     * @param userId roleId пользователь с изменениями.
     */
    public void addUserRole(long userId, long roleId);

    /**
     * Получить пользователя со списком его ролей по id.
     *
     * @param id пользователя.
     *
     * @return пользователя со списком его ролей.
     */
    public UserWithRolesDTO getUserWithRoles(@PathVariable long id);
}
