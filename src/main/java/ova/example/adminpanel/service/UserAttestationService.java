package ova.example.adminpanel.service;

import ova.example.adminpanel.DTO.UserAttestationDTO;

import java.util.List;

public interface UserAttestationService {
    /**
     * Получить список всех аттестаций.
     *
     * @return List<UserAttestationDTO>
     */
    List<UserAttestationDTO> getAllUserAttestation();

    /**
     * Получить аттестацию по id.
     *
     * @param id аттестации.
     *
     * @return UserAttestationDTO.
     */
    UserAttestationDTO getUserAttestationById(Long id);

    /**
     * Создать аттестацию в БД.
     *
     * @param userAttestationDTO
     *
     * @return аттестация.
     */
    UserAttestationDTO createAndUpdateUserAttestation(UserAttestationDTO userAttestationDTO);

    /**
     * Удаление аттестации из БД
     */
    void deleteUserAttestation(long id);
}
