package ova.example.adminpanel.service;

import ova.example.adminpanel.DTO.ThemeDetailsDTO;

import java.util.List;

public interface ThemeDetailsService {
    /**
     * Получить список всех тем.
     *
     * @return List<ThemeDetailsDTO>
     */
    List<ThemeDetailsDTO> getAllThemeDetails();

    /**
     * Получить тему по id
     *
     * @param id модуля
     *
     * @return ThemeDetailsDTO
     */
    ThemeDetailsDTO getThemeDetailsById(Long id);

    /**
     * Записать тему в БД
     *
     * @param themeDetailsDTO тема
     *
     * @return ThemeDetailsDTO созданная тема
     */
    ThemeDetailsDTO createThemeDetails(ThemeDetailsDTO themeDetailsDTO);

    /**
     * Редактировать существующую тему
     *
     * @param details темы
     *
     * @return ThemeDetailsDTO измененная тема
     */
    ThemeDetailsDTO updateThemeDetails(ThemeDetailsDTO details);

    /**
     * удалить модуль программы курса
     *
     * @param id модуля программы курса
     *
     */
    void deleteThemeDetails(Long id);
    // TODO: 29.04.2021 отредоктировать описание методов
}
