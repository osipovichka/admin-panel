package ova.example.adminpanel.service;

import ova.example.adminpanel.DTO.CourseDTO;

import java.util.List;

public interface CourseService {
    /**
     * Получить список всех курсов.
     *
     * @return List<CourseDTO>
     */
    List<CourseDTO> getAllCourse();

    /**
     * Получить курс по id
     *
     * @param id курса
     *
     * @return CourseDTO
     */
    CourseDTO getCourseById(Long id);

    /**
     * Записать новый курс в БД
     *
     * @param courseDTO модель создаваемого курса
     *
     * @return courseDTO созданный курс
     */
    CourseDTO createCourse(CourseDTO courseDTO);

    /**
     * Редактировать существующий курс
     *
     * @param courseDetails курс с изменениями
     *
     * @return courseDTO измененный курс
     */
    CourseDTO updateCourse(CourseDTO courseDetails);

    /**
     * удалить курс
     *
     * @param id курсa
     *
     */
    void deleteCourse(Long id);
}
