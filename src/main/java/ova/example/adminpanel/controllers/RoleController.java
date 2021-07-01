package ova.example.adminpanel.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ova.example.adminpanel.service.impl.RoleServiceImpl;
import ova.example.adminpanel.utils.RolesEnum;

@RestController
@RequestMapping("/api/role_user")
@RequiredArgsConstructor
@Tag(name = "Role controller", description = "Работа с ролями для пользователей")
public class RoleController {
    private final RoleServiceImpl roleService;

    @PostMapping("/AddUser_Role/{userId}/{roleId}")
    @Operation(summary = "Добавить пользователю роль", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Роль добаавлена",
                    content = @Content(mediaType = MediaType.ALL_VALUE))})
    public ResponseEntity addUserRole(
            @PathVariable
            @Parameter(description = "id - пользователя")
                    Long userId,
            @PathVariable
            @Parameter(description = "id - добовляемой роли")
                    Long roleId
    ){
        if(userId == 0 || roleId == 0){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Id не может равняться 0");
        }
        roleService.addUserRole(userId, roleId);
        return ResponseEntity.status(HttpStatus.OK).body("Роль успешно добавлена.");
    }

    @DeleteMapping("/User_Role/{userId}/{roleId}")
    public ResponseEntity deleteUserRole(
            @PathVariable
            @Parameter(description = "id - пользователя")
                Long userId,
            @PathVariable("roleId")@Parameter(description = "id - удаляемой роли")
                Long roleId
    ) {
        if(roleId == RolesEnum.USER.getValue()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Роль с id - " + roleId + " удалить нельзя.");
        }
        roleService.deleteUserRole(userId, roleId);
        return ResponseEntity.status(HttpStatus.OK).body("Роль успешно удалина.");
    }
}
