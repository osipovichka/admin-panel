package ova.example.adminpanel.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ova.example.adminpanel.DTO.LessonDTO;
import ova.example.adminpanel.service.impl.LessonServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/lesson")
@RequiredArgsConstructor
public class LessonController {

    private final LessonServiceImpl lessonService;

    @GetMapping
    public ResponseEntity<List<LessonDTO>> getAllLesson(){
        return ResponseEntity.ok(lessonService.getAllLesson());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LessonDTO> getLessonById(long id){
        if(id == 0){
            ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(lessonService.getLessonById(id));
    }

    @PostMapping
    public ResponseEntity<LessonDTO> createLesson(LessonDTO lessonDTO){
        return ResponseEntity.ok(lessonService.createLesson(lessonDTO));
    }

    @PutMapping
    public ResponseEntity<LessonDTO> updateLesson(LessonDTO details){
        if(details.getId() == 0){
            ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(lessonService.updateLesson(details));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteLesson(@PathVariable long id){
        if(id == 0){
            ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }
        lessonService.deleteLesson(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
