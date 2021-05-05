package ova.example.adminpanel.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ova.example.adminpanel.DTO.NewDTO;
import ova.example.adminpanel.service.impl.NewServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/new")
@RequiredArgsConstructor
public class NewController {

    private final NewServiceImpl newService;

    @GetMapping
    public ResponseEntity<List<NewDTO>> getAllLesson(){
        return ResponseEntity.ok(newService.getAllNews());
    }

    @GetMapping("/{id}")
    public ResponseEntity<NewDTO> getLessonById(@PathVariable long id){
        if(id == 0){
            ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(newService.getNewById(id));
    }

    @PostMapping
    public ResponseEntity<NewDTO> createLesson(@RequestBody NewDTO newDTO){
        return ResponseEntity.ok(newService.createNew(newDTO));
    }

    @PutMapping
    public ResponseEntity<NewDTO> updateLesson(@RequestBody NewDTO details){
        if(details.getId() == 0){
            ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(newService.updateNew(details));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteLesson(@PathVariable long id){
        if(id == 0){
            ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }
        newService.deleteNewDTO(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
