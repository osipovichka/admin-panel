package ova.example.adminpanel.service;

import ova.example.adminpanel.DTO.GroupDTO;
import ova.example.adminpanel.DTO.JournalDTO;

import java.util.List;

public interface JournalService {
    /**
     * Получить список журналов.
     *
     * @return List<JournalDTO>
     */
    List<JournalDTO> getAllJournal();

    /**
     * Получить журнал по id.
     *
     * @param id журнала.
     *
     * @return JournalDTO.
     */
    JournalDTO getJournalById(long id);

    /**
     * Создать новый журнал в БД.
     *
     * @param journalDTO журнал.
     *
     * @return созданный журнал.
     */
    JournalDTO createJournal(JournalDTO journalDTO);

    /**
     * Обновить журнал в БД.
     *
     * @param details журнала с изменениями.
     *
     * @return обновленный журнал.
     */
    JournalDTO updateJournal(JournalDTO details);

    /**
     * Удалить журнал из БД
     */
    void deleteJournal(long id);
}
