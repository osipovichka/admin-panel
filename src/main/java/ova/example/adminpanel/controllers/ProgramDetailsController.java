package ova.example.adminpanel.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ova.example.adminpanel.DTO.ProgramDetailsDTO;
import ova.example.adminpanel.DTO.UserAttestationDTO;
import ova.example.adminpanel.service.ProgramDetailsService;

import java.util.List;

@RestController
@RequestMapping("/api/program_details")
@RequiredArgsConstructor
@Tag(name = "Program details controller", description = "Работа с деталями прогрпммы курса")
public class ProgramDetailsController {
    private final ProgramDetailsService programDetailsService;

    @GetMapping
    @Operation(summary = "Генирация списка подробной программы курса", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Список сгенерирован",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            array = @ArraySchema(schema = @Schema(implementation = ProgramDetailsDTO.class))))})
    public ResponseEntity<List<ProgramDetailsDTO>> getAllProgramDetails(){
        return ResponseEntity.ok(programDetailsService.getAllProgramDetails());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Найти детали программы курса по id", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Детали программы курса найдены",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ProgramDetailsDTO.class)))})
    public ResponseEntity<ProgramDetailsDTO> getProgramDetailsById(@PathVariable @Parameter(description = "id - делалей программы курса") Long id){
        if(id == 0){
            ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(programDetailsService.getProgramDetailsById(id));
    }

    @PostMapping
    @Operation(summary = "Сохранить детали программы курса в БД", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Детали программы курса сохранены",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ProgramDetailsDTO.class)))})
    public ResponseEntity<ProgramDetailsDTO> createProgramDetails(@RequestBody
            @Parameter(description = "Сущность деталей программы курса") ProgramDetailsDTO programDetailsDTO){
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
