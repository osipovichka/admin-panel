package ova.example.adminpanel.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ova.example.adminpanel.DTO.JournalDTO;
import ova.example.adminpanel.service.impl.JournalServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/journal")
@RequiredArgsConstructor
public class JournalController {
    private final JournalServiceImpl journalService;

    @GetMapping
    public ResponseEntity<List<JournalDTO>> getAllJournal(){
        return ResponseEntity.ok(journalService.getAllJournal());
    }

    @GetMapping("/{id}")
    public ResponseEntity<JournalDTO> getJournalById(long id){
        if(id == 0){
            ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(journalService.getJournalById(id));
    }

    @PostMapping
    public ResponseEntity<JournalDTO> createJournal(JournalDTO journalDTO){
        return ResponseEntity.ok(journalService.createJournal(journalDTO));
    }

    @PutMapping
    public ResponseEntity<JournalDTO> updateJournal(JournalDTO details){
        if(details.getId() == 0){
            ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(journalService.updateJournal(details));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteGroup(@PathVariable long id){
        if(id == 0){
            ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }
        journalService.deleteJournal(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
