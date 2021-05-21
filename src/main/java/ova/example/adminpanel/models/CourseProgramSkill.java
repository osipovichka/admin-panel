package ova.example.adminpanel.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ova.example.adminpanel.DTO.CourseProgramSkillDTO;
import ova.example.adminpanel.service.CourseProgramService;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="course_program_skill")
public class CourseProgramSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "course_program_id")
    private CourseProgram courseProgram;

    private String name;

    @ManyToMany(mappedBy = "skills")
    private List<User> Student;

    public CourseProgramSkill(CourseProgramSkillDTO courseProgramSkillDTO){
        this.id = courseProgramSkillDTO.getId();
        this.name = courseProgramSkillDTO.getName();
    }
}
