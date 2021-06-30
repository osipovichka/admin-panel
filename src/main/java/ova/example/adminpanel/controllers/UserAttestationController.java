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
import ova.example.adminpanel.DTO.UserAttestationDTO;
import ova.example.adminpanel.DTO.UserDTO;
import ova.example.adminpanel.service.impl.UserAttestationServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/user_attestation")
@RequiredArgsConstructor
@Tag(name = "User attestation controller", description = "Работа с аттестацией студентов")
public class UserAttestationController {
    private final UserAttestationServiceImpl userAttestationService;

    @GetMapping
    @Operation(summary = "Генирация аттестационного списка для всех студентов", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Аттестационный список сгенерирован",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            array = @ArraySchema(schema = @Schema(implementation = UserAttestationDTO.class))))})
    public ResponseEntity<List<UserAttestationDTO>> getAllUserAttestation(){

        return ResponseEntity.ok(userAttestationService.getAllUserAttestation());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Найти аттестацию студента по id", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Аттестация найдена",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = UserAttestationDTO.class)))})
    public ResponseEntity<UserAttestationDTO> getUserAttestationById(@PathVariable @Parameter(description = "id - аттестации") Long id){
        if(id == null){
            ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(userAttestationService.getUserAttestationById(id));
    }

    @PostMapping
    @Operation(summary = "Сохранить итоги аттестации в БД", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Аттестация сохранена",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = UserAttestationDTO.class)))})
    public ResponseEntity<UserAttestationDTO> createUserAttestation(@RequestBody @Parameter(description = "Сущность аттестация студента") UserAttestationDTO userAttestationDTO){
        return ResponseEntity.ok(userAttestationService.createAndUpdateUserAttestation(userAttestationDTO));
    }

    @PutMapping
    @Operation(summary = "Изменить итоги аттестации в БД", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Аттестация изменена",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = UserAttestationDTO.class)))})
    public ResponseEntity<UserAttestationDTO> updateUserAttestation(@RequestBody
                @Parameter(description = "Сущность аттестация студента с внесенными изменениями")
                    UserAttestationDTO details){
        if(details.getId() == 0){
            ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(userAttestationService.createAndUpdateUserAttestation(details));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удалить итоги аттестации студента из БД", method = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Итоги аттестации удалены из БД",
                    content = @Content(mediaType = MediaType.ALL_VALUE))})
    public ResponseEntity deleteUserAttestation(@PathVariable @Parameter(description = "id - аттестации") Long id){
        if(id == 0){
            ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }
        userAttestationService.deleteUserAttestation(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
