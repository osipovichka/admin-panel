package ova.example.adminpanel.service;

import ova.example.adminpanel.DTO.UserDTO;
import ova.example.adminpanel.DTO.UserWithRolesDTO;

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
     * Обновить пользователя в БД.
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
     * Получить пользователя со списком его ролей по id.
     *
     * @param id пользователя.
     *
     * @return пользователя со списком его ролей.
     */
    public UserWithRolesDTO getUserWithRoles(long id);
}
