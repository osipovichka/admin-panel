package ova.example.adminpanel.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ova.example.adminpanel.models.ThemeDetails;


@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ThemeDetailsDTO {
    private long id;
    private Long programDetailsId;
    private String topic;

    public static ThemeDetailsDTO fromModel(ThemeDetails themeDetails){
        ThemeDetailsDTO themeDetailsDTO = new ThemeDetailsDTO();
        themeDetailsDTO.setId(themeDetails.getId());
        themeDetailsDTO.setProgramDetailsId(themeDetails.getProgramDetails().getId());
        themeDetailsDTO.setTopic(themeDetails.getTopic());

        return themeDetailsDTO;
    }
}
