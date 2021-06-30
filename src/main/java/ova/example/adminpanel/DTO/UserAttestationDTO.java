package ova.example.adminpanel.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ova.example.adminpanel.models.UserAttestation;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Schema(description = "Аттестация студента")
public class UserAttestationDTO {
    private Long id;

    @Schema(description = "Студент")
    private Long userId;

    @Schema(description = "Тема аттестации")
    private Long attestationThemeId;

    @Schema(description = "Пройденная теория")
    private boolean theoryPassed;

    @Schema(description = "Пройденная практика")
    private boolean practicePassed;

    public static UserAttestationDTO fromModel(UserAttestation userAttestation){
        UserAttestationDTO userAttestationDTO = new UserAttestationDTO();
        userAttestationDTO.setId(userAttestation.getId());
        userAttestationDTO.setUserId(userAttestation.getUser().getId());
        userAttestationDTO.setAttestationThemeId(userAttestation.getAttestationTheme().getId());
        userAttestationDTO.setTheoryPassed(userAttestation.isTheoryPassed());
        userAttestationDTO.setPracticePassed(userAttestation.isPracticePassed());

        return userAttestationDTO;
    }
}
