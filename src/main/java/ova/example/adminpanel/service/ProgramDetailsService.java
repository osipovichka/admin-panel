package ova.example.adminpanel.service;

import ova.example.adminpanel.DTO.ProgramDetailsDTO;

import java.util.List;

public interface ProgramDetailsService {
    /**
     * Получить список всех модулей всех программ.
     *
     * @return List<ProgramDetailsDTO>
     */
    List<ProgramDetailsDTO> getAllProgramDetails();

    /**
     * Получить 1 модуль программы по id
     *
     * @param id модуля
     *
     * @return ProgramDetailsDTO
     */
    ProgramDetailsDTO getProgramDetailsById(Long id);

    /**
     * Записать модуль программы в БД
     *
     * @param programDetailsDTO модель создаваемого модуля программы курса
     *
     * @return ProgramDetailsDTO созданный модуль
     */
    ProgramDetailsDTO createProgramDetails(ProgramDetailsDTO programDetailsDTO);

    /**
     * Редактировать существующий модуль программы курса
     *
     * @param details модуль с изменениями
     *
     * @return ProgramDetailsDTO измененный модуль
     */
    ProgramDetailsDTO updateProgramDetails(ProgramDetailsDTO details);

    /**
     * удалить модуль программы курса
     *
     * @param id модуля программы курса
     *
     */
    void deleteProgramDetails(Long id);
}
