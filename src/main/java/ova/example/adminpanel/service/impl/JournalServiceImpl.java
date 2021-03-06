package ova.example.adminpanel.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ova.example.adminpanel.DTO.JournalDTO;
import ova.example.adminpanel.models.*;
import ova.example.adminpanel.repository.JournalRepository;
import ova.example.adminpanel.repository.UserRepository;
import ova.example.adminpanel.service.JournalService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class JournalServiceImpl implements JournalService {
    private final JournalRepository journalRepo;
    private final UserServiceImpl userService;

    @Override
    public List<JournalDTO> getAllJournal() {
        List<JournalDTO> listJournalDTO = new ArrayList<>();
        for (Journal journal: journalRepo.findAll()) {
            listJournalDTO.add(JournalDTO.fromModel(journal));
        }

        return listJournalDTO;
    }

    @Override
    public JournalDTO getJournalById(long id) {
        Optional<Journal> opJournal = journalRepo.findById(id);
        if(opJournal.isEmpty()){
            log.info("Журнал с id - {} не найден", id);
        }

        return JournalDTO.fromModel(opJournal.get());
    }

    @Override
    public JournalDTO createJournal(JournalDTO journalDTO) {
        Journal journal = new Journal(journalDTO);
        User user = new User(userService.getUserById(journalDTO.getUserId()));
        journal.setUser(user);

        return JournalDTO.fromModel(journalRepo.saveAndFlush(journal));
    }

    @Override
    public JournalDTO updateJournal(JournalDTO details) {
        Optional<Journal> journalOptional = journalRepo.findById(details.getId());
        if(journalOptional.isEmpty()){
            log.info("Журнал с id - {} не найден", details.getId());
        }
        Journal journal = journalOptional.get();
        journal.setLessonId(details.getLessonId());
        journal.setAbsent(details.isAbsent());
        journal.setAbsentReason(details.getAbsentReason());

        return JournalDTO.fromModel(journalRepo.saveAndFlush(journal));
    }

    @Override
    public void deleteJournal(long id) {
        journalRepo.deleteById(id);
    }
}
