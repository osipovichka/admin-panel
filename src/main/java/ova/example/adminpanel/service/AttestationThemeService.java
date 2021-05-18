package ova.example.adminpanel.service;

import ova.example.adminpanel.DTO.AttestationThemeDTO;

import java.util.List;

public interface AttestationThemeService {
    /**
     * Получить список всех тем аттестации.
     *
     * @return List<AttestationThemeDTO>
     */
    List<AttestationThemeDTO> getAllAttestationTheme();

    /**
     * Получить тему аттестации по id
     *
     * @param id темы аттестации
     *
     * @return AttestationThemeDTO
     */
    AttestationThemeDTO getAttestationThemeById(Long id);

    /**
     * Согздать новую тему аттестации в БД
     *
     * @param attestationThemeDTO модель создаваемой темы аттестации
     *
     * @return AttestationThemeDTO
     */
    AttestationThemeDTO createAttestationTheme(AttestationThemeDTO attestationThemeDTO);

    /**
     * Редактировать существующую тему аттестаци
     *
     * @param details курс с изменениями
     *
     * @return AttestationThemeDTO измененная тема аттестации
     */
    AttestationThemeDTO updateAttestationTheme(AttestationThemeDTO details);

    /**
     * удалить тему аттестации
     *
     * @param id темы аттестации
     *
     */
    void deleteAttestationTheme(Long id);
}
