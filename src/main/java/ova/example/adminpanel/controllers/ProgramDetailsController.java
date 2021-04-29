package ova.example.adminpanel.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ova.example.adminpanel.DTO.ProgramDetailsDTO;
import ova.example.adminpanel.service.ProgramDetailsService;

import java.util.List;

@RestController
@RequestMapping("/api/program_details")
@RequiredArgsConstructor
public class ProgramDetailsController {
    private final ProgramDetailsService programDetailsService;

    @GetMapping
    public ResponseEntity<List<ProgramDetailsDTO>> getAllProgramDetails(){
        return ResponseEntity.ok(programDetailsService.getAllProgramDetails());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProgramDetailsDTO> getProgramDetailsById(@PathVariable Long id){
        if(id == 0){
            ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(programDetailsService.getProgramDetailsById(id));
    }

    @PostMapping
    public ResponseEntity<ProgramDetailsDTO> createProgramDetails(@RequestBody ProgramDetailsDTO programDetailsDTO){
        return ResponseEntity.ok(programDetailsService.createProgramDetails(programDetailsDTO));
    }

    @PutMapping
    public ResponseEntity<ProgramDetailsDTO> updateProgramDetails(@RequestBody ProgramDetailsDTO details){
        if(details.getId() == 0){
            ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(programDetailsService.updateProgramDetails(details));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProgramDetails(@PathVariable Long id){
        if(id == 0){
            ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }
        programDetailsService.deleteProgramDetails(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
