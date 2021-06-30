package ova.example.adminpanel.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ova.example.adminpanel.models.Role;
import ova.example.adminpanel.models.User;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Schema(description = "Сущность пользователя с его ролями")
public class UserWithRolesDTO {
    @JsonProperty("id")
    @Schema(description = "Id пользователя")
    private Long userId;

    @Schema(description = "Имя")
    private String firstName;

    @Schema(description = "Фамилия")
    private String lastName;

    @Schema(description = "Отчество")
    private String patronymic;

    @Schema(description = "Список ролей")
    private Set<RoleDTO> roles;

    public static UserWithRolesDTO fromModel(User user){
        UserWithRolesDTO dto = new UserWithRolesDTO();

        dto.setUserId(user.getId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setPatronymic(user.getPatronymic());
        Set<RoleDTO> roles = new HashSet<>();

        for (Role r: user.getRoles()) {
            roles.add(RoleDTO.fromModel(r));
        }
        dto.setRoles(roles);
        return dto;
    }
}
