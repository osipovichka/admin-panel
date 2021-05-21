package ova.example.adminpanel.service;

import ova.example.adminpanel.DTO.CourseProgramSkillDTO;

import java.util.List;

public interface CourseProgramSkillService {
    /**
     * Получить список всех скилов.
     *
     * @return List<CourseProgramSkillDTO>
     */
    List<CourseProgramSkillDTO> getAllCourseProgramSkill();

    /**
     * Получить скил по id
     *
     * @param id программы
     *
     * @return CourseProgramSkillDTO
     */
    CourseProgramSkillDTO getCourseProgramSkillById(Long id);

    /**
     * Сохранить скил в БД
     *
     * @param courseProgramSkillDTO модель создаваемого скила
     *
     * @return CourseProgramSkillDTO созданный скил
     */
    CourseProgramSkillDTO createAndUpdateCourseProgramSkill(CourseProgramSkillDTO courseProgramSkillDTO);

    /**
     * удалить скил
     *
     * @param id скила
     *
     */
    void deleteCourseProgramSkill(Long id);
}
