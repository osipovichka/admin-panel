package ova.example.adminpanel.service;

import ova.example.adminpanel.DTO.UserDTO;
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
     * @param user пользователь.
     *
     * @return пользователь.
     */
    UserDTO createUser(User user);

    /**
     * Записать пользователя в БД.
     *
     * @param userDetails пользователь с изменениями.
     *
     * @return пользователь.
     */
    UserDTO updateUser(User userDetails);

    /**
     * Удаление пользователя из БД
     */
    void deleteUser(long id);
}
