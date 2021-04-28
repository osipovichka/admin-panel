package ova.example.adminpanel.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ova.example.adminpanel.DTO.CourseProgramDTO;
import ova.example.adminpanel.DTO.GroupDTO;
import ova.example.adminpanel.service.impl.CourseProgramServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/courseProgram")
@RequiredArgsConstructor
public class CourseProgramController {
    private final CourseProgramServiceImpl courseProgramService;

    @GetMapping
    public ResponseEntity<List<CourseProgramDTO>> getAllCourseProgram(){
        return ResponseEntity.ok(courseProgramService.getAllCourseProgram());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseProgramDTO> getCourseProgramById(@PathVariable Long id){
        if(id == 0){
            ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok(courseProgramService.getCourseProgramById(id));
    }

    @PostMapping
    public ResponseEntity<CourseProgramDTO> createCourseProgram(@RequestBody CourseProgramDTO courseProgramDTO){
        return ResponseEntity.ok(courseProgramService.createCourseProgram(courseProgramDTO));
    }

    @PutMapping
    public ResponseEntity<CourseProgramDTO> updateCourseProgram(@RequestBody CourseProgramDTO courseProgramDetails){
        if(courseProgramDetails.getId() == 0){
            ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(courseProgramService.updateCourseProgram(courseProgramDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCourseProgram(@PathVariable Long id){
        if(id == 0){
            ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }
        courseProgramService.deleteCourseProgram(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
