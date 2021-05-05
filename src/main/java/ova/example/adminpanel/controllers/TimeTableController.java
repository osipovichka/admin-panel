package ova.example.adminpanel.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ova.example.adminpanel.DTO.TimeTableDTO;
import ova.example.adminpanel.service.impl.TimeTableServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/time_table")
@RequiredArgsConstructor
public class TimeTableController {
    private final TimeTableServiceImpl timeTableService;

    @GetMapping
    public ResponseEntity<List<TimeTableDTO>> getAllTimeTable(){
        return ResponseEntity.ok(timeTableService.getAllTimeTable());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TimeTableDTO> getTimeTableById(@PathVariable Long id){
        if(id == 0){
            ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(timeTableService.getTimeTableById(id));
    }

    @PostMapping
    public ResponseEntity<TimeTableDTO> createTimeTable(@RequestBody TimeTableDTO timeTableDTO){
        return ResponseEntity.ok(timeTableService.createTimeTable(timeTableDTO));
    }

    @PutMapping
    public ResponseEntity<TimeTableDTO> updateTimeTable(@RequestBody TimeTableDTO details){
        if(details.getId() == 0){
            ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(timeTableService.updateTimeTable(details));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTimeTable(@PathVariable Long id){
        if(id == 0){
            ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }
        timeTableService.deleteTimeTable(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
