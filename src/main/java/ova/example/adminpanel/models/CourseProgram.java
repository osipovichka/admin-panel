package ova.example.adminpanel.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ova.example.adminpanel.DTO.CourseDTO;
import ova.example.adminpanel.DTO.CourseProgramDTO;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="course_program")
public class CourseProgram {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;

    @Column(name = "is_actual")
    private boolean isActual;

    private String title;

    public CourseProgram(CourseProgramDTO courseProgramDTO) {
        this.id = courseProgramDTO.getId();
        this.isActual = courseProgramDTO.isActual();
        this.title = courseProgramDTO.getTitle();
    }
}
