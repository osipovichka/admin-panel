package ova.example.adminpanel.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ova.example.adminpanel.models.CourseProgram;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CourseProgramDTO {
    private Long id;
    private boolean isActual;
    private String title;
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
