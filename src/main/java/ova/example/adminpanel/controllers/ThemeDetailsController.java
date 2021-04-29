package ova.example.adminpanel.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ova.example.adminpanel.DTO.ThemeDetailsDTO;
import ova.example.adminpanel.service.impl.ThemeDetailsServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/theme_details")
@RequiredArgsConstructor
public class ThemeDetailsController {
    private final ThemeDetailsServiceImpl themeDetailsService;

    @GetMapping
    public ResponseEntity<List<ThemeDetailsDTO>> getAllThemeDetails(){
        return ResponseEntity.ok(themeDetailsService.getAllThemeDetails());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ThemeDetailsDTO> getThemeDetailsById(@PathVariable Long id){
        if(id == 0){
            ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(themeDetailsService.getThemeDetailsById(id));
    }

    @PostMapping
    public ResponseEntity<ThemeDetailsDTO> createThemeDetails(@RequestBody ThemeDetailsDTO themeDetailsDTO){
        return ResponseEntity.ok(themeDetailsService.createThemeDetails(themeDetailsDTO));
    }

    @PutMapping
    public ResponseEntity<ThemeDetailsDTO> updateThemeDetails(@RequestBody ThemeDetailsDTO details){
        if(details.getId() == 0){
            ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(themeDetailsService.updateThemeDetails(details));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteThemeDetails(@PathVariable Long id){
        if(id == 0){
            ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }
        themeDetailsService.deleteThemeDetails(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
