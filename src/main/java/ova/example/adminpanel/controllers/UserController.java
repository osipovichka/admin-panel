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
import ova.example.adminpanel.DTO.UserDTO;
import ova.example.adminpanel.DTO.UserWithRolesDTO;
import ova.example.adminpanel.service.impl.UserServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@Tag(name = "User controller", description = "Работа с пользователями")
public class UserController {

    private final UserServiceImpl userServiceImpl;

    @GetMapping
    @Operation(summary = "Генирация списка всех пользователей", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Пользователи найдены",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            array = @ArraySchema(schema = @Schema(implementation = UserDTO.class))))})
    public ResponseEntity<List<UserDTO>> getAllUser(){

        return ResponseEntity.ok(userServiceImpl.getAllUser());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Найти пользователя по ID", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Пользователь найден",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = UserDTO.class)))})
    public ResponseEntity<UserDTO> getUserById(@PathVariable @Parameter(description = "id - пользователя") Long id){
        if(id == null){
            ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(userServiceImpl.getUserById(id));
    }

    @PostMapping
    @Operation(summary = "Добавить в БД нового пользователя", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Пользователь добавлен",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = UserDTO.class)))})
    public ResponseEntity<UserDTO> createUser(@RequestBody @Parameter(description = "Сущность пользователя") UserDTO user){
        return ResponseEntity.ok(userServiceImpl.createUser(user));
    }

    @PutMapping
    @Operation(summary = "Обновить информацию о пользователе в БД", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Пользователь обнавлен",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = UserDTO.class)))})
    public ResponseEntity<UserDTO> updateUser(@RequestBody @Parameter(description = "Сущность пользователя с внесенными изменениями") UserDTO userDetails){
        if(userDetails.getId() == 0){
            ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(userServiceImpl.updateUser(userDetails));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удалить пользователя из БД", method = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Пользователь удален из БД",
                    content = @Content(mediaType = MediaType.ALL_VALUE))})
    public ResponseEntity deleteUser(@PathVariable @Parameter(description = "id - пользователя") Long id){
        if(id == 0){
            ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }
        userServiceImpl.deleteUser(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/AddUser_Role/{userId}/{roleId}")
    @Operation(summary = "Добавить пользователю роль", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Роль добаавлена",
                    content = @Content(mediaType = MediaType.ALL_VALUE))})
    public ResponseEntity addUserRole(@PathVariable @Parameter(description = "id - пользователя") Long userId,
                                      @PathVariable @Parameter(description = "id - добовляемой роли") Long roleId){
        if(userId == 0 || roleId == 0){
            ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }
        userServiceImpl.addUserRole(userId, roleId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/User_Roles/{id}")
    @Operation(summary = "Получить пользователя с его ролями", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Пользователь найден",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = UserWithRolesDTO.class)))})
    public ResponseEntity<UserWithRolesDTO> getUserWithRoles(@PathVariable @Parameter(description = "id - пользователя") Long id){
        if(id == 0){
            ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(userServiceImpl.getUserWithRoles(id));
    }
}
