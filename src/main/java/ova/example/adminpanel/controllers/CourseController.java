package ova.example.adminpanel.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ova.example.adminpanel.DTO.CourseDTO;
import ova.example.adminpanel.service.impl.CourseServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/course")
@RequiredArgsConstructor
public class CourseController {
    private final CourseServiceImpl courseService;

    @GetMapping
    public ResponseEntity<List<CourseDTO>> getAllCourse(){
        return ResponseEntity.ok(courseService.getAllCourse());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> getCourseById(@PathVariable Long id){
        if(id == 0){
            ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(courseService.getCourseById(id));
    }

    @PostMapping
    public ResponseEntity<CourseDTO> createCourse(@RequestBody CourseDTO courseDTO){
        return ResponseEntity.ok(courseService.createCourse(courseDTO));
    }

    @PutMapping
    public ResponseEntity<CourseDTO> updateCourse(@RequestBody CourseDTO courseDetails){
        if(courseDetails.getId() == 0){
            ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(courseService.updateCourse(courseDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCourse(@PathVariable Long id){
        if(id == 0){
            ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }
        courseService.deleteCourse(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
