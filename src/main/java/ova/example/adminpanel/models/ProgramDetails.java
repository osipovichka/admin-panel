package ova.example.adminpanel.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="program_details")
public class ProgramDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "course_program_id")
    private Long courseProgramId;

    @Column(name = "lesson_number")
    private int lessonNumber;

    @Column(name = "lesson_theme")
    private String lessonTheme;
}
