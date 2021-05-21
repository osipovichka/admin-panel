package ova.example.adminpanel.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ova.example.adminpanel.models.UserAttestation;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UserAttestationDTO {
    private Long id;
    private Long userId;
    private Long attestationThemeId;
    private boolean theoryPassed;
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
