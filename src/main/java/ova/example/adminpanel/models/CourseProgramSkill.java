package ova.example.adminpanel.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="course_program_skill")
public class CourseProgramSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "course_program_id")
    private int courseProgramId;

    private String name;

    @ManyToMany(mappedBy = "skills")
    private List<User> Student;
}
