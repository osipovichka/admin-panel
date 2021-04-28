package ova.example.adminpanel.service;

import ova.example.adminpanel.DTO.CourseDTO;
import ova.example.adminpanel.DTO.CourseProgramDTO;

import java.util.List;

public interface CourseProgramService {
    /**
     * Получить список всех программ.
     *
     * @return List<CourseProgramDTO>
     */
    List<CourseProgramDTO> getAllCourseProgram();

    /**
     * Получить программу по id
     *
     * @param id программы
     *
     * @return CourseProgramDTO
     */
    CourseProgramDTO getCourseProgramById(Long id);

    /**
     * Записать новую программу в БД
     *
     * @param courseProgramDTO модель создаваемой программы курса
     *
     * @return CourseProgramDTO созданный курс
     */
    CourseProgramDTO createCourseProgram(CourseProgramDTO courseProgramDTO);

    /**
     * Редактировать существующую программу курса
     *
     * @param courseProgramDetails курс с изменениями
     *
     * @return CourseProgramDTO измененный курс
     */
    CourseProgramDTO updateCourseProgram(CourseProgramDTO courseProgramDetails);

    /**
     * удалить программу курса
     *
     * @param id программы
     *
     */
    void deleteCourseProgram(Long id);
}
