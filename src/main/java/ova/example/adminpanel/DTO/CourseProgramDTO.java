package ova.example.adminpanel.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ova.example.adminpanel.models.CourseProgram;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Schema(description = "Программа курса")
public class CourseProgramDTO {
    private Long id;

    @Schema(description = "Актуальность программы курса")
    private boolean isActual;

    @Schema(description = "Название программы")
    private String title;

    @Schema(description = "Курс")
    private Long courseId;

    public static CourseProgramDTO fromModel(CourseProgram courseProgram){
        CourseProgramDTO courseProgDTO = new CourseProgramDTO();
        courseProgDTO.setId(courseProgram.getId());
        courseProgDTO.setActual(courseProgram.isActual());
        courseProgDTO.setTitle(courseProgram.getTitle());
        courseProgDTO.setCourseId(courseProgram.getCourse().getId());

        return courseProgDTO;
    }
}
