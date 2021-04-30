package ova.example.adminpanel.service;

import ova.example.adminpanel.DTO.LessonDTO;

import java.util.List;

public interface LessonService {
    /**
     * Получить список всех уроков.
     *
     * @return List<LessonDTO>
     */
    List<LessonDTO> getAllLesson();

    /**
     * Получить урок по id.
     *
     * @param id урока.
     *
     * @return Lesson.
     */
    LessonDTO getLessonById(long id);

    /**
     * Записать новый урок в БД.
     *
     * @param lessonDTO .
     *
     * @return созданный урок.
     */
    LessonDTO createLesson(LessonDTO lessonDTO);

    /**
     * Обновить урок в БД.
     *
     * @param details урока.
     *
     * @return обновленный урок.
     */
    LessonDTO updateLesson(LessonDTO details);

    /**
     * Удалить урок из БД
     */
    void deleteLesson(long id);
}
