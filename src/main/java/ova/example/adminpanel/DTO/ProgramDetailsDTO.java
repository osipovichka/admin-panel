package ova.example.adminpanel.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ova.example.adminpanel.models.ProgramDetails;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Schema(description = "Подробное описание программы курса")
public class ProgramDetailsDTO {
    private long id;

    @Schema(description = "Номер урока на котором будет пройдена тема")
    private int lessonNumber;

    @Schema(description = "Тема урока")
    private String lessonTheme;

    @Schema(description = "Программа курса")
    private Long courseProgramId;

    public static ProgramDetailsDTO fromModel(ProgramDetails programDetails){
        ProgramDetailsDTO programDetailsDTO = new ProgramDetailsDTO();
        programDetailsDTO.setId(programDetails.getId());
        programDetailsDTO.setLessonNumber(programDetails.getLessonNumber());
        programDetailsDTO.setLessonTheme(programDetails.getLessonTheme());
        programDetailsDTO.setCourseProgramId(programDetails.getCourseProgram().getId());

        return programDetailsDTO;
    }
}
