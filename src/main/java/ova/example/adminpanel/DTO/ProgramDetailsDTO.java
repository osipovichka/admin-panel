package ova.example.adminpanel.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ova.example.adminpanel.models.ProgramDetails;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ProgramDetailsDTO {
    private long id;
    private int lessonNumber;
    private String lessonTheme;

    public static ProgramDetailsDTO fromModel(ProgramDetails programDetails){
        ProgramDetailsDTO programDetailsDTO = new ProgramDetailsDTO();
        programDetailsDTO.setId(programDetails.getId());
        programDetailsDTO.setLessonNumber(programDetails.getLessonNumber());
        programDetailsDTO.setLessonTheme(programDetails.getLessonTheme());

        return programDetailsDTO;
    }
}
