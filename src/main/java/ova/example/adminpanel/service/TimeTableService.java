package ova.example.adminpanel.service;

import ova.example.adminpanel.DTO.TimeTableDTO;

import java.util.List;

public interface TimeTableService {
    /**
     * Получить список расписаний.
     *
     * @return List<TimeTableDTO>
     */
    List<TimeTableDTO> getAllTimeTable();

    /**
     * Получить расписание по id
     *
     * @param id расписания
     *
     * @return ThemeDetailsDTO
     */
    TimeTableDTO getTimeTableById(Long id);

    /**
     * Создать расписание в БД
     *
     * @param timeTableDTO расписание
     *
     * @return TimeTableDTO созданное расписание
     */
    TimeTableDTO createTimeTable(TimeTableDTO timeTableDTO);

    /**
     * Редактировать существующее расписание
     *
     * @param details расписания
     *
     * @return TimeTableDTO измененное расписание
     */
    TimeTableDTO updateTimeTable(TimeTableDTO details);

    /**
     * удалить расписание
     *
     * @param id расписания
     *
     */
    void deleteTimeTable(Long id);
}
