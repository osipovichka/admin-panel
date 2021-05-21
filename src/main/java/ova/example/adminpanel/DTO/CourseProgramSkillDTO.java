package ova.example.adminpanel.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ova.example.adminpanel.models.CourseProgramSkill;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CourseProgramSkillDTO {
    private long id;
    private Long courseProgramId;
    private String name;

    public static CourseProgramSkillDTO fromModel(CourseProgramSkill courseProgramSkill){
        CourseProgramSkillDTO courseProgramSkillDTO = new CourseProgramSkillDTO();
        courseProgramSkillDTO.setId(courseProgramSkill.getId());
        courseProgramSkillDTO.setCourseProgramId(courseProgramSkill.getCourseProgram().getId());
        courseProgramSkillDTO.setName(courseProgramSkill.getName());

        return courseProgramSkillDTO;
    }
}
