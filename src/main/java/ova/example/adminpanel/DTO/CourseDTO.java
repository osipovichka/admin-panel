package ova.example.adminpanel.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ova.example.adminpanel.models.Course;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CourseDTO {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;

    public static CourseDTO fromModel(Course course){
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setId(course.getId());
        courseDTO.setName(course.getName());
        courseDTO.setDescription(course.getDescription());
        courseDTO.setPrice(course.getPrice());

        return courseDTO;
    }
}
