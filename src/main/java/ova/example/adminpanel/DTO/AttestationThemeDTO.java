package ova.example.adminpanel.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ova.example.adminpanel.models.AttestationTheme;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Schema(description = "Тема аттестации")
public class AttestationThemeDTO {
    private Long id;

    @Schema(description = "Курс")
    private Long courseId;

    @Schema(description = "Тема аттестации")
    private String theme;

    public static AttestationThemeDTO fromModel(AttestationTheme attestationTheme){
        AttestationThemeDTO attestationThemeDTO = new AttestationThemeDTO();
        attestationThemeDTO.setId(attestationTheme.getId());
        attestationThemeDTO.setCourseId(attestationTheme.getCourse().getId());
        attestationThemeDTO.setTheme(attestationTheme.getTheme());

        return attestationThemeDTO;
    }
}
