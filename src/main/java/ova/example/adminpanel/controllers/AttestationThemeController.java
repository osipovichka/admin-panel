package ova.example.adminpanel.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Description;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ova.example.adminpanel.DTO.AttestationThemeDTO;
import ova.example.adminpanel.service.impl.AttestationThemeServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/attestation_theme")
@RequiredArgsConstructor
public class AttestationThemeController {
    private final AttestationThemeServiceImpl attestationThemeService;

    @GetMapping
    public ResponseEntity<List<AttestationThemeDTO>> getAllAttestationTheme(){
        return ResponseEntity.ok(attestationThemeService.getAllAttestationTheme());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AttestationThemeDTO> getAttestationThemeById(@PathVariable Long id){
        if(id == 0){
            ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(attestationThemeService.getAttestationThemeById(id));
    }

    @PostMapping
    public ResponseEntity<AttestationThemeDTO> createCourse(@RequestBody AttestationThemeDTO attestationThemeDTO){
        return ResponseEntity.ok(attestationThemeService.createAttestationTheme(attestationThemeDTO));
    }

    @PutMapping
    public ResponseEntity<AttestationThemeDTO> updateCourse(@RequestBody AttestationThemeDTO details){
        if(details.getId() == 0){
            ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(attestationThemeService.updateAttestationTheme(details));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCourse(@PathVariable Long id){
        if(id == 0){
            ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }
        attestationThemeService.deleteAttestationTheme(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
