package ova.example.adminpanel.service;

import ova.example.adminpanel.DTO.NewDTO;

import java.util.List;

public interface NewService {
    /**
     * Получить список всех новостей.
     *
     * @return List<NewDTO>
     */
    List<NewDTO> getAllNews();

    /**
     * Получить новость по id.
     *
     * @param id новости.
     *
     * @return NewDTO.
     */
    NewDTO getNewById(long id);

    /**
     * Создать новость в БД.
     *
     * @param newDTO .
     *
     * @return созданная новость.
     */
    NewDTO createNew(NewDTO newDTO);

    /**
     * Обновить новость в БД.
     *
     * @param details новости.
     *
     * @return обновленная новость.
     */
    NewDTO updateNew(NewDTO details);

    /**
     * Удалить новость из БД
     */
    void deleteNewDTO(long id);
}
