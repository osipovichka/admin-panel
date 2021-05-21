package ova.example.adminpanel.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ova.example.adminpanel.DTO.UserAttestationDTO;
import ova.example.adminpanel.service.impl.UserAttestationServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/user_attestation")
@RequiredArgsConstructor
public class UserAttestationController {
    private final UserAttestationServiceImpl userAttestationService;

    @GetMapping
    public ResponseEntity<List<UserAttestationDTO>> getAllUserAttestation(){

        return ResponseEntity.ok(userAttestationService.getAllUserAttestation());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserAttestationDTO> getUserAttestationById(@PathVariable Long id){
        if(id == null){
            ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(userAttestationService.getUserAttestationById(id));
    }

    @PostMapping
    public ResponseEntity<UserAttestationDTO> createUserAttestation(@RequestBody UserAttestationDTO userAttestationDTO){
        return ResponseEntity.ok(userAttestationService.createAndUpdateUserAttestation(userAttestationDTO));
    }

    @PutMapping
    public ResponseEntity<UserAttestationDTO> updateUserAttestation(@RequestBody UserAttestationDTO details){
        if(details.getId() == 0){
            ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(userAttestationService.createAndUpdateUserAttestation(details));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUserAttestation(@PathVariable Long id){
        if(id == 0){
            ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }
        userAttestationService.deleteUserAttestation(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
