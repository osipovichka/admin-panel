package ova.example.adminpanel.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ova.example.adminpanel.DTO.CourseProgramSkillDTO;
import ova.example.adminpanel.service.impl.CourseProgramSkillServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/course_program_skill")
@RequiredArgsConstructor
public class CourseProgramSkillController {
    private final CourseProgramSkillServiceImpl courseProgramSkillService;

    @GetMapping
    public ResponseEntity<List<CourseProgramSkillDTO>> getAllCourseProgramSkill(){
        return ResponseEntity.ok(courseProgramSkillService.getAllCourseProgramSkill());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseProgramSkillDTO> getCourseProgramSkillById(@PathVariable Long id){
        if(id == 0){
            ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok(courseProgramSkillService.getCourseProgramSkillById(id));
    }

    @PostMapping
    public ResponseEntity<CourseProgramSkillDTO> createCourseProgramSkill(@RequestBody CourseProgramSkillDTO courseProgramSkillDTO){
        return ResponseEntity.ok(courseProgramSkillService.createAndUpdateCourseProgramSkill(courseProgramSkillDTO));
    }

    @PutMapping
    public ResponseEntity<CourseProgramSkillDTO> updateCourseProgramSkill(@RequestBody CourseProgramSkillDTO details){
        if(details.getId() == 0){
            ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(courseProgramSkillService.createAndUpdateCourseProgramSkill(details));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCourseProgram(@PathVariable Long id){
        if(id == 0){
            ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }
        courseProgramSkillService.deleteCourseProgramSkill(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
