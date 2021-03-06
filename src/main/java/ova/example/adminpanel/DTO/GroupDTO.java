package ova.example.adminpanel.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ova.example.adminpanel.models.Group;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Schema(description = "Сущность группы")
public class GroupDTO {
    private Long id;

    @Schema(description = "Программа курса по которой учится группа")
    private Long courseProgramId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Schema(description = "Дата начала курса")
    private Date startDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Schema(description = "Дата конца курса")
    private Date endDate;

    public static GroupDTO fromModel(Group group){
        GroupDTO groupDTO = new GroupDTO();
        groupDTO.setId(group.getId());
        groupDTO.setCourseProgramId(group.getCourseProgram().getId());
        groupDTO.setStartDate(group.getStartDate());
        groupDTO.setEndDate(group.getEndDate());

        return groupDTO;
    }
}
