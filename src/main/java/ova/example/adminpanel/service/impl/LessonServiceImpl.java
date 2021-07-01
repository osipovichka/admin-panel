package ova.example.adminpanel.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ova.example.adminpanel.DTO.LessonDTO;
import ova.example.adminpanel.models.Lesson;
import ova.example.adminpanel.repository.LessonRepository;
import ova.example.adminpanel.service.LessonService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {

    private final LessonRepository lessonRepo;

    @Override
    public List<LessonDTO> getAllLesson() {
        List<LessonDTO> lessonDTOList = new ArrayList<>();
        for(Lesson lesson : lessonRepo.findAll()){
            lessonDTOList.add(LessonDTO.fromModel(lesson));
        }
        return lessonDTOList;
    }

    @Override
    public LessonDTO getLessonById(long id) {
        Optional<Lesson> lessonOptional = lessonRepo.findById(id);
        if(lessonOptional.isEmpty()){
            log.info("Урок с id - {} не найден", id);
        }
        return LessonDTO.fromModel(lessonOptional.get());
    }

    @Override
    public LessonDTO createLesson(LessonDTO lessonDTO) {
        Lesson lesson = new Lesson(lessonDTO);

        return LessonDTO.fromModel(lessonRepo.saveAndFlush(lesson));
    }

    @Override
    public LessonDTO updateLesson(LessonDTO details) {
        Optional<Lesson> lessonOptional = lessonRepo.findById(details.getId());
        if(lessonOptional.isEmpty()){
            log.info("Урок с id - {} не найден", details.getId());
        }
        Lesson lesson = lessonOptional.get();
        lesson.setDay(details.getDay());
        lesson.setHomeTask(details.getHomeTask());
        lesson.setRead(details.getRead());
        lesson.setVideos(details.getVideos());

        return LessonDTO.fromModel(lessonRepo.saveAndFlush(lesson));
    }

    @Override
    public void deleteLesson(long id) {
        lessonRepo.deleteById(id);
    }
}
