package ova.example.adminpanel.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ova.example.adminpanel.models.Role;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Schema(description = "Сущность роли")
public class RoleDTO {
    private Long id;
    private String title;

    public static RoleDTO fromModel(Role role) {
        RoleDTO roleDto = new RoleDTO();
        roleDto.setId(role.getId());
        roleDto.setTitle(role.getName());
        return roleDto;
    }
}
