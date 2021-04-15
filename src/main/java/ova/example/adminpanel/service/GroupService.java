package ova.example.adminpanel.service;

import ova.example.adminpanel.DTO.GroupDTO;

import java.util.List;

public interface GroupService {
    /**
     * Получить список всех групп.
     *
     * @return List<GroupDTO>
     */
    List<GroupDTO> getAllGroup();

    /**
     * Получить группу по id.
     *
     * @param id пользователя.
     *
     * @return группа.
     */
    GroupDTO getGroupById(long id);

    /**
     * Записать новую группу в БД.
     *
     * @param groupDTO пользователь.
     *
     * @return созданная группа.
     */
    GroupDTO createGroup(GroupDTO groupDTO);

    /**
     * Обновить группу в БД.
     *
     * @param groupDetails пользователь с изменениями.
     *
     * @return обновленная группа.
     */
    GroupDTO updateGroup(GroupDTO groupDetails);

    /**
     * Удалить группу из БД
     */
    void deleteGroup(long id);
}
